package nhl2024.entites;

public class StatistiquesGardien {
    private int arrets;
    private int butsEncaisses;
    private float moyenneButsAlloues;
    private int victoires;
    private int defaites;
    private int blanchissage;

    public StatistiquesGardien(int arrets, int butsEncaisses, float moyenneButsAlloues, int victoires, int defaites, int blanchissage) {
        this.arrets = arrets;
        this.butsEncaisses = butsEncaisses;
        this.moyenneButsAlloues = moyenneButsAlloues;
        this.victoires = victoires;
        this.defaites = defaites;
        this.blanchissage = blanchissage;
    }

    public int getArrets() {
        return arrets;
    }

    public void setArrets(int arrets) {
        this.arrets = arrets;
    }

    public int getButsEncaisses() {
        return butsEncaisses;
    }

    public void setButsEncaisses(int butsEncaisses) {
        this.butsEncaisses = butsEncaisses;
    }

    public float getMoyenneButsAlloues() {
        return moyenneButsAlloues;
    }

    public void setMoyenneButsAlloues(float moyenneButsAlloues) {
        this.moyenneButsAlloues = moyenneButsAlloues;
    }

    public int getVictoires() {
        return victoires;
    }

    public void setVictoires(int victoires) {
        this.victoires = victoires;
    }

    public int getDefaites() {
        return defaites;
    }

    public void setDefaites(int defaites) {
        this.defaites = defaites;
    }

    public int getBlanchissage() {
        return blanchissage;
    }

    public void setBlanchissage(int blanchissage) {
        this.blanchissage = blanchissage;
    }

    @Override
    public String toString() {
        return "StatistiquesGardien{" +
                "arrets=" + arrets +
                ", butsEncaisses=" + butsEncaisses +
                ", moyenneButsAlloues=" + moyenneButsAlloues +
                ", victoires=" + victoires +
                ", defaites=" + defaites +
                ", blanchissage=" + blanchissage +
                '}';
    }
}
