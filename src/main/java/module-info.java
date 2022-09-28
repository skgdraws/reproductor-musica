module sample.newreproductormusica {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires com.fazecast.jSerialComm;


    opens sample.newreproductormusica to javafx.fxml;
    exports sample.newreproductormusica;
}