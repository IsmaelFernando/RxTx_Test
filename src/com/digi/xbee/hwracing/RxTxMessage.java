package com.digi.xbee.hwracing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.digi.xbee.api.RemoteXBeeDevice;
import com.digi.xbee.api.XBeeDevice;
import com.digi.xbee.api.XBeeNetwork;
import com.digi.xbee.api.exceptions.TimeoutException;
import com.digi.xbee.api.exceptions.XBeeException;
import com.digi.xbee.api.models.XBee64BitAddress;
import com.digi.xbee.api.utils.HexUtils;

/**
* XBee RX/TX Example application
*
* TX: Write in left pannel, and press send button
* RX: Received messages will show in right pannel
*
 */
public class RxTxMessage {
	
	/**
	 * Application main method.
	 * 
	 * @param args Command line arguments.
	 * @throws XBeeException 
	 * @throws TimeoutException 
	 */
	public static void main(String[] args) throws TimeoutException, XBeeException {
		
		// Launch GUI
		final GUI view = new GUI();
		view.setVisible(true);
		ActionListener actionListener;
		
		// Instantiate an XBee device object.
		final XBeeDevice myLocalXBeeDevice = new XBeeDevice("/dev/ttyUSB0", 9600); //Change to COM if using WINDOWS!!
		try {
			myLocalXBeeDevice.open(); //Open the device
			myLocalXBeeDevice.addDataListener(new Listener(view)); //Add the listener for received messages
		} catch (XBeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		actionListener = new ActionListener() { //Send button pressed
            public void actionPerformed(ActionEvent actionEvent) {      
          	  String text = view.txtDataToSend.getText();// Get data from left pannel
          	  try {
				myLocalXBeeDevice.sendDataAsync(new RemoteXBeeDevice(myLocalXBeeDevice,myLocalXBeeDevice.getDestinationAddress()), text.getBytes()); // Destination address already stored in XBEE!!
			} catch (XBeeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
      };                
      view.getButton().addActionListener(actionListener);   
  } 
    
}