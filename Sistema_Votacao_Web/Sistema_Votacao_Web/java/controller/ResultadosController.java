package controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Candidato;
import model.Resultados;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.ResultadosDAO;

@WebServlet(name = "ResultadosController", urlPatterns = { "/ResultadosController" })
public class ResultadosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ResultadosController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idEleicao = Integer.parseInt(request.getParameter("eleicao"));
		List<Resultados> listaR = new ArrayList<>();
		
		listaR = buscarReseltado(idEleicao);
		
		HttpSession session = request.getSession();				
		session.setAttribute("listaR", listaR);
		response.sendRedirect("resultados.jsp");
	}
	public List<Resultados> buscarReseltado(Integer id) {
		ResultadosDAO dao = new ResultadosDAO();
		
		List<Resultados> listaResultado = new ArrayList<>();
		List<Resultados> resultados = new ArrayList<>();
		
		listaResultado = dao.listaResultado(id);
		 
		for (Resultados resultado : listaResultado) {
			String nome = resultado.getNome();
			String partido = resultado.getPartido();
			int totalVotos = resultado.getTotalVotos();
			Resultados result = new Resultados(nome, partido, totalVotos);
			resultados.add(result);
		}
		return resultados;
	}

}
