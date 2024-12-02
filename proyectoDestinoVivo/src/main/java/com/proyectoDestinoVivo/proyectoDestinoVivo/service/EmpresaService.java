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

    public Empresa editarEmpresa(int id_empresa, Empresa empresa){
        Empresa existente = empresaRepository.findById(id_empresa).orElseThrow(()->new RuntimeException("Empresa no existente"));
        existente.setNombre(empresa.getNombre());
        existente.setDireccion(empresa.getDireccion());
        existente.setDescripcion(empresa.getDescripcion());
        existente.setHorario(empresa.getHorario());
        existente.setTelefono(empresa.getTelefono());
        existente.setCorreo(empresa.getCorreo());
        existente.setContrasena(empresa.getContrasena());
        existente.setImagen(empresa.getImagen());
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
}
