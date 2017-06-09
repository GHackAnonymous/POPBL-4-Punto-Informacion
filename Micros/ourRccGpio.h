#ifndef OUR_RCC_H
#define OUR_RCC_H


#define ADD_GPIOF 0x40021400U
#define ADD_GPIOA 0x40020000U

#define OFF_RCC_AHB1ENR 0x30
#define OFF_RCC_CR 0x00

#define OFF_GPIO_ODR 0x14
#define OFF_GPIO_IDR 0x10

#define POS_GPIOF_AHB1 5
#define POS_GPIOA_AHB1 0

#define GPIO_MODE_INPUT 0
#define GPIO_MODE_OUTPUT 1


#define PIN_GPIOA0_OUT 0
#define PIN_LEDG 6

void rcc_enable_gpio(uint32_t selGPIO, uint32_t enable);
void initGpioPinMod(uint32_t hGPIO, uint32_t nPin, uint32_t mode);

void setGpioPinValu(uint32_t hGPIO, uint32_t nPin, uint32_t on);
uint32_t getGpioPinValu(uint32_t hGPIO, uint32_t nPin);

#endif
