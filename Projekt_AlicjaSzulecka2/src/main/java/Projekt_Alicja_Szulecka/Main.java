package Projekt_Alicja_Szulecka;

import Projekt_Alicja_Szulecka.Pesel.PESELPowtorka;
import Projekt_Alicja_Szulecka.Pesel.PoprawnoscPESELU;
import lombok.var;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Mieszkancy> list = new LinkedList<>();
        String answer, miasto, imie, nazwisko, PESEL;
        boolean Powtorka = false;
        System.out.println("Witam w Powszechnym Spisie Mieszkańców z Obiektowania Programowego");

        while (true) {
            System.out.println("Proszę podać nazwę miasta: ");
            miasto = scan.nextLine();
            System.out.println("Proszę podać imię: ");
            imie = scan.nextLine();
            System.out.println("Proszę podać nazwisko: ");
            nazwisko = scan.nextLine();
            System.out.println("Proszę podać PESEL: ");
            PESEL = scan.nextLine();

            if(PoprawnoscPESELU.SprawdzPESEL(PESEL, imie)) {
                if (PESELPowtorka.CzyPESELSiePowtarza(list, PESEL)) {
                    list.set(PESELPowtorka.IndexPowtorki(list, PESEL), Mieszkancy.builder().miasto(miasto).imie(imie).nazwisko(nazwisko).PESEL(PESEL).build());
                    Powtorka = false;
                } else {
                    var mieszkaniec = new Mieszkancy(miasto, imie, nazwisko, PESEL);
                    list.add(mieszkaniec);
                }
            }
            else
            {
                System.out.println("Podany PESEL jest błędny, wpis nie zostanie zapisany");
            }

            System.out.println("Czy chcesz wpisać kolejnego mieszkańca? [T/N]: ");
            answer = scan.nextLine();

            if (answer.equals("N") || answer.equals("n")) {
                break;
            }

        }
        ZapiszDoPliku.Zapis("lista.txt", list);
        System.out.println("Dziękuję za skorzystanie z naszego programu. Zapis wszystkich mieszkańców znajduje się w pliku.");
    }
}