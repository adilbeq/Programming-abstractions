import java.util.ArrayList;
import java.util.Arrays;

public class SoundsComposite extends SoundAbstractPlayer {

    ArrayList<Sound> sounds = new ArrayList<>();

    public void add(Sound... s) {
        sounds.addAll(Arrays.asList(s));
    }

    public void setCycleCount(int cycleCount) {
        for (Sound sound : sounds) {
            sound.setCycleCount(cycleCount);
        }
    }

    public void setRate(int rate) {
        for (Sound sound : sounds) {
            sound.setRate(rate);
        }

    }

    public void setVolume(int volume) {
        for (Sound sound : sounds) {
            sound.setVolume(volume);
        }
    }

    public void play() {
        for (Sound sound : sounds) {
            try {
                Thread.sleep(sound.getDelay() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sound.play();
        }
    }
    
    public void pause() {
        for (Sound sound : sounds) {
            sound.pause();
        }
    }


}
