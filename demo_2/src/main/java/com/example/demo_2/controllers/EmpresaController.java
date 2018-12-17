package com.example.demo_2.controllers;

import com.example.demo_2.dtos.EmpresaDto;
import com.example.demo_2.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @PostMapping
    public ResponseEntity<Response<EmpresaDto>> cadastrar(@RequestBody EmpresaDto empresaDto) {
        Response<EmpresaDto> response = new Response<>();

        empresaDto.setId(1L);
        response.setData(empresaDto);

        return ResponseEntity.ok(response);
    }
}