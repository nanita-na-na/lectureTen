package com.cursor.lectureten.mapper;

import com.cursor.lectureten.dto.ShopDto;
import com.cursor.lectureten.model.Shop;
import org.springframework.stereotype.Service;

@Service
public class ShopMapper {

    public ShopDto mapToShopDto(Shop shop) {
        ShopDto dto = new ShopDto();
        dto.setShopId(shop.getId());
        dto.setName(shop.getName());
        dto.setCity(shop.getCity());
        dto.setStreet(shop.getStreet());
        dto.setHaveSite(shop.isHaveSite());
        return dto;
    }

    public Shop mapToShop(ShopDto dto) {
        Shop shop = new Shop();
        shop.setId(dto.getShopId());
        shop.setName(dto.getName());
        shop.setCity(dto.getCity());
        shop.setStreet(dto.getStreet());
        shop.setHaveSite(dto.isHaveSite());

        return shop;
    }
}