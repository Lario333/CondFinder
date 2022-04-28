import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static VerbDB verbDB = new VerbDB();
    public static ArrayList<Conditional> condDB = new ArrayList<>();
    /*
        gets all the verbs from verb.csv and set them into an arraylist in VerbDB
     */
    public static void setVerbDatabase(){
        String fileReadTemp; // String of temporary read text
        try {
            // Setting vars to read the csv verb file
            File f = new File("src/main/resources/verbs.csv");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            br.readLine(); // Reading first line, which is the heading

            // Reads the file to the end
            while((fileReadTemp = br.readLine()) != null){
                String[] tempArray;
                tempArray = fileReadTemp.split(","); // temp String array of the verb read
                // array used in case of tempArray length < than 5
                String[] newTempArray = new String[5];
                // if the String array hasn't 5 strings it enters in the statement
                if (tempArray.length != 5){
                    // Setting the existing verbs in the newTempArray
                    for(int i = 0 ; i < tempArray.length ; i++){
                        newTempArray[i] = tempArray[i];
                    }
                    // for 5 times, whenever a null index is found, it becomes the same as the index before
                    for(int i = 0 ; i < 5 ; i++){
                        if ( (newTempArray[i] == null) || (newTempArray[i] == "")){
                            newTempArray[i] = newTempArray[i - 1];
                        }
                    }
                } else {
                    for(int i = 0 ; i < 5 ; i++){
                        newTempArray[i] = tempArray[i];
                    }
                }
                // creating and adding the verb into the arraylist in VerbDB
                Verb v = new Verb(newTempArray);
                verbDB.addVerb(v);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*
        creates conditionals and adds them to the arraylist
     */
    private static void createConditionals(){
        ArrayList<String> firstList = new ArrayList<>();
        ArrayList<String> secondList = new ArrayList<>();
        ArrayList<String> thirdList = new ArrayList<>();

        firstList.add("will");firstList.add("can");firstList.add("must");firstList.add("baseForm"); // baseForm intended as imperative
        secondList.add("would");secondList.add("could");
        thirdList.add("would have");thirdList.add("could have");

        Conditional zero = new Conditional("baseForm" , "baseForm" ,"zero" ,50); // baseform + baseform [50]
        Conditional first = new Conditional("baseForm" , firstList , "first" , 50); // baseform + will/can/must/imperative [50]
        Conditional second = new Conditional("smplPast" , secondList , "second" , 100 ); // simple past + would/could [100]
        Conditional third = new Conditional("pstPerfect" , thirdList , "third" , 100); // past perfect + would/could have [100]
        Conditional mixed = new Conditional("pstPerfect" , secondList , "mixed" , 100); // past perfect + would/could [100]

        condDB.add(zero);condDB.add(first);condDB.add(second);condDB.add(third);condDB.add(mixed);
    }

    /*
        Asks for the phrase and scans it into the stringScanner instance
     */
    public static void main(String[] args){
        setVerbDatabase();
        createConditionals();
        String phraseAsked;
        StringScanner stringScanner = new StringScanner();

        Scanner sc = new Scanner(System.in);
        phraseAsked = sc.nextLine(); // Getting the phrase
        stringScanner.scanString(phraseAsked); // Scannning the string
    }

}
