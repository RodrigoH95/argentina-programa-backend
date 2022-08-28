package com.portfoliofullstack.miportfolio.security.Service;

import com.portfoliofullstack.miportfolio.security.Models.Usuario;
import com.portfoliofullstack.miportfolio.security.Repository.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepo;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return usuarioRepo.findByNombreUsuario(nombreUsuario);
    }

    public boolean existByNombreUsuario(String nombreUsuario) {
        return usuarioRepo.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existByEmail(String email) {
        return usuarioRepo.existsByEmail(email);
    }
    
    public void save(Usuario usuario) {
        usuarioRepo.save(usuario);
    }
}
