module sample.newreproductormusica {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample.newreproductormusica to javafx.fxml;
    exports sample.newreproductormusica;
}