package com.proyectoDestinoVivo.proyectoDestinoVivo.service;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Empresa;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Resena;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Usuario;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.EmpresaRepository;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.ResenaRepository;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResenaService {
    private ResenaRepository resenaRepository;
    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;

    public ResenaService(UsuarioRepository usuarioRepository, ResenaRepository resenaRepository, EmpresaRepository empresaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.resenaRepository = resenaRepository;
        this.empresaRepository = empresaRepository;
    }

    public Resena insertarResena(Resena resena){
        System.out.println(resena);
        Usuario usuario = usuarioRepository.findById(resena.getUsuario().getDocumento())
                .orElseThrow(()->new IllegalArgumentException("Usuario no encontrado"));

        Empresa empresa = empresaRepository.findById(resena.getEmpresa().getId_empresa())
                .orElseThrow(()->new IllegalArgumentException("Empresa no encontrado"));


        return resenaRepository.save(resena);

    }

    public List<Resena> consultarResena(){
        return  resenaRepository.findAll();
    }

    public Resena actualizarResena(int id_resena, Resena nuevaResena) {
        //buscar la reseña existente por id
        Resena resenaExistente = resenaRepository.findById(id_resena)
                .orElseThrow(() -> new IllegalArgumentException("Reseña no encontrada"));

        //validar que el usuario y la empresa existan
        Usuario usuario = usuarioRepository.findById(nuevaResena.getUsuario().getDocumento())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Empresa empresa = empresaRepository.findById(nuevaResena.getEmpresa().getId_empresa())
                .orElseThrow(() -> new IllegalArgumentException("Empresa no encontrada"));

        //actualizar los campos de reseña
        resenaExistente.setUsuario(usuario);
        resenaExistente.setEmpresa(empresa);
        resenaExistente.setResena(nuevaResena.getResena());
        resenaExistente.setCalificacion(nuevaResena.getCalificacion());

        //guardar la reseña actualizada
        return resenaRepository.save(resenaExistente);
    }

    public String eliminarResena(int id_resena) {
        //verificar que la reseña exista
        Resena existente = resenaRepository.findById(id_resena)
                .orElseThrow(() -> new IllegalArgumentException("Reseña no encontrada"));

        //eliminar reseña
        resenaRepository.deleteById(existente.getId_resena());
        return "Reseña eliminada correctamente";
    }

}
