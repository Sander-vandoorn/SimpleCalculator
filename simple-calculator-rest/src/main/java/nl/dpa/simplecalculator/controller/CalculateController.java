package nl.dpa.simplecalculator.controller;

import nl.dpa.simplecalculator.dto.CalculationDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculate")
public class CalculateController {

    @PostMapping("/add")
    public ResponseEntity<Double> add(CalculationDto calculationDto) {
        return ResponseEntity.ok(Double.MAX_VALUE);
    }
}
