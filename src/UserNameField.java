
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UserNameField{
	private JTextField userName;
	private Properties properties;
	private String pcName = System.getProperty("user.name");
	
	public JTextField createUserNameField() {
		userName = new JTextField();
        userName.setBounds(new Rectangle(20, 500, 150, 30));
        userName.setText(getUserName());
        userName.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent arg0) {
                setUserName(userName.getText());
            }

            @Override
            public void focusGained(FocusEvent arg0) {
            }
        } );
        
        return userName;
	}
	
	private String getUserName() {
		properties = new Properties();
		String dbUserName = "Steve";
		try {
			FileInputStream stream = 
					new FileInputStream(String.format("C:\\Users\\%s\\.f1oatingMineCraft\\launcher\\config.properties", pcName));
			properties.load(stream);
			dbUserName = properties.getProperty("database.userName");
			stream.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return dbUserName;
	}
	
	private void setUserName(String text) {
		properties = new Properties();
		String dbUserName = text;
		try {
			FileInputStream stream = 
					new FileInputStream(String.format("C:\\Users\\%s\\.f1oatingMineCraft\\launcher\\config.properties", pcName));
			properties.load(stream);
			properties.setProperty("database.userName", dbUserName);
			stream.close();
			
			FileOutputStream outputStream = 
					new FileOutputStream(String.format("C:\\Users\\%s\\.f1oatingMineCraft\\launcher\\config.properties", pcName));
	        properties.store(outputStream, null);
	        outputStream.close();
	        
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
