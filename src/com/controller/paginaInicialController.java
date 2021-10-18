package com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import com.model.GerenciadorProjetos;
import com.model.Projeto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PaginaInicialController {
	
	private GerenciadorProjetos gProjetos;
	
	private FXMLLoader loaderProjeto;
	
	private FXMLLoader loaderPopUp;
	
	@FXML
	private ScrollPane scroll;
	
	@FXML
	private VBox box;
	
	@FXML
	private AnchorPane quadro;
	
	public PaginaInicialController() throws IOException {
		gProjetos = new GerenciadorProjetos();
	}
	
	
    @FXML
    private String popUpAdicionaProjeto() throws IOException {
    	loaderPopUp = new FXMLLoader(getClass().getResource("/fxml/adicionar_projeto_popup.fxml"));
    	Stage stage = new Stage();
    	
    	stage.setScene(new Scene(loaderPopUp.load()));
    	stage.initStyle(StageStyle.UNDECORATED);
    	stage.initModality(Modality.APPLICATION_MODAL);
    	PopUpAddProjetoController pController = loaderPopUp.getController();
    	stage.showAndWait();
    	
    	return pController.getNomeProjeto();
    }
    
    public void criarProjeto() throws IOException {
    	loaderProjeto = new FXMLLoader(getClass().getResource("/fxml/projeto.fxml"));
    	Parent projetoView = loaderProjeto.load();
    	ProjetoViewController pController = loaderProjeto.getController();
    	String nomeProjeto = popUpAdicionaProjeto();
    	
    	pController.nomeProjeto(nomeProjeto);
    	gProjetos.adicionaProjeto(new Projeto(nomeProjeto));
    	box.getChildren().add(projetoView);
    	
    }
    
    public void mostrarQuadro() {
    	
    }
    
    	
}

