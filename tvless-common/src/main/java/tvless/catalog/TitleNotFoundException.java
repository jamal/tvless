package tvless.catalog;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import tvless.ResourceNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
@SuppressWarnings("serial")
public class TitleNotFoundException extends ResourceNotFoundException {

    public TitleNotFoundException(Long id) {
        super("Could not find title with id " + id);
    }

}
