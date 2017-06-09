#include <stdint.h>
#include <string.h>
#include <stdio.h>
#include <ctype.h>
#include "ourRccGpio.h"
#include "sysClock.h"
#include "USART.h"

#define LED_PIN 6


void initGPIO(void);

char msg[40];

int main(void)
{
	
	initGPIO();
	//initSysClock(1000, POS_SYS_AHB1);
	USARTpiztu(); 
	USARTGPIOkonf();
	USARTkonfig();


  while(1)
  {
		if(getGpioPinValu(ADD_GPIOA,PIN_GPIOA0_OUT) == 1){
			sprintf(msg, "u");
			USARTbidali((uint8_t *)msg, strlen(msg));
			setGpioPinValu(ADD_GPIOF, LED_PIN,1);
		}else{
			setGpioPinValu(ADD_GPIOF, LED_PIN,0);
		}
}
}

void initGPIO(void)
{
	//led verde
	rcc_enable_gpio(POS_GPIOF_AHB1, 1);
	initGpioPinMod(ADD_GPIOF, LED_PIN, GPIO_MODE_OUTPUT);
	
	//sensor
	rcc_enable_gpio(POS_GPIOA_AHB1, 1);
	initGpioPinMod(ADD_GPIOA, PIN_GPIOA0_OUT, GPIO_MODE_INPUT);
}
