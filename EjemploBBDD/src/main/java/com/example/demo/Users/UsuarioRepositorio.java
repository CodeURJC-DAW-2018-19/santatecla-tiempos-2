package com.example.demo.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio  extends JpaRepository<Usuario,Long> {
    Usuario findByName(String username);
}
