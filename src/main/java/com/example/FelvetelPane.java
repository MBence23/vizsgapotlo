package com.example;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class FelvetelPane extends VBox {

    public FelvetelPane(TableView<Restauralas> tabla) {
        setSpacing(10);
        setPadding(new Insets(10));

        TextField idMezo = new TextField();
        idMezo.setPromptText("ID");

        TextField paintingIdMezo = new TextField();
        paintingIdMezo.setPromptText("Painting ID");

        TextField datumMezo = new TextField();
        datumMezo.setPromptText("Dátum (pl. 2023-05-10)");

        TextField muveletMezo = new TextField();
        muveletMezo.setPromptText("Művelet");

        TextField megjegyzesMezo = new TextField();
        megjegyzesMezo.setPromptText("Megjegyzés");

        Button hozzaadGomb = new Button("Hozzáadás");

        hozzaadGomb.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idMezo.getText());
                int paintingId = Integer.parseInt(paintingIdMezo.getText());
                String datum = datumMezo.getText();
                String muvelet = muveletMezo.getText();
                String megjegyzes = megjegyzesMezo.getText();

                Restauralas uj = new Restauralas(id, paintingId, datum, muvelet, megjegyzes);

                // Hozzáadjuk a táblázathoz
                tabla.getItems().add(uj);

                // Hozzáírjuk a CSV fájlhoz
                CSVKezelo.hozzaadCSVhez(uj);

                // Mezők kiürítése
                idMezo.clear();
                paintingIdMezo.clear();
                datumMezo.clear();
                muveletMezo.clear();
                megjegyzesMezo.clear();

            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Hiba");
                alert.setContentText("ID és Painting ID csak szám lehet!");
                alert.showAndWait();
            }
        });

        getChildren().addAll(idMezo, paintingIdMezo, datumMezo, muveletMezo, megjegyzesMezo, hozzaadGomb);
    }
}
