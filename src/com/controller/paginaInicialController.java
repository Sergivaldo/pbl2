package com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class PaginaInicialController {
	@FXML
	private ScrollPane scroll;
	@FXML
	private VBox box;
    
    @FXML
    private void addProjeto() throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/fxml/projeto.fxml"));
    	box.getChildren().add(root);
    }
    
}

