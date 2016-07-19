package br.edu.ifba.mobile.webservice.disciplinas;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("servico")
public class Servico {

	private static String VERSAO = "1.0";
	
	private static List<Disciplina> disciplinas;
	
	static {
		disciplinas = new ArrayList<Disciplina>();
		
		Disciplina disciplina = new Disciplina();
		disciplina.setCodigo(1);
		disciplina.setNome("Mobile");
		disciplina.setNota1(8);
		disciplina.setNota2(0);
		disciplina.setNota2(0);
		
		disciplinas.add(disciplina);
		
		disciplina = new Disciplina();
		disciplina.setCodigo(2);
		disciplina.setNome("AMS2");
		disciplina.setNota1(7);
		disciplina.setNota2(0);
		disciplina.setNota3(0);
		
		disciplinas.add(disciplina);
	}
	
	@GET
	@Path("/versao")
	@Produces(MediaType.TEXT_PLAIN)
	public String getVersao() {
		return VERSAO; 
	}
	
	@GET
	@Path("/disciplinas/{matricula}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Disciplina> getDisciplinas(@PathParam("matricula") int matricula) {
		return disciplinas;
	}
	
	@POST 
	@Path("/revisar/{matricula}/{disciplina}/{unidade}")
	@Produces(MediaType.TEXT_PLAIN)
	public String revisarNota(
			@PathParam("matricula") int matricula, 
			@PathParam("disciplina") int codDisciplina, 
			@PathParam("unidade") int unidade
			) {
		System.out.println("Revisão de nota solicitada pelo aluno da matricula = " 
		+  matricula + " referente à disciplina = " + codDisciplina + " unidade " +
				unidade);
		
		return "Solicitação Registrada";
	}
}
