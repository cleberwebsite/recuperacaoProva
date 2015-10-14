package br.senai.sc.ti2014n1.cleber.model;

import br.senai.sc.ti2014n1.cleber.dao.UserDao;
import br.senai.sc.ti2014n1.cleber.model.dominio.User;

public class UserRn {

	private UserDao dao;

	public UserRn() {
		dao = new UserDao();
	}

	public void salvar(User user) throws Exception {
		if (user.getNome().trim().isEmpty()) {
			throw new Exception("O nome Ã© obrigatÃ³rio!");
		}

		if (user.getDosagem() > 0) {
			throw new Exception("A dosagem deve ser maior que 0 (zero)!");
		}

		if (user.getIntervalo().trim().isEmpty()) {
			throw new Exception("O intervalo deve ser informado!");
		}

		if (user.getDuracao().trim().isEmpty()) {
			throw new Exception("A duração deve ser informada!");
		}

		dao.salvar(user);
	}

}
