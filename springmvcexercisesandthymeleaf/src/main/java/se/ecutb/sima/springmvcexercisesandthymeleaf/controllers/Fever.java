package se.ecutb.sima.springmvcexercisesandthymeleaf.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class Fever {
    double saveTemperature;

    public String fever(){return "fever";}

    @PostMapping("fever")
    public String tempResult(
            @RequestParam (name ="temp")Double temp, Model model){
        saveTemperature =temp;
        model.addAttribute("temp",saveTemperature);
        if(saveTemperature > 37){
            return "haveFever";
        }else if(saveTemperature < 37){
            return "haveHypo";
        }else{
            return "normal";
        }

    }
}
