package com.project.bootcamp.controllers;

import com.project.bootcamp.model.dto.StockDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(dto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@RequestBody StockDTO dto){
        return ResponseEntity.ok(dto);
    }

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){
        List<StockDTO> list = new ArrayList<>();
        StockDTO dto = new StockDTO();
        dto.setId(1L);
        dto.setName("Petrobras");
        dto.setPrice(30D);
        dto.setVariation(10D);
        dto.setDate(LocalDate.now());
        list.add(dto);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
        List<StockDTO> list = new ArrayList<>();
        StockDTO stock1 = new StockDTO();
        stock1.setId(1L);
        stock1.setName("Petrobras");
        stock1.setPrice(30D);
        stock1.setVariation(10D);
        stock1.setDate(LocalDate.now());

        StockDTO stock2 = new StockDTO();
        stock2.setId(2L);
        stock2.setName("Magalu");
        stock2.setPrice(90D);
        stock2.setVariation(20D);
        stock2.setDate(LocalDate.now());
        list.add(stock1);
        list.add(stock2);
        StockDTO dtoSelect = list.stream().filter(x -> x.getId().compareTo(id) == 0).findFirst().get();
        return ResponseEntity.ok(dtoSelect);
    }

}