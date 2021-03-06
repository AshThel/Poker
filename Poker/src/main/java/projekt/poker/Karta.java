package projekt.poker;

/**
 * Created by Konrad on 10.06.2017.
 */
public class Karta
{
    private short moc, kolor;
    private static String[] kolory = { "kier", "pik", "karo", "trefl" };
    private static String[] moce  = { "AS", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Walet", "Dama", "Krol" };

    public static String mocAsString( int __moc )
    {
        return moce[__moc];
    }


    Karta(short kolor, short moc)
    {
        this.moc=moc;
        this.kolor=kolor;
    }


    public String toString()
    {
        return moce[moc] + " " +  kolory[kolor];
    }



    public short getMoc()
    {
        return moc;
    }


    public short getKolor()
    {
        return kolor;
    }
}
