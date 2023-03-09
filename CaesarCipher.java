import edu.duke.*;
import org.apache.commons.csv.*;
import java.util.Scanner;

public class CaesarCipher
{
    
    public static Scanner scan = new Scanner(System.in);
    private String alphabetUc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String alphabetLc = "abcdefghijklmnopqrstuvwxyz";
    private String shiftedAlphabetUc;
    private String shiftedAlphabetLc;
    private int mainKey;
    
    public CaesarCipher(int key) {
        shiftedAlphabetUc = alphabetUc.substring(key) + alphabetUc.substring(0, key);
        shiftedAlphabetLc = alphabetLc.substring(key) + alphabetLc.substring(0, key);
        mainKey = key;
    }
    
    public String encrypt(String input) {
        StringBuilder sb = new StringBuilder(input);
        
        for(int i = 0; i < sb.length(); i++) {
            char currChar = sb.charAt(i);
            if(Character.isLowerCase(currChar)) {
                int indexLc = alphabetLc.indexOf(currChar);
                sb.setCharAt(i, shiftedAlphabetLc.charAt(indexLc));
            }
            else if(Character.isUpperCase(currChar)){
                int indexUc = alphabetUc.indexOf(currChar);
                sb.setCharAt(i, shiftedAlphabetUc.charAt(indexUc));
            }   
        }
        return sb.toString();
    }
    
    public String decrypt(String input) {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
    }

    
    
    
}
