package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.layout.HBox;

import java.util.List;

public class Main extends Application {

    private TableView<Restauralas> tabla;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
        public void start(Stage primaryStage) {
        primaryStage.setTitle("Restaurálási munkák nyilvántartása");

        tabla = TablaLetrehozo.letrehozottTabla();

        List<Restauralas> beolvasottLista = CSVKezelo.beolvasCSV();
        ObservableList<Restauralas> observableLista = FXCollections.observableArrayList(beolvasottLista);
        tabla.setItems(observableLista);

        FelvetelPane felvetelPane = new FelvetelPane(tabla); // új űrlap

        BorderPane root = new BorderPane();
        root.setCenter(tabla);
        root.setLeft(felvetelPane); // bal oldali panel

        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
