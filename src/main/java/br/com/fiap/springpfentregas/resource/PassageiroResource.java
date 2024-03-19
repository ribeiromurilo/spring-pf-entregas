package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Passageiro;
import br.com.fiap.springpfentregas.repository.PassageiroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/passageiro")
public class PassageiroResource {

    @Autowired
    private PassageiroRepository passageiroRep;

    @GetMapping
    public List<Passageiro> getAll() {
        return passageiroRep.findAll();
    }

    @Transactional
    @PostMapping
    public Passageiro post(@RequestBody Passageiro passageiro) {
        return passageiroRep.save(passageiro);
    }
}