package lect10;

public class ReadyState extends State{

	public ReadyState(AudioPlayer player) {
		super(player);
	}

	@Override
	public void lock() {
		player.state = new LockedState(player);
	}

	@Override
	public void prev() {
		player.prevTrack();
	}

	@Override
	public void next() {
		player.nextTrack();
	}

	@Override
	public void play() {
		player.player.play();
		player.state = new PlayingState(player);
	}

}
