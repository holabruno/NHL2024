package nhl2024.entites;

public class StatistiquesOffensives {
    private int buts;
    private int passes;
    private int points; // passes menant a un but + but
    private int tirs;

    public StatistiquesOffensives(int buts, int passes, int points, int tirs) {
        this.buts = buts;
        this.passes = passes;
        this.points = points;
        this.tirs = tirs;
    }

    public int getButs() {
        return buts;
    }

    public void setButs(int buts) {
        this.buts = buts;
    }

    public int getPasses() {
        return passes;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTirs() {
        return tirs;
    }

    public void setTirs(int tirs) {
        this.tirs = tirs;
    }


    @Override
    public String toString() {
        return "StatistiquesOffensives{" +
                "buts=" + buts +
                ", passes=" + passes +
                ", points=" + points +
                ", tirs=" + tirs +
                '}';
    }
}
