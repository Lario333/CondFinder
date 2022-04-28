import java.util.ArrayList;

public class VerbDB {
    public static ArrayList<Verb> verbDB = new ArrayList<>();

    public VerbDB(){}


    // Adding a Verb to the DB
    public void addVerb(Verb v){
        verbDB.add(v);
    }

    /*
        IsVerbContained
        @return a boolean, if the word given is a verb contained in the db
     */
    public boolean isVerbContained(String w){
        boolean isThere = false;
        for(int i = 0 ; i < verbDB.size() ; i ++){
            if ( (verbDB.get(i).getBaseForm().equalsIgnoreCase(w)) || (verbDB.get(i).getPrsntParticiple().equalsIgnoreCase(w)) || (verbDB.get(i).getPstParticiple().equalsIgnoreCase(w)) || (verbDB.get(i).getSmplPast().equalsIgnoreCase(w)) || (verbDB.get(i).getThPerson().equalsIgnoreCase(w)) || (verbDB.get(i).getPrsntParticiple().equalsIgnoreCase(w))) {
                isThere = true;
            }
        }
        return isThere;
    }

    /*
        Getting the verbal tense giving a verb
     */
    public String getVerbalTense(String v){
        for(int i = 0 ; i < verbDB.size(); i++){
            if (verbDB.get(i).containsVerb(v)){
                return verbDB.get(i).getVerbalTense(v);
            }
        }
        return null;
    }

    // Getting the whole db
    public ArrayList<Verb> getVerbDB() {
        return verbDB;
    }
}
