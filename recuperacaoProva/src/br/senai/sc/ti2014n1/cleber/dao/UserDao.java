package br.senai.sc.ti2014n1.cleber.dao;

import java.sql.PreparedStatement;


import br.senai.sc.ti2014n1.cleber.model.dominio.User;

public class UserDao extends Dao {

	private final String INSERT = "INSERT INTO user (nome, dosagem, intervalo, duracao) values (?,?,?,?)";
	

	public void salvar(User user) throws Exception {
		if (user.getId() == 0) {
			inserir(user);
		}
	}

	private void inserir(User user) throws Exception {
		try {
			PreparedStatement ps = getConnection().prepareStatement(INSERT);
			ps.setString(1, user.getNome());
			ps.setDouble(2, user.getDosagem());
			ps.setString(3, user.getIntervalo());
			ps.setString(4, user.getDuracao());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao tentar salvar o usuário");
		}
	}

	

}
