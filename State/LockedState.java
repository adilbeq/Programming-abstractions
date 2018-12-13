package lect10;

public class LockedState extends State {

	public LockedState(AudioPlayer player) {
		super(player);
	}

	@Override
	public void lock() {
		player.state = new ReadyState(player);
	}

	@Override
	public void prev() {
		// TODO Auto-generated method stub

	}

	@Override
	public void next() {
		// TODO Auto-generated method stub

	}

	@Override
	public void play() {
		// TODO Auto-generated method stub

	}

}
