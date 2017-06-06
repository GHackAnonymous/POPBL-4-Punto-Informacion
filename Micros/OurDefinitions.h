#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <stm32f407xx.h>
#include <string.h>




/**
*		Definizioak
*/ 

#define USANDO_PLACA 0
#define USANDO_MANDO 1

#define FOTO0_GPIO	GPIOA
#define FOTO0_PIN		0

#define FOTO1_GPIO	GPIOC
#define FOTO1_PIN		13

#define BUZZER_GPIO	GPIOB
#define BUZZER_PIN	1 

#define LED_GPIO			GPIOF
#define LED0_PIN			6
#define LED1_PIN			7

#define USART3_GPIO		GPIOD
#define USART3_TX_PIN	8
#define USART3_RX_PIN 9
#define BAUDIOAK			1667	//9600n jartzeko

#define FLAG_SARTU		0xFF		// 255 {FF} Javak -1 bezala irakurriko du (signed)
#define FLAG_IRTEN		0xFE		// 254 {FE} Javak -2 bezala irakurriko du (signed)
#define FLAG_HASI			0xFD		// 253 {FD} Javak -3 bezala bidaliko du (signed)

/**
*		Typedef-ak
*/ 

typedef enum _PINMODE{
	INPUT = 0,
	OUTPUT,
	ALTERNATIVE, 
	ANALOG
}PINMODE_t;

typedef enum _BOOLEAN{
	FALSE = 0,
	TRUE
} BOOLEAN_t;

typedef void (*P_FUNCT_t) (void);


//JOYSTICK
void inizializarGPIOs(void);
void enviarDatosSerie(int modo);
void controladorPlaca(void);
int obtenerEstadosMando(void);

// USART
void USARTpiztu(void);
void USARTkonfig (void);
void USARTGPIOkonf(void);
void USARTRXkendu(void);
void USARTbidali(uint8_t *data, uint32_t size);

