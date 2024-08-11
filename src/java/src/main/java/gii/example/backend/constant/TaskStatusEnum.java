package gii.example.backend.constant;

public enum TaskStatusEnum {
    NOT_STARTED("NOT_STARTED"),
    IN_PROGRESS("IN_PROGRESS"),
    PAUSED("PAUSED"),
    BLOCKED("BLOCKED"),
    DONE("DONE"),
    ;

    private final String text;

    TaskStatusEnum(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
