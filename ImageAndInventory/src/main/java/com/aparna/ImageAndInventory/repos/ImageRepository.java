package com.aparna.ImageAndInventory.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aparna.ImageAndInventory.entities.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

}
