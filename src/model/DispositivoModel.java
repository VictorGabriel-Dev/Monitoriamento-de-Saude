package model;

public class DispositivoModel {
    private String tipo;
    private String marca;
    private String modelo;
    private String status;
    private double valor;

    public DispositivoModel(String tipo, String marca, String modelo, String status, double valor){
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.status = status;
        this.valor = valor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}