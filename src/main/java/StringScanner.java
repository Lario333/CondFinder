/**
 * StringScanner
 */

public class StringScanner {

    private String[] phrase; // contain all words of the phrase
    // default constructor
    public StringScanner() {
        phrase = null;
    }

    // split the phrase in words
    private String[] phraseSplit(String phrase) {
        return phrase.split(",* ");
    }

    // identify the type of conditional
    public void scanString(String phraseGiven) {
        this.phrase = phraseSplit(phraseGiven);
        // TODO Trovare verbo base e a esclusione verificare ogni conditional
        // For every word, checks if it's a verb contained in VerbDB
        for(int i = 0 ; i < phrase.length ; i++){
            // Enters in the statement if the word is a verb
            if (Main.verbDB.isVerbContained(phrase[i])){
                // Getting the verbal tense
                System.out.println(Main.verbDB.getVerbalTense(phrase[i]));
            }
        }
    }

    // TODO **Idea Scan** Controllare l’index della parola ”if”, se e’ 0 si fa in un modo, se e’ altro in un altro modo.

    // get and set

    public String[] getWords() {
        return phrase;
    }

    public void setWords(String[] words) {
        this.phrase = words;
    }
}
