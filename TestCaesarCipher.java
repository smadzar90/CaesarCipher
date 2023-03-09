import edu.duke.*;
import org.apache.commons.csv.*;
import java.util.Scanner;

public class TestCaesarCipher
{
    public Scanner scan = new Scanner(System.in);
    
    public int[] countLetters(String encrypted) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] letters = new int[26];
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            if(Character.isLetter(currChar)) {
            int alphaIndex = alpha.indexOf(Character.toLowerCase(currChar));
            letters[alphaIndex]++;
            }
        }
        return letters;
    }
    
    public int maxIndex(int[] freq) {
        int max = freq[0];
        int maxInd = 0;
        for(int i = 1; i < freq.length; i++) {
            if(freq[i] > max) {
                max = freq[i];
                maxInd = i;
            }
        }
        return maxInd;
    }
    
    public void simpleTests() {
        FileResource fr = new FileResource();
        String content = fr.asString();
        System.out.print("Enter a key: ");
        int key = scan.nextInt();
        CaesarCipher cc = new CaesarCipher(key);
        String encrypted = cc.encrypt(content);
        System.out.println("\nEncrypted message: " + encrypted);
        breakCaesarCipher(encrypted);
    }
    
    public void breakCaesarCipher(String input) {
        
        int[] freq = countLetters(input);
        int maxIndex = maxIndex(freq);
        int dkey = maxIndex - 4;
        if(maxIndex < 4) {
            dkey = 26 - (4 - maxIndex);
        }
        CaesarCipher cc = new CaesarCipher(dkey);
        System.out.println("Decrypted message: " + cc.decrypt(input));
    }
    
   
}
