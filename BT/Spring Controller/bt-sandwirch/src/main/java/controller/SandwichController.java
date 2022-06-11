package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @RequestMapping("")
    public ModelAndView loadIndex() {
        ModelAndView index = new ModelAndView("index");
        return index;
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public ModelAndView loadResult(@RequestParam ("menu") String[] menu, Model model) {
        ModelAndView result = new ModelAndView("result");
        model.addAttribute("menu", menu);
        return result;
    }
}
