package com.tintuc.dunews.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
    @RequestMapping(value = {"/home","/"})
    public String index(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("username", name);
        return "index";
    }
    @RequestMapping(value = {"/news"})
    public String news(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("username", name);
        return "news";
    }
    @RequestMapping(value = {"/login"})
    public String login(){
        return "login";
    }
    @RequestMapping(value = {"/contact"})
    public String contact(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("username", name);
        return "contact";
    }
    @RequestMapping(value= {"/{categoryKey}"})
    public String category(@PathVariable("categoryKey") String categoryKey, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("username", name);
        model.addAttribute("categoryKey", categoryKey);
        return "category";
    }
    @RequestMapping(value = {"/news/{articleKey}"})
    public String news(@PathVariable("articleKey") String articleKey,Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("username", name);
        model.addAttribute("articleKey",articleKey);
        return "articleKey";
    }
    @RequestMapping(value = {"/search/{articleKey}"})
    public String search(@PathVariable("articleKey") String articleKey,Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("username", name);
        model.addAttribute("articleKey",articleKey);
        return "search";
    }
    @RequestMapping(value = {"/admin/home"})
    public String adminhome(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("username", name);
        return "adminhome";
    }
    @RequestMapping(value = {"/admin/category"})
    public String admincategory(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("username", name);
        return "admincategory";
    }
    @RequestMapping(value = {"/admin/user"})
    public String adminuser(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("username", name);
        return "adminuser";
    }
    @RequestMapping(value = {"/admin/article"})
    public String adminarticle(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("username", name);
        return "adminarticle";
    }
    @RequestMapping(value = {"/admin/error"})
    public String adminerror(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("username", name);
        return "adminerror";
    }
    @RequestMapping(value = {"/admin/comment"})
    public String admincomment(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        model.addAttribute("username", name);
        return "admincomment";
    }
}
