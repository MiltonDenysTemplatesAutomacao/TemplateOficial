package md.automation.core.enums;

public enum Header {

    ACCEPT("Accept"),
    CONTENT_TYPE("Content-Type"),
    AUTHORIZATION("Authorization");

    private final String value;

    Header(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
