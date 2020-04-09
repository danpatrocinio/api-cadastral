package com.cadastral;

import com.cadastral.entidy.Usuario;
import com.cadastral.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Base64;

@SpringBootApplication
public class ApiCadastral {

    public static void main(String[] args) {
        SpringApplication.run(ApiCadastral.class, args);
    }

    @Bean
    public CommandLineRunner createAdminUser(UsuarioRepository usuarioRepository) {
        return (args) -> {
            usuarioRepository.save(new Usuario(1L, "admin", Base64.getEncoder().encodeToString("admin".getBytes()), "Administrador"));
        };
    }
}
