package com.cursor.lectureten.rest;

import com.cursor.lectureten.dto.ShopDto;
import com.cursor.lectureten.service.ShopService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/shops/")
public class ShopController {

    private final ShopService shopService;
    private final ObjectMapper objectMapper;

    public ShopController(ShopService shopService, ObjectMapper objectMapper) {
        this.shopService = shopService;
        this.objectMapper = objectMapper;
    }

    @PostMapping(value = "/create")
    public void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String shopDto = request.getReader().lines().collect(Collectors.joining());
        ShopDto shop = objectMapper.readValue(shopDto, ShopDto.class);
        ShopDto createShop = shopService.create(shop);
        String createShopStr = objectMapper.writeValueAsString(createShop);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(createShopStr);
        writer.flush();
        writer.close();
    }

    @GetMapping(value = "/all")
    public void findAll(HttpServletResponse response) throws IOException {
        List<ShopDto> shopDtos = shopService.findAll();
        String shopsWithoutEmp = objectMapper.writeValueAsString(shopDtos);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(shopsWithoutEmp);
        writer.flush();
        writer.close();
    }
}
