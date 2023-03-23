package com.taein.springboot.example.domain.item.dto;

import com.taein.springboot.example.domain.item.entity.Item;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class ItemDTOs {

    @Builder
    @Getter
    @ToString
    public static class ItemDetailDTO {
        @NotNull
        private Long id;
        @NotBlank
        @NotNull
        private String name;
        @NotNull
        private Long price;

        public static ItemDetailDTO fromEntity(Item item) {
            return ItemDetailDTO.builder()
                    .id(item.getId())
                    .name(item.getName())
                    .price(item.getPrice())
                    .build();
        }
    }

    @Builder
    @Getter
    @ToString
    public static class ItemListDTO {
        @NotNull
        private Long id;
        @NotBlank
        @NotNull
        private String name;
        @NotNull
        private Long price;

        public static ItemListDTO fromEntity(Item item) {
            return ItemListDTO.builder()
                    .id(item.getId())
                    .name(item.getName())
                    .price(item.getPrice())
                    .build();
        }
    }

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ItemCreateDTO {
        @NotBlank
        @NotNull
        private String name;
        @NotNull
        private Long price;
    }
}
