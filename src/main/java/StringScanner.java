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
    // Searches for abbreviations like "'d" , "'ll" , "'ve" and split them clearing the phrase for the scan
    private String[] clearPhrase(){
        String[] clearPhrase = new String[phrase.length + 6];
        int counter = 0;
        for(int i = 0 ; i < phrase.length; i++){
            if (phrase[i].contains("'ll") || phrase[i].contains("'d") || phrase[i].contains("'ve") ){
                if(phrase[i].contains("'ll")){
                    clearPhrase[counter] = phrase[i].substring(0 , phrase[i].indexOf('\''));
                    counter++;
                    clearPhrase[counter] = "will";
                    counter++;
                } else if (phrase[i].contains("'d")){
                    clearPhrase[counter] = phrase[i].substring(0 , phrase[i].indexOf('\''));
                    counter++;
                    clearPhrase[counter] = "would"; // would / had
                    counter++;
                } else if (phrase[i].contains("'ve")) {
                    clearPhrase[counter] = phrase[i].substring(0, phrase[i].indexOf('\''));
                    counter++;
                    clearPhrase[counter] = "have";
                    counter++;
                }

            } else {
                clearPhrase[counter] = phrase[i];
                counter++;
            }
        }
        for(int i = 0 ; i < clearPhrase.length; i++){
            System.out.print(clearPhrase[i] + " ");
        }
        System.out.println();

        String[] finalPhrase = new String[counter];
        for(int i = 0 ; i < counter ; i++){
            finalPhrase[i] = clearPhrase[i];
        }

        return finalPhrase;
    }

    private String[] getVerbalTenses(String phraseGiven) {
        this.phrase = phraseSplit(phraseGiven);
        this.phrase = clearPhrase();
        this.ifStart = doesPhraseStartsWithIf(phrase); // getting if the phrase starts with if
        String[] phraseVerbs = new String[4];
        int verbCounter = 0;
        boolean skipVerb = false; // set to skip the next verb if the last was past perfect

        // enters if the phrase starts with "if"
        if (ifStart) {
            // Runs every word
            for (int i = 0; i < phrase.length; i++) {
                // runs if the last verb wasn't a composed tense
                if (!skipVerb) {
                    // Enters the statement if the tense is past perfect
                    if (phrase[i].equalsIgnoreCase("had") || phrase[i].equalsIgnoreCase("hadn't")) {
                        // Enters in the statement if the word is a verb
                        if (Main.verbDB.isVerbContained(phrase[i + 1])) {
                            // Getting the verbal tense and putting it into the phraseVerbs array
                            phraseVerbs[verbCounter] = Main.verbDB.getVerbalTense(phrase[i] + " " + phrase[i + 1]);
                            verbCounter++;
                            skipVerb = true;
                        } else{
                            phraseVerbs[verbCounter] = Main.verbDB.getVerbalTense("had");
                            verbCounter++;
                        }
                        // Enters if there's a "will" , "can" , "must" or [ imperative form < to-do ]
                    } else if (phrase[i].equalsIgnoreCase("will") || phrase[i].equalsIgnoreCase("can't") || phrase[i].equalsIgnoreCase("won't")  || phrase[i].equalsIgnoreCase("can") || phrase[i].equalsIgnoreCase("mustn't") || phrase[i].equalsIgnoreCase("must")) {
                        // if the word after is a verb in base form
                        if (Main.verbDB.isVerbContained(phrase[i + 1])) {
                            phraseVerbs[verbCounter] = "w/c/m-baseForm"; // Prob 1st conditional
                            verbCounter++;
                            skipVerb = true;
                        }
                        // Enters if there's a "could" or "would"
                    } else if (phrase[i].equalsIgnoreCase("could") || phrase[i].equalsIgnoreCase("would") || phrase[i].equalsIgnoreCase("wouldn't") || phrase[i].equalsIgnoreCase("couldn't")) {
                        // Checks if there's a verb after could/would
                        if (Main.verbDB.isVerbContained(phrase[i + 1])) {
                            if (phrase[i + 1].equalsIgnoreCase("have") && Main.verbDB.getVerbalTense(phrase[i + 2]).equals("pstParticiple")) {
                                // could/would + have + past participle
                                phraseVerbs[verbCounter] = "c/w-h-pstParticiple"; // Prob 3rd conditional
                                verbCounter++;
                                skipVerb = true;
                            } else {
                                // could/would + verb
                                phraseVerbs[verbCounter] = "c/w-baseForm"; // 2nd or Mixed conditional
                                verbCounter++;
                                skipVerb = true;
                            }
                        }
                        // Enters if the world is every tense nor past perfect or will/can/must/could/would
                    } else {
                        if (Main.verbDB.isVerbContained(phrase[i])) {
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
            for (int i = 0; i < phrase.length; i++) {
                // runs if the last verb wasn't a composed tense
                if (!skipVerb) {
                    // Enters the statement if the tense is past perfect
                    if (phrase[i].equalsIgnoreCase("had")) {
                        // Enters in the statement if the word is a verb
                        if (Main.verbDB.isVerbContained(phrase[i + 1])) {
                            // Getting the verbal tense and putting it into the phraseVerbs array
                            phraseVerbs[verbCounter] = Main.verbDB.getVerbalTense(phrase[i] + " " + phrase[i + 1]);
                            verbCounter++;
                            skipVerb = true;
                        } else{
                            phraseVerbs[verbCounter] = Main.verbDB.getVerbalTense("had");
                            verbCounter++;
                        }
                        // Enters if there's a "will" , "can" , "must" or [ imperative form < to-do ]
                    } else if (phrase[i].equalsIgnoreCase("will") || phrase[i].equalsIgnoreCase("can") || phrase[i].equalsIgnoreCase("must")) {
                        // if the word after is a verb in base form
                        if (Main.verbDB.isVerbContained(phrase[i + 1])) {
                            phraseVerbs[verbCounter] = "w/c/m-baseForm"; // Prob 1st conditional
                            verbCounter++;
                            skipVerb = true;
                        }
                        // Enters if there's a "could" or "would"
                    } else if (phrase[i].equalsIgnoreCase("could") || phrase[i].equalsIgnoreCase("would")) {
                        // Checks if there's a verb after could/would
                        if (Main.verbDB.isVerbContained(phrase[i + 1])) {
                            if (phrase[i + 1].equalsIgnoreCase("have") && Main.verbDB.getVerbalTense(phrase[i + 2]).equals("pstParticiple")) {
                                // could/would + have + past participle
                                phraseVerbs[verbCounter] = "c/w-h-pstParticiple"; // Prob 3rd conditional
                                verbCounter++;
                                skipVerb = true;
                            } else {
                                // could/would + verb
                                phraseVerbs[verbCounter] = "c/w-baseForm"; // 2nd or Mixed conditional
                                verbCounter++;
                                skipVerb = true;
                            }
                        }
                        // Enters if the world is every tense nor past perfect or will/can/must/could/would
                    } else {
                        if (Main.verbDB.isVerbContained(phrase[i])) {
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
        for (int i = 0; i < phraseVerbs.length; i++) {
            System.out.println(phraseVerbs[i]);
        }
        System.out.println("\n\n");
        return phraseVerbs;
    }
    // identify the type of conditional and searches for the conditional tense used
    public String scanString(String phraseGiven) {
        String[] verbalTenses = getVerbalTenses(phraseGiven);

        if (ifStart){
            if (verbalTenses[0].equals("baseForm")){
                if (verbalTenses[1].equals("baseForm")){
                    return "Zero";
                } else if (verbalTenses[1].equals("w/c/m-baseForm")){
                    return "First";
                }
            } else if (verbalTenses[0].equals("smplPast")){
                if (verbalTenses[1].equals("c/w-baseForm")){
                    return "Second";
                }
            } else if (verbalTenses[0].equals("pstPerfect")){
                if ( verbalTenses[1].equals("c/w-h-pstParticiple")){
                    return "Third";
                } else if (verbalTenses[1].equals("c/w-baseForm")){
                    return "Mixed";
                }
            }
        } else {
            if (verbalTenses[1].equals("baseForm")){
                if (verbalTenses[0].equals("baseForm")){
                    return "Zero";
                } else if (verbalTenses[0].equals("w/c/m-baseForm")){
                    return "First";
                } else if (verbalTenses[1].equals("smplPast")){
                    if (verbalTenses[0].equals("c/w-baseForm")){
                        return "Second";
                    }
                } else if (verbalTenses[1].equals("pstPerfect")){
                    if ( verbalTenses[0].equals("c/w-h-pstParticiple")){
                        return "Third";
                    } else if (verbalTenses[0].equals("c/w-baseForm")){
                        return "Mixed";
                    }
                }
            }
        }

        return "Conditional not found";
    }

    // Word get and set
    public String[] getWords() {
        return phrase;
    }
    public void setWords(String[] words) {
        this.phrase = words;
    }
}
