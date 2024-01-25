package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PetModel implements Serializable {
    private static final PetModel instance = new PetModel();

    private final Map<Integer, Pet> model;

    public PetModel(){
        model = new HashMap<Integer, Pet>();
    }

    public static PetModel getInstance(){
        return instance;
    }

    public void add(Pet pet, int id){
        model.put(id, pet);
    }

    public Pet getFromList(int id){
        return model.get(id);
    }
    public Map<Integer, Pet> getAll(){
        return model;
    }
    public Pet deletePet(Integer id) {
        return model.remove(id);
    }
    public void updatePet(Integer id, String name, String type, Integer age) {
        model.put(id, new Pet(name, type, age));
    }


}
