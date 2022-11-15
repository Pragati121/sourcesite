package AuthenticationOfRequests;

public class Pojoclass {
    private String title;
    private String publisher;
    private String author;

    public Pojoclass(String title, String author, String publisher) {
        this.title = title;
        this.publisher = publisher;
        this.author= author;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String subTitle) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "Title : " + this.title +"  " +"  author is : " + this.author+" "+"publisher is: " + this.publisher;
    }
}
