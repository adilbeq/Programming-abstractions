import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;

public abstract class SoundAbstractPlayer {
    AudioClip audioClip;
    abstract void setCycleCount(int cycleCount);
    abstract void setRate(int rate);
    abstract void setVolume(int volume);
    abstract void play();
    abstract void pause();
}
