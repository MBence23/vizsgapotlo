package com.example;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class CSVKezelo {

    private static final String CSV_FAJL = "/restauralasok.csv";  // resources-ből olvassuk

    // 1. CSV fájl beolvasása
    public static List<Restauralas> beolvasCSV() {
        List<Restauralas> lista = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(CSVKezelo.class.getResourceAsStream(CSV_FAJL), StandardCharsets.UTF_8))) {

            String sor;
            boolean elsoSor = true;

            while ((sor = reader.readLine()) != null) {
                if (elsoSor) {  // fejléc átugrása
                    elsoSor = false;
                    continue;
                }

                String[] mezok = sor.split(";");
                if (mezok.length == 5) {
                    int id = Integer.parseInt(mezok[0]);
                    int paintingId = Integer.parseInt(mezok[1]);
                    String datum = mezok[2];
                    String muvelet = mezok[3];
                    String megjegyzes = mezok[4];

                    lista.add(new Restauralas(id, paintingId, datum, muvelet, megjegyzes));
                }
            }

        } catch (IOException | NullPointerException e) {
            System.err.println("Hiba a CSV beolvasásakor: " + e.getMessage());
        }

        return lista;
    }

    // 2. CSV fájl mentése (az egész lista újraírása)
    public static void mentesCSV(List<Restauralas> lista) {
        Path outputPath = Paths.get("src/main/resources/restauralasok.csv");  // íráshoz teljes elérési út

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8)) {
            writer.write("id;paintingid;datum;muvelet;megjegyzes");
            writer.newLine();

            for (Restauralas r : lista) {
                writer.write(r.toCSVString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Hiba a CSV mentésekor: " + e.getMessage());
        }
    }

    public static void hozzaadCSVhez(Restauralas uj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hozzaadCSVhez'");
    }
}

