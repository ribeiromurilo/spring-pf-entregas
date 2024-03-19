package br.com.fiap.springpfentregas.resource;

import br.com.fiap.springpfentregas.entity.Produto;
import br.com.fiap.springpfentregas.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRep;

    @GetMapping
    public List<Produto> getAll() {
        return produtoRep.findAll();
    }

    @Transactional
    @PostMapping
    public Produto post(@RequestBody Produto produto) {
        return produtoRep.save(produto);
    }

    @GetMapping(value = "/{id}")
    public Produto getByID(@PathVariable Long id) {
        return produtoRep.findById(id).orElseThrow();
    }
}