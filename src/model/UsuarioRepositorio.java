package model;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio {
    private static UsuarioRepositorio instance;
    private List<UsuarioModel> usuarios = new ArrayList<>();
    public static UsuarioRepositorio getInstance() {
        if (instance == null) {
            instance = new UsuarioRepositorio();
        }
        return instance;
    }

    public List<UsuarioModel> getUsuario() {
        return usuarios;
    }

    public void adicionarUsuario(UsuarioModel usuario) {
        this.usuarios.add(usuario);
    }
    public boolean usuarioComEmailExiste(String email) {
        for (UsuarioModel usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean pacienteComCpfExiste(String cpf) {
        for (UsuarioModel usuario : usuarios) {
            if (usuario instanceof Paciente) {
                Paciente paciente = (Paciente) usuario;
                if (paciente.getCpf().equals(cpf)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean medicoComCrmExiste(String crm) {
        for (UsuarioModel usuario : usuarios) {
            if (usuario instanceof Medico) {
                Medico medico = (Medico) usuario;
                if (medico.getCrm().equals(crm)) {
                    return true;
                }
            }
        }
        return false;
    }
    public void exibirDadosMedico() {
        for (UsuarioModel usuario : usuarios) {
            if (usuario instanceof Medico) {
                Medico medico = (Medico) usuario;  // Faça o cast do usuário para Medico
                System.out.println("Nome: " + medico.getNome());
                System.out.println("CRM: " + medico.getCrm());
                System.out.println("Especialidade: " + medico.getEspecialidade());
                System.out.println("Email: " + medico.getEmail());
                System.out.println("Telefone: " + medico.getTelefone());
            }
        }
    }
    
}
