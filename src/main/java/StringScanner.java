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
        int verbCounter = 0;
        boolean skipVerb = false; // set to skip the next verb if the last was past perfect

        // enters if the phrase starts with "if"
        if (ifStart){
            // Runs every word
            for(int i = 0 ; i < phrase.length ; i++){
                // runs if the last verb wasn't a composed tense
                if (!skipVerb){
                    // Enters the statement if the tense is past perfect
                    if (phrase[i].equalsIgnoreCase("had")){
                        // Enters in the statement if the word is a verb
                        if (Main.verbDB.isVerbContained(phrase[i + 1])){
                            // Getting the verbal tense and putting it into the phraseVerbs array
                            phraseVerbs[verbCounter] = Main.verbDB.getVerbalTense(phrase[i] + " " + phrase[i + 1]);
                            verbCounter++;
                            skipVerb = true;
                        }
                        // Enters if the world is every tense nor past perfect
                    } else {
                        if (Main.verbDB.isVerbContained(phrase[i])){
                            // Getting the verbal tense and putting it into the phraseVerbs array
                            phraseVerbs[verbCounter] = Main.verbDB.getVerbalTense(phrase[i]);
                            verbCounter++;
                        }
                    }
                } else {
                    skipVerb = false;
                }
            }
        } else {
            // Runs every word
            for(int i = 0 ; i < phrase.length ; i++){
                // runs if the last verb wasn't a composed tense
                if (!skipVerb){
                    // Enters the statement if the tense is past perfect
                    if (phrase[i].equalsIgnoreCase("had")){
                        // Enters in the statement if the word is a verb
                        if (Main.verbDB.isVerbContained(phrase[i + 1])){
                            // Getting the verbal tense and putting it into the phraseVerbs array
                            phraseVerbs[verbCounter] = Main.verbDB.getVerbalTense(phrase[i] + " " + phrase[i + 1]);
                            verbCounter++;
                            skipVerb = true;
                        }
                        // Enters if the world is every tense nor past perfect
                    } else {
                        if (Main.verbDB.isVerbContained(phrase[i])){
                            // Getting the verbal tense and putting it into the phraseVerbs array
                            phraseVerbs[verbCounter] = Main.verbDB.getVerbalTense(phrase[i]);
                            verbCounter++;
                        }
                    }
                } else {
                    skipVerb = false;
                }
            }
        }


        // Print verbal tenses
        for(int i = 0 ; i < phraseVerbs.length; i++){
            System.out.println(phraseVerbs[i]);
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
