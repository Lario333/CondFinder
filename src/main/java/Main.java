import java.io.*;
import java.util.Scanner;


public class Main {
    public static VerbDB verbDB = new VerbDB();
    /*
        setVerbDatabase()
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
    public static void main(String[] args){
        setVerbDatabase();
        String phraseAsked;
        Scanner sc = new Scanner(System.in);
        phraseAsked = sc.nextLine();
        StringScanner stringScanner = new StringScanner();
        stringScanner.scanString(phraseAsked);
    }

}
