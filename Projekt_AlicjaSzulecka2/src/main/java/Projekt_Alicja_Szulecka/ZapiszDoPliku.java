package Projekt_Alicja_Szulecka;

import Projekt_Alicja_Szulecka.Mieszkancy;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ZapiszDoPliku {

    public static void Zapis(String filename, List<Mieszkancy> list) {
        try (FileWriter fileWriter = new FileWriter(filename))
        {
            for (Mieszkancy mieszkaniec : list) {
                fileWriter.write("Miasto: " + mieszkaniec.miasto + " " + "Imię: " + mieszkaniec.imie + " " + "Nazwisko : " + mieszkaniec.nazwisko + " " +
                        "PESEL: " + mieszkaniec.PESEL + "\n");
            }
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania do pliku");
        }
    }
}
