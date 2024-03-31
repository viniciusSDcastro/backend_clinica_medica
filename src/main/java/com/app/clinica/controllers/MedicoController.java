package com.app.clinica.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.clinica.dto.MedicoRecordDTO;
import com.app.clinica.models.MedicoModel;
import com.app.clinica.repositories.MedicoRepository;

import jakarta.validation.Valid;

@RestController
public class MedicoController {
    @Autowired
    MedicoRepository medicoRepository;

    @PostMapping("/medico")
    public ResponseEntity<MedicoModel> saveMedico(@RequestBody @Valid MedicoRecordDTO medicoRecordDto) {
        var medicoModel = new MedicoModel();
        BeanUtils.copyProperties(medicoRecordDto, medicoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoRepository.save(medicoModel));
    }

}
