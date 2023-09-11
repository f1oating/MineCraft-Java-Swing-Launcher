package back;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class DataUserName {
	
	private Properties properties;
	private String pcName = System.getProperty("user.name");
	
	public String getUserName() {
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
	
	public void setUserName(String text) {
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

