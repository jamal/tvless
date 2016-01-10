package tvless;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper() {
        setDateFormat(new ISO8601DateFormat());
    }

}
