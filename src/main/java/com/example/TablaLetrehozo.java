package com.example;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TablaLetrehozo {

    public static TableView<Restauralas> letrehozottTabla() {
        TableView<Restauralas> tabla = new TableView<>();

        TableColumn<Restauralas, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Restauralas, Integer> paintingIdCol = new TableColumn<>("Painting ID");
        paintingIdCol.setCellValueFactory(new PropertyValueFactory<>("paintingId"));

        TableColumn<Restauralas, String> datumCol = new TableColumn<>("Dátum");
        datumCol.setCellValueFactory(new PropertyValueFactory<>("datum"));

        TableColumn<Restauralas, String> muveletCol = new TableColumn<>("Művelet");
        muveletCol.setCellValueFactory(new PropertyValueFactory<>("muvelet"));

        TableColumn<Restauralas, String> megjCol = new TableColumn<>("Megjegyzés");
        megjCol.setCellValueFactory(new PropertyValueFactory<>("megjegyzes"));

        tabla.getColumns().addAll(idCol, paintingIdCol, datumCol, muveletCol, megjCol);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // automatikus méret

        return tabla;
    }
}
