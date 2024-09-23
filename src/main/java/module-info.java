module org.example.clipsfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.clipsfx to javafx.fxml;
    exports org.example.clipsfx;
}