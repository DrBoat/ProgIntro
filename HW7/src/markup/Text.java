package markup;

public class Text implements MarkUpElement {
    private String text;

    public Text(String text_) {
        text = text_;
    }

    @Override
    public void toMarkdown(StringBuilder markup) {
        markup.append(text);
    }

    @Override
    public void toHtml(StringBuilder sb) {
        toMarkdown(sb);
    }
}
