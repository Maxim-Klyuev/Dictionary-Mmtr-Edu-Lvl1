package mmtr.klyuev.dictionary.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "latin_dictionary")
public class LatinEntry extends BaseEntry implements Serializable {
}
