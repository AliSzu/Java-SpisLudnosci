package Projekt_Alicja_Szulecka;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Mieszkancy {

    String miasto;
    String imie;
    String nazwisko;
    String PESEL;

    public String PESELPowtorka()
    {
        return this.PESEL;
    } // stworzone na potrzeby klasy CzyPESELSiePowtarza zeby nie zmieniac głownego PESELu na public

    public boolean CzyPeselJestTakiSam(String pesel)
    {

        return this.PESEL.equals(pesel);
    }

}
