import java.awt.LayoutManager;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.border.TitledBorder;

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
  JTable RezepteTable;
  JPanel panel = new JPanel(); 
    public MainScreen()
    {
        setLayout(null);
        setBounds(0, 0, 1000, 1000);
        addComponents();
        setVisible(true);
    }

    private void addComponents()
    {
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),
                "ODI Rankings",
                TitledBorder.CENTER,
                TitledBorder.TOP));

        String[] ColumnNames = {"Name", "Schlagwörter", "Bewertung","Zutaten", "Zubereitungszeit", "Preis"};

        String[][] TestData = {
                {"Test","Test","Test","Test","Test","Test"},
                {"Test","Test","Test","Test","Test","Test"},
                {"Test","Test","Test","Test","Test","Test"},
                {"Test","Test","Test","Test","Test","Test"},
                {"Test","Test","Test","Test","Test","Test"}
        };

        RezepteTable = new JTable(TestData, ColumnNames);

        panel.setLayout((LayoutManager) new BorderLayout()); // WICHTIG!
        panel.add(new JScrollPane(RezepteTable), BorderLayout.CENTER);

        panel.setBounds(100, 100, 600, 400); // größer machen!
        add(panel);
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