package br.com.unisys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unisys.DAO.Projeto;
import br.com.unisys.DAO.ProjetoDAO;

public class ProjetosAction {
	
	ProjetoDAO projetoDAO = new ProjetoDAO();
	
	public String adicionaProjeto(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException, SQLException{
		Projeto projeto = new Projeto();
	  // Captura os dados do formulário.
	    String nomeProjeto = request.getParameter("nomeProjeto");
	    float valorProjeto  = Float.parseFloat(request.getParameter("valorProjeto"));
//	    float valorProjeto = Float.parseFloat(valorProjeto1);
	    projeto.setNomeProjeto(nomeProjeto);
	    projeto.setValorProjeto(valorProjeto);
		String status = projetoDAO.adicionar(projeto);
		return status;
	}
	
	public List<Projeto> buscaProjetos() throws SQLException {
		List<Projeto> listaProjeto = new ArrayList<Projeto>();
		listaProjeto = projetoDAO.selectProjeto();
		return listaProjeto;
	}
	
	public static void main(String[] args) throws SQLException {
		ProjetosAction projetosAction = new ProjetosAction();
		projetosAction.buscaProjetos();
	}
	
}