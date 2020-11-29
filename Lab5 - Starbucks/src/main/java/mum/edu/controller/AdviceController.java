package mum.edu.controller;

import java.util.List;
import java.util.Map;

import mum.edu.service.AdviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AdviceController {

    AdviceService adviceService;

    @Autowired
    public AdviceController(AdviceService adviceService) {
	  	this.adviceService = adviceService;
    }

    @GetMapping(value = {"/", "/advice"})
    public String adviceForm(Model model) {

        Map<Integer, String> roasts = adviceService.getAllRoasts();
        model.addAttribute("roasts", roasts);

        return "advice";
    }

    @PostMapping(value = "/advice")
    public String adviceList(Integer roastKey, Model model) throws Exception {

        String roast = adviceService.getRoast(roastKey);
        List<String> roastList = adviceService.getListByType(roast);

        model.addAttribute("roast", roast);
        model.addAttribute("roastList", roastList);

        return "display";

    }


}
