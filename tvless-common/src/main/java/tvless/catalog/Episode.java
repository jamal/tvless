package tvless.catalog;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class Episode extends Title {
    public Episode() {
        this.setType(TitleType.EPISODE);
    }
}
