package com.boats.service;

import com.boats.model.BoatModel;
import com.boats.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatService {
    @Autowired
    private BoatRepository boatRepository;

    public List<BoatModel> getAllBoats() {
        return boatRepository.getAllBoats();
    }

    public Optional<BoatModel> getBoat(Integer id) {
        return boatRepository.getBoat(id);
    }

    public BoatModel saveBoat(BoatModel boatModel) {
        if (boatModel.getId() ==null) {
            return boatRepository.saveBoat(boatModel);
        }else{
            Optional<BoatModel> optionalBoatModel=boatRepository.getBoat(boatModel.getId());
            if (optionalBoatModel.isEmpty()){
                return boatRepository.saveBoat(boatModel);
            }else {
                return boatModel;
            }
        }

    }

    /*public void deleteBoat(Integer id) {
        boatRepository.deleteBoat(id);
    }*/

    public BoatModel updateBoat(BoatModel boatModel) {
        if (boatModel.getId()!=null){
            Optional<BoatModel> optionalBoatModel=boatRepository.getBoat(boatModel.getId());
            if (!optionalBoatModel.isEmpty()){
                if (boatModel.getBrand()!=null){
                    optionalBoatModel.get().setBrand(boatModel.getBrand());
                }
                if (boatModel.getYear()!=null){
                    optionalBoatModel.get().setYear(boatModel.getYear());
                }
                if (boatModel.getCategoryId()!=null){
                    optionalBoatModel.get().setCategoryId(boatModel.getCategoryId());
                }
                if (boatModel.getName()!=null){
                    optionalBoatModel.get().setName(boatModel.getName());
                }
                if (boatModel.getDescription()!=null){
                    optionalBoatModel.get().setDescription(boatModel.getDescription());
                }
                boatRepository.saveBoat(optionalBoatModel.get());
                return optionalBoatModel.get();
            }else{
                return boatModel;
            }
        }else {
            return boatModel;
        }
    }

    public boolean deleteBoat(Integer id){
        Boolean aBoolean=getBoat(id).map(boatModel -> {
            boatRepository.deleteBoat(id);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
