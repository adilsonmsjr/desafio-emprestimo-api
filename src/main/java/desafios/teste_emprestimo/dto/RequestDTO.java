package desafios.teste_emprestimo.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {

    private Integer age;
    private String cpf;
    private String name;
    private float income;
    private String location;
    
}
