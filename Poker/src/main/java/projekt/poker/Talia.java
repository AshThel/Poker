package projekt.poker;

/**
 * Created by Konrad on 11.06.2017.
 */

import java.util.Random;
import java.util.ArrayList;

public class Talia
{
    private ArrayList<Karta> karty;


    Talia()
    {
        karty = new ArrayList<Karta>();
        int index_1, index_2;
        Random generator = new Random();
        Karta tmp;


        for (short a=0; a<=3; a++)
        {
            for (short b=0; b<=12; b++)
            {
                karty.add( new Karta(a,b) );
            }
        }


        int size = karty.size() -1;

        for (short i=0; i<100; i++)
        {
            index_1 = generator.nextInt( size );
            index_2 = generator.nextInt( size );

            tmp = (Karta) karty.get( index_2 );

            karty.set( index_2 , karty.get( index_1 ) );
            karty.set( index_1, tmp );
        }
    }


    public Karta dobierzZTalii()
    {
        return karty.remove( karty.size()-1 );
    }


    public int getKartySize()
    {
        return karty.size();
    }
}
