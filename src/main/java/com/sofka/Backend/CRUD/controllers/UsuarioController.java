package com.sofka.Backend.CRUD.controllers;

import com.sofka.Backend.CRUD.models.UsuarioModel;
import com.sofka.Backend.CRUD.repositories.UsuarioRepository;
import com.sofka.Backend.CRUD.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuario")//en que direccion del servidor se activaran los metodos de esta clase
public class UsuarioController {
    @Autowired //no es necesario instanciar ya spring sabe
    UsuarioService usuarioService ;

    @GetMapping()//peticiones get
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()//peticionespost
    public UsuarioModel guardarUsuarios(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }
}
