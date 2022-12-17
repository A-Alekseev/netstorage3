module com.example.client.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires io.netty.codec;

    opens com.example.client.client to javafx.fxml;
    exports com.example.client.client;
}