package br.edu.ifms.ordemservico.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.ordemservico.dto.OrdemDeServicoDTO;
import br.edu.ifms.ordemservico.services.OrdemDeServicoService;

@RestController
@RequestMapping(value = "/ordens_de_servico")
public class OrdemDeServicoResource {
	
	@Autowired
	private OrdemDeServicoService ordemdeservico;
	
	@GetMapping
	public ResponseEntity<List<OrdemDeServicoDTO>> findAll(){
		List<OrdemDeServicoDTO> lista = ordemdeservico.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrdemDeServicoDTO> findById(@PathVariable Long id){
		OrdemDeServicoDTO dto = ordemdeservico.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<OrdemDeServicoDTO> insert(@RequestBody OrdemDeServicoDTO dto){
		dto = ordemdeservico.instert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<OrdemDeServicoDTO> update(@PathVariable Long id, @RequestBody OrdemDeServicoDTO dto){
		dto = ordemdeservico.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<OrdemDeServicoDTO> delete(@PathVariable Long id){
		ordemdeservico.delete(id);
		return ResponseEntity.noContent().build();
	}
}
