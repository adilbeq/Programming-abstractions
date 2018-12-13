import javafx.scene.media.AudioClip;

public class Sound extends SoundAbstractPlayer {
    int cycleCount = 1;
    int rate = 1;
    int volume = 50;
    int delay = 1;
    String src;

    public Sound(String src) {
        this.src = src;
        audioClip = new AudioClip(getClass().getClassLoader().getResource(src).toString());
    }

    public Sound(int cycleCount, int rate, int volume) {
        this.cycleCount = cycleCount;
        this.rate = rate;
        this.volume = volume;
    }

    public void setCycleCount(int cycleCount) {
        this.cycleCount = cycleCount;
        audioClip.setCycleCount(cycleCount);
    }

    public void setRate(int rate) {
        this.rate = rate;
        audioClip.setRate(rate);
    }

    public void setVolume(int volume) {
        this.volume = volume;
        audioClip.setVolume(volume);
    }

    public void play() {
        audioClip.play();
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }
    
    public void pause() {
        audioClip.stop();
    }
}
