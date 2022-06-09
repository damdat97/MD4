package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/convert")
    public String convert(){
        return "/convert";
    }

    @PostMapping("/convert")
    public String convert(int inputCurrency, int inputRate, Model model) {
        int result = inputCurrency * inputRate;
        model.addAttribute("result", result);
        return "/convert";
    }
}
