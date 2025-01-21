package com.example.Team2BE.Menu.domain.repository;

import com.example.Team2BE.Menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long>{


//    Optional<Menu> save(Menu menu);

}
