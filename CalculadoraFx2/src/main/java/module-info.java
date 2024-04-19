module di.calculadorafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires okhttp3;
    requires org.json;

    opens di.calculadorafx to javafx.fxml;
    exports di.calculadorafx;
}