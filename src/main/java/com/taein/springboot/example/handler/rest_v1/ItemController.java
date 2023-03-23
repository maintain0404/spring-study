package com.taein.springboot.example.handler.rest_v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.taein.springboot.example.domain.item.dto.ItemDTOs;
import com.taein.springboot.example.domain.item.dto.ItemDTOs.ItemCreateDTO;
import com.taein.springboot.example.domain.item.service.ItemService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/item")
@Slf4j
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/{id}")
    public ItemDTOs.ItemDetailDTO retrieveItem(@PathVariable("id") Long id) {
        log.debug("retrieveITem method executed");
        return itemService.retrieveItem(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
    };

    @GetMapping("")
    public Page<ItemDTOs.ItemListDTO> listItems(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        log.debug("listItem method executed");
        PageRequest pReq = PageRequest.of(page, size);
        return itemService.listItem(pReq);
    }

    @PostMapping("")
    public ItemDTOs.ItemDetailDTO createItem(@RequestBody ItemCreateDTO dto) {
        return this.itemService.createItem(dto);
    }
}
