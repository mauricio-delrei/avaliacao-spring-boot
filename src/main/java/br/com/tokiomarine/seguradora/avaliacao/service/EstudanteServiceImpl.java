package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.tokiomarine.seguradora.avaliacao.exception.IdNaoValidoServiceException;
import br.com.tokiomarine.seguradora.avaliacao.model.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;

@Service
@Transactional
public class EstudanteServiceImpl implements EstudandeService {

	@Autowired
	 private EstudanteRepository repository;

	@Override
	public void cadastrarEstudante(@Valid Estudante estudante) {
		
		repository.save(estudante);

	}

	@Override
	public void atualizarEstudante(@Valid Estudante estudante) {
		
		repository.save(estudante);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Estudante> buscarEstudantes() {
		return (List<Estudante>) repository.findAll();
	}	

	@Override
	@Transactional(readOnly = true)
	public Optional<Estudante> buscarEstudante(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(idValido(id));
	}

	@Override
	public void exluir(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(idValido(id));
		
	}
	
	private Long idValido(Long id) {
        if (id <= 0) {
            throw new IdNaoValidoServiceException("Valor do campo id está invalido. Deve ser uma valor inteiro maior que zero.");
        }
        return id;
    }

}
