package org.example.clipsfx;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.clipsfx.db.Clip;
import org.example.clipsfx.db.ClipDAL;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ClipsController implements Initializable {

    @FXML
    private TableColumn<Clip, String> coArtista;

    @FXML
    private TableColumn<Clip, String> coData;

    @FXML
    private TableColumn<Clip, String> coDuracao;

    @FXML
    private TableColumn<Clip, String> coId;

    @FXML
    private TableColumn<Clip, String> coTitulo;

    @FXML
    private TableView<Clip> tableView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        coId.setCellValueFactory(new PropertyValueFactory<>("id"));
        coArtista.setCellValueFactory(new PropertyValueFactory<>("artista"));
        coData.setCellValueFactory(new PropertyValueFactory<>("datapub"));
        coDuracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        coTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));

        ClipDAL clipDAL = new ClipDAL();
        List<Clip> clips = clipDAL.get("");
        tableView.setItems(FXCollections.observableArrayList(clips));
    }
}
