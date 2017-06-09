#ifndef SYS_CLOCK_H
#define SYS_CLOCK_H

#define ADD_SYSTICK 0xE000E010U
#define FREC_AHB1 25000000 // 25MHz
#define POS_SYS_AHB1 1

#define OFF_RCC_CR 0x00
#define OFF_RCC_CFGR 0x08
#define OFF_STK_LOAD 0x04
#define OFF_STK_VAL 0x08
#define OFF_STK_CTRL 0x00


//uses external 25MHz clock

void initSysClock(uint32_t reload, uint32_t clk_src);
void waitSysClockTick(void);

#endif
