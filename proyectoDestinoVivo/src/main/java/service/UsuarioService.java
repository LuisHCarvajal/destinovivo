package service;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Usuario;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario insertarUsuario(Usuario usuario){
        try {
            return usuarioRepository.save(usuario);
        }catch (DataAccessException e){
            throw new RuntimeException("Error al insertar el usuario" +e);
        }
    }

    public List<Usuario> consultarUsuario(){
        return usuarioRepository.findAll();
    }
}
