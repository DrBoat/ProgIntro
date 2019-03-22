package markup;

public interface MarkUpElement {
    public void toMarkdown(StringBuilder sb);
    public void toHtml(StringBuilder sb);
}
