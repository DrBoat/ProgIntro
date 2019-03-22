package markup;

import java.util.List;

public class MarkupNode {
    private List<MarkUpElement> children;
    public MarkupNode(List<MarkUpElement> l) {
        children = l;
    }

    protected void toMarkdown(StringBuilder str, String appendix) {
        str.append(appendix);
        for(MarkUpElement node : children) {
            node.toMarkdown(str);
        }
        str.append(appendix);
    }

    protected void toHtml(StringBuilder str, String tagName) {
        str.append("<").append(tagName).append(">");
        for (MarkUpElement node : children) {
            node.toHtml(str);
        }
        str.append("</").append(tagName).append(">");
    }

    protected void toHtml(StringBuilder str) {
        for (MarkUpElement node : children) {
            node.toHtml(str);
        }
    }

}

