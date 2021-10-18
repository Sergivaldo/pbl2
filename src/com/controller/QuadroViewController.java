package com.controller;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class QuadroViewController {

    @FXML
    private VBox box_pendente;

    @FXML
    private VBox box_executando;

    @FXML
    private VBox box_concluida;
    
    @FXML
    private void popUpAddTarefa() throws IOException {
    	Stage stage = new Stage();
    	Parent root = FXMLLoader.load(getClass().getResource("/fxml/adicionar_tarefa_popup.fxml"));
    	stage.setScene(new Scene(root));
    	stage.initStyle(StageStyle.UNDECORATED);
    	stage.initModality(Modality.APPLICATION_MODAL);
    	stage.showAndWait();
    }
    
}
