import javafx.geometry.Insets;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.stage.StageStyle;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.stage.StageStyle;   
import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.*;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;
import javafx.scene.image.*;
import javafx.geometry.Insets;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;

public class Test extends Application {
	public static void main(String[] args) throws Exception {
        launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Car car = new Car();
		GearBoxState drive = new Drive();
		GearBoxState neutral = new Neutral();
		GearBoxState park = new Park();
		GearBoxState reverse = new Reverse();
		
        stage.initStyle(StageStyle.UNDECORATED);
		StackPane pane = new StackPane();

		Image img = new Image("close_btn.png");
		Rectangle close = new Rectangle(20, 20);
        close.setFill(new ImagePattern(img));
        pane.setAlignment(close, Pos.TOP_RIGHT);
        Image image = new Image("Park.png");
		ImageView gearIMG = new ImageView(image);
		

		Button driveButton = new Button();
		driveButton.setText("Drive");

		Button parkButton = new Button();
		parkButton.setText("Park");


		Button neutralButton = new Button();
		neutralButton.setText("Neutral");
		
		Button reverseButton = new Button();
		reverseButton.setText("Reverse");


		HBox hbox = new HBox();
		HBox.setHgrow(driveButton, Priority.ALWAYS);
    	HBox.setHgrow(parkButton, Priority.ALWAYS);
    	HBox.setHgrow(neutralButton, Priority.ALWAYS);
    	HBox.setHgrow(reverseButton, Priority.ALWAYS);
    	driveButton.setMaxWidth(Double.MAX_VALUE);
     	parkButton.setMaxWidth(Double.MAX_VALUE);
     	neutralButton.setMaxWidth(Double.MAX_VALUE);
     	reverseButton.setMaxWidth(Double.MAX_VALUE);

		hbox.getChildren().addAll(driveButton, parkButton, neutralButton, reverseButton);
		pane.setAlignment(hbox, Pos.BOTTOM_CENTER);

		driveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	car.setState(drive);
				car.changeGear();
				System.out.println(car.moving);
                Image image = new Image("Drive.png");
				ImageView gearIMG = new ImageView(image);
				HBox hbox = new HBox();
				HBox.setHgrow(driveButton, Priority.ALWAYS);
		    	HBox.setHgrow(parkButton, Priority.ALWAYS);
		    	HBox.setHgrow(neutralButton, Priority.ALWAYS);
		    	HBox.setHgrow(reverseButton, Priority.ALWAYS);
		    	hbox.getChildren().addAll(driveButton, parkButton, neutralButton, reverseButton);
				pane.getChildren().addAll(gearIMG, hbox);
			}
        });

        parkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	car.setState(park);
				car.changeGear();
				System.out.println(car.moving);
                Image image = new Image("Park.png");
				ImageView gearIMG = new ImageView(image);
				HBox hbox = new HBox();
				HBox.setHgrow(driveButton, Priority.ALWAYS);
		    	HBox.setHgrow(parkButton, Priority.ALWAYS);
		    	HBox.setHgrow(neutralButton, Priority.ALWAYS);
		    	HBox.setHgrow(reverseButton, Priority.ALWAYS);
		    	hbox.getChildren().addAll(driveButton, parkButton, neutralButton, reverseButton);
				pane.getChildren().addAll(gearIMG, hbox);
			}
        });

        neutralButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	car.setState(neutral);
				car.changeGear();
				System.out.println(car.moving);
                Image image = new Image("Neutral.png");
				ImageView gearIMG = new ImageView(image);
				HBox hbox = new HBox();
				HBox.setHgrow(driveButton, Priority.ALWAYS);
		    	HBox.setHgrow(parkButton, Priority.ALWAYS);
		    	HBox.setHgrow(neutralButton, Priority.ALWAYS);
		    	HBox.setHgrow(reverseButton, Priority.ALWAYS);
		    	hbox.getChildren().addAll(driveButton, parkButton, neutralButton, reverseButton);
				pane.getChildren().addAll(gearIMG, hbox);
			}
        });

        reverseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	car.setState(reverse);
				car.changeGear();
				System.out.println(car.moving);
                Image image = new Image("Reverse.png");
				ImageView gearIMG = new ImageView(image);
				HBox hbox = new HBox();
				HBox.setHgrow(driveButton, Priority.ALWAYS);
		    	HBox.setHgrow(parkButton, Priority.ALWAYS);
		    	HBox.setHgrow(neutralButton, Priority.ALWAYS);
		    	HBox.setHgrow(reverseButton, Priority.ALWAYS);
		    	hbox.getChildren().addAll(driveButton, parkButton, neutralButton, reverseButton);
				pane.getChildren().addAll(gearIMG, hbox);
			}
        });

		//pane.getChildren().addAll(gearIMG, driveButton, parkButton, neutralButton, reverseButton);
		pane.getChildren().add(gearIMG);
		
		pane.getChildren().add(hbox);

		Scene scene = new Scene(pane, 500, 500);
		stage.setScene(scene);
		//stage.setResizable(false);
		stage.setTitle("GearBox");
		stage.show();
	}
	
}

