package com.play.audio;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
public class Sound {
	public static Mixer mixer;
	public static Clip clip;
	private static ArrayList<Clip> clips;
	private static ArrayList<AudioInputStream> audioStreams;
	private static ArrayList<File> files;
	
	public static void init() {
		files = new ArrayList<File>();
		files.add(new File("res\\sound\\bensound-memories.wav"));
		clips = new ArrayList<Clip>();
		audioStreams = new ArrayList<AudioInputStream>();
		Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
		 for(Mixer.Info info:mixInfos) {
			System.out.println(info.getName() + "---" + info.getDescription());
		} 
		
		mixer = AudioSystem.getMixer(mixInfos[0]);
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		try { 
			for(File f:files){
				clips.add((Clip)mixer.getLine(dataInfo)); 
			}
		}
		catch (LineUnavailableException lue) { lue.printStackTrace(); }
		try {
			for(int i = 0; i<files.size(); i++){
				if(!files.get(i).exists()) {
					System.err.println("File at " + files.get(i).getAbsolutePath() + " does not exist.");
					System.exit(1);
				}
				
				audioStreams.add(AudioSystem.getAudioInputStream(files.get(i)));
				clips.get(i).open(audioStreams.get(i));
			}
		}
		catch (LineUnavailableException lue) { lue.printStackTrace(); }
		catch (UnsupportedAudioFileException uafe) { uafe.printStackTrace(); }
		catch (IOException ioe) { ioe.printStackTrace(); }
		
		clips.get(0).start();
//		while(true) {
//			update();
//		}
		
//		do {
//			try { Thread.sleep(50); }
//			catch (InterruptedException ie) { ie.printStackTrace(); }
//		} while(clip.isActive());
		
		//clips.get(0).loop(Clip.LOOP_CONTINUOUSLY);
		
//		 Thread t = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println(Double.valueOf(clips.get(0).getFramePosition()) / Double.valueOf(clips.get(0).getFrameLength()) * 100 + "%");
//					System.out.println(clips.get(0).getFramePosition() + " " + clips.get(0).getFrameLength());
//					if(Double.valueOf(clips.get(0).getFramePosition()) / Double.valueOf(clips.get(0).getFrameLength()) * 100 == 100) {
//						System.out.println("DONE");
//						clips.get(0).setFramePosition(0);
//						clips.get(0).start();
//					}
//				}
//				
//			}});
		 
		}
	
	public static void playSound(int soundID){
		//clips.get(soundID).setFramePosition(0);
		
		clips.get(soundID).start();
	}
	
	
	}