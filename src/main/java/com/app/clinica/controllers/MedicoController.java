package com.app.clinica.controllers;
// import java.util.List;

// import java.util.Optional;
// import java.util.UUID;

//import org.slf4j.Logger;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.clinica.dto.MedicoRecordDTO;
import com.app.clinica.models.MedicoModel;
import com.app.clinica.repositories.MedicoRepository;

// import com.clinica.app.dto.MedicoRecordDTO;
// import com.clinica.app.models.MedicoModel;
// import com.clinica.app.repositories.MedicoRepository;

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
