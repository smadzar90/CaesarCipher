import edu.duke.*;
import org.apache.commons.csv.*;
import java.util.Scanner;

public class TestCaesarCipherTwo
{
    private Scanner scan = new Scanner(System.in);
    
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
    
    public String halfOfTheString(String message, int start) {
        
        String halfString = "";
        for(int i = start; i < message.length(); i +=2) {
            halfString += message.charAt(i);
        }
        return halfString;
    }
    
    public void simpleTests() {
        FileResource fr = new FileResource();
        String content = fr.asString();
        System.out.print("Enter a key1: ");
        int key1 = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter a key2: ");
        int key2 = scan.nextInt();
        CaesarCipherTwo cc1 = new CaesarCipherTwo(key1, key2);
        String encrypted = cc1.encryptTwoKeys(content);
        System.out.println("\nEncrypted message: " + encrypted);
        breakCaesarCipher(encrypted);
    }
    
    public int getKey(String message) {
        int[] freq = countLetters(message);
        int maxIndex = maxIndex(freq);
        int key = maxIndex - 4;
        if(maxIndex < 4) {
            key = 26 - (4 - maxIndex);
        }
        return key;
    }
    
    public void breakCaesarCipher(String input) {
        String firstHalf = halfOfTheString(input, 0);
        String secondHalf = halfOfTheString(input, 1);
        int key1 = getKey(firstHalf);
        int key2 = getKey(secondHalf);
        CaesarCipherTwo cc2 = new CaesarCipherTwo(key1, key2);
        System.out.println("Decrypted message: " + cc2.decryptTwoKeys(input));
    }
    
    
}
