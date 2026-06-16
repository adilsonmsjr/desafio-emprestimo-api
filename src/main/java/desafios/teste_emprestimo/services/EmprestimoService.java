package desafios.teste_emprestimo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import desafios.teste_emprestimo.dto.EmprestimoDTO;
import desafios.teste_emprestimo.dto.RequestDTO;
import desafios.teste_emprestimo.dto.ResponseDTO;
import desafios.teste_emprestimo.entity.Cliente;
import desafios.teste_emprestimo.enums.EmprestimosEnums;

@Service
public class EmprestimoService {

    public ResponseDTO criarCliente(RequestDTO dto){

        Cliente cliente = new Cliente();

        cliente.setAge(dto.getAge());
        cliente.setCpf(dto.getCpf());
        cliente.setName(dto.getName());
        cliente.setIncome(dto.getIncome());
        cliente.setLocation(dto.getLocation());      

        return respCliente(dto);

    }

    public ResponseDTO respCliente(RequestDTO dto){

        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setName(dto.getName());

        List<EmprestimoDTO> emprestimos = new ArrayList<>();

        EmprestimoDTO pessoal = verificarPessoal(dto);
        if (pessoal != null){
            emprestimos.add(pessoal);
        }
        EmprestimoDTO consignado = verificarConsignado(dto);
        if (consignado != null){
            emprestimos.add(consignado);
        }
        EmprestimoDTO garantido = verificarGarantia(dto);
        if (garantido != null){
            emprestimos.add(garantido);
        }

        responseDTO.setEmprestimo(emprestimos);
        

        return responseDTO;

    }




    public EmprestimoDTO verificarPessoal(RequestDTO dto){
        EmprestimoDTO emprestimoDTO = new EmprestimoDTO();
        EmprestimosEnums emprestimosEnums = EmprestimosEnums.PERSONAL;

        if(dto.getIncome() <= 3000 
                || dto.getIncome() >= 3000 && dto.getIncome() <= 5000 && dto.getAge() < 30){
            emprestimoDTO.setTipoEmprestimo(emprestimosEnums.getTipoEmprestimo());
            emprestimoDTO.setTaxaJuros(emprestimosEnums.getTaxaJuros());
            return emprestimoDTO;
        }else{
                return null;
        }    
        
        
    }

    public EmprestimoDTO verificarGarantia(RequestDTO dto){
        EmprestimoDTO emprestimoDTO = new EmprestimoDTO();
        EmprestimosEnums emprestimosEnums = EmprestimosEnums.GUARANTEED;

        if(dto.getIncome() <= 3000 
                || dto.getIncome() >= 3000 && dto.getIncome() <= 5000 && dto.getAge() < 30 && dto.getLocation().equals("SP")){
            emprestimoDTO.setTipoEmprestimo(emprestimosEnums.getTipoEmprestimo());
            emprestimoDTO.setTaxaJuros(emprestimosEnums.getTaxaJuros());
            return emprestimoDTO;
        }else{
                return null;
        }    
    }


    public EmprestimoDTO verificarConsignado(RequestDTO dto){
        EmprestimoDTO emprestimoDTO = new EmprestimoDTO();
        EmprestimosEnums emprestimosEnums = EmprestimosEnums.CONSIGNMENT;

        if(dto.getIncome() >= 5000){
            emprestimoDTO.setTipoEmprestimo(emprestimosEnums.getTipoEmprestimo());
            emprestimoDTO.setTaxaJuros(emprestimosEnums.getTaxaJuros());
            return emprestimoDTO;
        }else{
                return null;
        }    
    }





}
