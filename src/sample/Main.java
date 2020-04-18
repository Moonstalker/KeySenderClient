package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Main extends Application {

    static String nickname = "";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("KeySender");
        primaryStage.setScene(new Scene(root, 500, 275));
        primaryStage.show();


    }

    public static boolean validChar(char c) {
        String valids = "bcfghijklmnoprtuvyzx";
        //System.out.println(nickname);
        return  (valids.contains(String.valueOf(c)));
    }


    public static void sendDataToServer(String data) {
        String serverName = "localhost";
        int port = 1231;
        try {
            Socket client = new Socket(serverName, port);
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
