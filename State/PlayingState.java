package lect10;

public class PlayingState extends State {

	public PlayingState(AudioPlayer player) {
		super(player);
	}

	@Override
	public void lock() {
		player.player.stop();
		player.state = new LockedState(player);
	}

	@Override
	public void prev() {
		player.player.stop();
		player.prevTrack();
		player.player.play();
	}

	@Override
	public void next() {
		player.player.stop();
		player.nextTrack();
		player.player.play();
	}

	@Override
	public void play() {
		player.player.pause();
		player.state = new ReadyState(player);
	}

}
