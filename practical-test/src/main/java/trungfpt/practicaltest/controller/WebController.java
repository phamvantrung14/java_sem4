package trungfpt.practicaltest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class WebController {
    @RequestMapping(path = "")
    public String home()
    {
        return "home";
    }
}
