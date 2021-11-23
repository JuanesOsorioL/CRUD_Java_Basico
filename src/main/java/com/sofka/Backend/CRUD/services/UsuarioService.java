package com.sofka.Backend.CRUD.services;

import com.sofka.Backend.CRUD.models.UsuarioModel;
import com.sofka.Backend.CRUD.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired //no es necesario instanciar ya spring sabe
    UsuarioRepository usuarioRepositiry;

    //obtener usuario
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepositiry.findAll();
    }

    //guardarUsuario
    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepositiry.save(usuario);
    }

    //buscar por ID
    public Optional<UsuarioModel> obtenerPorId(Long id){//como el metodo puede fallar se crea como optional
        return usuarioRepositiry.findById(id);
    }

    //buscar por prioridad
    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepositiry.findByPrioridad(prioridad);
    }

    //eliminar por id
    public boolean eliminarUsuario(Long id){//el metodo defaul no devuelve nada y si algo falla gener error por eso en yun try
        try {
            usuarioRepositiry.deleteById(id);
            return true;
        }catch (Exception err){
            return false;
        }
    }



}
