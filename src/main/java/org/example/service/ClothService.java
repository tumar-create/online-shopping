package org.example.service;


import org.example.dto.ClothDto;
import org.example.entity.ClothEntity;
import org.example.repository.ClothRepository;
import org.example.utils.ClothMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothService {


    private final ClothRepository clothRepository;
    private final ClothMapper clothMapper;

    public ClothService(ClothRepository clothRepository, ClothMapper clothMapper) {
        this.clothRepository = clothRepository;
        this.clothMapper = clothMapper;
    }


    public List<ClothDto> getAllClothes() {
        return clothRepository.findAllClothes().stream()
                .map(clothMapper::toDto)
                .toList();
    }

    public ClothDto getClothById(Integer id) {
        return clothMapper.toDto(clothRepository.findClothById(id));
    }

    public ClothDto saveCloth(ClothDto clothDto) {
        ClothEntity entity = clothMapper.toEntity(clothDto);
        clothRepository.saveCloth(entity);
        return clothMapper.toDto(entity);
    }

    public void deleteCloth(Integer id) {
        clothRepository.deleteCloth(id);
    }

}