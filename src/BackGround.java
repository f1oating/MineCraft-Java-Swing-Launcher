
import javax.swing.*;
import java.awt.*;

public class BackGround {
	
	private JLabel back;
	private ImageIcon background;
    private Image img;
    private Image temp;
    private String pcName = System.getProperty("user.name");
    
    private int width;
    private int height;
    
    BackGround(JFrame frame){
    	this.width = frame.getWidth();
    	this.height = frame.getHeight();
    }
    
    public JLabel createBackGround() {
    	background=new ImageIcon(String.format("C:\\Users\\%s\\.f1oatingMineCraft\\launcher\\background.jpg", pcName));
        img=background.getImage();
        temp=img.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,900,600);
        
        return back;
    }
	
}
