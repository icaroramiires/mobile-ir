package br.edu.ifba.mobile.wmobile.submit.cadeia;

public class CoordernadorQuimica extends Coordenador {

	@Override
	public String encaminhar(Area area) {
		if(area == Area.EXPERIMENTO_QUIMICO) {
			return "Fulano, Coordenador do curso de Quimica encaminhará seu projeto para um profesor da área";
		}
		return "Não Existe Coordenador para avaliar este projeto";
	}

}
	