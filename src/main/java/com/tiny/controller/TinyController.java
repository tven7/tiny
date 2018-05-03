package com.tiny.controller;

import com.tiny.service.EncodingDecodingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

/**
 * Created by venktatineni on 5/2/18.
 */
@RestController
public class TinyController {

    private EncodingDecodingService encodingDecodingService;

    @Autowired
    public TinyController(EncodingDecodingService encodingDecodingService){
       this.encodingDecodingService = encodingDecodingService;
    }

    @RequestMapping(value="/route/{code}", method = RequestMethod.GET, produces = "application/json")
    public RedirectView route(@PathVariable (required = true)String code) {
        //Optional<String> url = DecodingService.fetchUrl(code);
        //if(!url.empty())
        return new RedirectView("http://yahoo.com");
        // Tell the browser to redirect to the url instead of return RedirectView above
        //else
        //return error
    }

    @RequestMapping(value="/code", method = RequestMethod.POST, produces = "application/json")
    public String create(@RequestParam (name="url", required = true)String url){
        System.out.println("URL Passed "+url);
        Optional<String> code = this.encodingDecodingService.encode(url);
        return "{\"result\":\""+code.get()+"\"}";
    }

}
