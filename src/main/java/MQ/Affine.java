package MQ;

import java.math.BigInteger;

/**
 * Created by Einar Snorrason on 05/03/2018.
 */
public class Affine {

    public static void main(String[] args){
        String m = "EASY CIPHERTEXT";
        String c = encrypt(encrypt(m,3,5),5,7);
        System.out.println(c);
        System.out.println(decrypt(c,15,32));
        System.out.println(decrypt(decrypt(c,5,7),3,5));
    }
    public static String encrypt(String plaintext,int a,int b){
        StringBuilder ciphertext = new StringBuilder();
        for (int i=0;i<plaintext.length();i++){
            int letter = (int)plaintext.charAt(i)-65;
            if (letter<0||letter>25){
                ciphertext.append(plaintext.charAt(i));
                continue;
            }
            letter = ((letter*a+b)%26)+65;
            if (letter<65) letter +=26;
            ciphertext.append((char) letter);
        }
        return ciphertext.toString();
    }

    public static String decrypt(String plaintext, int a, int b){
        int inv = new BigInteger(Integer.toString(a)).modInverse(new BigInteger("26")).intValue();
        StringBuilder ciphertext = new StringBuilder();
        for (int i=0;i<plaintext.length();i++){
            int letter = (int)plaintext.charAt(i)-65;
            if (letter<0||letter>25){
                ciphertext.append(plaintext.charAt(i));
                continue;
            }
            letter = (((letter-b)*inv)%26)+65;
            if (letter<65) letter +=26;
            ciphertext.append((char) letter);
        }
        return ciphertext.toString();
    }
}
