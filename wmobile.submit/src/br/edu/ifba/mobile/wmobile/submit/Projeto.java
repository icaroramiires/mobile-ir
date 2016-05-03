package br.edu.ifba.mobile.wmobile.submit;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.edu.ifba.mobile.wmobile.submit.cadeia.Area;
import br.edu.ifba.mobile.wmobile.submit.cadeia.Coordenador;
import br.edu.ifba.mobile.wmobile.submit.cadeia.CoordenadorAmbiental;
import br.edu.ifba.mobile.wmobile.submit.cadeia.CoordenadorBSI;
import br.edu.ifba.mobile.wmobile.submit.cadeia.CoordenadorEletrica;
import br.edu.ifba.mobile.wmobile.submit.cadeia.CoordernadorQuimica;

@ManagedBean(name = "projeto")
@SessionScoped
public class Projeto {
	private String email = "";
	private String senha = "";
	private String resultado = "";
	private String titulo = "";
	private String descricao = "";

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<String> getAreaProjeto() {
		List<String> areas = new ArrayList<>();
		areas.add("Automação");
		areas.add("Programação");
		areas.add("Redes");
		areas.add("Elétrica");
		areas.add("Experimento Quimico");
		areas.add("Solos");

		return areas;
	}

	public void setAreaEscolhida(String areaEscolhida) {
		Area area = Area.NENHUMA;

		if (areaEscolhida.equals("Automação")) {
			area = Area.AUTOMACAO;
		} else if (areaEscolhida.equals("Programação")) {
			area = Area.PROGRAMACAO;
		} else if (areaEscolhida.equals("Redes")) {
			area = Area.REDES;
		} else if (areaEscolhida.equals("Elétrica")) {
			area = Area.ELETRICA;
		} else if (area.equals("Experimeneto Quimico")) {
			area = Area.EXPERIMENTO_QUIMICO;
		} else if (area.equals("Solos")) {
			area = Area.SOLOS;
		}

		Coordenador coordenador = new CoordenadorBSI();
		coordenador.setProximoCoordernador(new CoordenadorEletrica());
		coordenador.setProximoCoordernador(new CoordenadorAmbiental());
		coordenador.setProximoCoordernador(new CoordernadorQuimica());

		// System.out.println("Encaminhando Projeto de " + email);

		resultado = coordenador.encaminhar(area);
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
