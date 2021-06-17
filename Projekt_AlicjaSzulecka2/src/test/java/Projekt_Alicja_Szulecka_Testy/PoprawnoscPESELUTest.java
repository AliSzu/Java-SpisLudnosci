package Projekt_Alicja_Szulecka_Testy;

import Projekt_Alicja_Szulecka.Pesel.PoprawnoscPESELU;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PoprawnoscPESELUTest {
    @Test
    public void test() {
        boolean test1 = PoprawnoscPESELU.SprawdzPESEL("01234567821","Marcin");
        //Liczba odpowiedzialna za płeć jest niezgoda z imieinem, które wskazuje na mężczyznę
        assertFalse(test1);

        boolean test2 = PoprawnoscPESELU.SprawdzPESEL("99011297200","Kamila");
        //Poprawny pesel wygenerowany przy pomocy http://pesel.felis-net.com
        assertTrue(test2);

        boolean test3 = PoprawnoscPESELU.SprawdzPESEL("12272249718","Krzysztof");
        //Niepoprawna liczba kontrolna
        assertFalse(test3);

        boolean test4 = PoprawnoscPESELU.SprawdzPESEL("","Krzysztof");
        //Pusty Pesel
        assertFalse(test4);



    }
}