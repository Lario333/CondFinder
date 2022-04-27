import java.util.ArrayList;

public class VerbDB {
    public static ArrayList<Verb> verbDB = new ArrayList<>();

    public VerbDB(){}


    // Adding a Verb to the DB
    public void addVerb(Verb v){
        verbDB.add(v);
    }

    // Database
    public ArrayList<Verb> getVerbDB() {
        return verbDB;
    }

    public void setVerbDB(ArrayList<Verb> verbDB) {
        VerbDB.verbDB = verbDB;
    }
}
