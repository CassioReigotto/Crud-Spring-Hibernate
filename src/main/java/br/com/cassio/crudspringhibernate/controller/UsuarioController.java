package br.com.cassio.crudspringhibernate.controller;

import br.com.cassio.crudspringhibernate.controller.mapper.UsuarioMapper;
import br.com.cassio.crudspringhibernate.entity.UsuarioRequest;
import br.com.cassio.crudspringhibernate.models.Usuario;
import br.com.cassio.crudspringhibernate.repository.UsuarioRepository;
import br.com.cassio.crudspringhibernate.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioService usuarioService, UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Usuario salvar(@RequestBody UsuarioRequest usuarioRequest) {
        var usuarioEntity = UsuarioMapper.INSTANCE.toEntity(usuarioRequest);
        return usuarioService.salvar(usuarioEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody UsuarioRequest usuarioRequest) {
        var usuarioEntity = UsuarioMapper.INSTANCE.toEntity(usuarioRequest);
        Usuario atualizado = usuarioService.atualizar(id, usuarioEntity);
        return atualizado != null ? ResponseEntity.ok(atualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
