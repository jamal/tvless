package tvless.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {

    private final TitleRepository titleRepository;

    @Autowired
    public CatalogService(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    // Query methods

    public Title getTitle(Long titleId) {
       Title title = titleRepository.findOne(titleId);
        if (title == null) {
            throw new TitleNotFoundException(titleId);
        }
        return title;
    }

}
