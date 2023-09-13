package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import back.DataUserName;
import back.DataVersions;
import back.Launch;

public class PlayButtonJButton{
	
	private JButton playButton;
	private DataUserName dataUserName;
	private DataVersions dataVersions;
	private Launch launch;
	private JFrame frame;
	
	PlayButtonJButton(JFrame frame){
		this.frame = frame;
	}
	
	public JButton createPlayButton() {
		playButton = new JButton();
		dataUserName = new DataUserName();
		dataVersions = new DataVersions();
		launch = new Launch();
        playButton.setText("Play");
        playButton.setBounds(380, 480, 200, 70);
        playButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {     
        		
        		SwingWorker<Void, Void> minecraftExecute = new SwingWorker<Void, Void>(){
        			@Override
        			protected Void doInBackground() throws Exception {
        				frame.setVisible(false);
        				
        				launch.launchMineCraft(dataUserName.getUserName(), dataVersions.getVersion());
        				
        				return null;
        			}
        			
        			@Override
        			protected void done() {
        				frame.setVisible(true);
        			}
        		};
        		
        		minecraftExecute.execute();
        	}
        });
        
        return playButton;
	}
	
}
