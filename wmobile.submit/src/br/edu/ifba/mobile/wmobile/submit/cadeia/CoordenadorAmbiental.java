	package br.edu.ifba.mobile.wmobile.submit.cadeia;

public class CoordenadorAmbiental extends Coordenador{

	@Override
	public String encaminhar(Area area) {
		if (area == Area.SOLOS) {
			return "Fulano, Coordenador do curso de Eng. Ambiental encaminhará seu projeto para um profesor da área";
		}
		return proximo.encaminhar(area);
	}
}
