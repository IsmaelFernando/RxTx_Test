package com.digi.xbee.hwracing;


import com.digi.xbee.api.listeners.IDataReceiveListener;
import com.digi.xbee.api.models.XBeeMessage;

public class Listener implements IDataReceiveListener {
	String str;
	GUI gui;
	
	public Listener(GUI gui)
	{
		this.gui = gui;
	}
	@Override
	public void dataReceived(XBeeMessage xbeeMessage) {
		 str = new String(xbeeMessage.getData());
		 gui.txtReceivedData.setText(str);
	}
}
