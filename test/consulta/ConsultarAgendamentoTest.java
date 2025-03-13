import org.junit.Before;
import org.junit.Test;

import model.Consulta;
import model.Medico;
import model.Paciente;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultarAgendamentoTest {
    private Medico medico;
    private Paciente paciente;
    private List<Consulta> consultas = new ArrayList<>();

    @Before
    public void setup() {
        // Setup test data
        medico = new Medico("Dr. Test", "dr@test.com", "senha123", "Cardiologia", "CRM123", "11999999999");
        paciente = new Paciente("Paciente Test", "paciente@test.com", "11988888888", "senha123", "123.456.789-00",
                LocalDate.of(1990, 1, 1), "Rua Test", new ArrayList<>(), new ArrayList<>(), "");

        Consulta consulta = new Consulta(
                LocalDate.now().plusDays(1),
                LocalTime.of(14, 00),
                paciente,
                medico,
                new ArrayList<>(),
                new ArrayList<>());
        consultas.add(consulta);
        medico.setConsultas(consultas);

    }

    @Test
    public void testConsultarAgendamentosComSucesso() {
        assertTrue(medico.getConsultas() != null && !medico.getConsultas().isEmpty());
        assertEquals(1, medico.getConsultas().size());
        assertEquals("Paciente Test", medico.getConsultas().get(0).getPaciente().getNome());
    }

    @Test
    public void testConsultarAgendamentosVazio() {
        medico.setConsultas(new ArrayList<>());
        assertTrue(medico.getConsultas().isEmpty());
    }

    @Test
    public void testConsultaComDadosCompletos() {
        Consulta consulta = medico.getConsultas().get(0);
        assertNotNull(consulta.getDataConsulta());
        assertNotNull(consulta.getHoraConsulta());
        assertNotNull(consulta.getPaciente());
        assertNotNull(consulta.getMedico());
    }
}
