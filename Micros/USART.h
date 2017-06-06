#include <stdint.h>

#ifndef USART_H
#define USART_H


#define AF_SIZE 4 /**< Size of each pin inside the Alternate Function register. */
#define ALTERNATE_USART6 8 /**< Alternate function corresponding to the USART6. */
#define AF_USART6_TX 6 /**< The position of the USART6 TX pin inside the Alternate Function register. */
#define AF_USART6_RX 1 /**< The position of the USART6 RX pin inside the Alternate Function register. */
#define MODER_SIZE 2 /**< Size of each pin inside of the MODER register of the GPIO. */
#define GPIO_MODER_ALTERNATE 2 /**< Set the pin in Alternate function mode in the MODER register. */
#define USART6_TX_PIN 6 /**< PIN of the USART6 TX on the GPIO. */ 
#define USART6_RX_PIN 9 /**< PIN of the USART6 RX on the GPIO. */
#define BUFFERSIZE 300 /**< Size of the buffer for the received data. */

//#define ADD_RCC 0x40023800
#define OFF_APB2ENBR 0x44
#define OFF_AHB1ENBR 0x30
#define ADD_GPIOC 0x40020800
#define ADD_GPIOG 0x40021800
#define OFF_MODER 0x00
#define OFF_AFRL  0x20
#define OFF_AFRH 0x24
#define ADD_USART6 0x40011400
#define OFF_CR1 0x0C
#define OFF_SR  0x00
#define OFF_DR  0x04
#define OFF_BRR 0x08
#define ADD_NVIC 0xE000E100U 
#define PRIO_USART6 71 //Priority 78

#define POS_GPIOC 2
#define POS_GPIOG 6
#define POS_USART6 5


extern uint8_t usart6_buffer[BUFFERSIZE]; /** The buffer of the USART6. The data received from the USART6 will be saved here. */
extern uint16_t bufflen6; /** The lenght of the USART3 buffer */ 

typedef void (*func_address_t)(void); /**< Void function pointer typeDef */

void USART6_Init(void);
void USART_Enable_RCC(void);
void enableGPIO_RCC(void);


void USART_ConfGPIO(void);

void USART_Conf(void);
void USART_ConfIRQ_RX(void);

void USART_setIRQ(func_address_t func);

void USART_transmitString(uint8_t *data, uint8_t size);



#endif
