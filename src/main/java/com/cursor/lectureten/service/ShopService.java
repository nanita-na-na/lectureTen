package com.cursor.lectureten.service;


import com.cursor.lectureten.dto.ShopDto;
import com.cursor.lectureten.model.Shop;

import java.util.List;

public interface ShopService {

    ShopDto create (ShopDto shopDto);

    List<ShopDto> findAll();
}
