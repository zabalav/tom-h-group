package com.fizzybubbly.fizzybubbly.controllers;

import com.fizzybubbly.fizzybubbly.models.Drink;
import com.fizzybubbly.fizzybubbly.models.Review;
import com.fizzybubbly.fizzybubbly.models.User;
import com.fizzybubbly.fizzybubbly.models.data.DrinkRepository;
import com.fizzybubbly.fizzybubbly.models.data.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private ReviewRepository reviewRepository;


    @GetMapping
    public String displayDrinkAndReview(Integer id, Model model) {
        Optional<Drink> drinkResult = drinkRepository.findById(25);
        Drink drink = drinkResult.get();
        Optional<Review> reviewResult = reviewRepository.findById(1);
        Review review = reviewResult.get();

        model.addAttribute("title", "have you tried these yet?");
        model.addAttribute("title", drink.toString());
        model.addAttribute("drink", drink);
        model.addAttribute("review", review);

        return "index";
    }

}
