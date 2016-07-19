package br.edu.ifba.webservice.disciplinas.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

public class FachadaServico {
	private static FachadaServico instancia = null;
	
	public static FachadaServico getInstancia() {
		if (instancia == null) {
			instancia = new FachadaServico();
		} 
		return instancia;
	}
	
	private Gson conversor = null;
	
	private FachadaServico() {
		conversor = new Gson();
	}
	
	public String getVersao() {
		String versao = "";
		
		HttpClient client = new DefaultHttpClient();
		HttpGet acessoVersao = new HttpGet();
		acessoVersao.setURI(URI.create("http://localhost:8080/webservice.disciplinas/v1/servico/versao"));
		try {
			HttpResponse resposta = client.execute(acessoVersao);
			InputStreamReader isr = new InputStreamReader(resposta.getEntity().getContent());
			BufferedReader br = new BufferedReader(isr);
			versao = br.readLine();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return versao;
	}
	
	public Disciplina[] getDisciplinas(int matricula) {
		Disciplina[] disciplinas = new Disciplina[0];
		
		HttpClient client = new DefaultHttpClient();
		HttpGet acessoVersao = new HttpGet();
		acessoVersao.setURI(URI.create("http://localhost:8080/webservice.disciplinas/v1/servico/disciplinas/" + matricula));
		try {
			HttpResponse resposta = client.execute(acessoVersao);
			InputStreamReader isr = new InputStreamReader(resposta.getEntity().getContent());
			BufferedReader br = new BufferedReader(isr);
			String json = br.readLine();
			if (json != null) {
				disciplinas = conversor.fromJson(json, (new Disciplina[]{}.getClass()));
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return disciplinas;
	}
}
