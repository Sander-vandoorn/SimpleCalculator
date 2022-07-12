package nl.dpa.simplecalculator.service;

import nl.dpa.simplecalculator.model.Calculation;
import nl.dpa.simplecalculator.model.Operand;
import nl.dpa.simplecalculator.repository.CalculationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleCalculator {

    private final CalculationRepository calculationRepository;

    public SimpleCalculator(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    public Double add(Integer first, Integer second) {
        Calculation calculation = new Calculation(first, second, Operand.ADD);
        calculation.setResult(calculate(calculation));
        calculationRepository.save(calculation);
        return calculation.getResult();
    }

    public Double subtract(Integer first, Integer second) {
        Calculation calculation = new Calculation(first, second, Operand.SUBTRACT);
        calculation.setResult(calculate(calculation));
        calculationRepository.save(calculation);
        return calculation.getResult();
    }

    public Double multiply(Integer first, Integer second) {
        Calculation calculation = new Calculation(first, second, Operand.MULTIPLY);
        calculation.setResult(calculate(calculation));
        calculationRepository.save(calculation);
        return calculation.getResult();
    }

    public Double divide(Integer first, Integer second) {
        Calculation calculation = new Calculation(first, second, Operand.DIVIDE);
        calculation.setResult(calculate(calculation));
        calculationRepository.save(calculation);
        return calculation.getResult();
    }

    public List<Calculation> history() {
        return calculationRepository.findAll();
    }

    private Double calculate(Calculation calculation) {
        switch(calculation.getOperand()) {
            case ADD:
                return (double) calculation.getFirst() + calculation.getSecond();
            case SUBTRACT:
                return (double) calculation.getFirst() - calculation.getSecond();
            case MULTIPLY:
                return (double) calculation.getFirst() * calculation.getSecond();
            case DIVIDE:
                return (double) calculation.getFirst() / calculation.getSecond();
            default:
                throw new IllegalArgumentException();
        }
    }
}
