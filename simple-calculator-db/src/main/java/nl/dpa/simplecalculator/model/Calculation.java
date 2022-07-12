package nl.dpa.simplecalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "CALCULATION")
@NoArgsConstructor
public class Calculation {

    public Calculation(Integer first, Integer second, Operand operand) {
        this.first = first;
        this.second = second;
        this.operand = operand;
        this.createDatetime = LocalDateTime.now();
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

    @Column(name = "RESULT")
    private Double result;

    @Column(name = "DATETIME_CREATION")
    private LocalDateTime createDatetime;

}
