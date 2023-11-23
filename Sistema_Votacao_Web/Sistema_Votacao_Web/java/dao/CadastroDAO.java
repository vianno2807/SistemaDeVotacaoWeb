package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Eleitor;
import model.Usuario;

public class CadastroDAO {

	public String addEleitor(Eleitor eleitor) {

		String sql = "INSERT INTO Eleitores (nome, endereco, numRegistroEleitor) VALUES (?, ?, ?);";
		PreparedStatement stmt = null;
		Connection conn = null;

		try {

			conn = new Banco().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, eleitor.getNome());
			stmt.setString(2, eleitor.getEndereco());
			stmt.setString(3, eleitor.getNumRegistroEleitor());
			stmt.executeUpdate();
			/* ResultSet rs = stmt.getGeneratedKeys(); */

			stmt.close();
			conn.close();
			return "Eleitor cadastrado com sucesso";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Erro ao cadastrar eleitor: " + e.getMessage();
		}
	}

	public String addAdm(Usuario usuario) {

		String sql = "INSERT INTO Usuarios (login, senha, perfil) VALUES (?, ?, ?);";
		PreparedStatement stmt = null;
		Connection conn = null;

		try {
			conn = new Banco().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getPerfil());
			stmt.executeUpdate();
			/* ResultSet rs = stmt.getGeneratedKeys(); */

			stmt.close();
			conn.close();
			return "Administrador cadastrado com sucesso";

		} catch (SQLException e) {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

			e.printStackTrace();
			return "Erro ao cadastrar administrador: " + e.getMessage();
		}
	}

	public List<Eleitor> ListaEleitor() {
		List<Eleitor> listaEleitor = new ArrayList<Eleitor>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = new Banco().getConnection();
			String sql = "SELECT * FROM Eleitores";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer idEleitor = (rs.getInt("idEleitor"));
				String nome = (rs.getString("nome"));
				String endereco = (rs.getString("endereco"));
				String numRegistroEleitor = (rs.getString("numRegistroEleitor"));
				Eleitor eleitor = new Eleitor(idEleitor, nome, endereco, numRegistroEleitor);
				listaEleitor.add(eleitor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return listaEleitor;
	}
	
	public void deletar(String nome) {
		String sql = "DELETE FROM Eleitores WHERE nome = ?";
		PreparedStatement stmt = null;
		Connection conn = null;

		try {

			conn = new Banco().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);

			int ret = stmt.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}