package mmtr.klyuev.dictionary.repository;

import mmtr.klyuev.dictionary.model.LatinEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LatinDictionaryRepository extends JpaRepository<LatinEntry, String> {
}
