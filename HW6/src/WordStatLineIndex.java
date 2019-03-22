import java.io.*;
import java.util.*;

public class WordStatLineIndex {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "UTF-8"))){
            Scanner input = new Scanner(br);
            input.useDelimiter("");
            StringBuilder sb = new StringBuilder();
            while (input.hasNext()) {
                String s = input.next();
                for (int i = 0; i < s.length(); i++) {
                    if (Character.isLetter(s.charAt(i)) || Character.getType(s.charAt(i)) == Character.DASH_PUNCTUATION || s.charAt(i) == '\'') {
                        sb.append(s.charAt(i));
                    } else if (sb.length() != 0) {
                        String tmp = sb.toString().toLowerCase();
                        if (words.containsKey(tmp)) {
                            words.put(tmp, words.get(tmp) + 1);
                        } else {
                            words.put(tmp, 1);
                        }
                        sb.delete(0, sb.length());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(
                    "ERROR: input file not found: " + e.getMessage()
            );
        } catch (UnsupportedEncodingException e) {
            System.err.println(
                    "ERROR: unsupported encoding: " + e.getMessage()
            );
        } catch (IOException e) {
            System.err.println(
                    "ERROR: input error: " + e.getMessage()
            );
        }
        File outputFile = new File(args[1]);
        try {
            PrintWriter out = new PrintWriter(outputFile);

            Map<String, Integer> treeMap = new TreeMap<String, Integer>(words);
            for (Map.Entry i : treeMap.entrySet()) {
                out.println(i.getKey() + " " + i.getValue());
            }
            out.close();
        } catch (OutOfMemoryError e) {
            System.err.println(
                    "ERROR: out of memory: " + e.getMessage()
            );
        } catch (FileNotFoundException e) {
            System.err.println(
                    "ERROR: output file not found or read-only: " + e.getMessage()
            );
        }
    }
}
