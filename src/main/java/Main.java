import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String phraseAsked;
        Scanner sc = new Scanner(System.in);
        System.out.print("Type phrase: ");
        phraseAsked = sc.nextLine();
        System.out.println(phraseAsked);
        StringScanner stringScanner = new StringScanner();
        stringScanner.phraseSplit(phraseAsked);
        System.out.println(Arrays.toString(stringScanner.getWords()));
    }

}
