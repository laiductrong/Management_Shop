module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.demo1 to javafx.fxml, javafx.base;
    exports com.example.demo1;
    exports com.example.demo1.connect;
    opens com.example.demo1.connect to javafx.fxml;

    //add
}