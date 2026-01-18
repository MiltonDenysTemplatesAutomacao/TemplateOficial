package md.automation.core.enums;

public enum MediaType {
    JSON("application/json"),
    XML("application/xml");

    private final String value;

    MediaType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
