package br.med.MaisVida.resource;

import br.med.MaisVida.document.Medico;
import br.med.MaisVida.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MedicoResource {
    @Autowired
    private MedicoRepository medicoRepository;

    @RequestMapping("/allMedicos")
    public List<Medico> getMedicos() {
        return medicoRepository.findAll();
    }

    @RequestMapping("/getMedico/{id}")
    public Medico getMedico(@PathVariable String id) {
        return medicoRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/saveMedico")
    public Medico saveMedico(@RequestBody Medico medico) {
        return medicoRepository.save(medico);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteMedico/{id}")
    public String deleteMedico(@PathVariable String id) {
        medicoRepository.delete(id);
        return id;
    }
}
