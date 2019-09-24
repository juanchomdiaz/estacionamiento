package com.cientooncemil.estacionamiento.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.cientooncemil.estacionamiento.models.Usuario;

@Repository
public class UsuarioRepository {
	
	private ArrayList<Usuario> usuarios;

	public UsuarioRepository() {
		this.usuarios = new ArrayList<Usuario>();
		
		Usuario usuarioP = new Usuario("Diaz", "Juan Manuel", "jmdiaz", "pepe123");
		
		this.agregarUsuario(usuarioP);
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public Boolean agregarUsuario(Usuario usuario) {
		Usuario u = this.obtenerUsuarioConNombreUsuario(usuario.getNombre());
		
		Boolean result = (u==null);
		
		if(result) {
			this.usuarios.add(usuario);
		} 
		
		return result;
	}
	
	public Usuario obtenerUsuarioConNombreUsuario(String nombreUsuario) {
		Usuario result = null;
		
		for(Usuario u : this.usuarios) {
			if(u.getNombreUsuario().equals(nombreUsuario)) {
				result = u;
			}
		}
		
		return result;
	}
	
	

}
