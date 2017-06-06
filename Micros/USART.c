#ifndef USART_API_C
#define USART_API_C

#include "USART.h"
#include "sysClock.h"


uint8_t usart6_buffer[BUFFERSIZE]; /** The buffer of the USART6. The data received from the USART6 will be saved here. */
uint16_t bufflen6 = 0; /** The lenght of the USART3 buffer */

func_address_t irqUSART6; /** The function pointer to the function to be executed inside the USART6 IRQ. */

/*Inicializa USART6 en default settings y velocidad deseada, 9600*/
void USART6_Init() {
	enableGPIO_RCC();
	USART_Enable_RCC();
	USART_ConfGPIO();
	USART_Conf();
	USART_ConfIRQ_RX();
}



/*Activa USART6 en el RCC, APB2ENBR*/
void USART_Enable_RCC() {
	  uint32_t *P_RCC;
	  
	  P_RCC = (uint32_t*) (ADD_RCC + OFF_APB2ENBR);
	  *P_RCC |= (0x01 << POS_USART6);
}

/*Activa GPIOC y GPIOG en el RCC, AHB1ENBR*/
void enableGPIO_RCC() {
		uint32_t *P_RCC;
	  
	  P_RCC = (uint32_t*) (ADD_RCC + OFF_AHB1ENBR);
	  *P_RCC |= (0x01 << POS_GPIOC);
	  *P_RCC |= (0x01 << POS_GPIOG);
}


/*Configura USART en la GPIO
USART6:
TX: PC6
RX: PG9*/
void USART_ConfGPIO() {
		uint32_t *P_GPIOC, *P_GPIOG;
	
	  P_GPIOC = (uint32_t*) (ADD_GPIOC+OFF_MODER);  
	  P_GPIOG = (uint32_t*) (ADD_GPIOG+OFF_MODER);
	  *P_GPIOC |= (0x10 << (USART6_TX_PIN * 2));   //Pone Usart6 TX en alter mode
		*P_GPIOG |= (0x10 << (USART6_RX_PIN * 2));   //Pone Usart6 RX en alter mode
		
    P_GPIOC = (uint32_t*) (ADD_GPIOC+OFF_AFRL);
	  P_GPIOG = (uint32_t*) (ADD_GPIOG+OFF_AFRH);
	  *P_GPIOC |= (ALTERNATE_USART6 << (AF_USART6_TX * AF_SIZE));
		*P_GPIOG |= (ALTERNATE_USART6 << (AF_USART6_RX * AF_SIZE));	  
}


/*Configura USART6 en la velocidad y longitud de bsues indicada, 8 bits, 1 de paro/stop */
void USART_Conf() {
	uint32_t *P_USART6;
	
	P_USART6 = (uint32_t*) (ADD_USART6+OFF_BRR);
  *P_USART6 = (0x11);  //Divider
	*P_USART6 = (0x1110010 << 4);  //Mantissa
	//9600 bps @PCLK 16Mhz
	
		
	//30.6.4 Reference Manual
	P_USART6 = (uint32_t*) (ADD_USART6+OFF_CR1);
	*P_USART6 |= (0x01 << 13);  //UE, USART ENABLE
	*P_USART6 |= (0x01 << 3);  //TE, TRANSMITTER ENABLE
	*P_USART6 |= (0x01 << 2);  //RECEIVER ENABLE
}

/******************************************//**
*Sends a string or uint8 array through the UART. 
*@param usart The port to use.
*@param data The address of the array of data to send.
*@param size The size of the array or the number of characters to send.
********************************************/
void USART_transmitString(uint8_t *data, uint8_t size) {
	uint32_t *P_USART6_SR, *P_USART6_DR;
	int i = 0;	
	
	P_USART6_SR = (uint32_t*) (ADD_USART6+OFF_SR);
	P_USART6_DR = (uint32_t*) (ADD_USART6+OFF_DR);	

	while(i < size) {
		while(( *P_USART6_SR & (0x01 << 7)) == 0 );  //si en el TXE del SR hay un 0, es decir, 
																								 //el registro de transmisión de datos está vacío
		*P_USART6_DR = data[i++];  //mirarlo
	}
}


/*Configurar USART para que genere interrupciones en lectura de datos RX*/
void USART_ConfIRQ_RX() {
	uint32_t *P_USART6, *P_NVIC_IRQ;
	
	P_USART6 = (uint32_t*) (ADD_USART6+OFF_CR1);
	*P_USART6 |= (0x01 << 5);  //desenmascarar interrupción de USART, ORE o RXNE = 1 son los flags
	
	P_NVIC_IRQ = (uint32_t*) (ADD_NVIC);  //ahora apunta a NVIC + el offset del ISER
	
	//Esto es una función genérica de NVIC donde tu le metes tu numero de prioridad del Exti te lo configura automático
	//Los ISER/NVIC van en grupos de 32 bits, por eso los /32, los saltos son (posicion en tabla NVIC del exti % 32)
	//Los offsets están en hexadecimal en el pdf
	//el sumar un integer es como sumar 4 al offset
	//4.3.11 en el programming manual
	*(P_NVIC_IRQ + PRIO_USART6 / 32) |= (0x01 << PRIO_USART6 % 32);
}


/*
*lA FUNCIÓN QUE EJECUTA EL IRQ, es decir, el handler. */
void USART_setIRQ(func_address_t func) {
		irqUSART6 = func;
}

/*Es el handler, guarda los datos a un buffer, buffer USART6*/
void USART6_IRQHandler() {
	uint32_t *P_USART6_DR, *P_USART6_SR;
	
	P_USART6_DR = (uint32_t*) (ADD_USART6+OFF_DR);
	P_USART6_SR = (uint32_t*) (ADD_USART6+OFF_SR);
	
	if(bufflen6 < BUFFERSIZE) {
	usart6_buffer[bufflen6++] = *P_USART6_DR;
	irqUSART6();
	} else {
	bufflen6 = 0;
	}
	*P_USART6_SR &= ~(0x01 << 5);  //RXNE = Read data register is not empty
	//set by hardware to 1, reset to 0
}

void USART_resetTransmit(){
	
	uint32_t *P_USART6_DR;//, *P_USART6_SR;
	
	P_USART6_DR = (uint32_t*) (ADD_USART6+OFF_DR);
	//P_USART6_SR = (uint32_t*) (ADD_USART6+OFF_SR);
	
	*P_USART6_DR &= ~(0x01 << 6);
	*P_USART6_DR &= ~(0x01 << 7);
	
}

#endif
