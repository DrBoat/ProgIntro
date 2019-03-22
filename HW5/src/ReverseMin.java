import java.util.*;
import java.io.*;

public class ReverseMin {
    public static void main(String [] args) {

        List<ArrayList<Integer>> allNumbers = new ArrayList <ArrayList <Integer> > ();
        ArrayList<String> lines = new ArrayList <String> ();
        MyScanner in = new MyScanner(System.in);
        try {
            while (in.hasNext()) {
                ArrayList < Integer > numbers = new ArrayList < Integer > ();
                int curLine = in.getLineNumber();
                while (curLine == in.getLineNumber()) {
                    numbers.add(in.nextInt());
                }
                allNumbers.add(numbers);
            }
        } catch (IOException e) {
            System.out.println("IOException");
        } finally {
            //in.close();
        }
        /*
        ArrayList <ArrayList <Integer> > mins = new ArrayList <ArrayList <Integer> > ();
        Integer minColum = -1;
        try
        {
            for (int i = 0; i < allNumbers.size(); i++)
            {
                ArrayList <Integer> linemin = new ArrayList <Integer> ();
                if(!allNumbers.get(i).isEmpty()) {
                    if (allNumbers.get(i).size() > 0)
                    {
                        Integer min = allNumbers.get(i).get(0);
                        for (int j = 1; j < allNumbers.get(i).size(); j++)
                            if (min < allNumbers.get(i).get(j)) min = allNumbers.get(i).get(j);
                        for (int j = 0; j < allNumbers.get(i).size(); j++)
                            linemin.add(min);
                    }
                }
                mins.add(linemin);
                if (allNumbers.get(i).size() > 0 && minColum < allNumbers.get(i).size()) minColum = allNumbers.get(i).size();
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }

        try
        {
            for (int j = 0; j < minColum; j++) {
                Integer min = 0;
                boolean flag = true;
                for (int i = 0; i < allNumbers.size(); i++) {
                    if (allNumbers.get(i).size()-1 >= j) {
                        if (flag) {
                            min = allNumbers.get(i).get(j);
                            flag=false;
                        }
                        else if (min < allNumbers.get(i).get(j)) {
                            min = allNumbers.get(i).get(j);
                        }
                    }
                }
                for (int i = 0; i < allNumbers.size(); i++) {
                    if (allNumbers.get(i).size()-1 >= j) {
                        if (min > mins.get(i).get(j)) {
                            mins.get(i).set(j, min);
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
        for (int i = 0; i < mins.size(); i++)
        {
            for (int j = 0; j < mins.get(i).size(); j++) {
                System.out.print(mins.get(i).get(j) + " ");
            }
            System.out.println();
        }*/
        for (int i = 0; i < allNumbers.size(); i++)
        {
            for (int j = 0; j < allNumbers.get(i).size(); j++) {
                System.out.print(allNumbers.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

class MyScanner {
    private BufferedReader reader;
    private boolean isReadNext;
    private boolean isReadWord;
    private int lineNumber = 1;
    private String lineSep = System.lineSeparator();

    public MyScanner(InputStream in) {
        reader = new BufferedReader(new InputStreamReader(in));
    }

    public MyScanner(File file, String encoding) throws UnsupportedEncodingException, FileNotFoundException {
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
    }

    public boolean hasNextWord() throws IOException {
        int curChar;
        int prevChar = 0;
        while (true) {
            reader.mark(1);
            curChar = reader.read();
            if (curChar == -1) {
                isReadWord = false;
                return false;
            }
            if (ifNextLine(curChar, prevChar)) {
                lineNumber++;
            }
            prevChar = curChar;
            if (isGood((char) curChar)) {
                isReadWord = true;
                reader.reset();
                return true;
            }
        }
    }

    public String nextWord() throws IOException {
        StringBuilder curString = new StringBuilder();
        if (isReadWord || hasNextWord()) {
            isReadWord = false;
            int curChar;
            while (true) {
                reader.mark(1);
                curChar = reader.read();
                if (isGood((char)curChar)) {
                    curString.append((char) curChar);
                } else {
                    reader.reset();
                    return curString.toString();
                }
            }
        } else {
            throw new NoSuchElementException("Next word not found");
        }
    }

    public boolean hasNext() throws IOException {
        int curChar;
        int prevChar = 0;
        while (true) {
            reader.mark(1);
            curChar = reader.read();
            if (curChar == -1) {
                isReadNext = false;
                return false;
            }
            if (ifNextLine(curChar, prevChar)) {
                lineNumber++;
            }
            prevChar = curChar;
            if (!Character.isWhitespace(curChar)) {
                isReadNext = true;
                reader.reset();
                return true;
            }
        }
    }

    public String next() throws IOException {
        StringBuilder curString = new StringBuilder();
        if (isReadNext || hasNext()) {
            isReadNext = false;
            int curChar;
            int prevChar = 0;
            while (true) {
                curChar = reader.read();
                if (ifNextLine(curChar, prevChar)) {
                    lineNumber++;
                }
                prevChar = curChar;
                if (curChar == -1 || Character.isWhitespace(curChar)) {
                    return curString.toString();
                } else {
                    curString.append((char) curChar);
                }
            }
        } else {
            throw new NoSuchElementException("No strings found");
        }
    }

    public int nextInt () throws IOException, NumberFormatException {
        if (isReadNext || hasNext()) {
            return Integer.parseInt(next());
        } else {
            throw new NoSuchElementException("No numbers found");
        }
    }

    private static boolean isGood(char c) {
        return Character.getType(c) == Character.DASH_PUNCTUATION || Character.isLetter(c) || c == '\'';
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public boolean ifNextLine (int curChar, int prevChar) {
        return lineSep.length() == 1 && String.valueOf((char)curChar).equals(lineSep) ||
                lineSep.length() == 2 && String.valueOf((char)prevChar+(char)curChar).equals(lineSep);
    }

    public void close() throws IOException {
        if (reader != null) {
            reader.close();
            reader = null;
        }
    }
}