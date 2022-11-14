package Enum;
public enum LoginEnum {
    Book ("Book Store Application"),
    Items("Book Store"),
    title("Git Pocket Rocket"),
    author("Richard E.Silverman"),
    publisher("O' Reilly Media");
    private String name;
    LoginEnum(String name)
    {
        this.name = name;
    }
    public String getresourcesname
            ()
    {
        return name;
    }
}

