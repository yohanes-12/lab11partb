package com.example.asdlab11partb.service.impl;

import lombok.AllArgsConstructor;
import org.example.lab6.entity.Surgery;
import org.example.lab6.repo.SurgeryRepository;
import org.example.lab6.service.SurgeryService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SurgeryServiceImpl implements SurgeryService {

    private SurgeryRepository surgeryRepository;
    @Override
    public Surgery newSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }
}
