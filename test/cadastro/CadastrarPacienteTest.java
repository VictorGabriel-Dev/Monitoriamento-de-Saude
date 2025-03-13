import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import model.Paciente;
import model.UsuarioRepositorio;
import utils.Validacao;

public class CadastrarPacienteTest {
    private UsuarioRepositorio repositorio;
    private Paciente paciente = new Paciente(
            "Kevin",
            "kevin@o.com",
            "(51) 98179-7376",
            "123456",
            "12345678910",
            LocalDate.of(2000, 1, 1),
            "Rua A, 123",
            new ArrayList<>(),
            new ArrayList<>(),
            null);
    private Paciente paciente2 = new Paciente(
            "Kevin",
            "kevin2@o.com",
            "(51) 98179-7376",
            "123456",
            "12345678910",
            LocalDate.of(2000, 1, 1),
            "Rua A, 123",
            new ArrayList<>(),
            new ArrayList<>(),
            null);
    private Paciente paciente3 = new Paciente(
            "Kevin",
            "kevin@o.com",
            "(51) 98179-7376",
            "123456",
            "12345678910",
            LocalDate.of(2000, 1, 1),
            "Rua A, 123",
            new ArrayList<>(),
            new ArrayList<>(),
            null);

    @Before
    public void setup() {
        repositorio = UsuarioRepositorio.getInstance();
        repositorio.getUsuarios().clear();
        repositorio.adicionarUsuario(paciente);
        repositorio.adicionarUsuario(paciente2);
        repositorio.adicionarUsuario(paciente3);
    }

    @Test
    public void testCadastroPaciente() {
        assertEquals(paciente, repositorio.getUsuarios().get(0));
    }

    @Test
    public void testVerificarSeEmailExiste() {
        assertTrue(repositorio.verificaSeEmailExiste(paciente.getEmail()));
    }

    @Test
    public void testEmailInvalida() {
        assertFalse(Validacao.validarEmail("kevin.com"));
        assertFalse(Validacao.validarEmail("kevin@o"));
    }

    @Test
    public void testVerificarSeTelefoneEstaOuNaoFormatado() {
        assertTrue(Validacao.validarTelefone(paciente.getTelefone()));
        assertFalse(Validacao.validarTelefone("(51)12345678"));
    }

    @Test
    public void testTelefoneInvalido() {
        assertFalse(Validacao.validarTelefone("(51) 12345678"));
        assertFalse(Validacao.validarTelefone("(51) 12345678910"));
    }

    @Test
    public void testVerificarSeSenhaEstaOuNaoFormatada() {
        assertTrue(Validacao.validarSenha(paciente.getSenha()));
        assertFalse(Validacao.validarSenha("12345"));
    }

    @Test
    public void testVerificarSeCpfEstaOuNaoCadastrado() {
        assertTrue(repositorio.verificarSeCpfExiste(paciente.getCpf()));
        assertFalse(repositorio.verificarSeCpfExiste("12345678911"));
    }

    @Test
    public void testCpfInvalido() {
        assertFalse(Validacao.validarCpf("123"));
        assertFalse(Validacao.validarCpf("123456"));
    }

    @Test
    public void testVerificarSeCpfEstaComOTamanhoCorreto() {
        assertTrue(Validacao.validarCpf(paciente.getCpf()));
    }

    @Test
    public void testCpfDuplicado() {
        assertTrue(repositorio.verificarSeCpfExiste(paciente2.getCpf()));
    }

    @Test
    public void testEmailDuplicado() {
        assertTrue(repositorio.verificaSeEmailExiste(paciente3.getEmail()));
    }
}