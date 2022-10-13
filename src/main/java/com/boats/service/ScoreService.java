package com.boats.service;

import com.boats.model.ScoreModel;
import com.boats.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<ScoreModel> getAllScores(){
        return scoreRepository.getAllScores();
    }

    public Optional<ScoreModel> getScore(Integer id){
        return  scoreRepository.getScore(id);
    }

    public ScoreModel saveScore(ScoreModel scoreModel){
        if (scoreModel.getId() ==null){
            return scoreRepository.saveScore(scoreModel);
        }else{
            Optional<ScoreModel> optionalScoreModel=scoreRepository.getScore(scoreModel.getId());
            if (optionalScoreModel.isEmpty()){
                return scoreRepository.saveScore(scoreModel);
            }else {
                return  scoreModel;
            }
        }
    }

    public ScoreModel updateScore(ScoreModel scoreModel){
        if (scoreModel.getId()!=null){
            Optional<ScoreModel> optionalScoreModel=scoreRepository.getScore(scoreModel.getId());
            if (!optionalScoreModel.isEmpty()){
                if (scoreModel.getMessageText()!=null){
                    optionalScoreModel.get().setMessageText(scoreModel.getMessageText());
                }
                if (scoreModel.getStars()!=null){
                    optionalScoreModel.get().setStars(scoreModel.getStars());
                }
                scoreRepository.saveScore(optionalScoreModel.get());
                return  optionalScoreModel.get();
            }else {
                return scoreModel;
            }
        }else {
            return scoreModel;
        }
    }

    public boolean deleteScore(Integer id){
        Boolean aBoolean=getScore(id).map(scoreModel -> {
            scoreRepository.deleteScore(scoreModel);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
