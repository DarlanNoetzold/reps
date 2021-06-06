package tech.noetzold.reps.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Objrep {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeRep;
	private String urlRep;
	private String urlImagem;
	
	@Enumerated(EnumType.STRING)
	private StatusRep status;
	
	@Column(name="descricao", nullable=false, length=1800)
	private String descricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeRep() {
		return nomeRep;
	}

	public void setNomeRep(String nomeRep) {
		this.nomeRep = nomeRep;
	}

	public String getUrlRep() {
		return urlRep;
	}

	public void setUrlRep(String urlRep) {
		this.urlRep = urlRep;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public StatusRep getStatus() {
		return status;
	}

	public void setStatus(StatusRep status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
