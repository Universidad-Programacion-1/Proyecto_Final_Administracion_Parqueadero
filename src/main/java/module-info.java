module org.openjfx.Administracion_Parqueadero {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx.Administracion_Parqueadero to javafx.fxml;
    opens viewController to javafx.fxml;
    exports org.openjfx.Administracion_Parqueadero;
}
