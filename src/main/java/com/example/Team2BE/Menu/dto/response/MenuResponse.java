package com.example.Team2BE.Menu.dto.response;

import com.example.Team2BE.Menu.domain.Menu;

import java.util.List;

public class MenuResponse {
    List<Menu> menuList;

    public MenuResponse(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
