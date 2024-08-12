package gii.example.backend.constant;

public enum UserGroupEnum {
    VIEWER("VIEWER"),
    EDITOR("EDITOR"),
    ADMIN("ADMIN"),
    ;

    private final String text;

    UserGroupEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
