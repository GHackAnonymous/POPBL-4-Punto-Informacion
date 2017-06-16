/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popbl4.app.modelo.olimexRS232;


import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

/**
 *
 * @author GHackAnonymous
 */
public class ConexionRS232{
    
    private final int VELOCIDAD = 9600;
    private final int DATABITS = 8;
    private final int STOPBITS = 1;
    private final int PARIDAD = 0;
    
    public ConexionRS232() {}
    
    private String puertoConectado(){

		String[] portNames = SerialPortList.getPortNames();
		for(int i = 0; i < portNames.length; i++){
			System.out.println(portNames[i]);
		}
		return portNames[0];
	}

	public String leerUsart(){
                System.out.println("LectoraUsart");
		SerialPort serialPort = new SerialPort(puertoConectado());
		String buffer = null;
		
		try {
			serialPort.openPort();//Open serial port
			serialPort.setParams(VELOCIDAD, DATABITS, STOPBITS, PARIDAD);//Set params.
			buffer = serialPort.readString(4);//Read 10 bytes from serial port
			serialPort.closePort();//Close serial port
			System.out.println("Se ha cerrado el puerto serial");
		}
		catch (SerialPortException ex) {
			System.out.println(ex);
		}
                System.out.println("buffer: "+buffer);
		return buffer;
	}

	public void escribirUsart(String texto){
		SerialPort serialPort = new SerialPort(puertoConectado());
		try {
			serialPort.openPort();//Open serial port

			serialPort.setParams(VELOCIDAD, DATABITS, STOPBITS, PARIDAD);
			serialPort.writeBytes(texto.getBytes());//Write data to port
			serialPort.closePort();//Close serial port
			System.out.println("Se ha cerrado el puerto serial");
			
		}
		catch (SerialPortException ex) {
			System.out.println(ex);
		}
	}
}