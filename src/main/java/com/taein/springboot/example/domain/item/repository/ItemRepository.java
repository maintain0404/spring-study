package com.taein.springboot.example.domain.item.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

import com.taein.springboot.example.domain.item.entity.Item;

@Primary
public interface ItemRepository extends JpaRepository<Item, Long>  {
    
}
