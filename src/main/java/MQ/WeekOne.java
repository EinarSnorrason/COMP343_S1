package MQ;

import java.math.BigInteger;
import java.util.Random;

/**
 * Methods to create and solve a one time pad
 */
public class WeekOne {
    public static void main(String[] args){
        System.out.println(hexToAscii("8ab932e3ef257be762ecd22d852ba82b98973e836623f3576f8c7e041ca51f656406a7c3d89083d433e09486c5393792f692b884392b74448fca1ab0c977f9f657bbfaf08a36ddce40eecb5c24c59dfa9cbefd95f396b8e53a83c8e7a777c1f9bc565647508ee8535b8eda600042779f49c7ce375bdb200c0a89d22f87635b9644be27231ab7f0787a043b7c2b79e5ecf1c44d79a615d3392c51a58c57c14a49e89539648ed597b10034f9269c6a3340b930306598d2712d972f7ca1d823903a73e79055ece7d426edf7d07bec4b87cda00e72dfcb5399847056647728602fdb9be97a16b4eda9ea3eb90d8de63caa4e1f6fa1e0ccdbc8be7bea0869001948a"));
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
