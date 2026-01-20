package org.example.controller;


import org.example.dto.ClothDto;
import org.example.dto.PhoneDto;
import org.example.service.ClothService;
import org.example.service.PhoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final PhoneService phoneService;
    private final ClothService clothService;

    public ItemController(PhoneService phoneService, ClothService clothService) {
        this.phoneService = phoneService;
        this.clothService = clothService;
    }


    @GetMapping("/phone/{id}")
    public PhoneDto getPhoneById(@PathVariable("id") Integer id) {
        return phoneService.getPhoneById(id);
    }

    @GetMapping("/cloth/{id}")
    public ClothDto getClothById(@PathVariable("id") Integer id) {
        return clothService.getClothById(id);
    }

    @GetMapping("/phone")
    public List<PhoneDto> getAllPhones(){
        return phoneService.getAllPhones();
    }

    @GetMapping("/cloth")
    public List<ClothDto> getAllClothes() {
        return clothService.getAllClothes();
    }

    @PostMapping("/phone")
    public PhoneDto savePhone(@RequestBody PhoneDto phoneDto) {
        return phoneService.savePhone(phoneDto);
    }


    @PostMapping("/cloth")
    public ClothDto saveCloth(@RequestBody ClothDto clothDto) {
        return clothService.saveCloth(clothDto);
    }

    @DeleteMapping("/phone/{id}")
    public void deletePhone(@PathVariable("id") Integer id) {
        phoneService.deletePhone(id);
    }

    @DeleteMapping("/cloth/{id}")
    public void deleteCloth(@PathVariable("id") Integer id) {
        clothService.deleteCloth(id);
    }




}