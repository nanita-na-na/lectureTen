package com.cursor.lectureten.dto;

import lombok.Data;

@Data
public class ShopDto {

    private Long shopId;
    private String name;
    private String city;
    private String street;
    private boolean haveSite;
}
