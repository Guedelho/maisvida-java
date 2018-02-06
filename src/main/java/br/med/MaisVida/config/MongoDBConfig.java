package br.med.MaisVida.config;

import br.med.MaisVida.document.Medico;
import br.med.MaisVida.repository.MedicoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = MedicoRepository.class)
public class MongoDBConfig {
    @Bean
    CommandLineRunner commandLineRunner(MedicoRepository medicoRepository) {
        return strings -> {
            medicoRepository.save(new Medico("1", "joao", "ferreira", "joaoferreira@gmail.com", "Cardiologista", "GO", "Goiânia", true, false));
            medicoRepository.save(new Medico("2", "maria", "pereira", "mariapereira@gmail.com", "Ortopedista", "CE", "Fortaleza", true, false));
            medicoRepository.save(new Medico("3", "thiago", "santos", "thiagosantos@gmail.com", "Urologista", "DF", "Brasília", false, true));
        };
    }
}
