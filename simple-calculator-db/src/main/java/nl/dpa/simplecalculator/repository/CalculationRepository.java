package nl.dpa.simplecalculator.repository;

import nl.dpa.simplecalculator.model.Calculation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CalculationRepository extends CrudRepository<Calculation, BigInteger> {
}
