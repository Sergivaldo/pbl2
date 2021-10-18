package com.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import com.model.GerenciadorProjetos;
import com.model.Projeto;
public class PopUpAddProjetoController {
	private String nomeProjeto;
    @FXML
    private TextField input_nome;

    @FXML
    private Button cancelar_btt;

    @FXML
    private Button adicionar_btt;
    
    public PopUpAddProjetoController() {
    	nomeProjeto = "";
    }
    
    public String getNomeProjeto() {
    	return nomeProjeto;
    }
    
    @FXML
    public void salvarNome() throws IOException {
    	nomeProjeto = input_nome.getText();
    	close();
    }
    
    
    private void close() {
	    Stage stage = (Stage) adicionar_btt.getScene().getWindow();
	    stage.close();
	} 
    
    
    
    
}
