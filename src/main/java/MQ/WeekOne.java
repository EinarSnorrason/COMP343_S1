package MQ;

import java.math.BigInteger;
import java.util.Random;

/**
 * Methods to create and solve a one time pad
 */
public class WeekOne {
    public static void main(String[] args){
        for (int i=255;i<1000;i++){
            System.out.println(i+" "+((char)i));
        }
        System.out.println(-30%26);
    }



    public static String[] oneTimePadCreator(String message){
        String[] result = new String[2];
        BigInteger key = new BigInteger(asciiToHex(message),16);
        BigInteger cipher = new BigInteger(key.bitLength(),new Random());
        result[0] = cipher.xor(key).toString(16);
        result[1] = cipher.toString(16);
        return result;
    }

    public static String oneTimePadSolver(String key, String cipher){
        BigInteger keyNum = new BigInteger(key,16);
        BigInteger cipherNum = new BigInteger(cipher,16);
        return hexToAscii(keyNum.xor(cipherNum).toString(16));
    }

    private static String hexToAscii(String hex){
        if (hex.length()%2!=0){
            hex = "0"+hex;
        }
        StringBuilder message = new StringBuilder();
        for (int i=0;i<hex.length();i+=2){
            int a = Integer.parseInt(hex.substring(i,i+2),16);
            message.append((char) a);
        }
        return message.toString();
    }

    private static String asciiToHex(String message){
        StringBuilder keyStr = new StringBuilder();
        int n = message.length();
        for (int i=0; i<n; i++){
            int asciiNum = (int) message.charAt(i);
            if (asciiNum<=0xF){
                keyStr.append(0);
            }
            keyStr.append(Integer.toString(asciiNum,16));
        }
        return keyStr.toString();
    }
}
