package Model;

    public class Medico extends Usuario{
        private String especialidade;
        private String crm;

        public Medico (String nome, String especialidade, String crm, String email, String telefone){
            super(nome,email,telefone);
            this.especialidade = especialidade;
            this.crm = crm;
        }

        public String getEspecialidade() {
            return especialidade;
        }

        public String getCrm() {
            return crm;
        }
    }

