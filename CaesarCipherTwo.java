import edu.duke.*;
import org.apache.commons.csv.*;

public class CaesarCipherTwo
{
    
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private String shiftedAlphabetKey1;
    private String shiftedAlphabetKey2;
    private int key1;
    private int key2;
    
    public CaesarCipherTwo(int key1, int key2) {
        shiftedAlphabetKey1 = alphabet.substring(key1) 
        + alphabet.substring(0, key1);
        shiftedAlphabetKey2 = alphabet.substring(key2) 
        + alphabet.substring(0, key2);
        this.key1 = key1;
        this.key2 = key2;
    }
    
    public String encryptTwoKeys(String input) {
        StringBuilder sb = new StringBuilder(input);
        int key = key1;
        
        for(int i = 0; i < sb.length(); i++) {
            char currChar = sb.charAt(i);
            
            if(key == key1) {
                if(Character.isLowerCase(currChar)) {
                int indexLc = alphabet.indexOf(currChar);
                sb.setCharAt(i, shiftedAlphabetKey1.charAt(indexLc));
                }
                else if(Character.isUpperCase(currChar)){
                currChar = Character.toLowerCase(currChar);
                int indexUc = alphabet.indexOf(currChar);
                char toChange = Character.toUpperCase(shiftedAlphabetKey1.charAt(indexUc));
                sb.setCharAt(i, toChange);
                }  
                key = key2;
            }
            else {
                if(Character.isLowerCase(currChar)) {
                int indexLc = alphabet.indexOf(currChar);
                sb.setCharAt(i, shiftedAlphabetKey2.charAt(indexLc));
                }
                else if(Character.isUpperCase(currChar)){
                currChar = Character.toLowerCase(currChar);
                int indexUc = alphabet.indexOf(currChar);
                char toChange = Character.toUpperCase(shiftedAlphabetKey2.charAt(indexUc));
                sb.setCharAt(i, toChange);
                }
                key = key1;
            }
        }
        return sb.toString();    
    }
    
    public String decryptTwoKeys(String input) {
        CaesarCipherTwo cc = new CaesarCipherTwo(26-key1, 26-key2);
        return cc.encryptTwoKeys(input);
    }
    
}
