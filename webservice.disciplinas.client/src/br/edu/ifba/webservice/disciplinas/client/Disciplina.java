package br.edu.ifba.webservice.disciplinas.client;

import java.text.DecimalFormat;

public class Disciplina {
	private long codigo = -1;
	private String nome;
	private double nota1 = 0.0;
	private double nota2 = 0.0;
	private double nota3 = 0.0;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNota3() {
		return nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}

	@Override
	public String toString() {
		double media = (nota1 + nota2 + nota3) / 3;
		return nome + " -> Média = "
				+ new DecimalFormat("0.00").format(media);
	}

}
