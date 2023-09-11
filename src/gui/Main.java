package gui;

import javax.swing.*;
import java.awt.*;

public class Main{

    private JFrame frame;
    private String pcName = System.getProperty("user.name");

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
                main.createAndShowGUI();
            }
        });
    }
    
    public void createAndShowGUI(){
    	
        frame = new JFrame();
        frame.setTitle("Minecraft launcher by f1oating 0.1");
        frame.setIconImage(
        		new ImageIcon(String.format("C:\\Users\\%s\\.f1oatingMineCraft\\launcher\\launcherIcon.jpg", pcName))
        		.getImage());
        frame.setSize(new Dimension(900, 600));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        frame.add(new UserNameField().createUserNameField());
        frame.add(new VersionListComboBox().createVersionListComboBox());
        frame.add(new PlayButtonJButton().createPlayButton());
        frame.add(new BackGround(frame).createBackGround());
        frame.setVisible(true);
    }
}