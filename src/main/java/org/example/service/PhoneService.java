package org.example.service;


import org.example.dto.PhoneDto;
import org.example.entity.PhoneEntity;
import org.example.repository.PhoneRepository;
import org.example.utils.PhoneMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    public PhoneService(PhoneRepository phoneRepository, PhoneMapper phoneMapper) {
        this.phoneRepository = phoneRepository;
        this.phoneMapper = phoneMapper;
    }


    public List<PhoneDto> getAllPhones() {
        return phoneRepository.findAllPhones().stream()
                .map(phoneMapper::toDto)
                .toList();
    }

    public PhoneDto getPhoneById(Integer id) {
        return phoneMapper.toDto(phoneRepository.findPhoneById(id));
    }

    public PhoneDto savePhone(PhoneDto phoneDto) {
        PhoneEntity entity = phoneMapper.toEntity(phoneDto);
        phoneRepository.savePhone(entity);
        return phoneMapper.toDto(entity);
    }

    public void deletePhone(Integer id) {
        phoneRepository.deletePhone(id);
    }
}