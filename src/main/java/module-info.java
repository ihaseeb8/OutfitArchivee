module com.example.outfitarchivee {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens com.example.outfitarchivee to javafx.fxml;
    exports com.example.outfitarchivee;
    exports com.example.outfitarchivee.Controllers;
    opens com.example.outfitarchivee.Controllers to javafx.fxml;
}