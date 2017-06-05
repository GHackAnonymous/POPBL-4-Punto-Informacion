#include <stdint.h>
#include <string.h>
#include <stdio.h>
#include <ctype.h>
#include "ourRccGpio.h"
#include "ourCom.h"
#include "sysClock.h"

#define LED_PIN 6
#define USED_COM_PORT COM1


void initGPIO(void);

int main(void)
{
  int i, n=1, booleano = 1;
	char str[128];
	
	initGPIO();
  initSysClock(1000, POS_SYS_AHB1);
	initCom(USED_COM_PORT,9600);

  while(1)
  {
		if(getGpioPinValu(ADD_GPIOA,PIN_GPIOA0_OUT) == 1){//&&(booleano == 1)){
			sprintf(str," %d",n);
			writeToUart(USED_COM_PORT,(uint8_t *)str,strlen(str));
			setGpioPinValu(ADD_GPIOF, LED_PIN,1);
			//booleano = 0;
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


