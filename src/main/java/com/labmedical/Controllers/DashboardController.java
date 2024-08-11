package com.labmedical.Controllers;

import com.labmedical.Services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<Map<String, Long>> listarDadosDoDashboard() {
        Map<String, Long> estatisticas = dashboardService.obterEstatisticas();
        return ResponseEntity.ok(estatisticas);
    }
}
