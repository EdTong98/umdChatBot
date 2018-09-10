import java.awt.event.*;
import java.io.File;
import java.awt.*;
import javax.swing.*;
import jaco.mp3.player.MP3Player;
public class MusicWindow extends JFrame{
	private JPanel panel;
	private JButton play;
	private JButton pause;
	private JButton stop;
	private JLabel label;
	private JLabel label2;
	private JLabel label3;
	private ImageIcon flag;
	private ImageIcon mdPic;
	

	
	private static final String SONG = "UMD.mp3";
	
	public MusicWindow() {
		
		panel = new JPanel(new GridLayout(2,3));
		panel.setBackground(new Color(255,0,0));
		add(panel);
		label = new JLabel("This is the MaryLand State Song. After exiting, press enter"); 
		panel.add(label);
	    flag = new ImageIcon(getClass().getResource("mdIcon.png"));
	    label2 = new JLabel(flag);
	    panel.add(label2);
	    
	    mdPic = new ImageIcon(getClass().getResource("mdState.png"));
	    label3 = new JLabel(mdPic);
	    panel.add(label3);
        
	    play = new JButton("Play") ;
	    panel.add(play);
	    pause = new JButton("Pause");
	    panel.add(pause);
	    stop = new JButton("Stop");
	    panel.add(stop);
	    
	
		event1 pl = new event1();
		play.addActionListener(pl);
		event2 p = new event2();
		pause.addActionListener(p);
		event3 s = new event3();
		stop.addActionListener(s);
		
	}
	MP3Player mp3 = new MP3Player(new File(SONG));
	
	public class event1 implements ActionListener{
		public void actionPerformed(ActionEvent pl) {
			mp3.play();
		}
	}
	public class event2 implements ActionListener{
		public void actionPerformed(ActionEvent p) {
			mp3.pause();
		}
	}
	public class event3 implements ActionListener{
		public void actionPerformed(ActionEvent s) {
			mp3.stop();
		}
	}
	public static void main(String [] args) {
		MusicWindow gui = new MusicWindow();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setTitle("Maryland State Song");
		gui.pack();
		gui.setVisible(true);
		
		
	}
	
	
	
	
	

}

