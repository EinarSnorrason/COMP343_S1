package MQ;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Einar Snorrason on 12/03/2018.
 */
public class SHASolver {
    final static String original = "5146ADE2F3CF7A7517C161DFE47AAE05BEF44CA3CB63BA31A701268F49289018";
    public static void main(String[] args){
        System.out.println(SHAFinder(original));
    }
    public static String SHAFinder(String original){
        try {
            // Read lines from file that contains all words in english language
            BufferedReader br = new BufferedReader(new FileReader("enable1.txt"));
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            String word = br.readLine();
            String hash;
            while(word!=null){
                // Take a hash of each word and convert it to hexadecimal
                byte[] encodedhash = digest.digest(
                        word.getBytes(StandardCharsets.UTF_8));
                hash = bytesToHex(encodedhash);
                // Check if the hashes match
                if (hash.equals(original)){
                    return word;
                }
                word = br.readLine();
            }
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b:hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString().toUpperCase();
    }

}
