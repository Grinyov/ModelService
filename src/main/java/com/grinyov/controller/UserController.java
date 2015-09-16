package com.grinyov.controller;

import com.grinyov.domain.User;
import com.grinyov.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Grinyov Vitaliy on 15.09.15.
 *
 * Веб-слой приложения (классы-контроллеры, описывающие КАК и
 * КОГДА приложение взаимодействует с пользователем через веб.).
 */
@Controller
@Scope("singleton")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostConstruct
    public void post(){
        System.out.println("post construct");
    }
    @PreDestroy
    public void pre(){
        System.out.println("pre destroy");
    }

    @RequestMapping(value="/index.htm", method=RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("accounts", userService.getAll());
        return "index"; // показываем страницу index.jsp
    }

    @RequestMapping(value="/user/create.htm", method=RequestMethod.GET)
    public String createUser(@ModelAttribute("userAttribute") User account, Model model) {

        return "usercreate"; // показываем страницу usercreate.jsp
    }

    @RequestMapping(value="/user/update/{id}.htm", method=RequestMethod.GET)
    public String updateUser(@PathVariable Long id, @ModelAttribute("userAttribute") User account, Model model){
        for(User us : userService.getAll()){
            if(us.getId().longValue() == id.longValue()){
                account.setId(us.getId());
                account.setName(us.getName());
                model.addAttribute("userAttribute", account);
                break;
            }
        }

        return "userupdate";
    }

    @RequestMapping(value="/user/delete/{id}.htm", method=RequestMethod.GET)
    public String deleteUser(@PathVariable Long id, Model model){
        userService.deleteUser(id);
        return "redirect:/index.htm"; // делаем редирект на index.htm
    }

    @RequestMapping(value="/user/save.htm", method=RequestMethod.POST)
    public String saveUser(@ModelAttribute("userAttribute") User account, Model model) {
        if(account.getId() == null){
            this.userService.addUser(account);
        } else {
            this.userService.updateUser(account);
        }
        return "redirect:/index.htm";
    }


}
