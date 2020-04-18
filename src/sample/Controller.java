package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class Controller {


    @FXML
    private TextField nickname1;

    public void buttonAction() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Bilgi");
        if (!nickname1.getText().isEmpty()) {
            Main.nickname = nickname1.getText();
            nickname1.setEditable(false);

            alert.setContentText("Aktif edildi.");


        } else
            alert.setContentText("Lütfen isim giriniz.");

        alert.showAndWait();
        Thread thread= new Threading();
        thread.start();
    }

}
