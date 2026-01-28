import java.util.LinkedList;
import javax.swing.*;

public class Projekt
{
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Manager manager = new Manager();
    }
}

class Manager
{
    Datenhandler Datenhandler = new Datenhandler();
    MainScreen MainScreen;

    public Manager()
    {
        MainScreen = new MainScreen();
    }
}

class MainScreen extends JFrame
{
    private final JButton TestButton = new JButton("Test"); 
    public MainScreen()
    {
        this.setBounds(0, 0, 1000, 1000);
        addComponents();
        this.setVisible(true);
    }

    private void addComponents()
    {
        TestButton.setBounds(20,20,960,100);
        this.add(TestButton);
    }
}

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

    protected double get_Preis()
    {
        return Preis;
    }

    protected void set_Name(String neuerName)
    {
        Name = neuerName;
    }

    protected void set_Menge(int neueMenge)
    {
        Menge = neueMenge;
    }

    protected void set_Nährwerte(double[] neueNährwerte)
    {
        Nährwerte = neueNährwerte;
    }

    protected void set_Preis(double neuerPreis)
    {
        Preis = neuerPreis;
    }

    public void set_All(String neuerName, int neueMenge, double[] neueNährwerte, double neuerPreis)
    {
        Name = neuerName;
        Nährwerte = neueNährwerte;
        Menge = neueMenge;
        Preis = neuerPreis;
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

    public Rezept(String NeuerName, String[] NeueSchlagwörter, int NeueBewertung, LinkedList<Zutat> NeueZutaten, String NeueZubereitung, int NeueZubereitungszeit)
    {
       Name = NeuerName;
       Schlagwörter = NeueSchlagwörter;
       Bewertung = NeueBewertung;
       Zutaten = NeueZutaten;
       Zubereitung = NeueZubereitung;
       Zubereitungszeit = NeueZubereitungszeit;
       readNährwerte();
       readPreis();
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

    private void readNährwerte()
    {
        double[] tempNährwerte;
        for(int i = 0; i < Zutaten.size(); i++)
        {
            tempNährwerte = Zutaten.get(i).get_Nährwerte();
            for(int j = 0; j < 4; j++)
            {
                Nährwerte[j] += tempNährwerte[j];
            }
        }
    }

    protected double[] get_Nährwerte()
    {
        readNährwerte();
        return Nährwerte;
    }

    protected int get_Zubereitungszeit()
    {
        return Zubereitungszeit;
    }

    private void readPreis()
    {
        for(int i = 0; i < Zutaten.size(); i++)
        {
            Preis += Zutaten.get(i).get_Preis();
        }
    }

    protected double get_Preis()
    {
        readPreis();
        return Preis;
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

    protected void set_Zubereitungszeit(int NeueZubereitungszeit)
    {
        Zubereitungszeit = NeueZubereitungszeit;
    }

    protected void set_All(String NeuerName, String[] NeueSchlagwörter, int NeueBewertung, LinkedList<Zutat> NeueZutaten, String NeueZubereitung, int NeueZubereitungszeit)
    {
       Name = NeuerName;
       Schlagwörter = NeueSchlagwörter;
       Bewertung = NeueBewertung;
       Zutaten = NeueZutaten;
       Zubereitung = NeueZubereitung;
       Zubereitungszeit = NeueZubereitungszeit;
       readNährwerte();
       readPreis();
    }
}