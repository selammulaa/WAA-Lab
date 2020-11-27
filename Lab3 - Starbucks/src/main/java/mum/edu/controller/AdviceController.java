package mum.edu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import mum.edu.service.AdviceService;

@Controller
public class AdviceController {

    AdviceService adviceService;

    public AdviceController(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    @GetMapping("/advice")
    public String adviceForm(Model model) {

        Map<Integer, String> roasts = adviceService.getAllRoasts();
        model.addAttribute("roasts", roasts);

        return "advice";
    }

    @PostMapping("/advice")
    public String adviceList(Integer roastKey, Model model) throws Exception {

        String roast = adviceService.getRoast(roastKey);
        List<String> roastList = adviceService.getListByType(roast);

        model.addAttribute("roast", roast);
        model.addAttribute("roastList", roastList);

        return "display";

    }


}
