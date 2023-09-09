
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.*;

public class PlayButtonJButton{
	
	private JButton playButton;
	private Properties properties;
	private JFrame frame;
	private String pcName = System.getProperty("user.name");
	
	PlayButtonJButton(JFrame frame){
		this.frame = frame;
	}
	
	public JButton createPlayButton() {
		playButton = new JButton();
        playButton.setText("Play");
        playButton.setBounds(380, 480, 200, 70);
        playButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		launchMineCraft(getUserName(), getVersion());
        	}
        });
        
        return playButton;
	}
	
	private String getUserName() {
		properties = new Properties();
		String userName = "Steve";

		try {
			FileInputStream stream = 
					new FileInputStream(String.format("C:\\Users\\%s\\.f1oatingMineCraft\\launcher\\config.properties", pcName));
			properties.load(stream);
			userName = properties.getProperty("database.userName");
			stream.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return userName;
	}
	
	private String getVersion() {
		properties = new Properties();
		String version = "1.5.2";
		try {
			FileInputStream stream = 
					new FileInputStream(String.format("C:\\Users\\%s\\.f1oatingMineCraft\\launcher\\config.properties", pcName));
			properties.load(stream);
			version = properties.getProperty("database.version");
			stream.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return version;
	}
	
	private void launchMineCraft(String userName, String version) {
		
		List<String> command = new ArrayList<>();
		
		String gameDir = String.format("--gameDir C:\\Users\\%s\\.f1oatingMineCraft\\instances\\%s ", pcName ,version);
		String assetsDir = String.format("--assetsDir C:\\Users\\%s\\.f1oatingMineCraft\\assets ", pcName);
		
		String cp = 
				String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\net\\minecraft\\launchwrapper\\1.11\\launchwrapper-1.11.jar;", pcName) +
				String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\net\\sf\\jopt-simple\\jopt-simple\\4.6\\jopt-simple-4.6.jar;", pcName) +
				String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\org\\ow2\\asm\\asm-debug-all\\5.0.3\\\\asm-debug-all-5.0.3.jar;", pcName) +
				String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\org\\lwjgl\\lwjgl\\lwjgl\\2.9.1\\lwjgl-2.9.1.jar;", pcName) +
				String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\org\\lwjgl\\lwjgl\\lwjgl_util\\2.9.1\\lwjgl_util-2.9.1.jar;", pcName) +
				String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\org\\apache\\logging\\log4j\\log4j-api\\2.0-beta9\\log4j-api-2.0-beta9.jar;", pcName) +
				String.format("C:\\Users\\%s\\.f1oatingMineCraft\\libraries\\org\\apache\\logging\\log4j\\log4j-core\\2.0-beta9\\log4j-core-2.0-beta9.jar;", pcName) +
				String.format("C:\\Users\\%s\\.f1oatingMineCraft\\versions\\%s\\%s.jar ", pcName ,version, version);
		
		
		
		command.add(String.format("C:\\Users\\%s\\.f1oatingMineCraft\\jre\\jdk8u382-b05-jre\\bin\\java.exe ", pcName));
		command.add("-Xmx2G ");
		command.add("-Xms1G ");
		command.add(String.format("-Djava.library.path=C:\\Users\\%s\\.f1oatingMineCraft\\versions\\natives ", pcName));
		command.add("-Dminecraft.launcher.brand=f1oatingMineCraft ");
		command.add("-Dminecraft.launcher.version=0.1 ");
		command.add("-cp ");
		command.add(cp);
		command.add("net.minecraft.launchwrapper.Launch ");
		command.add(gameDir);
		command.add(assetsDir);
		command.add(userName);		
		
		Thread thread = new Thread(new Runnable() {
			public void run() {
				try {
					
					Process process = Runtime.getRuntime().exec(String.join(" ", command));
					
					frame.setVisible(false);
					
					InputStream inputStream = process.getInputStream();
		            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		            
		            String line;
		            while ((line = reader.readLine()) != null) {
		                System.out.println(line);
		            }

		            
		            @SuppressWarnings("unused")
					int exitCode = process.waitFor();
		            
		            frame.setVisible(true);
		            
				}catch(IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		thread.start();
		
	}
	
}
