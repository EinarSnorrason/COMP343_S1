package MQ;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Einar Snorrason on 04/04/2018.
 */
public class DSAMaker {
    static BigInteger publicKey = new BigInteger("3192457456296028447170730893415873702237282322062154903814103785989586874053860169624443014307241056228683399078948308946240213223928094842460308552438070463668190428111746635035566372788715214572763825411754275108765612370229312538242879098074772931243449584736830418971889951541237162539893326666094910270140628851767398074989205950776486158159389812194885957740897837761491888471696315229808599200051683875194429975470688618929595679098894284933898995023166101362595274407927332295503715665637692263336367338684460012763387648934324519333506695400982235263912929785454840794336660219727271894739374362748110958100");
    static BigInteger p = new BigInteger("19552284362830564337966704355057166912804404031166711679236552569540216566780307826556867578871358576485437030942222195018081030691032539148764839230159556269162571104631125243645396734982908383768635645011674286516337887644532161784387787974377283092237245433092195388766919359771882576936876207694749870408589625208505941289702869304351315221501552209561943824085044377310530806829302917982399584945973266979228241186125402575932131348900342939564050820454479426591777063007833844106775705269150852739375278894162090022693591793968528405477303762423158664144555096918043468360406345994906124551793588849878747395663");
    static BigInteger g = new BigInteger("9369228326851588128067094743581477709920277496836775237312108149103793859242097392461261958047072509833337328257405846155281318370339212682244570311305939741139975814626041456655019240400261932984637262924772361302181863871716170249459932972459920378181623255028507760251027411367445715256986964725673431470297353925167168809737676619089616249592749350500663292938637146739170484968986364179811205356786577287741465593479791915227167723276173488551272429777303232759545362915489475948424327174196256541530719510063649963987466857385776890108389780914858553073795431739818845921967286222345192498103117402945212914400");
    static BigInteger q = new BigInteger("105232489643835277469852304646516456431850353561758360808645843167358376593733");
    static BigInteger gamma = new BigInteger("19279110241941451951679879925338641252960480753232344467297834695570050515312632067567516022839066331094822675996175721960380441326459815329916744060341375537643611434243197925663613961537646331497541902098232623520032406451413371764355304001983047360758897424255603968173954435620746320222709831546715154372219478236934238187227127941410300903014767526661155681294517936435321523776633717099882494426381012477454016593052841890434799608204267698018538797860358452607256979563827760353637207631240262985630295172187911905471569226230001718730168180569617909420309513928584393943860088213204569225100444731631643551172");
    static BigInteger meteor_private = new BigInteger("25437293595366446869478279884756891513095330936049956761867667289983332598313");
    static BigInteger NINE = new BigInteger("9");

    public static void main(String[] args){
        BigInteger ha = new BigInteger("2106870989709746704155980834353433311111708490161336529088133721504647308070823859943004643683266362175395366055947236562127941838299988964541088895324944444271130521312994001666755448871373539753110011463115389256448354224754598824404639497115808240571201134651264855465773195566719212447538986105390453206932554025223691250759868541899441934204314119801055393974048015635918889435490120395406231855265345382712875131501738156599658487549077384169480322967615194154774916519228951715465346867449040572861522064296560495651763441302541911708617218623309023501564915557960480084299744432199357166533755228430578664333");
        BigInteger H = new BigInteger("684EBFAF9DB0B7A061CF2098FF98D398AD75B46CD45DFD85D30E30D1D1497CFD",16);
        DSACreator(p,q,gamma,H,ha,meteor_private);
    }
    public static void DSACreator(BigInteger p,BigInteger q,BigInteger gamma,BigInteger H,BigInteger ha,BigInteger a){
        // DSA Signature Protocol
        // Create random integer between 0 and q
        BigInteger k = new BigInteger(q.bitLength(), new Random());
        BigInteger r = gamma.modPow(k,p).mod(q);
        BigInteger s = (H.add(a.multiply(r))).multiply(k.modInverse(q)).mod(q);
        //Print out signature:
        System.out.println("["+r+","+s+"]");
        // DSA verification:
        BigInteger w = s.modInverse(q);
        BigInteger u1 = H.multiply(w).mod(q);
        BigInteger u2 = r.multiply(w).mod(q);
        BigInteger v = gamma.modPow(u1,p).multiply(ha.modPow(u2,p)).mod(p).mod(q);
        if (v.equals(r)){
            System.out.println("Signature is correct");
        } else{
            System.out.println("Signature is wrong");
        }
    }
}
