import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
    LinkedList<Rezept> Rezepte = new LinkedList<>();

    public Manager()
    {
        MainScreen = new MainScreen();
        // Beispieldaten erstellen und Tabelle füllen
        LinkedList<Zutat> z1 = new LinkedList<>();
        z1.add(new Zutat("Mehl", 500, new double[]{200,10,5,2}, 1.20));
        z1.add(new Zutat("Milch", 250, new double[]{80,4,3,1}, 0.80));
        Rezept r1 = new Rezept("Pfannkuchen", new String[]{"Frühstück","Süß"}, 5, z1, "Alles mischen und braten", 20);
        LinkedList<Zutat> z2 = new LinkedList<>();
        z2.add(new Zutat("Tomate", 200, new double[]{18,1,0.2,0.1}, 0.60));
        z2.add(new Zutat("Nudeln", 200, new double[]{350,12,5,2}, 0.90));
        Rezept r2 = new Rezept("Nudeln mit Tomatensoße", new String[]{"Abendessen","Vegetarisch"}, 4, z2, "Kochen und mischen", 30);
        Rezepte.add(r1);
        Rezepte.add(r2);
        MainScreen.setRezepte(Rezepte);
    }
}

class MainScreen extends JFrame implements ActionListener
{
    JTable RezepteTable;
    JScrollPane panel;
    JButton NamenButton = new JButton("Name");
    JButton SchlagwörterButton = new JButton("Schlagwörter");
    JButton BewertungButton = new JButton("Bewertung");
    JButton ZutatenButton = new JButton("Zutaten");
    JButton ZubereitungButton = new JButton("Zubereitung");
    JButton NährwerteButton = new JButton("Nährwerte");
    JButton ZubereitungszeitButton = new JButton("Zeit");
    JButton PreisButton = new JButton("Preis");
    JTextField NameSuchFeld = new JTextField();
    JTextField SchlagwörterSuchFeld = new JTextField();
    JButton AuswählenKnopf = new JButton("Rezept auswählen");
    JButton HinzufügenKnopf = new JButton("Rezept hinzufügen");
    JButton EntfernenKnopf = new JButton("Rezept entfernen");
    JButton ÄndernKnopf = new JButton("Rezept ändern");
    LinkedList<Rezept> RezepteKopie = new LinkedList<>();
    public MainScreen()
    {
        setLayout(null);
        setBounds(0, 0, 1050, 1000);
        addComponents();
        setVisible(true);
    }

    private void addComponents()
    {

        String[] ColumnNames = {"", "", "", "", "", "", "", ""};
        String[][] TestData = {{"","","","","","","",""}};
        RezepteTable = new JTable(TestData, ColumnNames);
        RezepteTable.setCellEditor(null);
        panel = new JScrollPane(RezepteTable);
        panel.setBounds(20, 120, 1000, 800);
        add(panel);

        NamenButton.setBounds(20, 100, 125, 20);
        NamenButton.addActionListener(this);
        add(NamenButton);

        NameSuchFeld.setBounds(20, 80, 125, 20);
        NameSuchFeld.addActionListener(this);
        add(NameSuchFeld);

        SchlagwörterButton.setBounds(145, 100, 125, 20);
        SchlagwörterButton.addActionListener(this);
        add(SchlagwörterButton);

        SchlagwörterSuchFeld.setBounds(145, 80, 125, 20);
        SchlagwörterSuchFeld.addActionListener(this);
        add(SchlagwörterSuchFeld);

        BewertungButton.setBounds(270, 100, 125, 20);
        BewertungButton.addActionListener(this);
        add(BewertungButton);

        ZutatenButton.setBounds(395, 100, 125, 20);
        ZutatenButton.addActionListener(this);
        add(ZutatenButton);

        ZubereitungButton.setBounds(520, 100, 125, 20);
        ZubereitungButton.addActionListener(this);
        add(ZubereitungButton);

        NährwerteButton.setBounds(645, 100, 125, 20);
        NährwerteButton.addActionListener(this);
        add(NährwerteButton);

        ZubereitungszeitButton.setBounds(770, 100, 125, 20);
        ZubereitungszeitButton.addActionListener(this);
        add(ZubereitungszeitButton);

        PreisButton.setBounds(895, 100, 125, 20);
        PreisButton.addActionListener(this);
        add(PreisButton);

        AuswählenKnopf.setBounds(20, 20, 250, 40);
        AuswählenKnopf.addActionListener(this);
        add(AuswählenKnopf);

        HinzufügenKnopf.setBounds(270, 20, 250, 40);
        HinzufügenKnopf.addActionListener(this);
        add(HinzufügenKnopf);

        EntfernenKnopf.setBounds(520, 20, 250, 40);
        EntfernenKnopf.addActionListener(this);
        add(EntfernenKnopf);

        ÄndernKnopf.setBounds(770, 20, 250, 40);
        ÄndernKnopf.addActionListener(this);
        add(ÄndernKnopf);
    }

