package se.ecutb.sima.springmvcexercisesandthymeleaf.controllers;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {

    public List<String> savestring = new ArrayList<>();

    @GetMapping("/index")
    public String index(){
     return "index";
    }

    @GetMapping("/contact")
   public String contact(){
        return "contact";
   }

    @PostMapping("/contact")
   public String contact(@RequestParam(value = "name") String string){
        if (!string.isEmpty()){
       savestring.add(string);}
        return "redirect:/contact";
   }
   @GetMapping("/contactlist")
   public String contactlist(Model model){
       model.addAttribute("string",savestring);
       return "contact";
   }

   @GetMapping("/img")
    public String about(){return "img";
    }

    @GetMapping("/about")
    public String about(Model model) {
        String path = "/IMG/index.jpg";
        model.addAttribute("img", path);
        return "about";
    }


/*
@Controller
public class Home {

    List<String> savestring = new ArrayList<>();

    @GetMapping("/index")
    public String index() {

        return "index";
    }

    @GetMapping("/contact")
    public String contact() {

        return "contact";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam(value = "savestring") String string) {
        if (!string.isEmpty()) {
            savestring.add(string);
        }
        return "redirect:/contact";
    }

    @GetMapping("/contactlist")
    public String contactList(Model model) {
        model.addAttribute("name", savestring);
        return "contact-view";

    }*/

}
