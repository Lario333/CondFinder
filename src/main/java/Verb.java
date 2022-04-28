public class Verb {
    String baseForm , thPerson, prsntParticiple, smplPast, pstParticiple;
    String pstPerfect , shortPstPerfect , negPstPerfect;
    /*
        Class Constructor
        every verbs in csv is a param
     */
    public Verb(String[] verbArray){
        this.baseForm = verbArray[0];
        this.thPerson = verbArray[1];
        this.prsntParticiple = verbArray[2];
        this.smplPast = verbArray[3];
        this.pstParticiple = verbArray[4];
        this.pstPerfect = "had " + verbArray[4];
        this.negPstPerfect = "hadn't " + verbArray[4];
        this.shortPstPerfect = "'d " + verbArray[4];
    }

    // Return if contains the verb, not caring of the tense
    public boolean containsVerb(String v){
        if (baseForm.equalsIgnoreCase(v) || thPerson.equalsIgnoreCase(v) || prsntParticiple.equalsIgnoreCase(v) || smplPast.equalsIgnoreCase(v) || pstParticiple.equalsIgnoreCase(v) || pstPerfect.equalsIgnoreCase(v) || shortPstPerfect.equalsIgnoreCase(v) || negPstPerfect.equalsIgnoreCase(v)) {
            return true;
        } else {
            return false;
        }
    }

    // Returning the tense of the verb given
    public String getVerbalTense(String v){
        if (baseForm.equalsIgnoreCase(v) || thPerson.equalsIgnoreCase(v) || prsntParticiple.equalsIgnoreCase(v) || smplPast.equalsIgnoreCase(v) || pstParticiple.equalsIgnoreCase(v) || pstPerfect.equalsIgnoreCase(v) || shortPstPerfect.equalsIgnoreCase(v) || negPstPerfect.equalsIgnoreCase(v)) {
            //System.out.println(v);
            if (pstParticiple.equalsIgnoreCase(v) && smplPast.equalsIgnoreCase(v)){
                return "irregular";
            }
            if (baseForm.equalsIgnoreCase(v)){
                return "baseForm";
            } else if (thPerson.equalsIgnoreCase(v)){
                return "thPerson";
            } else if (prsntParticiple.equalsIgnoreCase(v)){
                return "prsntParticiple";
            } else if (smplPast.equalsIgnoreCase(v)){
                return "smplPast";
            } else if (pstParticiple.equalsIgnoreCase(v)){
                return "pstParticiple";
            } else if (negPstPerfect.equalsIgnoreCase(v) || pstPerfect.equalsIgnoreCase(v) || shortPstPerfect.equalsIgnoreCase(v)){
                return "pstPerfect";
            }
        }
        return "null tense";
    }

    // Base Form
    public String getBaseForm() {
        return baseForm;
    }



    // Third Person
    public String getThPerson() {
        return thPerson;
    }

    // Present Participle
    public String getPrsntParticiple() {
        return prsntParticiple;
    }



    // Simple Past
    public String getSmplPast() {
        return smplPast;
    }


    // Past Participle
    public String getPstParticiple() {
        return pstParticiple;
    }
}
