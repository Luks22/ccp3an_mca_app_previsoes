package br.usjt.meteriologia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.meteriologia.model.Usuario;
import br.usjt.meteriologia.repository.UsuarioRepository;

@Service
public class LoginService {

	@Autowired
	UsuarioRepository usuarioRepo;
	
	public boolean logar(Usuario usuario) {
		return usuarioRepo.findOneByLoginAndSenha(usuario.getLogin(), usuario.getSenha()) != null;
	}
}
