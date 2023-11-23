package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuariosDAO {

	public boolean valida(Usuario usuario) {

		String sql = "SELECT idUsuario, login, senha, perfil FROM Usuarios WHERE login = ? and senha =  ? ";
		PreparedStatement stmt = null;
		Connection conn = null;

		try {

			conn = new Banco().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				conn.close();
				return true;
			}
			/* stmt.close(); */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String retonaPerfil(Usuario usuario) {

		String sql = "SELECT perfil FROM Usuarios WHERE login = ? and senha =  ? ";
		PreparedStatement stmt = null;
		Connection conn = null;

		try {

			conn = new Banco().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());

			ResultSet rs = stmt.executeQuery();
			System.out.println(rs);

			if (rs.next()) {
				String perfilUsu = rs.getString("perfil");
				System.out.println("perfil do usuario: " + perfilUsu);

				conn.close();
				return perfilUsu;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public Integer retornaId(Usuario usuario) {
		String sql = "SELECT idUsuario FROM Usuarios WHERE login = ? and senha =  ? ";
		PreparedStatement stmt = null;
		Connection conn = null;

		try {

			conn = new Banco().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Integer idUsuario = rs.getInt("idUsuario");
				conn.close();
				return idUsuario;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Usuario> ListaUsuarios() {
		List<Usuario> listausuarios = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = new Banco().getConnection();
			String sql = "SELECT * FROM Usuarios";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idUsuario = (rs.getInt("idUsuario"));
				String login = (rs.getString("login"));
				String senha = (rs.getString("senha"));
				String perfil = (rs.getString("perfil"));
				Usuario usuario = new Usuario(idUsuario, login, senha, perfil);
				listausuarios.add(usuario);

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
		return listausuarios;
	}
	

	public void deletar(Integer id) {
		String sql = "DELETE FROM Usuarios WHERE idUsuario = ?";
		PreparedStatement stmt = null;
		Connection conn = null;

		try {

			conn = new Banco().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			int ret = stmt.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
