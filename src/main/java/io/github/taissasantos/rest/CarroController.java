package io.github.taissasantos.rest;

import io.github.taissasantos.model.entity.Carros;
import io.github.taissasantos.model.repository.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin("*")
public class CarroController {

    private final CarrosRepository repository;

    @Autowired
    public CarroController(CarrosRepository repository) {
        this.repository = repository;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carros salvar(@RequestBody @Valid Carros carros){
        return repository.save(carros);
    }

    @GetMapping("{id}")
    public Carros findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @GetMapping()
    public List<Carros> list (){
        return repository.findAll();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository.findById(id)
                .map( carros -> {
                    repository.delete(carros);
                    return Void.TYPE;
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void update(@PathVariable @Valid Integer id, @RequestBody Carros carrosAtualizado){
        repository.findById(id)
                .map( carros -> {
                    carrosAtualizado.setId(carros.getId());
                    return  repository.save(carrosAtualizado);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
                );
    }
}
