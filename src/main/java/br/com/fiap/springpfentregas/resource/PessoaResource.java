package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Pessoa;
import br.com.fiap.springpfentregas.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {
    @Autowired
    private PessoaRepository pessoaRep;

    @GetMapping
    public List<Pessoa> getAll() {
        return pessoaRep.findAll();
    }

    @Transactional
    @PostMapping
    public Pessoa post(@RequestBody Pessoa pessoa) {
        return pessoaRep.save(pessoa);
    }

    @GetMapping(value = "/{id}")
    public Pessoa getById(@PathVariable Long id) {
        return pessoaRep.findById(id).orElseThrow();
    }
}