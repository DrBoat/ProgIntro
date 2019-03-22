package markup;

import java.util.List;

public class Strikeout extends MarkupNode implements MarkUpElement {
    public Strikeout(List<MarkUpElement> elements) {
        super(elements);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        super.toMarkdown(sb, "~");
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "s");
    }
}
