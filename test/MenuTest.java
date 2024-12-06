public class MenuTest {
    import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

    public class MenuTest {

        private Menu menu;
        private DispositivoView dispositivoViewMock;
        private List<DispositivoModel> dispositivos;

        @Before
        public void setUp() {
            // Mock da view e a lista de dispositivos
            dispositivoViewMock = mock(DispositivoView.class);
            dispositivos = new ArrayList<>();

            // Cria uma instância do Menu com o mock da view
            menu = new Menu(dispositivoViewMock, new Scanner(System.in));
            menu.setDispositivos(dispositivos); // Define a lista de dispositivos
        }

        @Test
        public void testCadastrarDispositivo() {
            // Mock para os retornos dos métodos da DispositivoView
            when(dispositivoViewMock.selecionarTipo()).thenReturn(new String[]{"Sensor", "Celsius"});
            when(dispositivoViewMock.selecionarStatus()).thenReturn("Ativo");
            when(dispositivoViewMock.solicitarEntrada("Marca:")).thenReturn("MarcaTeste");
            when(dispositivoViewMock.solicitarEntrada("Modelo:")).thenReturn("ModeloTeste");
            when(dispositivoViewMock.solicitarValor("Valor apresentado em Celsius:")).thenReturn(100.0);

            // Chama o método cadastrarDispositivo
            menu.cadastrarDispositivo();

            // Verifica se o dispositivo foi adicionado à lista
            assertEquals(1, dispositivos.size()); // Verifica se a lista de dispositivos tem 1 elemento
            DispositivoModel dispositivo = dispositivos.get(0);
            assertEquals("Sensor", dispositivo.getTipo());
            assertEquals("MarcaTeste", dispositivo.getMarca());
            assertEquals("ModeloTeste", dispositivo.getModelo());
            assertEquals("Ativo", dispositivo.getStatus());
            assertEquals(100.0, dispositivo.getValor(), 0.0); // Verifica se o valor foi corretamente atribuído

            // Verifica se a mensagem de sucesso foi exibida
            verify(dispositivoViewMock, times(1)).exibirMensagem("Dispositivo cadastrado com sucesso!");
        }

        @Test
        public void testCadastrarDispositivoComStatusInativo() {
            // Mock para os retornos dos métodos da DispositivoView com status "Inativo"
            when(dispositivoViewMock.selecionarTipo()).thenReturn(new String[]{"Sensor", "Celsius"});
            when(dispositivoViewMock.selecionarStatus()).thenReturn("Inativo");
            when(dispositivoViewMock.solicitarEntrada("Marca:")).thenReturn("MarcaTeste");
            when(dispositivoViewMock.solicitarEntrada("Modelo:")).thenReturn("ModeloTeste");
            when(dispositivoViewMock.solicitarValor("Valor apresentado em Celsius:")).thenReturn(0.0);

            // Chama o método cadastrarDispositivo
            menu.cadastrarDispositivo();

            // Verifica se o dispositivo foi adicionado à lista
            assertEquals(1, dispositivos.size());
            DispositivoModel dispositivo = dispositivos.get(0);
            assertEquals("Sensor", dispositivo.getTipo());
            assertEquals("MarcaTeste", dispositivo.getMarca());
            assertEquals("ModeloTeste", dispositivo.getModelo());
            assertEquals("Inativo", dispositivo.getStatus());
            assertEquals(0.0, dispositivo.getValor(), 0.0); // Verifica se o valor é 0.0 para status "Inativo"

            // Verifica se a mensagem de sucesso foi exibida
            verify(dispositivoViewMock, times(1)).exibirMensagem("Dispositivo cadastrado com sucesso!");
        }
    }

}
