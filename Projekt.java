import java.util.LinkedList;

public class Projekt
{
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Manager manager = new Manager();
    }
}

class Manager
{}

class Datenhandler
{}

class Zutat
{
    private String Name;
    private int Menge;
    private double[] Nährwerte;
    private double Preis;

    public Zutat(String neuerName, int neueMenge, double[] neueNährwerte, double neuerPreis)
    {
        Name = neuerName;
        Nährwerte = neueNährwerte;
        Menge = neueMenge;
        Preis = neuerPreis;
    }

    protected String get_Name()
    {
        return Name;
    }

    protected int get_Menge()
    {
        return Menge;
    }

    protected double[] get_Nährwerte()
    {
        return Nährwerte;
    }

    protected double Preis()
    {
        return Preis;
    }
}

class Rezept
{
    private String Name;
    private String[] Schlagwörter;
    private int Bewertung;
    private LinkedList<Zutat> Zutaten;
    private String Zubereitung;
    private double[] Nährwerte;
    private int Zubereitungszeit;
    private double Preis;

    public Rezept(String NeuerName, String[] NeueSchlagwörter, int NeueBewertung, LinkedList<Zutat> NeueZutaten, String NeueZubereitung, double[] NeueNährwerte, int NeueZubereitungszeit)
    {
       Name = NeuerName;
       Schlagwörter = NeueSchlagwörter;
       Bewertung = NeueBewertung;
       Zutaten = NeueZutaten;
       Zubereitung = NeueZubereitung;
       Nährwerte = NeueNährwerte;
       Zubereitungszeit = NeueZubereitungszeit;
    }

    protected String get_Name()
    {
        return Name;
    }

    protected String[] get_Schlagwörter()
    {
        return Schlagwörter;
    }

    protected int get_Bewertung()
    {
        return Bewertung;
    }

    protected LinkedList<Zutat> get_Zutaten()
    {
        return Zutaten;
    }

    protected String get_Zubereitung()
    {
        return Zubereitung;
    }

    protected double[] get_Nährwerte()
    {
        return Nährwerte;
    }

    protected int get_Zubereitungszeit()
    {
        return Zubereitungszeit;
    }

    protected void set_Name(String neuerName)
    {
        Name = neuerName;
    }

    protected void set_Schlagwörter(String[] neueSchlagwörter)
    {
        Schlagwörter = neueSchlagwörter;
    }

    protected void set_Bewertung(int NeueBewertung)
    {
        Bewertung = NeueBewertung;
    }
    
    protected void set_Zutaten(LinkedList<Zutat> neueZutaten)
    {
        Zutaten = neueZutaten;
    }

    protected void Zutat_Ändern(Zutat NeueZutat,int index)
    {
        Zutaten.set(index, NeueZutat);
    }

    protected void set_Zubereitung(String NeueZubereitung)
    {
        Zubereitung = NeueZubereitung;
    }

    protected void set_Nährwerte(double[] NeueNährwerte)
    {
        Nährwerte = NeueNährwerte;
    }

    protected void set_Zubereitungszeit(int NeueZubereitungszeit)
    {
        Zubereitungszeit = NeueZubereitungszeit;
    }

    protected void set_All(String NeuerName, String[] NeueSchlagwörter, int NeueBewertung, LinkedList<Zutat> NeueZutaten, String NeueZubereitung, double[] NeueNährwerte, int NeueZubereitungszeit)
    {
       Name = NeuerName;
       Schlagwörter = NeueSchlagwörter;
       Bewertung = NeueBewertung;
       Zutaten = NeueZutaten;
       Zubereitung = NeueZubereitung;
       Nährwerte = NeueNährwerte;
       Zubereitungszeit = NeueZubereitungszeit;
    }
}