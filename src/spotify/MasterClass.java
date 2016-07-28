package spotify;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MasterClass {

	FileInputStream FIS;
	BufferedInputStream BIS;
	public long SongTotalLength;
	public long PauseLocation;
	public String FilePath;
	
	public Player Spotify;
	
	public void Stop(){
		if(Spotify != null){
				
				PauseLocation = SongTotalLength;
				MainGui.Display.setText("STOPPED");
				Spotify.close();
				
		}
	}
	
	public void pause(){
		if(Spotify != null){
			try {
				PauseLocation = FIS.available();
				MainGui.Display.setText("PAUSED");
				Spotify.close();
			} catch (IOException e) {
				
			}
		}
	}
	
	public void resume(){
		try {
			FIS = new FileInputStream(FilePath);
			SongTotalLength = FIS.available();
			FIS.skip(SongTotalLength - PauseLocation);
			BIS = new BufferedInputStream(FIS);
			Spotify = new Player(BIS);
						
			}catch(FileNotFoundException | JavaLayerException e) {
			}		
		    catch (IOException e) {
		    }
		new Thread(){
			@Override
			public void run(){
				try {
					Spotify.play();
					if(Spotify.isComplete()){
						MainGui.Stop.setVisible(false);
						MainGui.Play.setVisible(true);
						MainGui.Play.setBounds(5, 195, 185, 185);
						MainGui.Display.setText("Replay?");			
					}
				} catch (JavaLayerException e) {
					
				}
			}
		}.start();
	        
		
	}
	
	public void Play(String path){
		try {
			FIS = new FileInputStream(path);
			BIS = new BufferedInputStream(FIS);
			Spotify = new Player(BIS);
			FilePath = path + "";
			SongTotalLength = FIS.available();		
			} catch (JavaLayerException | FileNotFoundException ex) {
				
			}
			catch (IOException e) {
			  //because of	FIS>availabe
			}	
			
		new Thread(){
			@Override
			// rum method starts any thread
			public void run(){
				try {
					Spotify.play();
				} catch (JavaLayerException e) {
					
				}
			}
		}.start();
			
		
	}
	
}
