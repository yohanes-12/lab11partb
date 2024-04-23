package com.example.asdlab11partb.service.impl;

import lombok.AllArgsConstructor;
import org.example.lab6.entity.Role;
import org.example.lab6.repo.RoleRepository;
import org.example.lab6.service.RoleService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {


    private RoleRepository roleRepository;
    @Override
    public Role newRole(Role role) {
        return roleRepository.save(role);
    }
}
