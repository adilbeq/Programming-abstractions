package lect10;

import java.io.File;
import java.util.ArrayList;

import jaco.mp3.player.MP3Player;

public class AudioPlayer {
	State state;
	ArrayList<String> playlist;
	int track;
	
	File file;
	MP3Player player;
	
	public AudioPlayer(){
		state = new LockedState(this);
		playlist = new ArrayList<>();
		playlist.add("C:\\Users\\Админ\\Desktop\\music\\1.mp3");
		playlist.add("C:\\Users\\Админ\\Desktop\\music\\2.mp3");
		playlist.add("C:\\Users\\Админ\\Desktop\\music\\3.mp3");
		playlist.add("C:\\Users\\Админ\\Desktop\\music\\4.mp3");
		track = 0;
		
		file = new File(playlist.get(track));
		player = new MP3Player(file);
	}
	
	public void prevTrack(){
		track--;
		if(track == -1) track = playlist.size()-1;
		file = new File(playlist.get(track));
		player = new MP3Player(file);
	}
	
	public void nextTrack(){
		track++;
		if(track == playlist.size()) track = 0;
		file = new File(playlist.get(track));
		player = new MP3Player(file);
	}
	
}
