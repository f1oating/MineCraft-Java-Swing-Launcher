package gui;

import javax.swing.*;

import back.DataUserName;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class UserNameField{
	private JTextField userName;
	private DataUserName dataUserName;
	
	public JTextField createUserNameField() {
		dataUserName = new DataUserName();
		userName = new JTextField();
        userName.setBounds(new Rectangle(20, 500, 150, 30));
        userName.setText(dataUserName.getUserName());
        userName.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent arg0) {
                dataUserName.setUserName(userName.getText());
            }

            @Override
            public void focusGained(FocusEvent arg0) {
            }
        } );
        
        return userName;
	}
}
