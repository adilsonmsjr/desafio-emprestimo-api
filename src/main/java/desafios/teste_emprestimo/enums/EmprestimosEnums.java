package desafios.teste_emprestimo.enums;



public enum  EmprestimosEnums {
    PERSONAL("Personal", 2),
    GUARANTEED("Guaranteed", 3),
    CONSIGNMENT("Consignment", 5);

    private String tipoEmprestimo;
    private Integer taxaJuros;

    EmprestimosEnums(String tipoEmprestimo, int taxaJuros){
        this.tipoEmprestimo = tipoEmprestimo;
        this.taxaJuros = taxaJuros;
    }

    public String getTipoEmprestimo(){
        return tipoEmprestimo;
    }

    public int getTaxaJuros(){
        return taxaJuros;
    }





}
