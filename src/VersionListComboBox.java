
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class VersionListComboBox {
	
	private JComboBox<String> versionList;
	private String pcName = System.getProperty("user.name");
	private String[] versions = {"1.5.2", "1.5.1", "1.4.7", "1.4.6", "1.4.5", "1.4.4", "1.4.2", 
								 "1.3.2", "1.3.1", "1.2.5", "1.2.4", "1.2.3", "1.2.2", "1.2.1",
								 "1.1", "1.0"};
	private Properties properties;
	
	public JComboBox<String> createVersionListComboBox() {
		versionList = new JComboBox<String>(versions);
        versionList.setSelectedIndex(getSelectedIndex());
        versionList.setMaximumRowCount(5);
        versionList.setBounds(new Rectangle(190, 500, 150, 30));
        versionList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setSelectedText(versionList.getSelectedItem());
        	}
        });
        
        return versionList;
	}
	
	private int getSelectedIndex() {
		properties = new Properties();
		String dbVersion = "1.5.2";
		int index = 0;
		try {
			FileInputStream stream = 
					new FileInputStream(String.format("C:\\Users\\%s\\.f1oatingMineCraft\\launcher\\config.properties", pcName));
			properties.load(stream);
			dbVersion = properties.getProperty("database.version");
			stream.close();
			index = findIndex(versions, dbVersion);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return index;
	}
	
	private void setSelectedText(Object text) {
		properties = new Properties();
		String dbVersion = text.toString();
		try {
			FileInputStream stream = 
					new FileInputStream(String.format("C:\\Users\\%s\\.f1oatingMineCraft\\launcher\\config.properties", pcName));
			properties.load(stream);
			properties.setProperty("database.version", dbVersion);
			stream.close();
			
			FileOutputStream outputStream = 
					new FileOutputStream(String.format("C:\\Users\\%s\\.f1oatingMineCraft\\launcher\\config.properties", pcName));
	        properties.store(outputStream, null);
	        outputStream.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private int findIndex(String[] versions, String dbVersion) {
		for(int i = 0; i < versions.length; i++) {
			if(versions[i].equals(dbVersion)) {
				return i;
			}
		}
		return 0;
	}
}


