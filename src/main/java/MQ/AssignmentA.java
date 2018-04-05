package MQ;

/**
 * Created by Einar Snorrason on 08/03/2018.
 */
public class AssignmentA {
    /*"LBHNERBALBHEJNLARKGFGEVATVFRAPELCGRQHFVATNTRARENYVFNGVBABSGURNSSVARPVCUREJURERGURFRGBSPUNENPGREFVFZNQRBSNYYGURYRGGREFVAGURNYCUNORGCYHFNYYGURQVTVGFSEBZMREBGBAVARCYHFGURFCNPRPUNENPGREVAGUNGBEQREGUNGVFGUVEGLFRIRAFLZOBYFVAGBGNYLBHEPYHRVFGURSBYYBJVATQNGRBSOVEGUGUVEGRRABSZNLAVARGRRAUHAQERQFRIRAGLSBHENAQBARBSGURGJBXRLFHFRQVAGURNSSVARPVCUREVFGURLRNEBSOVEGUERQHPRQZBQHYBGUVEGLFRIRA"

and
*/
    static String affine = "6I46EI2INMN1IMCN8M55196JNLM5IJN9 N4FINH9BB91E GNJEGI54NSWTRMJIVHUKHQMQSWQKWRWJHITQMMIXSLIHTTKMUKLRULMUWMQXWVRPHTOVPOXWPN9L4ME IJN1E4FNFM5FNH3 K4E9 N5FMVSR";

    static String caesar = "LBHNERBALBHEJNLARKGFGEVATVFRAPELCGRQHFVATNTRARENYVFNGVBABSGURNSSVARPVCUREJURERGURFRGBSPUNENPGREFVFZNQRBSNYYGURYRGGREFVAGURNYCUNORGCYHFNYYGURQVTVGFSEBZMREBGBAVARCYHFGURFCNPRPUNENPGREVAGUNGBEQREGUNGVFGUVEGLFRIRAFLZOBYFVAGBGNYLBHEPYHRVFGURSBYYBJVATQNGRBSOVEGUGUVEGRRABSZNLAVARGRRAUHAQERQFRIRAGLSBHENAQBARBSGURGJBXRLFHFRQVAGURNSSVARPVCUREVFGURLRNEBSOVEGUERQHPRQZBQHYBGUVEGLFRIRA";

    public static void main(String[] args){
        //System.out.println(solver(caesar));
        System.out.println(Affine.decrypt(affineKey,affine,36,12));
        System.out.println(Affine.decrypt(affineKey,affine,eKey2(affine),12));
        for (int i=1;i<37;i++){
            System.out.println(Affine.decrypt(affineKey,affine,12,i));
        }
        for (int i=1;i<37;i++){
            System.out.println(Affine.decrypt(affineKey,affine,i,12));
        }
    }
    public static String solver(String message){
        return Caesar.cipher(message,eKey(message));
    }
    public static int eKey(String message){
        int[] counter = new int[26];
        for (int i=0;i<message.length();i++){
            counter[(int)message.charAt(i)-65]++;
        }
        int max = 0;
        int index = 0;
        for (int i=0;i<counter.length;i++){
            if (counter[i]>max){
                max = counter[i];
                index=i;
            }
        }
        System.out.println(4-index);
        System.out.println(4-index);
        return 4-index;
    }
    static int eKey2(String message){
        int[] counter = new int[affineKey.length()];
        for (int i=0;i<message.length();i++){
            char c = message.charAt(i);
            for (int j=0;j<affineKey.length();j++){
                if (c==affineKey.charAt(j)){
                    counter[j]++;
                    break;
                }
            }
        }
        int max = 0;
        int index = 0;
        for (int i=0;i<counter.length;i++){
            if (counter[i]>max){
                max = counter[i];
                index=i;
            }
        }
        return index+1;
    }

    /*
    YOU ARE ON YOUR WAY NEXT STRING IS ENCRYPTED USING A GENERALISATION OF THE AFFINE CIPHER
    WHERE THE SET OF CHARACTERS IS MADE OF ALL THE LETTERS IN THE ALPHABET PLUS ALL THE DIGITS
    FROM ZERO TO NINE PLUS THE SPACE CHARACTER IN THAT ORDER THAT IS THIRTY SEVEN SYMBOLS IN
    TOTAL YOUR CLUE IS THE FOLLOWING DATE OF BIRTH THIRTEEN OF MAY NINETEEN HUNDRED SEVENTY
    FOUR AND ONE OF THE TWO KEYS USED IN THE AFFINE CIPHER IS THE YEAR OF BIRTH REDUCED
    MODULO THIRTY SEVEN
    */

    static String affineKey = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
    static int key = 13;



}
