package br.com.cassio.crudspringhibernate.service;

import br.com.cassio.crudspringhibernate.models.Usuario;
import br.com.cassio.crudspringhibernate.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setEmail(usuarioAtualizado.getEmail());
                    usuario.setSenha(usuarioAtualizado.getSenha());
                    return usuarioRepository.save(usuario);
                }).orElse(null);
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
