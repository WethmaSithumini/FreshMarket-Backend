package com.agriMarket.backend.repository;

import com.agriMarket.backend.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
public abstract class CropRepository implements JpaRepository<Crop, Long> {

}
