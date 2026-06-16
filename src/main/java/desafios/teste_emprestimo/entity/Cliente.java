package desafios.teste_emprestimo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private Integer age;
    private String cpf;
    private String name;
    private float income;
    private String location;

}
