package com.josevabo.infnetdevops.medico.resource;

import com.josevabo.infnetdevops.medico.dto.MedicoDto;
import com.josevabo.infnetdevops.medico.model.Medico;
import com.josevabo.infnetdevops.medico.service.MedicoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoResource extends AbstractResource{

    @Autowired
    MedicoService service;

    @GetMapping
    public ResponseEntity listAll() {
        return ResponseEntity.ok(
                mapList(service.listAll(), MedicoDto.class)
        );
    }

    @GetMapping("/{codigo}")
    public ResponseEntity findByCodigo(@PathVariable Long codigo) {
        return ResponseEntity.ok(
                map(service.findByCodigo(codigo), MedicoDto.class)
        );
    }

    @PostMapping
    public ResponseEntity create(@RequestBody MedicoDto novoMedicoDto) {
        var entidade = map(novoMedicoDto, Medico.class);
        return ResponseEntity.ok(
                map(service.create(entidade), MedicoDto.class)
        );
    }
    @PutMapping
    public ResponseEntity update(@RequestBody MedicoDto atualizaMedicoDto) {
        var entidade = map(atualizaMedicoDto, Medico.class);
        return ResponseEntity.ok(
                map(service.update(entidade), MedicoDto.class)
        );
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity delete(@PathVariable Long codigo) {
        return ResponseEntity.ok(
                map(service.delete(codigo), MedicoDto.class)
        );
    }
}
