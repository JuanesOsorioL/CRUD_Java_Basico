package com.sofka.Backend.CRUD.repositories;

import com.sofka.Backend.CRUD.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long> {//<que tipo de dato es,tipo de identificador que tiene>
}
