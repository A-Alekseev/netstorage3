package com.example.client.client;

import com.example.core.model.InnerMessage;
import io.netty.handler.codec.serialization.ObjectDecoderInputStream;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    ObjectEncoderOutputStream os;
    ObjectDecoderInputStream is;

    @FXML
    private TextArea myTextArea;

    @FXML
    protected void onHelloButtonClick() {

        InnerMessage msg = new InnerMessage();

        try {
            os.writeObject(msg);
        } catch (IOException e) {
            myTextArea.setText(e.toString());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            Socket socket = new Socket("localhost", 8989);
            os = new ObjectEncoderOutputStream(socket.getOutputStream());
            is = new ObjectDecoderInputStream(socket.getInputStream());
            Thread t = new Thread(this::read);
            t.setDaemon(true);
            t.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void read(){
        try{
            InnerMessage msg = (InnerMessage)is.readObject();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}