package org.example.clipsfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public BorderPane painel;
    private static BorderPane painelStatic;

    public void onNovoCip(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("novoclip-view.fxml"));
        try {
            painelStatic.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        painelStatic=painel;
        carregarTelaTabela();
    }

    public static void carregarTelaTabela () {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("clips-view.fxml"));
        try {
            painelStatic.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}