import java.util.ArrayList;
public class Conditional {
    private String firstVerb , condName, secondVerbS;
    private ArrayList<String> secondVerb = new ArrayList<>();
    private int percPossibility;

    /*
        Base Constructor
        @param fv First Tense
        @param sv Second Tense String
        @param cn Conditional Name
        @param perc Percentage of possibility to be that conditional
     */
    public Conditional(String fv, String sv, String cn, int perc) {
        this.firstVerb = fv;
        this.secondVerbS = sv;
        this.condName = cn;
        this.percPossibility = perc;
    }

    /*
        Base Constructor
        @param fv First Tense
        @param sv Second Tense List
        @param cn Conditional Name
        @param perc Percentage of possibility to be that conditional
     */
    public Conditional(String fv, ArrayList<String> sv, String cn, int perc) {
        this.firstVerb = fv;
        this.secondVerb = sv;
        this.condName = cn;
        this.percPossibility = perc;
    }


    /*
        returns a boolean, giving two tenses it checks if the conditional is the tested one
        @param fv First Tense
        @param sv Second Tense
     */
    public boolean isThisConditional(String fv , String sv){
        if (firstVerb.equalsIgnoreCase(fv) && secondVerb.contains(sv)){
            return true;
        } else {
            return false;
        }
    }
    /*
        @return percentage of possibility to be this conditional
     */
    public int getPercPossibility(){
        return percPossibility;
    }
}
