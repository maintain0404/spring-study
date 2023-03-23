package com.taein.springboot.example.domain.item.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.taein.springboot.example.domain.item.repository.ItemRepository;

public class ItemServiceImplTest implements ItemServiceTest<ItemService, ItemRepository> {

    @Mock
    ItemRepository itemRepository;

    @InjectMocks
    ItemServiceImpl itemService;

    @Override
    public ItemService getService() {
        return this.itemService;
    }

    @Override
    public ItemRepository getRepository() {
        // TODO Auto-generated method stub
        return this.itemRepository;
    }
}
