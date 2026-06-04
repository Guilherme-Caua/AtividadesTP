package br.edu.fatecpg.abstracao.model;

public class Medico {
   
    public String nome;
    public String crm;
    public String especialidade;
    public String hospital_atual;
   
    public void diagnosticar() {
        System.out.println("Diagnosticando paciente...");
        System.out.println("Paciente diagnosticado com êxito.");
    }
    public void prescreverMedicamento() {
        System.out.println("Prescrevendo medicamento para paciente...");
        System.out.println("Medicamento prescrevido com êxito.");
    }
    public void requisitarExame() {
        System.out.println("Requisitando exame para paciente...");
        System.out.println("Exame requisitado com êxito.");
    }
}
