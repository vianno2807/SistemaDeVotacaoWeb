package controller;

import java.io.IOException;

import dao.CadastroDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Eleitor;
import model.Usuario;

@WebServlet(name = "CadastroController", urlPatterns = { "/cadastrocontroller" })
public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroController() {
		super();
	}


	  @Override protected void doGet(HttpServletRequest request,
	  HttpServletResponse response) throws ServletException, IOException {
	  RequestDispatcher dispatcher =
	  getServletContext().getRequestDispatcher("/Cadastro1.jsp");
	  dispatcher.forward(request, response); }
	 

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tipoPerfil = request.getParameter("perfil");
		CadastroDAO cadastroDAO = new CadastroDAO();
		String result = null; 
		
		if ("Eleitor".equals(tipoPerfil)) {
			Eleitor eleitor = new Eleitor();
			eleitor.setNome(request.getParameter("nome"));
			eleitor.setEndereco(request.getParameter("endereco"));
			eleitor.setNumReegistroEleitor(request.getParameter("registro"));

			result = cadastroDAO.addEleitor(eleitor);			
		}

		if ("Administrador".equals(tipoPerfil)) {
			Usuario usuario = new Usuario();
			usuario.setLogin(request.getParameter("nome"));
			usuario.setSenha(request.getParameter("senha"));
			usuario.setPerfil(request.getParameter("perfil"));

			result = cadastroDAO.addAdm(usuario);
			
		}
		response.sendRedirect("Cadastro1.jsp?status=success");
		System.out.println(result);
		
	}

}
