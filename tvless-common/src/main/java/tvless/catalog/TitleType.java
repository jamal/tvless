package tvless.catalog;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TitleType {

    MOVIE("movie"),
    SERIES("series"),
    EPISODE("episode");

    private String typeName;

    TitleType(String typeName) {
        this.typeName = typeName;
    }

    @JsonValue
    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        return getTypeName();
    }

}
