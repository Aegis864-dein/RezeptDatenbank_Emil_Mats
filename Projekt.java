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
{}

@SuppressWarnings("unused")
class Rezept
{
    private String Name;
    private String[] Schlagwörter;
    private int Bewertung;
    private LinkedList<Zutat> Zutaten;
    private String Zubereitung;
    private double[] Nährwerte;
    private int Zubereitungszeit;

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