package szymek.wspin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String showLandingPage(){
        return "Welcome to world of climbing.";
    }

}
