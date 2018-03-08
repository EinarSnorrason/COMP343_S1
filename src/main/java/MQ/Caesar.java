package MQ;

/**
 * Created by Einar Snorrason on 05/03/2018.
 */
public class Caesar {

    public static void main(String[] args){
        String plaintext = "ENEMY CODE EXTREMELY EASY TO BREAK";
        String cipherText1 = cipher(plaintext,5);
        String cipherText2 = cipher(cipherText1,7);
        System.out.println(cipherText2);
        System.out.println(cipher(cipherText2,-12));
    }
    public static String cipher(String plaintext, int key){
        key %=26;
        if (key<0)
            key += 26;
        StringBuilder ciphertext = new StringBuilder();
        for (int i=0;i<plaintext.length();i++){
            int letter = (int)plaintext.charAt(i)-65;
            if (letter<0||letter>25){
                ciphertext.append(plaintext.charAt(i));
                continue;
            }
            letter = ((letter+key)%26)+65;
            ciphertext.append((char) letter);
        }
        return ciphertext.toString();
    }
}
