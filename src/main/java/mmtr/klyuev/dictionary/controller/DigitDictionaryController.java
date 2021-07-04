package mmtr.klyuev.dictionary.controller;

import mmtr.klyuev.dictionary.service.serviceApi.IDigitDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/digitdictionary")
public class DigitDictionaryController {

    private IDigitDictionaryService digitDictionaryService;

    @Autowired
    public DigitDictionaryController(IDigitDictionaryService digitDictionaryService) {
        this.digitDictionaryService = digitDictionaryService;
    }
}
