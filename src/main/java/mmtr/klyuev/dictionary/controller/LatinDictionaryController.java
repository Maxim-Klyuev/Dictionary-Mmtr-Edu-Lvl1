package mmtr.klyuev.dictionary.controller;

import mmtr.klyuev.dictionary.model.LatinEntry;
import mmtr.klyuev.dictionary.service.serviceApi.ILatinDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(name = "/latindictionary")
public class LatinDictionaryController {

    private ILatinDictionaryService latinDictionaryService;

    @Autowired
    public LatinDictionaryController(ILatinDictionaryService latinDictionaryService) {
        this.latinDictionaryService = latinDictionaryService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAllEntries() {
        List<LatinEntry> latinEntries = latinDictionaryService.getAllLatinEntries();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("latin-entries");
        modelAndView.addObject("latinEntries", latinEntries);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable Long id) {
        LatinEntry latinEntry = latinDictionaryService.getLatinEntryById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit-latin-entry");
        modelAndView.addObject("latinEntry", latinEntry);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editLatinEntry(@ModelAttribute("latinEntry") LatinEntry latinEntry) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/latindictionary");
        latinDictionaryService.updateLatinEntry(latinEntry);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit-latin-entry");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addEntry(@ModelAttribute("latinEntry") LatinEntry latinEntry) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/latindictionary");
        latinDictionaryService.addLatinEntry(latinEntry);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteEntry(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/latindictionary");
        latinDictionaryService.deleteLatinEntryById(id);
        return modelAndView;
    }
}

