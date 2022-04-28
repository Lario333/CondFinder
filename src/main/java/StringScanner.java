import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * StringScanner
 */

public class StringScanner {

    private String[] phrase; // contain all words of the phrase
    private boolean ifStart;
    // default constructor
    public StringScanner() {
        phrase = null;
    }

    // split the phrase in words
    private String[] phraseSplit(String phrase) {
        return phrase.split(",* ");
    }

    private boolean doesPhraseStartsWithIf(String[] p){
        if (p[0].equalsIgnoreCase("if")){
            return true;
        } else {
            return false;
        }
    }

    // identify the type of conditional and searches for the conditional tense used
    public void scanString(String phraseGiven) {
        this.phrase = phraseSplit(phraseGiven);
        this.ifStart = doesPhraseStartsWithIf(phrase); // getting if the phrase starts with if
        String[] phraseVerbs = new String[4];

        if (ifStart){
            for(int i = 0 ; i < phrase.length ; i++){
                // Enters the statement if the tense is past perfect
                if (phrase[i].equalsIgnoreCase("had")){
                    // Enters in the statement if the word is a verb
                    if (Main.verbDB.isVerbContained(phrase[i + 1])){
                        // Getting the verbal tense and putting it into the phraseVerbs array
                        phraseVerbs[i] = Main.verbDB.getVerbalTense(phrase[i] + " " + phrase[i + 1]);


                        // System.out.println(Main.verbDB.getVerbalTense(phrase[i] + " " + phrase[i + 1]));
                    }
                // Enters if the world is not had
                } else {
                    if (Main.verbDB.isVerbContained(phrase[i])){
                        // Getting the verbal tense and putting it into the phraseVerbs array
                        phraseVerbs[i] = Main.verbDB.getVerbalTense(phrase[i]);

                        // System.out.println(Main.verbDB.getVerbalTense(phrase[i]));
                    }
                }
            }

            for(int i = 0 ; i < phraseVerbs.length; i++){

            }
        } else {

        }

    }

    // get and set

    public String[] getWords() {
        return phrase;
    }

    public void setWords(String[] words) {
        this.phrase = words;
    }
}
