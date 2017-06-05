#include <stdint.h>
#include "ourRccGpio.h"

void rcc_enable_gpio(uint32_t selGPIO, uint32_t enable)
{
	uint32_t *pRCC;
	
	pRCC = (uint32_t*) (ADD_RCC + OFF_RCC_AHB1ENR);
	
	*pRCC &= ~(0x01 << selGPIO); // Resetear
	*pRCC |= (enable << selGPIO);
}

void initGpioPinMod(uint32_t hGPIO, uint32_t nPin, uint32_t mode)
{
	uint32_t *GPIO_MODER;
	
	GPIO_MODER = (uint32_t*) (hGPIO + OFF_RCC_CR);
	
	*GPIO_MODER &= ~(0x03 << nPin*2);
	*GPIO_MODER |= (mode << nPin*2);
}

uint32_t getGpioPinValu(uint32_t hGPIO, uint32_t nPin){
	uint32_t *GPIO_IDR;
	
	GPIO_IDR = (uint32_t*) (hGPIO + OFF_GPIO_IDR);
	
	return *GPIO_IDR &= (0x01<<nPin);
}

void setGpioPinValu(uint32_t hGPIO, uint32_t nPin, uint32_t on){
	uint32_t *GPIO_ODR;
	
	GPIO_ODR = (uint32_t*) (hGPIO + OFF_GPIO_ODR);
	
	*GPIO_ODR &= ~(0x01 << nPin);
	*GPIO_ODR |= (on << nPin);
}

