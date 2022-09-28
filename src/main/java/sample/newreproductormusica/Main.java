package sample.newreproductormusica;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * This class kickstarts the project and runs the essential functions of the GUI.
 *
 * @author Franco Sagot
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            //Loads the initial Scene
            Parent root = FXMLLoader.load(getClass().getResource("musicPlayer.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent windowEvent) {

                    Platform.exit();
                    System.exit(0);
                }
            });

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] Args){
        launch(Args);

    }
}

