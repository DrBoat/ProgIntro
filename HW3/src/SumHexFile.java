import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class sumhexfile {
    public static void main(string[] args) {
        biginteger ans = new biginteger("0", 10);
        file inputfile = new file(args[0]);
        try {
            scanner nums = new scanner(inputfile);
            while (nums.hasnext()) {
                string s = nums.next();
                if (s.length() > 2) {
                    if (s.charat(1) == 'x' || s.charat(1) == 'x') {
                        stringbuilder sb = new stringbuilder(s);
                        sb.delete(0, 2);
                        s = sb.tostring();
                    }
                }
                biginteger tmp = new biginteger(s, 16);
                ans = ans.add(tmp);
            }
            nums.close();
        } catch (filenotfoundexception e) {
            e.printstacktrace();
        }
        file outputfile = new file(args[1]);
        try {
            printwriter out = new printwriter(outputfile);
            out.println(ans);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
