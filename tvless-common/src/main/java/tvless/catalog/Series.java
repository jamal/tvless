package tvless.catalog;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.Date;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class Series extends Title {
    public Series() {
        this.setType(TitleType.SERIES);
    }
}
