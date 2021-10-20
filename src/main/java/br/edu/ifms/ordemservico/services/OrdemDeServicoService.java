package br.edu.ifms.ordemservico.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import br.edu.ifms.ordemservico.dto.OrdemDeServicoDTO;
import br.edu.ifms.ordemservico.entities.OrdemDeServico;
import br.edu.ifms.ordemservico.repositories.OrdemDeServicoRepository;
import br.edu.ifms.ordemservico.services.exceptions.DataBaseException;
import br.edu.ifms.ordemservico.services.exceptions.ResourceNotFoundException;

@Service
public class OrdemDeServicoService {

private OrdemDeServicoRepository repository;
	
	@Transactional/*(readOnly = true)*/
	public List<OrdemDeServicoDTO> findAll(){
		List<OrdemDeServico> list = repository.findAll();
		return list.stream().map(ordemdeservico -> new OrdemDeServicoDTO(ordemdeservico)).collect(Collectors.toList());
	}
	
	@Transactional/*(readOnly = true)*/
	public OrdemDeServicoDTO findById(Long id){
		Optional<OrdemDeServico> obj = repository.findById(id);
		OrdemDeServico ordemdeservico = obj.orElseThrow(() -> new ResourceAccessException("Não encontrado"));
		return new OrdemDeServicoDTO(ordemdeservico);
	}
	
	@Transactional
	public OrdemDeServicoDTO instert(OrdemDeServicoDTO dto) {
		OrdemDeServico ordemdeservico = new OrdemDeServico();
		copyDtoToEntity(dto, ordemdeservico);
		ordemdeservico = repository.save(ordemdeservico);
		return new OrdemDeServicoDTO(ordemdeservico);
	}
	
	@Transactional
	public OrdemDeServicoDTO update(Long id, OrdemDeServicoDTO dto) {
		try {
			OrdemDeServico ordemdeservico = repository.getById(id);
			copyDtoToEntity(dto, ordemdeservico);
			ordemdeservico = repository.save(ordemdeservico);
			return new OrdemDeServicoDTO(ordemdeservico);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("ID não localizado");
		}
		
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("ID não localizado, impossível excluir");
		}catch(DataIntegrityViolationException e) {
			throw new DataBaseException("Ordem em uso, umpossível excluir");
		}
		
	}

	
	private void copyDtoToEntity(OrdemDeServicoDTO dto, OrdemDeServico ordemdeservico) {
		ordemdeservico.setEquippamento(dto.getEquippamento());
		ordemdeservico.setPatrimonio(dto.getPatrimonio());
		ordemdeservico.setSetor(dto.getSetor());
		ordemdeservico.setDescricaoProblema(dto.getDescricaoProblema());
		ordemdeservico.setDataCadastro(dto.getDataCadastro());
		ordemdeservico.setStatus(dto.getStatus());
		ordemdeservico.setPrioridade(dto.getPrioridade());
		ordemdeservico.setDescricaoSolucao(dto.getDescricaoSolucao());
		ordemdeservico.setServidor(dto.getServidor());
	}
	
	

}
