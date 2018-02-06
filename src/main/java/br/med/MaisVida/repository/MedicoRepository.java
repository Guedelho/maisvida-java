package br.med.MaisVida.repository;

import br.med.MaisVida.document.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicoRepository extends MongoRepository<Medico, String> {

}