    @SuppressWarnings("unused")
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == AuswählenKnopf)
        {
            int i = RezepteTable.getSelectedRow();
            if(i < 0) return;
            AuswählenScreen WAAAAAA = new AuswählenScreen(RezepteKopie.get(i));
        }
    }

    public void setRezepte(LinkedList<Rezept> rezepte)
    {
        if(rezepte == null) return;
        RezepteKopie = rezepte;
        String[] ColumnNames = {"", "", "", "", "", "", "", ""};
        String[][] data = new String[rezepte.size()][8];
        for(int i = 0; i < rezepte.size(); i++)
        {
            Rezept r = rezepte.get(i);
            data[i][0] = r.get_Name();
            String[] Schlagwörter = r.get_Schlagwörter();
            data[i][1] = (Schlagwörter == null) ? "" : String.join(", ", Schlagwörter);
            data[i][2] = String.valueOf(r.get_Bewertung());
            LinkedList<Zutat> Zutaten = r.get_Zutaten();
            if(Zutaten != null)
            {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < Zutaten.size(); j++)
                {
                    if(j>0) sb.append(", ");
                    sb.append(Zutaten.get(j).get_Name()).append("(").append(Zutaten.get(j).get_Menge()).append(")");
                }
                data[i][3] = sb.toString();
            } else data[i][3] = "";
            data[i][4] = r.get_Zubereitung();
            double[] n = r.get_Nährwerte();
            data[i][5] = (n == null) ? "" : Arrays.toString(n);
            data[i][6] = String.valueOf(r.get_Zubereitungszeit());
            data[i][7] = String.format("%.2f", r.get_Preis());
        }
        RezepteTable.setModel(new DefaultTableModel(data, ColumnNames));
    }
}

class AuswählenScreen extends JFrame
{ 
    Rezept Rezept;
    JTextField NamenFeld = new JTextField();
    JTextField SchlagwörterFeld = new JTextField();
    JTextField BewertungFeld = new JTextField();
    JTextField NährwerteFeld = new JTextField();
    JTextField ZeitFeld = new JTextField();
    JTextField PreisFeld = new JTextField();
    JTextField ZutatenFeld = new JTextField();
    public AuswählenScreen(Rezept neuRezept)
    {
        Rezept = neuRezept;
        setLayout(null);
        setBounds(20, 200, 1000, 600);
        setVisible(true);
        addComponents();
    }

    public void addComponents()
    {
        NamenFeld.setBounds(20, 20, 200, 25);
        NamenFeld.setText(Rezept.get_Name());
        NamenFeld.setEditable(false);
        add(NamenFeld);

        SchlagwörterFeld.setBounds(225, 20, 300, 25);
        SchlagwörterFeld.setText(String.join(", ", Rezept.get_Schlagwörter()));
        SchlagwörterFeld.setEditable(false);
        add(SchlagwörterFeld);

        BewertungFeld.setBounds(530, 20, 25, 25);
        BewertungFeld.setText(String.valueOf(Rezept.get_Bewertung()));
        BewertungFeld.setEditable(false);
        add(BewertungFeld);

        NährwerteFeld.setBounds(560, 20, 125, 25);
        double[] Temp = Rezept.get_Nährwerte();
        String[] Nährwerte = new String[Temp.length];
        for(int i = 0; i < Temp.length; i++)
        {
            Nährwerte[i] = String.valueOf(Temp[i]);
        }
        NährwerteFeld.setText(String.join(",", Nährwerte));
        NährwerteFeld.setEditable(false);
        add(NährwerteFeld);

        ZeitFeld.setBounds(690, 20, 50, 25);
        ZeitFeld.setText(String.valueOf(Rezept.get_Zubereitungszeit()));
        ZeitFeld.setEditable(false);
        add(ZeitFeld);

        PreisFeld.setBounds(745, 20, 50, 25);
        PreisFeld.setText(String.valueOf(Rezept.get_Preis()));
        PreisFeld.setEditable(false);
        add(PreisFeld);

        ZutatenFeld.setBounds(530, 50, 265, 400);
        ZutatenFeld.setText(BuildZutatenString());
        ZutatenFeld.setEditable(false);
        add(ZutatenFeld);
    }
    
    public String BuildZutatenString()
    {
        LinkedList<Zutat> Zutaten = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < Zutaten.size(); j++)
        {
            if(j>0) sb.append(", ");
            sb.append(Zutaten.get(j).get_Name()).append("(").append(Zutaten.get(j).get_Menge()).append(")");
        }
        System.out.println(sb.toString());
        return sb.toString();       
    }
}

class Datenhandler
{

}

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
        Nährwerte = new double[4];
        double[] tempNährwerte;
        for(int i = 0; i < Zutaten.size(); i++)
        {
            tempNährwerte = Zutaten.get(i).get_Nährwerte();
            if(tempNährwerte == null) continue;
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
        Preis = 0.0;
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