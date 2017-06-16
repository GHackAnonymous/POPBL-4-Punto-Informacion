#include "USART.h"
#include <string.h>
#include <stm32f407xx.h>


//PASAR CLOCK A GPIOA Y USART3
void initUSART(void){
	uint32_t *P_RCC_AHB1, *P_RCC_APB1;
	  
	P_RCC_AHB1 = (uint32_t*) (ADD_RCC + OFF_AHB1ENBR);
	P_RCC_APB1 = (uint32_t*) (ADD_RCC + OFF_APB1ENBR);
	
	*P_RCC_APB1 |= (0x01 << POS_USART3);
	*P_RCC_AHB1 |= (0x01 << POS_GPIOD);
}

//CONFIGURAR USART
/*Para cálculos de Mantissa y Div***************************************
	http://embedded-lab.com/blog/stm32-serial-communication/
***********************************************************************/
void USARTconfig (void){	
	uint32_t * P_USART3_CR1, *P_USART3_BRR;
	
	P_USART3_CR1 = (uint32_t*) (ADD_USART3 + OFF_CR1);
	P_USART3_BRR = (uint32_t*) (ADD_USART3 + OFF_BRR);
	
	*P_USART3_CR1 |= (0x01 << 13);  //UE   
	*P_USART3_CR1 |= (0x01 << 3);   //TE
	*P_USART3_CR1 |= (0x01 << 2);   //RE
	*P_USART3_BRR &= (0x00 << 0);   //Reiniciar lo que se pueda de BRR
	//*P_USART3_BRR |= (0x011010000011 << 0);   //Divider y Mantissa 16MHz
	*P_USART3_BRR |= (0x101000101100 << 0);   //Divider y Mantissa 25MHz
}

//PONER LOS PINES DEL USART EN ALTER MODE
void USARTGPIOconf(void){
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



//PARA ENVIAR DATOS POR USART, STATE REGISTER, DATA REGISTER
void USARTenviar(uint8_t *data, uint32_t size){
	uint32_t * P_USART3_SR, *P_USART3_DR;
	
	P_USART3_SR = (uint32_t*) (ADD_USART3 + OFF_SR);
	P_USART3_DR = (uint32_t*) (ADD_USART3 + OFF_DR);
	
	int i = 0;
	while(i < size) {
		while(( *P_USART3_SR & (0x01 << 7)) == 0 );
		*P_USART3_DR = data[i++];
	}
}


//DE AQUÍ HACIA ABAJO SON COMENTARIOS DE LO QUE NO SE HA IMPLEMENTADO

// 1- PARA LEER DESDE USART

/*Documentacion************************************************************

http://www.keil.com/forum/61761/cmsis-v5-usartn-irqhandler-multiply-defined
https://github.com/MaJerle/stm32f429

**************************************************************************/

/*Habilitar una interrupción en NVIC para este handler, por ahora solo con librería stm32f4xx.h

NVIC_DisableIRQ(USART3_IRQn);

*/

/*Llamar a este handler desde la interrupción que se le asigne a la lectura de USART3
  BUFFERSIZE se tiene que declarar*/

/*void USART3_IRQHandler() {
	if(bufflen3 < BUFFERSIZE) {
	usart3_buffer[bufflen3++] = USART3->DR;
	irqUSART3();
	} else {
	bufflen3 = 0;
	}
	USART3->SR &= ~USART_SR_RXNE;
}*/


//Esto desactivaría la lectura
/*void quitarUSARTRX(void){
	uint32_t * P_USART3_CR1;
	
	P_USART3_CR1 = (uint32_t*) (ADD_USART3 + OFF_CR1);
	*P_USART3_CR1 &=~ (0x01 << 2);
}*/


// 2- PARA UTILIZAR EL SENSOR HC SR04

/*Documentacion*********************************************************************

https://stm32f4-discovery.net/2014/08/library-30-measure-distance-hc-sr04-stm32f4xx/
https://github.com/MaJerle/stm32f429
https://hsel.co.uk/2014/08/19/interfacing-the-hc-sr04-ultrasonic-distance-sensor-and-the-stm32f0-discovery-board/

***********************************************************************************/

/*Algoritmia************************************************************************

1- Conectar HC-SR04 a 5v de alimentación, GND, PAx y PAz
2- Activar GPIOA de donde estén conectados el TRIGGER y el ECHO
3- En algún momento del programa lanzar un 1 al TRIGGER
4- Escuchar con la misma función que para el sensor de infrarrojos al ECHO
5- Empezar un contador cuando ECHO suba a 1
6- Terminar de contar cuando ECHO baje a 0 (Devolver valor en TicksRegistrados)
7- Leer cuantos ticks a hecho el clock
8- Si es inferior a una cantidad de ticks, según la distancia, USARTenviar
9- Si es superior a una cantidad se ticks, según la distancia, no hacer nada


************************************************************************************/

/*Para calcular la distancia al objeto***********************************************

Tomamos el preescaler del clock como 1:

TiempoPorTick = 1/FrecuenciaReloj
TiempoDelPulso = TiempoPorTick * TicksRegistrados
TiempoDeVueloDeSeñal = TiempoDelPulso/2
DistanciaAlObjeto = TiempoDeVueloSeñal * 343  (El sonido viaja a 343m/s)


************************************************************************************/
