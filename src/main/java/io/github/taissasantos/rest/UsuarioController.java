package io.github.taissasantos.rest;

import io.github.taissasantos.model.entity.Usuario;
import io.github.taissasantos.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar( @RequestBody @Valid Usuario usuario){
        return repository.save(usuario);
    }

    @GetMapping("{id}")
    public Usuario findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @GetMapping()
    public List<Usuario> list (){
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository.findById(id)
                .map( usuario -> {
                    repository.delete(usuario);
                    return Void.TYPE;
                })
                .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void update(@PathVariable @Valid Integer id, @RequestBody Usuario usuarioAtualizado){
        repository.findById(id)
                .map( usuario -> {
                    usuarioAtualizado.setId(usuario.getId());
                    return  repository.save(usuarioAtualizado);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }
}
