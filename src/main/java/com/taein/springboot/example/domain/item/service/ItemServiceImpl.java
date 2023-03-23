package com.taein.springboot.example.domain.item.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.taein.springboot.example.domain.item.dto.ItemDTOs.ItemCreateDTO;
import com.taein.springboot.example.domain.item.dto.ItemDTOs.ItemDetailDTO;
import com.taein.springboot.example.domain.item.dto.ItemDTOs.ItemListDTO;
import com.taein.springboot.example.domain.item.entity.Item;
import com.taein.springboot.example.domain.item.repository.ItemRepository;

@Component
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Optional<ItemDetailDTO> retrieveItem(Long id) {
        return this.itemRepository.findById(id).map(
                item -> Optional.of(ItemDetailDTO.fromEntity(item))).orElse(Optional.empty());
    }

    @Override
    public Page<ItemListDTO> listItem(Pageable pageable) {
        return this.itemRepository.findAll(pageable).map(
                item -> ItemListDTO.fromEntity(item));
    }

    @Override
    public ItemDetailDTO createItem(ItemCreateDTO dto) {
        Item item = new Item(dto.getName(), dto.getPrice());
        itemRepository.save(item);
        return ItemDetailDTO.fromEntity(item);
    }
}
