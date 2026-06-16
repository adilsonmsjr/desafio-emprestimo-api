package desafios.teste_emprestimo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafios.teste_emprestimo.dto.RequestDTO;
import desafios.teste_emprestimo.dto.ResponseDTO;
import desafios.teste_emprestimo.services.EmprestimoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService){
        this.emprestimoService = emprestimoService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> criar(@RequestBody RequestDTO dto) {
        
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO = emprestimoService.criarCliente(dto);
        
        return ResponseEntity.ok(responseDTO);
    }
    



    

}
