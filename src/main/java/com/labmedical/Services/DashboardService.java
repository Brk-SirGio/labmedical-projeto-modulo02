package com.labmedical.Services;

import com.labmedical.Repositories.ConsultaRepository;
import com.labmedical.Repositories.ExameRepository;
import com.labmedical.Repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ExameRepository exameRepository;

    public Map<String, Long> obterEstatisticas() {
        Map<String, Long> estatisticas = new HashMap<>();

        estatisticas.put("quantidadePacientes", pacienteRepository.count());
        estatisticas.put("quantidadeConsultas", consultaRepository.count());
        estatisticas.put("quantidadeExames", exameRepository.count());

        return estatisticas;
    }
}
