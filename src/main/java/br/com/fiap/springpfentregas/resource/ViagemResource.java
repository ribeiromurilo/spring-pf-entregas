package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Viagem;
import br.com.fiap.springpfentregas.repository.ViagemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/viagem")
public class ViagemResource {

    @Autowired
    private ViagemRepository viagemRep;

    @GetMapping
    public List<Viagem> getAll() {
        return viagemRep.findAll();
    }

    @Transactional
    @PostMapping
    public Viagem post(@RequestBody Viagem viagem) {
        return viagemRep.save(viagem);
    }

    @GetMapping(value = "/{id}")
    public Viagem getById(@PathVariable Long id) {
        return viagemRep.findById(id).orElseThrow();
    }
}
