import java.io.*;
import java.util.Scanner;

public class Main {
    public static VerbDB verbDB = new VerbDB();
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
                String[] tempArray = fileReadTemp.split(","); // temp String array
                if (tempArray.length != 5){
                    for(int i = 0 ; i < 5 ; i++){
                        if ( (tempArray[i] == null) || (tempArray[i] == "")){
                            tempArray[i] = tempArray[i - 1];
                        }
                    }
                }
                Verb v = new Verb(tempArray);
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
    }

}
