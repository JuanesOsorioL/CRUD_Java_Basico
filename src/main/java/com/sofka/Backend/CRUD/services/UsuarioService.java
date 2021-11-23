package com.sofka.Backend.CRUD.services;

import com.sofka.Backend.CRUD.models.UsuarioModel;
import com.sofka.Backend.CRUD.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepositiry;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepositiry.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepositiry.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepositiry.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepositiry.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id){
        try {
            usuarioRepositiry.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }

    public UsuarioModel obtenerUsuarioPorEmail(String email){
        return usuarioRepositiry.findByEmail(email);
    }


    public ResponseEntity<UsuarioModel> actualizarPrioridadporId(UsuarioModel usuario){
        if (usuarioRepositiry.existsById(usuario.getId())){
            Optional<UsuarioModel> usuarioId = obtenerPorId(usuario.getId());
            usuarioId.get().setPrioridad(usuario.getPrioridad());
            guardarUsuario(usuarioId.get());
            return ResponseEntity.ok(usuarioId.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}

