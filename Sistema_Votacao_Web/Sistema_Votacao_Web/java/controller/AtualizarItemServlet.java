package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Candidato;

import java.io.IOException;

import dao.CadastroCadDao;

public class AtualizarItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AtualizarItemServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		int id = 0;		 
		 if(request.getParameter("salvar") != null ) {
		
			 Candidato candidatoNovo = new Candidato();
			 candidatoNovo.setIdCandidato(Integer.parseInt(request.getParameter("idCandidato")));
			 candidatoNovo.setNome(request.getParameter("nome"));
			 candidatoNovo.setNumPartido(request.getParameter("numPartido"));
			 candidatoNovo.setPartido(request.getParameter("partido"));
			 
			 System.out.println(candidatoNovo);
			 
			 CadastroCadDao candidatoDAO = new CadastroCadDao();
			 candidatoDAO.alterar(candidatoNovo.getIdCandidato(), candidatoNovo.getNome(), candidatoNovo.getNumPartido(), candidatoNovo.getPartido());
			 
			 response.sendRedirect("gerenciar.jsp");	
				 
			 
		 }
		
		 else if(request.getParameter("idCandidato") != null) {
			id = Integer.parseInt(request.getParameter("idCandidato"));
			Candidato candidato = new Candidato();
			CadastroCadDao candidatoDAO = new CadastroCadDao();
			candidato =  candidatoDAO.candidatoPorId(id);
			CandidatoDTO candidatoDTO = new CandidatoDTO(candidato.getIdCandidato(), candidato.getNome(), candidato.getNumPartido(), candidato.getPartido(), candidato.getIdEleicao());
			HttpSession session = request.getSession();				
			session.setAttribute("candidato",candidatoDTO);
			response.sendRedirect("AlterarItem.jsp");		
		 }
		 
		 
		// request.setAttribute("candidato", candidatoDTO);
		 
//		 response.sendRedirect("AlterarItem.jsp");	

	}

}
