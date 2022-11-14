package AuthenticationOfRequests;

public class Pojoclass {
    private String title;
    private String subtitle;
    private String author;

    public Pojoclass(String title, String subTitle, String publisher) {
        this.title = title;
        this.subtitle= subTitle;
        this.author= author;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitl() {
        return subtitle;
    }

    public void setSubTitl(String subTitle) {
        this.subtitle = subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "Title : " + this.title + "subtitile is: " + this.subtitle+"  Author is : " + this.author;
    }
}
