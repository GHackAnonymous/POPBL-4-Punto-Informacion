/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.olimexRS232;


import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

/**
 *
 * @author GHackAnonymous
 */
public class ConexionRS232 {

    public ConexionRS232() {
    }
    
    private String puertoConectado(){

		String[] portNames = SerialPortList.getPortNames();
		for(int i = 0; i < portNames.length; i++){
			System.out.println(portNames[i]);
		}
		return portNames[0];
	}

	public String leerUsart(){

		SerialPort serialPort = new SerialPort(puertoConectado());
		String buffer = null;
		
		try {
			serialPort.openPort();//Open serial port
			serialPort.setParams(9600, 8, 1, 0);//Set params.
			buffer = serialPort.readString(4);//Read 10 bytes from serial port
			serialPort.closePort();//Close serial port
		}
		catch (SerialPortException ex) {
			System.out.println(ex);
		}
		return buffer;
	}

	public void escribirUsart(String texto){
		SerialPort serialPort = new SerialPort(puertoConectado());
		try {
			serialPort.openPort();//Open serial port

			/*
	        serialPort.setParams(SerialPort.BAUDRATE_9600, 
	                             SerialPort.DATABITS_8,
	                             SerialPort.STOPBITS_1,
	                             SerialPort.PARITY_NONE);
			 */  
			serialPort.setParams(9600, 8, 1, 0);
			serialPort.writeBytes(texto.getBytes());//Write data to port
			serialPort.closePort();//Close serial port
		}
		catch (SerialPortException ex) {
			System.out.println(ex);
		}
	}
}