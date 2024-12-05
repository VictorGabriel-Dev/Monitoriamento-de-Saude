package model;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio {
    private static UsuarioRepositorio instance;
    private List<UsuarioModel> usuarios = new ArrayList<>();

    private UsuarioRepositorio() {}

    public static UsuarioRepositorio getInstance() {
        if (instance == null) {
            instance = new UsuarioRepositorio();
        }
        return instance;
    }

    public void adicionarUsuario(UsuarioModel usuario) {
        usuarios.add(usuario);
    }

    public List<UsuarioModel> getUsuarios() {
        return usuarios;
    }
    public boolean verificaSeEmailExiste(String email) {
        for (UsuarioModel usuario : usuarios) {
            if (usuario.getEmail().trim().equals(email)) {
                return true;
            }
        }
        return false;
    }
    public boolean verificarSeCrmExiste(String crm) {
        for (UsuarioModel usuario : usuarios) {
            if (usuario instanceof Medico && ((Medico) usuario).getCrm().equals(crm)) {
                return true;
            }
        }
        return false;
    }
    public boolean verificarSeCpfExiste(String cpf) {
        for (UsuarioModel usuario : usuarios) {
            if (usuario instanceof Paciente && ((Paciente) usuario).getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

}
