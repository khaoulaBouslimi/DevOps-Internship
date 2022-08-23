package tn.esprit.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entity.Rating;

@RestController
@RequestMapping({ "/", "/index" })
public class RatingRestController {

	@GetMapping
    public String main(Model model) {
        model.addAttribute("rating", new Rating());
        return "index";
    }

    @PostMapping
    public String save(Rating rating, Model model) {
        model.addAttribute("rating", rating);
        return "saved";
    }
}
