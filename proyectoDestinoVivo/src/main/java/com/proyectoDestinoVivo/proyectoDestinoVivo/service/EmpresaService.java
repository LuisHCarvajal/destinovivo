package com.proyectoDestinoVivo.proyectoDestinoVivo.service;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Empresa;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.EmpresaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmpresaService {
    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa insertarEmpresa(@RequestBody Empresa empresa){
        try {
            return empresaRepository.save(empresa);
        }catch (DataAccessException e){
            throw new RuntimeException("Error al insertar la empresa" +e);
        }
    }

    public Empresa editarEmpresa(Empresa empresa){
        Empresa existente = empresaRepository.findById(empresa.getId_empresa()).orElseThrow(()->new RuntimeException("Empresa no existente"));
        existente.setNombre(empresa.getNombre() != null ? empresa.getNombre() : existente.getNombre());
        existente.setDireccion(empresa.getDireccion() != null ? empresa.getDireccion() : existente.getDireccion());
        existente.setDescripcion(empresa.getDescripcion() != null ? empresa.getDescripcion() : existente.getDescripcion());
        existente.setHorario(empresa.getHorario() != null ? empresa.getHorario() : existente.getHorario());
        existente.setTelefono(empresa.getTelefono() != null ? empresa.getTelefono() : existente.getTelefono());
        existente.setCorreo(empresa.getCorreo() != null ? empresa.getCorreo() : existente.getCorreo());
        existente.setContrasena(empresa.getContrasena() != null ? empresa.getContrasena() : existente.getContrasena());
        existente.setImagen(empresa.getImagen() != null ? empresa.getImagen() : existente.getImagen());
        return empresaRepository.save(existente);
    }

    public String eliminarEmpresa(int id_empresa){
        Empresa existente = empresaRepository.findById(id_empresa).orElseThrow(()->new RuntimeException("Empresa no existente"));
        empresaRepository.deleteById(existente.getId_empresa());
        return "Empresa eliminada correctamente";
    }

    public List<Empresa> consultarEmpresas(){
        return empresaRepository.findAll();
    }

    public Empresa consultarEmpresa(int id_empresa){
        return empresaRepository.findById(id_empresa).orElseThrow(()->new RuntimeException("Empresa no existente"));
    }
}
