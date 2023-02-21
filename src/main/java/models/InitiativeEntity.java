package models;

public class InitiativeEntity implements Comparable<InitiativeEntity>{
    public InitiativeEntity(int initiative, int ac, int hits, String name) {
        this.initiative = initiative;
        this.ac = ac;
        this.hits = hits;
        this.name = name;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStr(){
        StringBuilder builder=new StringBuilder();
        String[] inf =new String[]{
                getName(),
                Integer.toString(getInitiative()),
                Integer.toString(getAc()),
                Integer.toString(getHits())
        };
        builder.append(String.format("%10s%4s%4s%4s%n", inf));
        return builder.toString();

    }


    private int initiative;
    private int ac;
    private int hits;
    private String name;


    @Override
    public int compareTo(InitiativeEntity o) {
        int diff = this.initiative - o.initiative;
        return -diff;
    }
}
