import javax.xml.bind.DatatypeConverter;
import java.util.*;
import java.security.*;

public class day5{
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String s = "ffykfhsq";
        MessageDigest md = MessageDigest.getInstance("MD5");
        String result;
        String zeros = "00000";
        String password = "";
        char[] pass = new char[8];
        int counter = 0;
        for(int x = 0; x<pass.length;x++){
            pass[x] = '*';
        }
        for(int x = 0; counter < 8; x++){
            md.update((s+x).getBytes());
            result = DatatypeConverter.printHexBinary(md.digest());

            if(result.substring(0,5).equals(zeros) && result.charAt(5) >= '0' && result.charAt(5) <= '7' && pass[result.charAt(5)-'0']=='*'){
                pass[result.charAt(5)-'0'] = result.charAt(6);
                counter++;
            }
            /*
            if(result.substring(0, 5).equals(zeros)){
                password += result.charAt(5);
            }
            */


        }

        for(int x = 0; x<pass.length;x++){
            System.out.print(pass[x]);
        }

        System.out.println(password);


    }
}