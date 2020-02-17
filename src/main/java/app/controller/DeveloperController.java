package app.controller;
import app.model.Developer;
import app.services.DbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeveloperController {

    @Autowired DbServiceImpl dbService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "developer", method = RequestMethod.GET)
    public ModelAndView viewDeveloper() {
        return new ModelAndView("developer", "command", new Developer());
    }

    @RequestMapping(value = "view",method = RequestMethod.GET)
    public String view(ModelMap modelMap) throws Exception {
        modelMap.addAttribute("string",dbService.getAllRecords());
        return "view";
    }


    @RequestMapping(value = "/addDeveloper", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("mvc-dispatcher") Developer developer, ModelMap model) throws Exception {
        System.out.println(developer.toString());
        dbService.addDevelopers(developer);
        model.addAttribute("name", developer.getName());
        return "result";
    }
}