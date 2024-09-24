module org.example.clipsfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens org.example.clipsfx to javafx.fxml;
    exports org.example.clipsfx;
    opens org.example.clipsfx.db to javafx.fxml;
    exports org.example.clipsfx.db;
}