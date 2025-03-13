package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;

import utils.IdGenerator;

public class Consulta {
    private String idConsulta;
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
    private Paciente paciente;
    private Medico medico;
    private List<Diagnostico> diagnostico;
    private List<Medicamento> prescricao;

    public Consulta(LocalDate dataConsulta, LocalTime horaConsulta, Paciente paciente, Medico medico,
            List<String> diagnostico, List<Medicamento> prescricao) {
        this.idConsulta = new IdGenerator().gerarIdConsulta();
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.medico = medico;
        this.paciente = paciente;
        this.diagnostico = new ArrayList<>();
        this.prescricao = new ArrayList<>();
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public LocalTime getHoraConsulta() {
        return horaConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public List<Diagnostico> getDiagnostico() {
        return diagnostico;
    }

    public List<Medicamento> getPrescricao() {
        return prescricao;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public void setHoraConsulta(LocalTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setDiagnostico(List<Diagnostico> diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setPrescricao(List<Medicamento> prescricao) {
        this.prescricao = prescricao;
    }

    public void adicionarMedicamento(Medicamento medicamento) {
        this.prescricao.add(medicamento);
    }
}