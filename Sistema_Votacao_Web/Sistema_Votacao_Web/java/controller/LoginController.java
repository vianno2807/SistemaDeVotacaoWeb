package controller;

import java.io.IOException;

import dao.UsuariosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public String perfil;
	public int idUsuarioLogado;

	public LoginController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usu = new Usuario();
		usu.setLogin(request.getParameter("usuario"));
		usu.setSenha(request.getParameter("senha"));

		UsuariosDAO usuarios = new UsuariosDAO();
		if (usuarios.valida(usu)) {
			System.out.println("usuario logado!");
			perfil = usuarios.retonaPerfil(usu);
			idUsuarioLogado = usuarios.retornaId(usu);
			HttpSession session = request.getSession();				
			session.setAttribute("perfil",perfil);
			session.setAttribute("usuario", idUsuarioLogado);
			response.sendRedirect("HomeADM.jsp");
		} else {
			System.out.println("usuario ou senha invalidos!");
		}

		/*
		 * if (usuarios.testeConexao()) {
		 * System.out.println("Conectado ao banco com sucesso!!");
		 * 
		 * }else { System.out.println("não conectou!!!!"); }
		 */

	}

}
