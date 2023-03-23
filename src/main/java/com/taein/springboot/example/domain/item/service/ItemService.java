package com.taein.springboot.example.domain.item.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.taein.springboot.example.domain.item.dto.ItemDTOs.ItemCreateDTO;
import com.taein.springboot.example.domain.item.dto.ItemDTOs.ItemDetailDTO;
import com.taein.springboot.example.domain.item.dto.ItemDTOs.ItemListDTO;

public interface ItemService {

    public Optional<ItemDetailDTO> retrieveItem(Long id);

    public Page<ItemListDTO> listItem(Pageable pReq);

    public ItemDetailDTO createItem(ItemCreateDTO dto);
}
