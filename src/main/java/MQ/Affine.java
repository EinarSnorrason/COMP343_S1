package MQ;

import java.math.BigInteger;

/**
 * Created by Einar Snorrason on 05/03/2018.
 */
public class Affine {

    static final String affineKey = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args){
        String m = "EASY CIPHERTEXT";
        String c = encrypt(encrypt(m,3,5),5,7);
        System.out.println(c);
        System.out.println(decrypt(c,15,32));
        System.out.println(decrypt(decrypt(c,5,7),3,5));
    }

    private static int findPos(String alphabet,char c){
        for (int i=0;i<alphabet.length();i++){
            if (c==alphabet.charAt(i)) return i;
        }
        return -1;
    }
    public static String encrypt(String plaintext,int a,int b){
        return encrypt(affineKey,plaintext,a,b);
    }

    public static String encrypt(String alphabet,String plaintext,int a,int b){
        StringBuilder ciphertext = new StringBuilder();
        for (int i=0;i<plaintext.length();i++){
            int letter = findPos(alphabet,plaintext.charAt(i));
            if (letter<0){
                ciphertext.append(plaintext.charAt(i));
                continue;
            }
            letter = ((letter*a+b)%alphabet.length());
            if (letter<0) letter +=alphabet.length();
            ciphertext.append(alphabet.charAt(letter));
        }
        return ciphertext.toString();
    }


    public static String decrypt(String plaintext, int a, int b){
        return decrypt(affineKey,plaintext,a,b);
    }

    /**
     * Decrypts a message encrypted with an affine cipher when given two keys
     */
    public static String decrypt(String alphabet,String plaintext, int a, int b){
        // Calculate 1/a mod (lenght of alphabet)
        int inv = new BigInteger(Integer.toString(a)).modInverse(new BigInteger(Integer.toString(alphabet.length()))).intValue();
        StringBuilder ciphertext = new StringBuilder();
        // Decrypt letter by letter
        for (int i=0;i<plaintext.length();i++){
            int letter = findPos(alphabet,plaintext.charAt(i));
            if (letter<0){
                // If letter is not in alphabet, leave it be
                ciphertext.append(plaintext.charAt(i));
                continue;
            }
            letter = (inv*(letter-b)%alphabet.length());
            if (letter<0) letter +=alphabet.length();
            ciphertext.append(alphabet.charAt(letter));
        }
        return ciphertext.toString();
    }
}
