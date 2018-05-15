package org.launchcode.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {


    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request){
        String name = request.getParameter("name");

        if(name == null) {
            name = "world";
        }
        return "Hello Butt World stinking, " + name;
    }
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        //String html = "<form method='post' action='someurl'>" + This is a way to redirect the output
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";
        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
        String name = request.getParameter("name");
        return "Hello " + name;
    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "Hello stikin, " + name;
    }

    @RequestMapping(value = "goodbye")
    @ResponseBody
    public String goodbye() {
        return "get outta here";
        //return "redirect:/;  a way to redirect

    }
}