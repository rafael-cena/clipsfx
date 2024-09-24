package org.example.clipsfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.example.clipsfx.db.Clip;
import org.example.clipsfx.db.ClipDAL;
import org.example.clipsfx.db.SingletonDB;

import javax.swing.*;

public class NovoclipController {

    @FXML
    private DatePicker tdData;

    @FXML
    private TextField tfArtista;

    @FXML
    private TextField tfDuracao;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfTitulo;

    @FXML
    private TextField tfUrl;

    @FXML
    void onCadastrar(ActionEvent event) {
        Clip novo = new Clip(tfArtista.getText(),tfTitulo.getText(),Integer.parseInt(tfDuracao.getText()),
                                tdData.getValue(),tfUrl.getText());

        ClipDAL clipDAL = new ClipDAL();
        if (!clipDAL.inserir(novo)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(SingletonDB.getConexao().getMensagemErro());
            alert.showAndWait();
        }
        HelloController.carregarTelaTabela();
    }

    @FXML
    void onCancelar(ActionEvent event) {
        HelloController.carregarTelaTabela();
    }

}
