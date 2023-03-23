package com.taein.springboot.example.domain.item.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.taein.springboot.example.domain.item.dto.ItemDTOs.ItemCreateDTO;
import com.taein.springboot.example.domain.item.dto.ItemDTOs.ItemDetailDTO;
import com.taein.springboot.example.domain.item.entity.Item;
import com.taein.springboot.example.domain.item.repository.ItemRepository;

@SpringBootTest
public interface ItemServiceTest<T extends ItemService, S extends ItemRepository> {

    S getRepository();

    T getService();

    @Test
    default void retrieveItemSuccess() {
        S repo = getRepository();
        T service = getService();
        Mockito.doReturn(Optional.of(new Item("name", 0L))).when(repo).findById(1L);
        Optional<ItemDetailDTO> res = service.retrieveItem(1L);

        Assertions.assertThat(res.isPresent()).isEqualTo(true);
    }

    @Test
    default void retrieveItemFail() {
        S repo = getRepository();
        T service = getService();
        Mockito.doReturn(Optional.of(new Item("name", 0L))).when(repo).findById(1L);
        Optional<ItemDetailDTO> res = service.retrieveItem(0L);

        Assertions.assertThat(res.isPresent()).isEqualTo(false);
    }

    @Test
    default void createItem() {
        S repo = getRepository();
        T service = getService();
        Item ret = new Item("name", 0L);
        Mockito.doReturn(Optional.of(ret)).when(repo).save(ret);

        ItemDetailDTO dto = service.createItem(ItemCreateDTO.builder().name("name").price(0L).build());

        Assertions.assertThat(dto.getName()).isEqualTo("name");
        Assertions.assertThat(dto.getPrice()).isEqualTo(0L);
    }
}
