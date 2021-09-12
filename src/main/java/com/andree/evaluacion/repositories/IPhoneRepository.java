package com.andree.evaluacion.repositories;

import com.andree.evaluacion.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhoneRepository extends JpaRepository<Phone,Integer> { }
