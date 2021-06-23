package mmtr.klyuev.dictionary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@MappedSuperclass
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class BaseEntry {

    @Id
    @Column(name = "word", unique = true, nullable = false)
    private String word;

    @Column(name = "translations", nullable = false)
    private String translations;

    public BaseEntry() {
    }

    public BaseEntry(String word, String translations) {
        this.word = word;
        this.translations = translations;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String idWord) {
        this.word = idWord;
    }

    public String getTranslations() {
        return translations;
    }

    public void setTranslations(String translations) {
        this.translations = translations;
    }
}
