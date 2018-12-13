import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import javafx.geometry.Pos;

public class MusicPlayer extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    BorderPane borderPane = new BorderPane();
    Button buttonPlay = new Button("Play");

    public void start(Stage primaryStage) {
        Image image = new Image("Screenshot_2.png");
        ImageView mv = new ImageView(image);
        borderPane.getChildren().addAll(mv); 

        SoundsComposite sounds = new SoundsComposite();
        runAllnotesIn(sounds);
    
        borderPane.setAlignment(buttonPlay, Pos.CENTER);
        borderPane.setBottom(buttonPlay);

        buttonPlay.setOnAction(e -> sounds.play());
        Scene scene = new Scene(borderPane, 1010, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void runAllnotesIn(SoundsComposite sounds){
        Sound Do = new Sound("do.wav");
        Sound Re = new Sound("re.wav");
        Sound Mi = new Sound("mi.wav");
        Sound Fa = new Sound("fa.wav");
        Sound Sol = new Sound("sol.wav");
        Sound La = new Sound("la.wav");
        Sound Si = new Sound("si.wav");
        sounds.add(Do, Re, Mi, Fa, Sol, La, Si);    
    }
}
