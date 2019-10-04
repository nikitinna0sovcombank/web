package app.controller;
import app.database.DbController;
import app.model.Developer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class DeveloperController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "developer", method = RequestMethod.GET)
    public ModelAndView developer() {
        return new ModelAndView("developer", "command", new Developer());
    }

    @RequestMapping(value = "view",method = RequestMethod.GET)
    public String view(ModelMap modelMap) throws SQLException, NamingException, ClassNotFoundException {
        List<String> list = DbController.getAllRecords();
        modelMap.addAttribute("string",list);
        return "view";
    }


    @RequestMapping(value = "/addDeveloper", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("mvc-dispatcher") Developer developer,
                             ModelMap model) throws SQLException, ClassNotFoundException {
        DbController.insetInDataBase(developer);
        model.addAttribute("name", developer.getName());
        return "result";
    }
}