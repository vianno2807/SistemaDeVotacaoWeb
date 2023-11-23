package controller;

import java.io.IOException;

import dao.CadastroEleicaoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Eleicao;

@WebServlet(name = "CadastroEleicaoController")
public class CadastroEleicaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroEleicaoController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = null;
		CadastroEleicaoDAO cadastroEleicao = new CadastroEleicaoDAO();
		Eleicao ele = new Eleicao();

		ele.setNomeEleicao(request.getParameter("nomeEleicao"));
		ele.setDataInicio(request.getParameter("dataInicio"));
		ele.setDataFim(request.getParameter("dataFim"));

		 result = cadastroEleicao.addEleicao(ele); 
		 System.out.println(result);
		 response.sendRedirect("cadastrarEleicao.jsp?status=success");
		
	}

}
