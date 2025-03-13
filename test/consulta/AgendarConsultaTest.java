import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Consulta;
import model.Medico;
import model.Paciente;
import controller.ConsultaController;
import model.UsuarioRepositorio;

public class AgendarConsultaTest {
    private Paciente paciente;
    private Medico medico;
    private ConsultaController consultas;
    private UsuarioRepositorio repositorio;
    private Consulta consulta;

    @Before
    public void setup() {
        paciente = new Paciente(
                "Paciente Test",
                "paciente@test.com",
                "11988888888",
                "senha123",
                "123.456.789-00",
                LocalDate.of(1990, 1, 1),
                "Rua Test", new ArrayList<>(), new ArrayList<>(),
                "");

        medico = new Medico(
                "Dr. Test",
                "dr@test.com",
                "senha123",
                "Cardiologia",
                "CRM123",
                "11999999999");
        repositorio = UsuarioRepositorio.getInstance();
        repositorio.adicionarUsuario(medico);
        consultas = new ConsultaController(paciente);

        consulta = new Consulta(
                LocalDate.now().plusDays(1),
                LocalTime.of(8, 00),
                paciente,
                medico,
                new ArrayList<>(),
                new ArrayList<>());
    }

    @Test
    public void testAgendarConsulta() {
        consultas.confirmarConsulta(consulta);
        List<Consulta> historicoMedico = paciente.getHistoricoMedico();
        assertNotNull(historicoMedico);
        assertEquals(1, historicoMedico.size());
    }

    @Test
    public void testCancelarConsulta() {
        consultas.cancelarConsulta(consulta);
        List<Consulta> historicoMedico = paciente.getHistoricoMedico();
        assertNotNull(historicoMedico);
        assertEquals(0, historicoMedico.size());
    }

    @Test
    public void testAgendarConsultaComDataPassado() {
        LocalDate dataPassada = LocalDate.now().minusDays(1);
        Consulta consultaPassada = new Consulta(
                dataPassada,
                LocalTime.of(8, 00),
                paciente,
                medico,
                new ArrayList<>(),
                new ArrayList<>());
        assertTrue(consultaPassada.getDataConsulta().isBefore(LocalDate.now()));
        consultas.confirmarConsulta(consultaPassada);
        List<Consulta> historicoMedico = paciente.getHistoricoMedico();
        assertEquals(0, historicoMedico.size());
    }

    @Test
    public void testAgendarConsultaComHoraInvalida() {
        LocalTime horaInvalida = LocalTime.of(17, 30);
        Consulta consultaInvalida = new Consulta(
                LocalDate.now().plusDays(1),
                horaInvalida,
                paciente,
                medico,
                new ArrayList<>(),
                new ArrayList<>());
        assertTrue(consultaInvalida.getHoraConsulta().isAfter(LocalTime.of(17, 00)));
        consultas.confirmarConsulta(consultaInvalida);
        List<Consulta> historicoMedico = paciente.getHistoricoMedico();
        assertEquals(0, historicoMedico.size());
    }

    @Test
    public void testAgendarConsultaSemMedicoDiponivel() {
        consulta = new Consulta(
                LocalDate.now().plusDays(1),
                LocalTime.of(8, 00),
                paciente,
                null,
                new ArrayList<>(),
                new ArrayList<>());
        List<Consulta> historicoMedico = paciente.getHistoricoMedico();
        assertEquals(0, historicoMedico.size());
        assertNull(consulta.getMedico());
    }
}
