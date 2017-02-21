package com.grzelak.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Kapelusznik on 21.02.2017.
 */
@Controller
public class GoodJobController {
    @RequestMapping("/goodjob")
    public String test() {
        return "goodjob";
    }
}
