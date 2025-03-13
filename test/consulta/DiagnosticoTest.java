
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Consulta;
import model.Diagnostico;
import model.Medico;
import model.Paciente;

public class DiagnosticoTest {
    private Medico medico;
    private Paciente paciente;
    private Consulta consulta;
    private Diagnostico diagnostico;
    private Consulta consultaInexistente;

    @Before
    public void setup() {
        medico = new Medico("Dr. Test", "dr@test.com", "senha123", "Cardiologia", "CRM123", "11999999999");
        paciente = new Paciente("Paciente Test", "paciente@test.com", "11988888888", "senha123", "123.456.789-00",
                LocalDate.of(1990, 1, 1), "Rua Test", new ArrayList<>(), new ArrayList<>(), "");

        consulta = new Consulta(
                LocalDate.now().plusDays(1),
                LocalTime.of(14, 00),
                paciente,
                medico,
                new ArrayList<>(),
                new ArrayList<>());

        diagnostico = new Diagnostico("Pressão alta");

    }

    @Test
    public void testAdicionarDiagnosticoSucesso() {
        consulta.getDiagnostico().add(diagnostico);
        assertNotNull(consulta.getDiagnostico());
        assertEquals(1, consulta.getDiagnostico().size());
        assertEquals("Pressão alta", consulta.getDiagnostico().get(0).getDiagnostico());
    }

    @Test
    public void testAdicionarDiagnosticoFracasso() {
        consultaInexistente = new Consulta(
                null, 
                null, 
                paciente, 
                medico, 
                new ArrayList<>(), 
                new ArrayList<>());
        assertEquals(0, consultaInexistente.getDiagnostico().size());
        assertEquals(0, consulta.getDiagnostico().size());
    }
}
