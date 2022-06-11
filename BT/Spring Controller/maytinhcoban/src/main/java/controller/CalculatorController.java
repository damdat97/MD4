package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @RequestMapping("")
    public ModelAndView loadIndex() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public ModelAndView loadResult(@RequestParam ("first") double first, @RequestParam("second") double second, @RequestParam("operator") String operator, Model model) {
        ModelAndView loadResult = null;
        double result;

        try {
            result = 0;
            loadResult = new ModelAndView("index");
            switch (operator) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "*":
                    result = first * second;
                    break;
                case "/":
                    result = first / second;
                    break;
            }
            model.addAttribute("result", result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return loadResult;
    }
}
