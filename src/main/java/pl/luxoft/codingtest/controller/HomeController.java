package pl.luxoft.codingtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by iussov on 08.10.2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String get() {
        return "test";
    }

}
