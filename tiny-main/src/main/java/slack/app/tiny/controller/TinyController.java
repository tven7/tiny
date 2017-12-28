package slack.app.tiny.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TinyController {

    @RequestMapping("/tiny")
    public String index(){
        return "Tiny controller";
    }
}
