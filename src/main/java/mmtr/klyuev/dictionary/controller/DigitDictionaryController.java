package mmtr.klyuev.dictionary.controller;

import mmtr.klyuev.dictionary.service.DigitDictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/digitdictionary")
public class DigitDictionaryController {

    private DigitDictionaryServiceImpl digitDictionaryService;

    @Autowired
    public DigitDictionaryController(DigitDictionaryServiceImpl digitDictionaryService) {
        this.digitDictionaryService = digitDictionaryService;
    }

}
