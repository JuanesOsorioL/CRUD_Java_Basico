package com.sofka.Backend.CRUD.controllers;

import com.sofka.Backend.CRUD.models.UsuarioModel;
import com.sofka.Backend.CRUD.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")//en que direccion del servidor se activaran los metodos de esta clase
public class UsuarioController {
    @Autowired //no es necesario instanciar ya spring sabe
    UsuarioService usuarioService ;

    //buscar todos
    @GetMapping()//peticiones get
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    //agregar usuario por body
    @PostMapping()//peticionespost
    public UsuarioModel guardarUsuarios(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    //buscar por id
    @GetMapping(path = "/{id}")//para por ruta el id ejem "usuario/1"
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id")Long id){//captura el id que viene por url
        return this.usuarioService.obtenerPorId(id);
    }

    //buscar por prioridad
    @GetMapping(path = "/query")//para traer valores de la ruta ejm: "usuario/query?prioridad=5" tomaria el 5
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad")Integer prioridad){//captura el parametro que viene por url de la variable prioridad
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    //eliminar usuario
    @DeleteMapping(path = "/{id}")//metodo delete y envia el id del que se eliminara
    public String eliminarPorId(@PathVariable("id")Long id){//captura el id que viene por url
        boolean ok= this.usuarioService.eliminarUsuario(id);
        if (ok)
            return "se elimino usuario con id "+id;
        else
            return "No se elimino usuario con id "+id;
    }
}
