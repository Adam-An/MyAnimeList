package zack.san.ceft.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController {


    @GetMapping("/error")
    public ModelAndView handleError(HttpServletResponse response){
        int code = response.getStatus();
        System.out.println("Error with code "+code+" Happened!");
        return new ModelAndView("error");
    }

}
