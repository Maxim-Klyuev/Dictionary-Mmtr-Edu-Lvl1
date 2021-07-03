package mmtr.klyuev.dictionary.model;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntry {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "word", nullable = false, unique = true)
    private String word;

    @Column(name = "translation", nullable = false)
    private String translation;

    public BaseEntry() {
    }

    public BaseEntry(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public String toString() {
        return "BaseEntry{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", translation='" + translation + '\'' +
                '}';
    }
}
