package nl.dpa.simplecalculator.controller;

import nl.dpa.simplecalculator.dto.CalculationDto;
import nl.dpa.simplecalculator.model.Calculation;
import nl.dpa.simplecalculator.service.SimpleCalculator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/calculate")
public class CalculateController {

    private final SimpleCalculator simpleCalculator;

    public CalculateController(SimpleCalculator simpleCalculator) {
        this.simpleCalculator = simpleCalculator;
    }

    @PostMapping("/add")
    public ResponseEntity<Double> add(@RequestBody CalculationDto calculationDto) {
        return ResponseEntity.ok(simpleCalculator.add(calculationDto.getFirst(), calculationDto.getSecond()));
    }

    @PostMapping("/subtract")
    public ResponseEntity<Double> subtract(@RequestBody CalculationDto calculationDto) {
        return ResponseEntity.ok(simpleCalculator.subtract(calculationDto.getFirst(), calculationDto.getSecond()));
    }

    @PostMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestBody CalculationDto calculationDto) {
        return ResponseEntity.ok(simpleCalculator.multiply(calculationDto.getFirst(), calculationDto.getSecond()));
    }

    @PostMapping("/divide")
    public ResponseEntity<Double> divide(@RequestBody CalculationDto calculationDto) {
        return ResponseEntity.ok(simpleCalculator.divide(calculationDto.getFirst(), calculationDto.getSecond()));
    }

    @GetMapping("/history")
    public ResponseEntity<List<Calculation>> history() {
        return ResponseEntity.ok(simpleCalculator.history());
    }
}
