package io.github.taissasantos;

import io.github.taissasantos.model.entity.Carros;
import io.github.taissasantos.model.entity.Usuario;
import io.github.taissasantos.model.repository.CarrosRepository;
import io.github.taissasantos.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CarrosApplication {



    public static void main(String[] args) {
        SpringApplication.run(CarrosApplication.class, args);

    }
}
