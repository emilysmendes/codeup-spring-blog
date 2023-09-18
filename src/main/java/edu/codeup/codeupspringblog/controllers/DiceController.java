
        package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String showRollDicePage() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/result")
    public String rollDice(@RequestParam(name = "guess") int guess, Model model) {
        int numRolls = 5; // Number of dice rolls
        int matchCount = 0; // Count of rolls that match the user's guess
        List<Integer> rolls = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < numRolls; i++) {
            int roll = random.nextInt(6) + 1; // Simulate rolling a six-sided dice
            rolls.add(roll);

            if (roll == guess) {
                matchCount++;
            }
        }

        model.addAttribute("rolls", rolls);
        model.addAttribute("guess", guess);
        model.addAttribute("matchCount", matchCount);

        return "roll-dice-result";
    }
}