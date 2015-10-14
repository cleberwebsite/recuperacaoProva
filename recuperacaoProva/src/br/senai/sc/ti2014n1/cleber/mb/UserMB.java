package br.senai.sc.ti2014n1.cleber.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.ti2014n1.cleber.model.UserRn;
import br.senai.sc.ti2014n1.cleber.model.dominio.User;

@ManagedBean
public class UserMB {
	private List<User> usuarios;
	private User user;
	private UserRn rn;

	@PostConstruct
	public void init() {
		rn = new UserRn();
		user = new User();
	}

	public List<User> getUsuarios() {
		if (usuarios == null) {
		}
		return usuarios;
	}

	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String salvar() {
		try {
			rn.salvar(user);
		} catch (Exception e) {
			return "";
		}
		return "userlist";
	}
	
	public String editar(String idParam){
		Long id = Long.parseLong(idParam);
		user = rn.buscarPorId(id);
		return "userform";
	}
	
	public String excluir(String idParam){
		Long id = Long.parseLong(idParam);
		try {
			rn.excluir(id);
			usuarios = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
