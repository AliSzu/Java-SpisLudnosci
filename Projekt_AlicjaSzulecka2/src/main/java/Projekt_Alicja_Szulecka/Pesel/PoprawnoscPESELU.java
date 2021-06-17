package Projekt_Alicja_Szulecka.Pesel;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PoprawnoscPESELU {

    public static boolean SprawdzPESEL(String PESEL, String imie)
    {
        int[] Wyniki = new int[2];

        //Czy PESEL składa sie z 11 cyfr
        if (!PESEL.matches("[0-9]+") || PESEL.length() != 11)
        {
            return false;
        }
        char plec = PESEL.charAt(9);
        int NumerPlci = Integer.parseInt(String.valueOf(plec));

        //Płeć - Kobieta
        if (imie.substring(imie.length() - 1).equals("a"))
        {
            if(NumerPlci % 2 != 0 )
            {
                return false;
            }
        }
        //Płeć - Mężczyza
        else
        {
            if(NumerPlci % 2 == 0)
            {
                return false;
            }
        }
        Wyniki = (LiczbaKontrolna(PESEL));

        // jeśli liczba kontrolna, które wynika z liczeń nie zgadza się z liczbą w peselu
        if (!PESEL.substring(PESEL.length() - 1).equals(Integer.toString(Wyniki[0])))
        {
            return false;
        }
        //Gdy ostatnia cyfra liczby kontrolnej nie rowna się 0 to Pesel jest fałszywy
        if(Wyniki[1] % 10 != 0)
        {
            return false;
        }

        return true;
    }

    private static int[] LiczbaKontrolna(String PESEL)
    {
        long intPESEL = Long.parseLong(PESEL);
        int[] arrPESEL = new int[11];
        int[] Iloczyny = new int[10];
        int[] Wyniki = new int[2];
        int S, M, OstatniaCyfra, CyfraKontrolna;

        for ( int i =0; i < PESEL.length() ; i++)
        {
            arrPESEL[i] = Integer.parseInt(String.valueOf(PESEL.charAt(i)));
        }

        for ( int i=0; i<10; i++)
        {
            if ( i == 0 || i == 4 || i == 8)
            {
                Iloczyny[i] = arrPESEL[i] * 1;
            }
            else if( i == 1 || i == 5 || i == 9)
            {
                Iloczyny[i] = arrPESEL[i] * 3;
            }
            else if ( i == 2 || i == 6)
            {
                Iloczyny[i] = arrPESEL[i] * 7;
            }
            else
            {
                Iloczyny[i] = arrPESEL[i] * 9;
            }
        }
        S = IntStream.of(Iloczyny).sum();
        M = S % 10;
        if ( M == 0)
        {
            OstatniaCyfra = 0;
        }
        else {
            OstatniaCyfra = 10 - M;
        }

        CyfraKontrolna = S + arrPESEL[10] *  1;
        Wyniki[0] = OstatniaCyfra;
        Wyniki[1] = CyfraKontrolna;

        return Wyniki;
    }
}
