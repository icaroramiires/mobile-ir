package br.edu.ifba.mobile.wmobile.submit.cadeia;

public class CoordenadorBSI extends Coordenador {

	@Override
	public String encaminhar(Area area) {
		if (area == Area.PROGRAMACAO) {
			return "Fulano, Coordenador do curso de Sistemas de Informação encaminhará seu projeto para um profesor da área";
		} else if (area == Area.REDES) {
			return "Fulano, Coordenador do curso de Sistemas de Informação encaminhará seu projeto para um profesor da área";
		}
		return proximo.encaminhar(area);
	}
}
