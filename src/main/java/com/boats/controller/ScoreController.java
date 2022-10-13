package com.boats.controller;

import com.boats.model.ScoreModel;
import com.boats.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<ScoreModel> getAllScores(){
        return scoreService.getAllScores();
    }

    @GetMapping("/{id}")
    public Optional<ScoreModel> getScore(@PathVariable Integer id){
        return scoreService.getScore(id);
    }

    @PostMapping("/save")
    public ScoreModel saveScore(@RequestBody ScoreModel scoreModel){
        return scoreService.saveScore(scoreModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteScore(@PathVariable Integer id){
        scoreService.deleteScore(id);
    }

    @PutMapping
    public  ScoreModel updateScore(@RequestBody ScoreModel scoreModel){
        return scoreService.updateScore(scoreModel);
    }
}
