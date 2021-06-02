package tech.noetzold.reps.dto;

import javax.validation.constraints.NotBlank;

import tech.noetzold.reps.model.Objrep;
import tech.noetzold.reps.model.StatusRep;

public class RequisicaoNovoObjrep {
	@NotBlank
	private String nomeRep;
	
	@NotBlank
	private String urlRep;
	
	@NotBlank
	private String urlImagem;
	private String descricao;
	
	public String getNomeRep() {
		return nomeRep;
	}
	public void setNomeRep(String nomeProduto) {
		this.nomeRep = nomeProduto;
	}
	public String getUrlRep() {
		return urlRep;
	}
	public void setUrlRep(String urlProduto) {
		this.urlRep = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Objrep toObjrep() {
		Objrep objrep = new Objrep();
		objrep.setDescricao(descricao);
		objrep.setNomeRep(nomeRep);
		objrep.setUrlImagem(urlImagem);
		objrep.setUrlRep(urlRep);
		objrep.setStatus(StatusRep.DESENVOLVIMENTO);
		return objrep;
	}
	
}
