package nl.dpa.simplecalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CALCULATION")
public class Calculation {

    public Calculation(Integer first, Integer second, Operand operand) {
        this.first = first;
        this.second = second;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NUMBER")
    private Integer first;

    @Column(name = "SECOND_NUMBER")
    private Integer second;

    @Column(name = "OPERAND")
    private Operand operand;

}
