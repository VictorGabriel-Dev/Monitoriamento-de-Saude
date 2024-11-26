package Model;

public class Consulta {
    private String data;
    private String hora;
    private Medico medico;
    private Paciente paciente;
    private String diagnostico;
    private String prescricao;

    public Consulta(String data, String hora, Medico medico, Paciente paciente, String diagnostico, String prescricao) {
        this.data = data;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }
}
