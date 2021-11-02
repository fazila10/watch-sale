package com.accenture.imaginea.dao;

import com.accenture.imaginea.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Integer> {
}
