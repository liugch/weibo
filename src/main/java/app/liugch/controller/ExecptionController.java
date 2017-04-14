package app.liugch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Administrator on 2017/2/10.
 */
@Controller
public class ExecptionController {

    @ExceptionHandler
    public String error(Exception ex, Model model) {
        model.addAttribute("error", ex);
        return "error";
    }

}

