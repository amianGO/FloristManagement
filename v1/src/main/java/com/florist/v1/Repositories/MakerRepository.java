package com.florist.v1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.florist.v1.Entities.Maker;

@Repository
public interface MakerRepository extends JpaRepository<Maker, Long>{
    
}
