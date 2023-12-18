module com.example.player {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jlayer;


    opens com.example.player to javafx.fxml;
    exports com.example.player;
    exports com.example.player.controllers;
    opens com.example.player.controllers to javafx.fxml;
    exports com.example.player.scanners;
    opens com.example.player.scanners to javafx.fxml;
    exports com.example.player.music;
    opens com.example.player.music to javafx.fxml;
}