package nl.dpa.simplecalculator.service;

import nl.dpa.simplecalculator.model.Calculation;
import nl.dpa.simplecalculator.model.Operand;
import nl.dpa.simplecalculator.repository.CalculationRepository;
import org.springframework.stereotype.Service;

@Service
public class SimpleCalculator {

    private final CalculationRepository calculationRepository;


    public SimpleCalculator(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    public Double add(Integer first, Integer second) {
        calculationRepository.save(new Calculation(first, second, Operand.ADD));
        return (double) (first + second);
    }
}
