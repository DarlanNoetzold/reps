package tech.noetzold.reps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Objapi {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeApi;
	private String urlApi;
	private String urlImagemApi;
	
	@Enumerated(EnumType.STRING)
	private StatusApi status;
	
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

	public String getNomeApi() {
		return nomeApi;
	}

	public void setNomeApi(String nomeApi) {
		this.nomeApi = nomeApi;
	}

	public String getUrlApi() {
		return urlApi;
	}

	public void setUrlApi(String urlApi) {
		this.urlApi = urlApi;
	}

	public String getUrlImagemApi() {
		return urlImagemApi;
	}

	public void setUrlImagemApi(String urlImagemApi) {
		this.urlImagemApi = urlImagemApi;
	}

	public StatusApi getStatus() {
		return status;
	}

	public void setStatus(StatusApi status) {
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
