package markup;

import java.util.List;

public class Strong extends MarkupNode implements MarkUpElement {
    public Strong(List<MarkUpElement> elements) {
        super(elements);
    }

    @Override
    public void toMarkdown(StringBuilder sb) {
        super.toMarkdown(sb, "__");
    }

    @Override
    public void toHtml(StringBuilder sb) {
        super.toHtml(sb, "strong");
    }
}
