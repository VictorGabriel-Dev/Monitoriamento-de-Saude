

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.Medico;
import model.UsuarioRepositorio;

public class CadastrarMedicoTest {
    private UsuarioRepositorio repositorio;
    private Medico medico = new Medico(
            "Joao", 
            "joao@o.com", 
            "123456", 
            "Cirurgiao", 
            "000006", 
            "11988888888");


    @Before
    public void setup(){
        repositorio = UsuarioRepositorio.getInstance();
        repositorio.getUsuarios().clear();
        repositorio.adicionarUsuario(medico);
    }
    @Test
    public void testCadastroMedico(){
        assertEquals(medico, repositorio.getUsuarios().get(0));
    }
    @Test
    public void testVerificarSeCrmExiste(){
        assertTrue(repositorio.verificarSeCrmExiste("000006"));
    }

    @Test
    public void testVerificarSeEmailExiste(){
        assertTrue(repositorio.verificaSeEmailExiste("joao@o.com"));
    }
}