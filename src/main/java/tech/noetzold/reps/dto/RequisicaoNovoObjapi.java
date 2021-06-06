package tech.noetzold.reps.dto;

import javax.validation.constraints.NotBlank;

import tech.noetzold.reps.model.Objapi;
import tech.noetzold.reps.model.StatusRep;

public class RequisicaoNovoObjapi {
	@NotBlank
	private String nomeApi;
	
	@NotBlank
	private String urlApi;
	private String urlImagemApi;
	private String descricao;
	
	private StatusRep status;
	
	public String getNomeApi() {
		return nomeApi;
	}
	public void setNomeApi(String nomeApi) {
		this.nomeApi = nomeApi;
	}
	public String getUrlApi() {
		return urlApi;
	}
	public void Api(String urlApi) {
		this.urlApi = urlApi;
	}
	public String getUrlImagemApi() {
		if(urlImagemApi == null) {
			return "https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png";
		}else {
			return urlImagemApi;
		}
	}
	public void setUrlImagem(String urlImagemApi) {
		this.urlImagemApi = urlImagemApi;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public StatusRep getStatus() {
		return status;
	}
	public void setStatus(StatusRep status) {
		this.status = status;
	}
	
	public Objapi toObjrep() {
		Objapi objapi = new Objapi();
		objapi.setDescricao(descricao);
		objapi.setNomeApi(nomeApi);
		objapi.setUrlImagemApi(urlImagemApi);
		objapi.setUrlApi(urlApi);
		objapi.setStatus(status);
		return objapi;
	}
	
}
