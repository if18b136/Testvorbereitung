package at.technikumwien.testvorbereitung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Autowired
    private CarRepository carRepository;

    @RequestMapping
    public String index(
            @RequestParam(defaultValue = "false") boolean all,
            Model model) {
        var cars = (all ? carRepository.findAll() : carRepository.findAllByNeedsServiceTrue());
        model.addAttribute("cars",cars);
        if(all) {
            model.addAttribute("all",true);
        }
        return "index";
    }
}
