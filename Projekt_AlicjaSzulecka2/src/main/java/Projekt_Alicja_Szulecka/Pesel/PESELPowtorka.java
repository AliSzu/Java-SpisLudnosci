package Projekt_Alicja_Szulecka.Pesel;

import Projekt_Alicja_Szulecka.Mieszkancy;
import lombok.var;

import java.util.List;

public class PESELPowtorka {

    public static int IndexPowtorki(List<Mieszkancy> list, String szukanyPesel) {
        var SzukanyPesel = list.stream()
                .filter(m -> m.CzyPeselJestTakiSam(szukanyPesel))
                .findFirst()
                .get();
        return list.indexOf(SzukanyPesel);
    }

    public static boolean CzyPESELSiePowtarza(List<Mieszkancy> list, String szukanyPesel)
    {
        for (Mieszkancy mieszkaniec : list) {
            if (szukanyPesel.equals(mieszkaniec.PESELPowtorka())) {
                return true;
            }
        }
        return false;
    }
}
