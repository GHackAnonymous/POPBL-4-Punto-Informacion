#include <stdint.h>
#include "sysClock.h"
#include "USART.h"

#define CLOCK_FREC  (25000000/8)  //we are going to use (AHB clock / 8 )

uint32_t ticks=0;
uint32_t ticksOld=0;

void initSysClock(uint32_t reload, uint32_t clk_src)
{
	uint32_t reg;
	
  uint32_t *pRCC_CR, *pLOAD, *pVAL, *pCTRL;
	pRCC_CR = (uint32_t*)(ADD_RCC + OFF_RCC_CR);
	
	*pRCC_CR &= ~0x00050000;  //reset HSEON and HSEBypass
	*pRCC_CR |= 0x00010000;    //set HSEON
	while(!(*pRCC_CR & 0x00020000)); //waits until clock stabilized
	
	uint32_t *pRCC_CFGR;
	pRCC_CFGR = (uint32_t*)(ADD_RCC + OFF_RCC_CFGR);
	
	reg=*pRCC_CFGR;
	reg &= ~ 0x00000003;  
	reg |= 0x00000001;
	*pRCC_CFGR=reg;  // set HSE as sysclock
	
	if(reload!=0)
	{
		pLOAD = (uint32_t*)(ADD_SYSTICK + 0x04);
		
		*pLOAD = (uint32_t)(CLOCK_FREC/1000*reload - 1UL); 
		
		pVAL = (uint32_t*)(ADD_SYSTICK + 0x08);
		*pVAL = 0UL;
		
		pCTRL = (uint32_t*)(ADD_SYSTICK + 0x00);
		*pCTRL |= 0x00000003; //enable, int enable, AHB clock/8
	}
}

void waitSysClockTick(void)
{
  while(ticksOld==ticks);
  ticksOld++;
}

void ourSysTickHandler(void)
{
  ticks++;
}
