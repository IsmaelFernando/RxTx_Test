package com.digi.xbee.hwracing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	public JButton btnSend;
	public JTextField txtDataToSend;
	public JTextField txtReceivedData;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 269, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		txtDataToSend = new JTextField();
		txtDataToSend.setText("Send data");
		contentPane.add(txtDataToSend, BorderLayout.WEST);
		txtDataToSend.setColumns(10);
		
		btnSend = new JButton("Send");
		contentPane.add(btnSend, BorderLayout.SOUTH);
		
		txtReceivedData = new JTextField();
		txtReceivedData.setText("Received data");
		contentPane.add(txtReceivedData, BorderLayout.EAST);
		txtReceivedData.setColumns(10);
	}
	
    public JButton getButton(){
        return btnSend;
    }
    
    public void setText(String text){
        txtDataToSend.setText(text);
    }
    

}
