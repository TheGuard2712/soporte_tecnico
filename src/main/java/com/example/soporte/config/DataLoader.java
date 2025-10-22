package com.example.soporte.config;

import com.example.soporte.model.Cliente;
import com.example.soporte.model.Tecnico;
import com.example.soporte.repository.ClienteRepository;
import com.example.soporte.repository.TecnicoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner load(ClienteRepository clientes, TecnicoRepository tecnicos) {
        return args -> {
            if (clientes.count()==0) {
                Cliente a = new Cliente(); a.setNombre("Empresa A"); a.setEmail("contacto@empresaA.com"); a.setTelefono("999111222"); clientes.save(a);
                Cliente b = new Cliente(); b.setNombre("Empresa B"); b.setEmail("soporte@empresaB.com"); b.setTelefono("988777666"); clientes.save(b);
            }
            if (tecnicos.count()==0) {
                Tecnico t1 = new Tecnico(); t1.setNombre("Ana Pérez"); t1.setEspecialidad("Redes"); tecnicos.save(t1);
                Tecnico t2 = new Tecnico(); t2.setNombre("Luis García"); t2.setEspecialidad("Sistemas"); tecnicos.save(t2);
            }
        };
    }
}
