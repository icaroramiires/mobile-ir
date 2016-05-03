package br.edu.ifba.mobile.wmobile.submit.cadeia;

public class CoordenadorEletrica extends Coordenador {

	@Override
	public String encaminhar(Area area) {
		if (area == Area.AUTOMACAO) {
			return "Fulano, Coordenador do curso de Eng. Elétrica encaminhará seu projeto para um profesor da área";
		} else if (area == Area.ELETRICA) {
			return "Fulano, Coordenador do curso de Eng. Elétrica encaminhará seu projeto para um profesor da área";
		}
		return proximo.encaminhar(area);

	}

}
