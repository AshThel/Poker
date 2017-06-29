package projekt.poker;

import java.util.Scanner;

/**
 * Created by Konrad on 17.06.2017.
 */


public class Main
{
    public static void main(String[] args)
    {
        boolean koniec = true;
        boolean gra = true;
        Scanner wczytajOpcje = new Scanner(System.in);
        int opcje;
        int opcjeGlowne;
        int nr;


        while(gra)
        {
            Talia talia = new Talia();
            Reka reka = new Reka(talia);
            Reka reka2 = new Reka(talia);

            System.out.println("Menu glowne");
            System.out.println();
            System.out.println("1 - Graj");
            System.out.println("2 - Zakoncz");
            System.out.println();


            opcjeGlowne = wczytajOpcje.nextInt();
            clrScr();

            switch(opcjeGlowne)
            {
                case 1:
                    while(koniec)
                    {
                        System.out.println();



                        System.out.println();
                        System.out.println("Opcje");
                        System.out.println("1 - sprawdz swoja reke; 2 - sprawdz");

                        opcje = wczytajOpcje.nextInt();


                        switch (opcje)
                        {
                            case 1:
                                clrScr();

                                System.out.println("Reka gracza");
                                reka.wyswietl();
                                reka.wyswietlWszystko();

                                System.out.println();
                                break;
                            case 2:
                                clrScr();

                                System.out.println("Reka gracza");
                                reka.wyswietl();
                                reka.wyswietlWszystko();

                                System.out.println();

                                System.out.println("Reka przeciwnika");
                                reka2.wyswietl();
                                reka2.wyswietlWszystko();

                                System.out.println();

                                if (reka.compareTo(reka2) == 1)
                                    System.out.println("Wygral gracz!");
                                if (reka.compareTo(reka2) == -1)
                                    System.out.println("Wygral przeciwnik!");
                                System.out.println(reka.compareTo(reka2));

                                System.out.println();
                                System.out.println("Opcje");
                                System.out.println("1 - Zakoncz");
                                nr = wczytajOpcje.nextInt();
                                if(nr > -1)
                                {
                                    koniec = false;
                                    break;
                                }
                        }
                    }
                    break;
                case 2:
                    gra = false;
                    break;
            }
        }
        wczytajOpcje.close();
    }


    public static void clrScr()
    {
        for(int clear = 0; clear < 10; clear++)
        {
            System.out.println("\b") ;
        }
    }
}