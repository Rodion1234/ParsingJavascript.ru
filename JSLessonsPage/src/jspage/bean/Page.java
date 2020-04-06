package jspage.bean;

public class Page {

    private Author author;

    private Content content;

    private String title;

    private String urlOriginal;

    private String utlPage;

    public Page() {
    }

    public String converterContentToURL() {
        this.content.addContent("a", urlOriginal);
        String content = ((this.content.getData()).toString()).replace("[[", "[").replace("]]", "]");

        String[] str1 = content.split("\"tag\":");
        String newContent = str1[0];
        for (int i = 1; i < str1.length; i++) {
            str1[i] = str1[i].substring(1);
            int index = str1[i].indexOf("]");
            str1[i] = str1[i].substring(0, str1[i].indexOf("]")) + str1[i].substring(str1[i].indexOf("]") + 1);
            str1[i] = "\"tag\":" + str1[i];
            newContent += str1[i];
        }
        
        return "[" + newContent + "]";

    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Content getContent1() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public String getUtlPage() {
        return utlPage;
    }

    public void setUtlPage(String utlPage) {
        this.utlPage = utlPage;
    }

    @Override
    public String toString() {
        return "Page{" + "author=" + author + ", content=" + content + ", title=" + title + ", urlOriginal=" + urlOriginal + ", utlPage=" + utlPage + '}';
    }

	
}
