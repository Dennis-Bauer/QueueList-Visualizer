module de.dennis.qlvisualizer {
    requires javafx.controls;
    requires javafx.fxml;

    opens de.dennis.qlvisualizer to javafx.fxml;
    exports de.dennis.qlvisualizer;
}