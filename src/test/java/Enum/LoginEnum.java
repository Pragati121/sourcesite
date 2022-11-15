package Enum;
public enum LoginEnum {
    Book ("Book Store Application"),
    Items("Book Store"),
    title("Git Pocket Guide"),
    BookSecondtitle("Learning JavaScript Design Patterns"),
    BookSixthtitle("Eloquent JavaScript, Second Edition"),
    author("Richard E. Silverman"),
    Booksecondauthor("Addy Osmani");
    ;
    private String name;
    LoginEnum(String name)
    {
        this.name = name;
    }
    public String getresourcesname()
    {
        return name;
    }
}

