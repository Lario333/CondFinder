public class Verb {
    String baseForm , thPerson, prsntParticiple, smplPast, pstParticiple;
    /*
        Class Constructor
        every verbs in csv is a param
     */
    public Verb(String baseForm , String thPerson , String prsntParticiple , String smplPast , String pstParticiple ){
        this.baseForm = baseForm;
        this.thPerson = thPerson;
        this.prsntParticiple = prsntParticiple;
        this.smplPast = smplPast;
        this.pstParticiple = pstParticiple;
    }
    // Base Form
    public String getBaseForm() {
        return baseForm;
    }

    public void setBaseForm(String baseForm) {
        this.baseForm = baseForm;
    }


    // Third Person
    public String getThPerson() {
        return thPerson;
    }

    public void setThPerson(String thPerson) {
        this.thPerson = thPerson;
    }


    // Present Participle
    public String getPrsntParticiple() {
        return prsntParticiple;
    }

    public void setPrsntParticiple(String prsntParticiple) {
        this.prsntParticiple = prsntParticiple;
    }


    // Simple Past
    public String getSmplPast() {
        return smplPast;
    }

    public void setSmplPast(String smplPast) {
        this.smplPast = smplPast;
    }


    // Past Participle
    public String getPstParticiple() {
        return pstParticiple;
    }

    public void setPstParticiple(String pstParticiple) {
        this.pstParticiple = pstParticiple;
    }
}
