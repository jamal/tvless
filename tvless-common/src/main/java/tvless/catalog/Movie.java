package tvless.catalog;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class Movie extends Title {
   public Movie() {
      this.setType(TitleType.MOVIE);
   }
}
