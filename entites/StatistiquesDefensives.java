package nhl2024.entites;

public class StatistiquesDefensives {
    private int plusMoins;
    private int blocs;
    private int interceptions;

    public StatistiquesDefensives(int plusMoins, int blocs, int interceptions) {
        this.plusMoins = plusMoins;
        this.blocs = blocs;
        this.interceptions = interceptions;
    }

    public int getPlusMoins() {
        return plusMoins;
    }

    public void setPlusMoins(int plusMoins) {
        this.plusMoins = plusMoins;
    }

    public int getBlocs() {
        return blocs;
    }

    public void setBlocs(int blocs) {
        this.blocs = blocs;
    }

    public int getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(int interceptions) {
        this.interceptions = interceptions;
    }

    @Override
    public String toString() {
        return "StatistiquesDefensives{" +
                "plusMoins=" + plusMoins +
                ", blocs=" + blocs +
                ", interceptions=" + interceptions +
                '}';
    }
}
