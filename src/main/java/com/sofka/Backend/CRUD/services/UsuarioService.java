package com.sofka.Backend.CRUD.services;

import com.sofka.Backend.CRUD.models.UsuarioModel;
import com.sofka.Backend.CRUD.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
}
