package lect10;

public abstract class State {
	AudioPlayer player;
	
	public State(AudioPlayer player){
		this.player = player;
	}
	
	public abstract void lock();
	public abstract void prev();
	public abstract void next();
	public abstract void play();
	
}
