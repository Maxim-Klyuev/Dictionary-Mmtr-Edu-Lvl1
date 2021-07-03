package mmtr.klyuev.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping(name = "/latindictionary")
public class LatinDictionaryController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dictionaries");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editDictionary() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editDictionary");
        return modelAndView;
    }
}
