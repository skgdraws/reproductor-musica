package sample.newreproductormusica;

import java.io.File;
import java.net.URL;
import java.util.*;

import com.fazecast.jSerialComm.SerialPort;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * This class controls the scene that JavaFX and SceneBuilder creates.
 * It also manages the logic behind the Audio Player and File loading
 *
 * @author Franco Sagot
 */
public class SceneController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private Label songLabel;
    @FXML
    private Button previousButton, pauseButton, playButton, nextButton, resetButton;
    @FXML
    private Slider volumeSlider;
    @FXML
    private ProgressBar songProgressBar;

    private Media media;
    private MediaPlayer mediaPlayer;

    private File directory;
    private File[] files;

    private ArrayList<File> songs;
    private int songNumber;

    private Timer timer;
    private TimerTask task;
    private boolean running;
    public boolean canLoop;

    /**
     * Initializes and sets up the base GUI which the user interacts with
     * @param url
     * @param resourceBundle
     *
     * @author Franco Sagot
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SerialPort[] ports = SerialPort.getCommPorts();
        System.out.println("Select a port:");
        int i = 1;
        for(SerialPort port : ports)
            System.out.println(i++ +  ": " + port.getSystemPortName());
        Scanner s = new Scanner(System.in);
        int chosenPort = s.nextInt();

        SerialPort serialPort = ports[chosenPort - 1];
        if(serialPort.openPort())
            System.out.println("Port opened successfully.");
        else {
            System.out.println("Unable to open the port.");
            return;
        }
        //serialPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);
        serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 0, 0);

        songs = new ArrayList<File>();

        directory = new File("songs");
        files = directory.listFiles();

        if (files != null){

            for (File file: files) {

                songs.add(file);
            }
        }

        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        songLabel.setText(songs.get(songNumber).getName().substring(4, songs.get(songNumber).getName().length() - 4));

        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
            }
        });
    }

    /**
     * Plays the song that is currently loaded
     *
     * @author Franco Sagot
     */
    public void playSong(){

        beginTimer();
        mediaPlayer.play();
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
            }
        });
    }

    /**
     * Pauses the song that the media player is currently playing
     *
     * @author Franco Sagot
     */
    public void pauseSong(){

        stopTimer();
        mediaPlayer.pause();
    }

    /**
     * Stops the song that's currently playing and proceed to load the one before
     *
     * @author Franco Sagot
     */
    public void prevSong(){

        if(songNumber > 0){

            songNumber--;

            mediaPlayer.stop();

            if(running) stopTimer();

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            songLabel.setText(songs.get(songNumber).getName().substring(4, songs.get(songNumber).getName().length() - 4));
            playSong();
        }
        else{
            canLoop = true;
            if(canLoop) {
                songNumber = songs.size() - 1;

                mediaPlayer.stop();

                if(running) stopTimer();

                media = new Media(songs.get(songNumber).toURI().toString());

                mediaPlayer = new MediaPlayer(media);
                songLabel.setText(songs.get(songNumber).getName().substring(4, songs.get(songNumber).getName().length() - 4));
            }
            else{
                mediaPlayer.stop();
            }
        }
    }

    /**
     * Stops the song that's currently playing and proceed to load the song that comes next
     *
     * @author Franco Sagot
     */
    public void nextSong(){

        if(songNumber < songs.size() - 1){

            songNumber++;

            if(running) stopTimer();

            mediaPlayer.stop();
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            songLabel.setText(songs.get(songNumber).getName().substring(4, songs.get(songNumber).getName().length() - 4));
            playSong();
        }
        else{
            canLoop = true;
            if(canLoop) {
                songNumber = 0;

                if(running) stopTimer();

                mediaPlayer.stop();
                media = new Media(songs.get(songNumber).toURI().toString());
                mediaPlayer = new MediaPlayer(media);
                songLabel.setText(songs.get(songNumber).getName().substring(4, songs.get(songNumber).getName().length() - 4));
            }
            else{
                mediaPlayer.stop();
            }
        }
    }

    /**
     * Restarts the song that is currently loading
     *
     * @author Franco Sagot
     */
    public void resetSong(){

        songProgressBar.setProgress(0);
        mediaPlayer.seek(Duration.seconds(0));
    }

    /**
     * Updates the song's progress bar every second while the song is playing
     *
     * @author Franco Sagot
     */
    public void beginTimer(){

        timer = new Timer();
        task = new TimerTask(){

            public void run(){

                running = true;
                double current = mediaPlayer.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();
                songProgressBar.setProgress(current/end);

                if (current/end == 1){

                    stopTimer();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    /**
     * Stops the updating of the progress bar
     *
     * @author Franco Sagot
     */
    public void stopTimer(){
        running = false;
        timer.cancel();
    }
}
