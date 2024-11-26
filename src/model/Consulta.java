package model;
import utils.IdGenerator;
public class Consulta {
    private String idConsulta; 
    private String dataConsulta;
    private String horaConsulta;
    private Paciente paciente;
    private Medico medico;
    private String diagnostico;
    private String prescricao;

    public Consulta(String dataConsulta, String horaConsulta, Paciente paciente, Medico medico, String diagnostico, String prescricao) {
        this.idConsulta = new IdGenerator().gerarIdConsulta();
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.medico = medico;
        this.paciente = paciente;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
    }
    public String getIdConsulta() {
        return idConsulta;
    }
    public String getDataConsulta() {
        return dataConsulta;
    }
    public String getHoraConsulta() {
        return horaConsulta;
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