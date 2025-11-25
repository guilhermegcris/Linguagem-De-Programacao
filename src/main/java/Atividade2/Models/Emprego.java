package Atividade2.Models;

public class Emprego {

    private int id;
    private String empresa;
    private String cargo;
    private double salario;

    public Emprego() {}

    public Emprego(String empresa, String cargo, double salario) {
        this.empresa = empresa;
        this.cargo = cargo;
        this.salario = salario;
    }

    // GETTERS E SETTERS
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
}
