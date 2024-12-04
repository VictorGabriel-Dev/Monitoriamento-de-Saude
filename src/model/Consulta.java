package model;
import java.time.LocalDate;
import utils.IdGenerator;
public class Consulta {
    private String idConsulta; 
    private LocalDate dataConsulta;
    private String horaConsulta;
    private Paciente paciente;
    private Medico medico;
    private String diagnostico;
    private String prescricao;

    public Consulta(LocalDate dataConsulta, String horaConsulta, Paciente paciente, Medico medico, String diagnostico, String prescricao) {
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
    public LocalDate getDataConsulta() {
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
    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }
    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

}