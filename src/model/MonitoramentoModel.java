package model;
import java.util.*;

public class MonitoramentoModel {
    private Paciente paciente; // Referência ao paciente
    private DispositivoModel dispositivo; // Referência ao dispositivo
    private int bpm; // Batimentos cardíacos
    private int pressaoArterial; // Pressão arterial
    private double temperatura; // Temperatura do paciente
    private Medico medico;

    // Construtor
    public MonitoramentoModel(Paciente paciente, Medico medico, DispositivoModel dispositivo, int bpm, int pressaoArterial, double temperatura){
        this.paciente = paciente;
        this.medico = medico;
        this.dispositivo = dispositivo;
        this.bpm = bpm;
        this.pressaoArterial = pressaoArterial;
        this.temperatura = temperatura;
    }

    // Métodos para visualizar dados de monitoração
    public void visualizarDados(){
        System.out.println("--- Monitoramento do Paciente ---");
        System.out.printf("Paciente: %s\n",paciente.getNome());
        System.out.printf("Medico: %s\n", medico.getNome());
        System.out.printf("Dados do dispositivo: %s\n",dispositivo.getTipo());
        System.out.printf("Frequência Cardíaca: %s bpm\n",bpm);
        System.out.printf("Pressão Arterial: %s bpm\n",pressaoArterial);
        System.out.printf("Temperatura: %s °C\n",temperatura);
    }

    //Metodo encontrar monitoramento
    public static MonitoramentoModel encontrarMonitoramento(List<MonitoramentoModel> monitoramentos, Paciente paciente) {
        for (MonitoramentoModel monitoramento : monitoramentos) {
            if (monitoramento.getPaciente().equals(paciente)) {
                return monitoramento;
            }
        }
        System.out.println("Monitoramento não encontrado para o paciente selecionado.");
        return null;
    }


    // Getters e Setters

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(int pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public DispositivoModel getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(DispositivoModel dispositivo) {
        this.dispositivo = dispositivo;
    }
}
