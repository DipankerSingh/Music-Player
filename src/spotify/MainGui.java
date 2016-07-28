package spotify;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileFilter;

public class MainGui {
	public JFrame MainFrame; 
	public JLabel Background, Add;
	public static JLabel Play;
	public JLabel Pause;
	public static JLabel Stop;
	public static JLabel Display;
	public JPanel panel2;
	public String name;
	public String openlastlocation;
	MasterClass MC = new MasterClass();
	
	public MainGui(){
		gui();
	}
	
	public void gui(){
		MainFrame = new JFrame("SPOTIFY-INDIA");
		
		Background = new JLabel(new ImageIcon("E:\\coding\\java_project\\layers\\layer1.png"));
		Add = new JLabel(new ImageIcon("E:\\coding\\java_project\\layers\\layer2.png"));
		Play = new JLabel(new ImageIcon("E:\\coding\\java_project\\layers\\play.png"));
		Pause = new JLabel(new ImageIcon("E:\\coding\\java_project\\layers\\pause.png"));
		Stop = new JLabel(new ImageIcon("E:\\coding\\java_project\\layers\\stop.png"));
		
		Font myfont =new Font("AmericanCaptain",Font.PLAIN,20);
		
		
		Display = new JLabel("Chose File To Play Music");
		Display.setLayout(null);
		Display.setBounds(0,0,185,185);
		Display.setFont(myfont);
		Display.setForeground(Color.white);
		
		
		MainFrame.setLayout(null);
		MainFrame.setSize(390,410);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		MainFrame.setLocation(dim.width/2-MainFrame.getSize().width/2, dim.height/2-MainFrame.getSize().height/2);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Background.setLayout(null);
		Background.setSize(400,400);
		Background.setBounds(0, 0, 400, 400);
		
		MainFrame.add(Background);
		
		Add.setLayout(null);
		Add.setSize(185,185);
		Add.setBounds(5,5,185,185);
		
		Background.add(Add);
		
		Play.setLayout(null);
		Play.setSize(185, 185);
		Play.setBounds(5,195,185,185);
		
		Background.add(Play);
		
		Pause.setLayout(null);
		Pause.setSize(185, 185);
		Pause.setBounds(195,195,185,185);
		
		Background.add(Pause);
		
		Stop.setLayout(null);
		Stop.setSize(185, 185);
		Stop.setBounds(5,195,185,185);
		Stop.setVisible(false);
		Background.add(Stop);
		
		panel2= new JPanel();
		panel2.setBackground(new Color(108,42,128));
		panel2.add(Display);
		panel2.setLayout(null);
		panel2.setSize(185,185);
		panel2.setBounds(195,5,185,185);
		
		Background.add(panel2);
				
		MainFrame.setVisible(true);
		MainFrame.setResizable(false);
	
		Add.addMouseListener(
				new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
							FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3  Files","mp3","mpeg3");
							JFileChooser chooser;
							if (openlastlocation==null)
								chooser = new JFileChooser("C:\\Users\\Dipanker\\Music");
							else
								chooser = new JFileChooser(openlastlocation);
							chooser.addChoosableFileFilter(filter);
							int returnval = chooser.showOpenDialog(null);
							if(returnval == JFileChooser.APPROVE_OPTION){
							Play.setVisible(false);
							Play.setBounds(195,195,185,185);
							Stop.setVisible(true);
							Pause.setVisible(true);
							openlastlocation=chooser.getSelectedFile().getParent() + "";
							File myfile = chooser.getSelectedFile();
							String Song = myfile + "";
							MC.Stop();
							name = chooser.getSelectedFile().getName();
							Display.setText(name);
							MC.Play(Song);
							}
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				}
				);

		
		Play.addMouseListener(
				new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
							if(Display.getText()!= "Chose File To Play Music" ){			
							if(Pause.isVisible()){
							Play.setVisible(false);
							Stop.setVisible(true);
							Display.setText(name);
							MC.resume();
							
							}
							else{
								Play.setVisible(false);
								Pause.setVisible(true);
								Display.setText(name);
								MC.resume();
							}
							}
							
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				}
				);
		
		Stop.addMouseListener(
				new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
							Stop.setVisible(false);
							Play.setVisible(true);
							Play.setBounds(5,195, 185, 185);
							Pause.setVisible(true);
							MC.Stop();
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				}
				);
			
		Pause.addMouseListener(
				new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
							if(!Play.isVisible()){
							Pause.setVisible(false);
							Play.setBounds(195,195, 185, 185);
							Play.setVisible(true);
							MC.pause();
							}
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				}
				);
		
	}
	
	public static void main(String[] args){
		new MainGui();
	}
	
	
	
	
}
