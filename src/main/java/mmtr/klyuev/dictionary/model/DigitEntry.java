package mmtr.klyuev.dictionary.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "digit_dictionary", schema = "spring_mvc_dictionary")
public class DigitEntry extends BaseEntry implements Serializable {
}
