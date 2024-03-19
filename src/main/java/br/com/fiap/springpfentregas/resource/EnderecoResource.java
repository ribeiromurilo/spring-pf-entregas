package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Endereco;
import br.com.fiap.springpfentregas.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public List<Endereco> getAll(){
        return enderecoRepository.findAll();
    }

    @Transactional
    @PostMapping
    public Endereco post(@RequestBody Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @GetMapping(value = "/{id}")
    public Endereco getById(@PathVariable Long id) {
        return enderecoRepository.findById(id).orElseThrow();
    }
}