package markup;

import java.util.List;

public class Paragraph extends MarkupNode implements MarkUpElement{
    public Paragraph(List<MarkUpElement> l) {
        super(l);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        super.toMarkdown(sb, "");
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb);
    }
}
