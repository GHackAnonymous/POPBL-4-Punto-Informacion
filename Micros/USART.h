#include <stdint.h>

#ifndef USART_H
#define USART_H

#define ADD_RCC 0x40023800
#define OFF_APB1ENBR 0x40
#define OFF_APB2ENBR 0x44
#define OFF_AHB1ENBR 0x30
#define ADD_GPIOC 0x40020800
#define ADD_GPIOD 0x40020C00
#define ADD_GPIOG 0x40021800
#define OFF_MODER 0x00
#define OFF_AFRL  0x20
#define OFF_AFRH 0x24
#define ADD_USART3 0x40004800
#define ADD_USART6 0x40011400
#define OFF_CR1 0x0C
#define OFF_SR  0x00
#define OFF_DR  0x04
#define OFF_BRR 0x08
#define ADD_NVIC 0xE000E100U 
#define PRIO_USART6 71 

#define POS_GPIOC 2
#define POS_GPIOD 3
#define POS_GPIOG 6
#define POS_USART3 18

#define PIN_USART3_TX 8
#define PIN_USART3_RX 9


void initUSART(void);
void USARTconfig (void);
void USARTGPIOconf(void);
void quitarUSARTRX(void);
void USARTenviar(uint8_t *data, uint32_t size);


#endif
