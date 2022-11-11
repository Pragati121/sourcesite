package Enum;
public enum LoginEnum {
    Book ("Book Store Application");

    private String name;
    LoginEnum(String name)
    {
        this.name = name;
    }
    public String getResourcesName()
    {
        return name;
    }
}

