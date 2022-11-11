package AuthenticationOfRequests;

public class Pojoclass {
    private int isbn;
    private String title;
    private String subTitl;
    private String author;

    public Pojoclass(String isbn, String email, String name1, String email3) {
        this.isbn = name;

        this.email = email;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitl() {
        return subTitl;
    }

    public void setSubTitl(String subTitl) {
        this.subTitl = subTitl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
