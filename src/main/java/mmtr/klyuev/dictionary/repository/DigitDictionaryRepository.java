package mmtr.klyuev.dictionary.repository;

import mmtr.klyuev.dictionary.model.DigitEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DigitDictionaryRepository extends JpaRepository<DigitEntry, String> {
}
