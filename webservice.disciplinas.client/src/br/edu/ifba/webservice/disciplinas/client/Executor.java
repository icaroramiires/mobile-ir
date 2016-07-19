package br.edu.ifba.webservice.disciplinas.client;

public class Executor {

	public static void main(String[] args) {
		String versao = FachadaServico.getInstancia().getVersao();
		System.out.println(versao);
		
		Disciplina[] disciplinas = FachadaServico.getInstancia().getDisciplinas(1234567);
		for (Disciplina disciplina : disciplinas) {
			System.out.println(disciplina);
		}

	}

}
