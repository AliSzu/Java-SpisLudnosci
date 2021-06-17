package Projekt_Alicja_Szulecka_Testy;

import Projekt_Alicja_Szulecka.Pesel.PESELPowtorka;
import lombok.var;
import org.junit.jupiter.api.Test;
import Projekt_Alicja_Szulecka.Mieszkancy;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CzyPeselSiePowtarzaTest {

    @Test
    public void Test()
    {
        List<Mieszkancy> list = new LinkedList<>();
        var mieszkaniec = new Mieszkancy("Poznan", "Patryk", "Kowalski", "12272249719");
        var mieszkaniec1 = new Mieszkancy("Poznan", "Marcin", "Kowalski", "12272249717");
        var mieszkaniec2 = new Mieszkancy("Warszawa", "Natalia", "Nowak", "01220331006");
        list.add(mieszkaniec); // mieszkaniec został dodany na miejsce 0 do listy
        list.add(mieszkaniec1); // mieszkaniec został dodany na miejsce 1 do listy
        list.add(mieszkaniec2); // mieszkaniec został dodany na miejsce 2 do listy

        boolean test2 = PESELPowtorka.CzyPESELSiePowtarza(list,"12272249717" );
        // sprawdza czy podany pesel juz istnieje w liscie mieszkancow
        assertTrue(test2);

        boolean test3 = PESELPowtorka.CzyPESELSiePowtarza(list,"12272249799" );
        assertFalse(test3);

        int test1 = PESELPowtorka.IndexPowtorki(list, "12272249717");
        //mieszkaniec z tym peselem został dodany na miejsce 1 do listy
        assertTrue(test1 == 1);

        int test4 = PESELPowtorka.IndexPowtorki(list, "12272249717");
        //mieszkaniec z tym peselem został dodany na miejsce 1 do listy, a na miejscu 0 znajduje sie całkiem inny mieszkaniec
        assertFalse(test4 == 0);


    }

}