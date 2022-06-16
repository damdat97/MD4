package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.IUserService;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/create_user", method = RequestMethod.GET)
    public ModelAndView loadCreateForm(){
        ModelAndView createForm = null;
        User user;
        try {
            user = new User();
            createForm = new ModelAndView("create");
            createForm.addObject("user", user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return createForm;
    }

    @RequestMapping(value = "/create_user", method = RequestMethod.POST)
    public ModelAndView createUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        ModelAndView created = null;
        try {
            user.validate(user, bindingResult);
            if (bindingResult.hasFieldErrors()) {
                created = new ModelAndView("create");
            } else {
                userService.save(user);
                created = new ModelAndView("result");
                created.addObject("user", user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return created;
    }
}
