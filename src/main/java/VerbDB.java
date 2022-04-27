import java.util.ArrayList;

public class VerbDB {
    public static ArrayList<Verb> verbDB = new ArrayList<>();

    public VerbDB(){}


    // Database
    public static ArrayList<Verb> getVerbDB() {
        return verbDB;
    }

    public static void setVerbDB(ArrayList<Verb> verbDB) {
        VerbDB.verbDB = verbDB;
    }
}
