package com.example.Team2BE.Menu.presentation;


import com.example.Team2BE.Menu.domain.Menu;
import com.example.Team2BE.Menu.dto.request.MenuRequest;
import com.example.Team2BE.Menu.dto.response.MenuResponse;
import com.example.Team2BE.Menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private MenuService menuService;

    // 메뉴 가격 변경
    @PostMapping("/cost/change")
    public ResponseEntity<Void> updateMenuCostRequest(@RequestBody MenuRequest request)
    {
        menuService.updateMenuCost(request.getMenu(), request.getCost());
        return ResponseEntity.ok().build();
    }

    // 메뉴 추가
    @PostMapping("/create")
    public ResponseEntity<Void> createMenuRequest(@RequestBody MenuRequest request)
    {
        menuService.createMenu(request.getMenu(), request.getCost());
        return ResponseEntity.ok().build();
    }

    // 모든 메뉴 조회
    @GetMapping("/list")
    public ResponseEntity<MenuResponse> getAllMenuRequest()
    {
        MenuResponse menuList = new MenuResponse(menuService.getAllMenu());
        return ResponseEntity.ok().body(menuList);
    }
}
