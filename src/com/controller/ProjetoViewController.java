package com.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.HBox;

public class ProjetoViewController {
	private FXMLLoader loaderGerenciador;
	private FXMLLoader loaderQuadro;
    @FXML
    private Button nome_projeto_btt;

    @FXML
    private MenuButton projeto_menu_btt;
    
    public void nomeProjeto(String nome) {
    	nome_projeto_btt.setText(nome);
    }
    
    public void quadro() throws IOException {
    	loaderGerenciador = new FXMLLoader(getClass().getResource("/fxml/pagina_inicial.fxml"));
    	Parent GerenciadorView = loaderGerenciador.load();
    	loaderQuadro = new FXMLLoader(getClass().getResource("/fxml/quadro.fxml"));
    	Parent QuadroView = loaderQuadro.load();
    	PaginaInicialController pController = loaderGerenciador.getController();
    	
    
    	
    	
    }
}

