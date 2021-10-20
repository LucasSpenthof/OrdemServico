package br.edu.ifms.ordemservico.dto;

import java.io.Serializable;
import java.time.Instant;


import br.edu.ifms.ordemservico.entities.OrdemDeServico;
import br.edu.ifms.ordemservico.entities.Servidor;
import br.edu.ifms.ordemservico.entities.enums.Prioridade;
import br.edu.ifms.ordemservico.entities.enums.Status;

public class OrdemDeServicoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String equippamento;
	private String patrimonio;
	private String setor;
	private String descricaoProblema;
	private Instant dataCadastro;
	private Status status;
	private Prioridade prioridade;
	private String descricaoSolucao;
	private Servidor servidor;
	
	public OrdemDeServicoDTO() {}

	public OrdemDeServicoDTO(Long id, String equippamento, String patrimonio, String setor, String descricaoProblema,
			Instant dataCadastro, Status status, Prioridade prioridade, String descricaoSolucao, Servidor servidor) {
		super();
		this.id = id;
		this.equippamento = equippamento;
		this.patrimonio = patrimonio;
		this.setor = setor;
		this.descricaoProblema = descricaoProblema;
		this.dataCadastro = dataCadastro;
		this.status = status;
		this.prioridade = prioridade;
		this.descricaoSolucao = descricaoSolucao;
		this.servidor = servidor;
	}
	
	public OrdemDeServicoDTO(OrdemDeServico ordem) {
		super();
		this.id = ordem.getId();
		this.equippamento = ordem.getEquippamento();
		this.patrimonio = ordem.getPatrimonio();
		this.setor = ordem.getSetor();
		this.descricaoProblema = ordem.getDescricaoProblema();
		this.dataCadastro = ordem.getDataCadastro();
		this.status = ordem.getStatus();
		this.prioridade = ordem.getPrioridade();
		this.descricaoSolucao = ordem.getDescricaoSolucao();
		this.servidor = ordem.getServidor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEquippamento() {
		return equippamento;
	}

	public void setEquippamento(String equippamento) {
		this.equippamento = equippamento;
	}

	public String getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(String patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getDescricaoProblema() {
		return descricaoProblema;
	}

	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public String getDescricaoSolucao() {
		return descricaoSolucao;
	}

	public void setDescricaoSolucao(String descricaoSolucao) {
		this.descricaoSolucao = descricaoSolucao;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
	
	

}
