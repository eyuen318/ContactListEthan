public class Athlete extends Person{

    private String sport;
    public Athlete(String sport, String firstName, String lastName, String phoneNumber)
    {
        super(String firstName, String lastName, String phoneNumber);
        this.sport = sport;
    }

    public int getSport() {
        return sport;
    }
    @Override
    public String toString() {
        return super.toString() + " Sport: " + sport;
    }

}

