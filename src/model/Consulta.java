package model;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import utils.IdGenerator;
public class Consulta {
    private String idConsulta; 
    private LocalDate dataConsulta;
    private String horaConsulta;
    private Paciente paciente;
    private Medico medico;
    private List<String> diagnostico;
    private String prescricao;

    public Consulta(LocalDate dataConsulta, String horaConsulta, Paciente paciente, Medico medico, List<String> diagnostico, String prescricao) {
        this.idConsulta = new IdGenerator().gerarIdConsulta();
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.medico = medico;
        this.paciente = paciente;
        this.diagnostico = new ArrayList<>();
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
    public List<String> getDiagnostico() {
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
    public void setDiagnostico(List<String> diagnostico) {
        this.diagnostico = diagnostico;
    }
    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }
    public void adicionarDiagnostico(String diagnostico) {
        this.diagnostico.add(diagnostico);
    }
    public void alterarDiagnostico(int indice, String novoDiagnostico) {
        if (indice >= 0 && indice < diagnostico.size()) {
            diagnostico.set(indice, novoDiagnostico);
        }
    }
}