module com.mtgapp.mtgapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires com.google.gson;
    requires java.smartcardio;


    opens com.mtgapp.mtgapp to javafx.fxml;
    exports com.mtgapp.mtgapp;
}