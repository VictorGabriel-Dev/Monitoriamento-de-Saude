package model;

public class Diagnostico {

    private String diagnostico;

    public Diagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    @Override
    public String toString() {
        return diagnostico;
    }
}
