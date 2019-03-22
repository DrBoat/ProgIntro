import java.util.Arrays;
import java.util.Collections;

import markup.*;

public class Main {
    public static void main(String[] args) {
        Paragraph paragraph = new Paragraph(Collections.singletonList(
                new Strong(Arrays.asList(
                        new Text("1"),
                        new Strikeout(Arrays.asList(
                                new Text("2"),
                                new Emphasis(Arrays.asList(
                                        new Text("3"),
                                        new Text("4")
                                )),
                                new Text("5")
                        )),
                        new Text("6")
                ))
        ));
        StringBuilder wr = new StringBuilder();
        paragraph.toHtml(wr);
        System.out.println(wr.toString());
    }
}
