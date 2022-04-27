/**
 * StringScanner
 */

public class StringScanner {

    private String[] words; // contain all words of the phrase

    // default constructor
    public StringScanner() {
        words = null;
    }

    // split the phrase in words
    public String[] phraseSplit(String phrase) {

        // TODO

        words = phrase.split(",* ");

        return words;
    }

    // identify the type of conditional
    private void conditionalScan() {
        // TODO Trovare verbo base e a esclusione verificare ogni conditional
    }

    // TODO **Idea Scan** Controllare l’index della parola ”if”, se e’ 0 si fa in un modo, se e’ altro in un altro modo.

    // get and set

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }
}
