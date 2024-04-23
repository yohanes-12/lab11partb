package com.example.asdlab11partb.repo;

import com.example.asdlab11partb.entity.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}
