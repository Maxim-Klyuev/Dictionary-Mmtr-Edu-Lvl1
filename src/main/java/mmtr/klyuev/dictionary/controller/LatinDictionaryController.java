package mmtr.klyuev.dictionary.controller;

import mmtr.klyuev.dictionary.model.LatinEntry;
import mmtr.klyuev.dictionary.service.LatinDictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/latindictionary", produces = "application/json")
public class LatinDictionaryController {

    private LatinDictionaryServiceImpl latinDictionaryService;

    @Autowired
    public LatinDictionaryController(LatinDictionaryServiceImpl latinDictionaryService) {
        this.latinDictionaryService = latinDictionaryService;
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<LatinEntry> latinEntries = latinDictionaryService.findAll();
        if (latinEntries == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(latinEntries);
    }

    @GetMapping("{word}")
    public ResponseEntity findByWord(@PathVariable(value = "word") String word) {
        LatinEntry entry = latinDictionaryService.findByWord(word);
        if(entry == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entry);
    }

    @DeleteMapping("{word}")
    public ResponseEntity deleteByWord(@PathVariable String word) {
        LatinEntry entry = latinDictionaryService.findByWord(word);
        if(entry == null) {
            return ResponseEntity.notFound().build();
        }
        latinDictionaryService.deleteByWord(word);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity add(@RequestBody LatinEntry latinEntry) {
        if(latinEntry == null) {
            return ResponseEntity.badRequest().build();
        }
        latinDictionaryService.add(latinEntry);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
