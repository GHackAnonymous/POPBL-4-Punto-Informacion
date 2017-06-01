#include <stdint.h>
#include <string.h>
#include <stdio.h>
#include <ctype.h>
#include "ourRccGpio.h"
#include "ourCom.h"
#include "sysClock.h"

#define LED_PIN 6
#define USED_COM_PORT COM1

void initLed(void);

int main(void)
{
  int i, n=1, booleano = 1;
	char str[128];
	
  initSysClock(1000);
	initCom(USED_COM_PORT,9600);
  initLed();
  while(1)
  {
		if(getGpioPinValue(GPIOA,PIN_GPIOA4_ECO) == 1){//&&(booleano == 1)){
			sprintf(str," %d",n);
			writeToUart(USED_COM_PORT,(uint8_t *)str,strlen(str));
			setGpioPinValue(GPIOF, LED_PIN,1);
			//booleano = 0;
		}else{
			setGpioPinValue(GPIOF, LED_PIN,0);
		}
}
}

void initLed(void)
{
	//led verde
  RCC_AHB1PeriphClockCmd(RCC_AHB1Periph_GPIOF, 1);
  initGpioPinMode(GPIOF, LED_PIN, GPIO_Mode_OUT);
	//sensor
	RCC_AHB1PeriphClockCmd(RCC_AHB1Periph_GPIOA, 1);
	initGpioPinMode(GPIOA, PIN_GPIOA4_ECO, GPIO_Mode_IN);
}
