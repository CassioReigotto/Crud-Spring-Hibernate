package br.com.cassio.crudspringhibernate.controller.mapper;

import br.com.cassio.crudspringhibernate.entity.UsuarioRequest;
import br.com.cassio.crudspringhibernate.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario toEntity(UsuarioRequest usuarioRequest);

}
