package projekt.poker;

/**
 * Created by Konrad on 17.06.2017.
 */
public class Reka
{
    private Karta[] karty;
    private int[] wartosc;


    Reka(Talia d)
    {
        wartosc = new int[6];
        karty = new Karta[5];


        for (int x=0; x<5; x++)
        {
            karty[x] = d.dobierzZTalii();
        }


        int[] moce = new int[14];
        int[] kolejnoscMocy = new int[5];
        boolean flush=true, straight=false;
        int sameKarty=1,sameKarty2=1;
        int duzaGrupaMoc=0,malaGrupaMoc=0;
        int index=0;
        int topStraightwartosc=0;


        for (int x=0; x<=13; x++)
        {
            moce[x]=0;
        }


        for (int x=0; x<=4; x++)
        {
            moce[ karty[x].getMoc() ]++;
        }


        for (int x=0; x<4; x++)
        {
            if ( karty[x].getKolor() != karty[x+1].getKolor() )
                flush=false;
        }


        for (int x=13; x>=1; x--)
        {
            if (moce[x] > sameKarty)
            {
                if (sameKarty != 1)
                {
                    sameKarty = sameKarty;
                    malaGrupaMoc = duzaGrupaMoc;
                }
                sameKarty = moce[x];
                duzaGrupaMoc = x;
            }
            else if (moce[x] > sameKarty2)
            {
                sameKarty2 = moce[x];
                malaGrupaMoc = x;
            }
        }


        if (moce[1]==1)
        {
            kolejnoscMocy[index]=14;
            index++;
        }


        for (int x=13; x>=2; x--)
        {
            if (moce[x]==1)
            {
                kolejnoscMocy[index]=x;
                index++;
            }
        }


        for (int x=1; x<=9; x++)
        {
            if (moce[x]==1 && moce[x+1]==1 && moce[x+2]==1 && moce[x+3]==1 && moce[x+4]==1)
            {
                straight=true;
                topStraightwartosc=x+4;
                break;
            }
        }


        if (moce[10]==1 && moce[11]==1 && moce[12]==1 && moce[13]==1 && moce[1]==1)
        {
            straight=true;
            topStraightwartosc=14;
        }


        for (int x=0; x<=5; x++)
        {
            wartosc[x]=0;
        }


        if ( sameKarty==1 )
        {
            wartosc[0]=1;
            wartosc[1]=kolejnoscMocy[0];
            wartosc[2]=kolejnoscMocy[1];
            wartosc[3]=kolejnoscMocy[2];
            wartosc[4]=kolejnoscMocy[3];
            wartosc[5]=kolejnoscMocy[4];
        }


        if (sameKarty==2 && sameKarty2==1)
        {
            wartosc[0]=2;
            wartosc[1]=duzaGrupaMoc;
            wartosc[2]=kolejnoscMocy[0];
            wartosc[3]=kolejnoscMocy[1];
            wartosc[4]=kolejnoscMocy[2];
        }


        if (sameKarty==2 && sameKarty2==2)
        {
            wartosc[0]=3;
            wartosc[1]= duzaGrupaMoc>malaGrupaMoc ? duzaGrupaMoc : malaGrupaMoc;
            wartosc[2]= duzaGrupaMoc<malaGrupaMoc ? duzaGrupaMoc : malaGrupaMoc;
            wartosc[3]=kolejnoscMocy[0];
        }


        if (sameKarty==3 && sameKarty2!=2)
        {
            wartosc[0]=4;
            wartosc[1]= duzaGrupaMoc;
            wartosc[2]=kolejnoscMocy[0];
            wartosc[3]=kolejnoscMocy[1];
        }


        if (straight && !flush)
        {
            wartosc[0]=5;
            wartosc[1]=topStraightwartosc;
        }


        if (flush && !straight)
        {
            wartosc[0]=6;
            wartosc[1]=kolejnoscMocy[0];
            wartosc[2]=kolejnoscMocy[1];
            wartosc[3]=kolejnoscMocy[2];
            wartosc[4]=kolejnoscMocy[3];
            wartosc[5]=kolejnoscMocy[4];
        }


        if (sameKarty==3 && sameKarty2==2)
        {
            wartosc[0]=7;
            wartosc[1]=duzaGrupaMoc;
            wartosc[2]=malaGrupaMoc;
        }


        if (sameKarty==4)
        {
            wartosc[0]=8;
            wartosc[1]=duzaGrupaMoc;
            wartosc[2]=kolejnoscMocy[0];
        }


        if (straight && flush)
        {
            wartosc[0]=9;
            wartosc[1]=topStraightwartosc;
        }
    }


    void wyswietl()
    {
        String s;
        switch( wartosc[0] )
        {
            case 1:
                s="Wysoka Karta";
                break;
            case 2:
                s="Para " + Karta.mocAsString(wartosc[1]);
                break;
            case 3:
                s="Dwie pary " + Karta.mocAsString(wartosc[1]) + " " + Karta.mocAsString(wartosc[2]);
                break;
            case 4:
                s="Trojka " + Karta.mocAsString(wartosc[1]) ;
                break;
            case 5:
                s=Karta.mocAsString(wartosc[1]) + " Strit";
                break;
            case 6:
                s="Kolor";
                break;
            case 7:
                s="Ful " + Karta.mocAsString(wartosc[1]) + " koniec " + Karta.mocAsString(wartosc[2]);
                break;
            case 8:
                s="Kareta " + Karta.mocAsString(wartosc[1]);
                break;
            case 9:
                s="Poker " + Karta.mocAsString(wartosc[1]) + " krolewski";
                break;
            default:
                s="error in Reka.wyswietl: wartosc[0] contains invalid wartosc";
        }
        s = "               " + s;
        System.out.println(s);
    }

    void wyswietlWszystko()
    {
        for (int x=0; x<5; x++)
            System.out.println(karty[x]);
    }

    int compareTo(Reka that)
    {
        for (int x=0; x<6; x++)
        {
            if (this.wartosc[x]>that.wartosc[x])
                return 1;
            else if (this.wartosc[x]<that.wartosc[x])
                return -1;
        }
        return 0;
    }
}