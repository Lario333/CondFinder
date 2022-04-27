import java.util.ArrayList;

public class VerbDB {
    public static ArrayList<Verb> verbDB = new ArrayList<>();

    public VerbDB(){}


    // Adding a Verb to the DB
    public void addVerb(Verb v){
        verbDB.add(v);
    }

    // GetVerbFromBaseForm
    public Verb getVerbFromBF(String bf){
        for(int i = 0 ; i < verbDB.size() ; i++){
            if (verbDB.get(i).getBaseForm().equalsIgnoreCase(bf)){
                return verbDB.get(i);
            }
        }
        return null;
    }

    // Database
    public ArrayList<Verb> getVerbDB() {
        return verbDB;
    }

    public void setVerbDB(ArrayList<Verb> verbDB) {
        VerbDB.verbDB = verbDB;
    }
}
