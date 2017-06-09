#include "USART.h"
#include <string.h>	//ejbuwobiuwe
#include <stm32f407xx.h>
#include "OurDefinitions.h"
/**
*	USARTa eta erabilitako gpioak pizten dira
*/

void USARTpiztu(void){
	uint32_t *P_RCC_AHB1, *P_RCC_APB1;
	  
	P_RCC_AHB1 = (uint32_t*) (ADD_RCC + OFF_AHB1ENBR);
	P_RCC_APB1 = (uint32_t*) (ADD_RCC + OFF_APB1ENBR);
	
	*P_RCC_APB1 |= (0x01 << POS_USART3);
	*P_RCC_AHB1 |= (0x01 << POS_GPIOD);
}

/**
*	USARTa 9600 baudiotara jartzen da, 8 biteko paketeak tramitatuz.
*	Tx eta Rx aktibatzen dira, eta USARTa bera.
*/

void USARTkonfig (void){	
	uint32_t * P_USART3_CR1, *P_USART3_BRR;
	
	P_USART3_CR1 = (uint32_t*) (ADD_USART3 + OFF_CR1);
	P_USART3_BRR = (uint32_t*) (ADD_USART3 + OFF_BRR);
	
	*P_USART3_CR1 |= (0x01 << 13);  //UE   
	*P_USART3_CR1 |= (0x01 << 3);   //TE
	*P_USART3_CR1 |= (0x01 << 2);   //RE
	*P_USART3_BRR &= (0x00 << 0);   //Reiniciar lo que se pueda de BRR
	*P_USART3_BRR |= (0x11010000011 << 0);   //Divider y Mantissa
}


/**
*	USARTeko gpioak modu alternoan jartzen dira, eta funtzio bat hematen zaie.
*/
//ESTA ES LA QUE PETA
void USARTGPIOkonf(void){
	uint32_t * P_GPIOD_MODER, *P_GPIOD_AFR;
	
	P_GPIOD_MODER = (uint32_t*) (ADD_GPIOD);
	P_GPIOD_AFR = (uint32_t*) (ADD_GPIOD + OFF_AFRH);
	
	*P_GPIOD_MODER &= ~(3 << (2 * PIN_USART3_TX));
	*P_GPIOD_MODER |= (2 << (2 * PIN_USART3_TX));
	
	*P_GPIOD_MODER &=~ (3 << (2 * PIN_USART3_RX));
	*P_GPIOD_MODER |= (2 << (2 * PIN_USART3_RX));
	
	*P_GPIOD_AFR |= (7 << (4 * (PIN_USART3_TX & 7)));
	*P_GPIOD_AFR |= (7 << (4 * (PIN_USART3_TX & 7)));
}

/**
*	USARTaren irakurketa desaktibatzen da.
*/
void USARTRXkendu(void){
	uint32_t * P_USART3_CR1;
	
	P_USART3_CR1 = (uint32_t*) (ADD_USART3 + OFF_CR1);
	*P_USART3_CR1 &=~ (0x01 << 2);
}

/**
*	Bidaltzeko prest dagoenean, 4x8 biteko pakete bidaltzen ditu ordenan.
*/

void USARTbidali(uint8_t *data, uint32_t size){
	uint32_t * P_USART3_SR, *P_USART3_DR;
	
	P_USART3_SR = (uint32_t*) (ADD_USART3 + OFF_SR);
	P_USART3_DR = (uint32_t*) (ADD_USART3 + OFF_DR);
	
	int i = 0;
	while(i < size) {
			while(( *P_USART3_SR & (0x01 << 7)) == 0 );
			*P_USART3_DR = data[i++];
	}
}

