package br.edu.ifba.mobile.wmobile.submit.cadeia;

public abstract class Coordenador {
	protected Coordenador proximo = null;
	
	public void setProximoCoordernador(Coordenador proximo) {
		if(this.proximo != null) {
			this.proximo.setProximoCoordernador(proximo);
		} else {
			this.proximo = proximo;
		}
	}
	
	public abstract String encaminhar(Area area);
}
