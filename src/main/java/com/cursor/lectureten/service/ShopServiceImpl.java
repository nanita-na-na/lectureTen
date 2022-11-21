package com.cursor.lectureten.service;

import com.cursor.lectureten.dto.ShopDto;
import com.cursor.lectureten.mapper.ShopMapper;
import com.cursor.lectureten.model.Shop;
import com.cursor.lectureten.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final ShopMapper shopMapper;

    public ShopServiceImpl(ShopRepository shopRepository, ShopMapper shopMapper) {
        this.shopRepository = shopRepository;
        this.shopMapper = shopMapper;
    }

    @Override
    public ShopDto create(ShopDto shopDto) {
        Shop shop = shopMapper.mapToShop(shopDto);
        Shop saveShop = shopRepository.save(shop);

        return shopMapper.mapToShopDto(saveShop);
    }

    @Override
    public List<ShopDto> findAll() {
        Iterable<Shop> iterable = shopRepository.findAll();
        List<Shop> shops = new ArrayList<>();
        iterable.forEach(shops::add);
        return shops.stream().map(shopMapper::mapToShopDto)
                .collect(Collectors.toList());
    }
}