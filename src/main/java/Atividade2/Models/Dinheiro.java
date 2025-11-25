package Atividade2.Models;

public class Dinheiro {

    private int id;
    private double salario;
    private String poderAquisitivo;
    private String moeda;

    public Dinheiro() {}

    public Dinheiro(double salario, String poderAquisitivo, String moeda) {
        this.salario = salario;
        this.poderAquisitivo = poderAquisitivo;
        this.moeda = moeda;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public String getPoderAquisitivo() { return poderAquisitivo; }
    public void setPoderAquisitivo(String poderAquisitivo) { this.poderAquisitivo = poderAquisitivo; }

    public String getMoeda() { return moeda; }
    public void setMoeda(String moeda) { this.moeda = moeda; }
}
