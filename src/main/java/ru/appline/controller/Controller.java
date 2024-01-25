package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);


    @PostMapping(value = "/createPet", consumes = "application/json", produces = "application/json")
    public String createPet(@RequestBody Pet pet){
        petModel.add(pet, newId.getAndIncrement());
        return "Вы_успешно_создали_питомца_!";
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll(){
        return petModel.getAll();
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id){
        return petModel.getFromList(id.get("id"));
    }

    @DeleteMapping(value = "/deletePet", consumes = "application/json", produces = "application/json")
    public Pet deletePet(@RequestBody Map<String, Integer> id){
       return petModel.deletePet(id.get("id"));
    }

    @PutMapping(value = "/updatePet", consumes = "application/json", produces = "application/json")
    public void updatePet (@RequestBody Map<String, String> pet) {

        Integer id = Integer.valueOf(pet.get("id"));
        String name = pet.get("name");
        String type = pet.get("type");
        Integer age = Integer.valueOf(pet.get("age"));


        petModel.updatePet(id,name, type, age);

    }


}
