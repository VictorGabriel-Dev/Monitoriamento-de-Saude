# Plano de Teste: Sistema de Monitoramento e Gestão de Saúde

## 1. Objetivo do Teste
Garantir que o sistema de monitoramento e gestão de saúde funcione corretamente, atendendo aos requisitos funcionais e não funcionais, com ênfase em:
- Precisão dos dados vitais
- Integridade das informações de pacientes, médicos e dispositivos
- Eficiência na geração de diagnósticos e alertas

## 2. Escopo do Teste
### Funcionalidades do Paciente:
- Registro, consulta, atualização de dados, consulta de histórico e agendamento de consultas.

### Funcionalidades do Médico:
- Registro, consulta, atualização de dados, ajuste de planos e prescrições médicas.

### Gerenciamento de Medicamentos:
- Prescrição, ajuste de dosagem, cancelamento e consulta de medicamentos.

### Monitoramento de Pacientes:
- Visualização de dados de dispositivos, análise de monitoramento e geração de alertas.

### Alertas:
- Geração, consulta e encerramento de alertas de anormalidades ou emergências.

### Dispositivos:
- Cadastro, consulta e remoção de dispositivos.

## 3. Estratégia de Teste
### Tipo de Teste:
- **Teste Unitário**: Validar funções e métodos individuais, como registro de paciente e geração de alertas.

## 4. Ferramentas e Requisitos de Teste
- **Ferramenta de Teste**: JUnit
- **Ambiente de Execução**: Terminal
- **Dependências**:
  - Java Development Kit (JDK 17 ou superior)
  - Configuração adequada do projeto com JUnit
  - Classes e métodos seguindo as boas práticas para facilitar a testabilidade

## Cenários de Teste

### 1. Paciente

#### Registrar um Paciente
- **Sucesso**: O usuário fornece todos os dados válidos (Nome, CPF, Data de Nascimento, etc.), e o paciente é registrado no sistema com sucesso.
- **Alternativo**:
  - **Cenário 1**: O usuário fornece apenas os dados obrigatórios (Nome, CPF, Data de Nascimento). O paciente é registrado com os campos opcionais como valores padrão ou em branco.
  - **Cenário 2**: O usuário fornece todos os dados válidos, seleciona "Editar registro", edita um campo, confirma e o paciente é registrado com sucesso.
  - **Cenário 3**: O usuário fornece todos os dados válidos e seleciona "Cancelar Registro", as informações são apagadas e uma mensagem "Registro Cancelado" é exibida.
- **Negativo**:
  - **Cenário 1**: O usuário fornece um CPF inválido ou deixa campos obrigatórios em branco. O sistema exibe uma mensagem de erro e não registra o paciente.

#### Consultar Histórico do Paciente
- **Sucesso**: O paciente possui um histórico registrado, e ao fornecer o CPF válido, o sistema exibe o histórico detalhado.
- **Alternativo**: Se o paciente não tiver histórico, o sistema informa que não há histórico disponível.
- **Negativo**: Caso o CPF fornecido seja inválido, o sistema exibe uma mensagem de erro.

#### Atualizar Dados do Paciente
- **Sucesso**: O paciente está registrado e o usuário atualiza os dados válidos, o sistema realiza a atualização com sucesso.
- **Alternativo**: O sistema aceita a atualização de campos opcionais para valores em branco.
- **Negativo**:
  - **Cenário 1**: O usuário tenta atualizar campos obrigatórios para valores em branco. O sistema exibe uma mensagem de erro.
  - **Cenário 2**: O usuário tenta atualizar campos com valores inválidos. O sistema exibe uma mensagem de erro.

#### Consultar Dados do Paciente
- **Sucesso**: O sistema exibe os dados do paciente registrado quando o CPF é fornecido corretamente.
- **Alternativo**:
  - **Cenário 1**: O usuário busca por Nome e o sistema exibe os pacientes correspondentes.
  - **Cenário 2**: O usuário busca por Data de Nascimento e o sistema exibe os pacientes correspondentes.
- **Negativo**:
  - **Cenário 1**: O usuário insere um CPF inexistente ou inválido, e o sistema exibe uma mensagem de erro.
  - **Cenário 2**: O usuário insere um Nome não registrado, e o sistema exibe uma mensagem de erro.

### 2. Médico

#### Registrar um Médico
- **Sucesso**: O usuário fornece todos os dados válidos (Nome, CRM, E-mail, etc.), e o médico é registrado com sucesso.
- **Alternativo**:
  - **Cenário 1**: O usuário insere apenas os dados obrigatórios, e o médico é registrado com os campos opcionais como valores padrão ou em branco.
  - **Cenário 2**: O usuário seleciona "Editar registro" e altera um campo. O sistema registra o médico com sucesso.
  - **Cenário 3**: O usuário seleciona "Cancelar Registro", e as informações são apagadas com uma mensagem "Registro Cancelado".
- **Negativo**:
  - **Cenário 1**: Os campos obrigatórios fornecidos são inválidos. O sistema exibe uma mensagem de erro.
  - **Cenário 2**: Campos obrigatórios estão vazios. O sistema exibe uma mensagem de erro.
  - **Cenário 3**: O e-mail já existe no sistema. O sistema exibe uma mensagem de erro.

#### Alterar Dados do Médico
- **Sucesso**: O médico atualiza os campos válidos e o sistema realiza a atualização com sucesso.
- **Alternativo**: O sistema aceita a atualização de campos opcionais para valores em branco.
- **Negativo**:
  - **Cenário 1**: O usuário tenta atualizar campos obrigatórios para valores em branco ou inválidos. O sistema exibe uma mensagem de erro.

#### Consultar Dados do Médico
- **Sucesso**: O sistema exibe os dados do médico registrado ao fornecer o CRM válido.
- **Alternativo**:
  - **Cenário 1**: O sistema exibe os médicos registrados ao buscar por Nome ou Especialidade.
- **Negativo**:
  - **Cenário 1**: O sistema exibe uma mensagem de erro caso o CRM, Nome ou Especialidade não sejam encontrados.

#### Ajustar Plano do Paciente
- **Sucesso**: O médico ajusta o plano do paciente com sucesso.
- **Alternativo**: Se o paciente não tiver plano configurado, o sistema permite a criação de um novo plano.
- **Negativo**: Caso o CPF do paciente ou CRM do médico não existam no sistema, o ajuste do plano não é permitido.

### 3. Agendamento de Consultas

#### Realizar Agendamento
- **Sucesso**: O paciente e o médico estão registrados, e ao fornecer dados válidos (data e hora), o sistema exibe uma mensagem de sucesso.
- **Alternativo**:
  - **Cenário 1**: O usuário edita um agendamento existente e o sistema exibe uma mensagem de sucesso.
  - **Cenário 2**: O usuário cancela o agendamento e o sistema exibe uma mensagem de cancelamento.
- **Negativo**:
  - **Cenário 1**: O usuário fornece uma data ou hora inválida, e o sistema exibe uma mensagem de erro.
  - **Cenário 2**: O CPF do paciente ou CRM do médico não existem no sistema, e o sistema exibe uma mensagem de erro.

#### Consultar Agendamento
- **Sucesso**: O paciente consulta o agendamento utilizando o ID da consulta ou a data.
- **Negativo**:
  - **Cenário 1**: O paciente não tem consulta agendada, e o sistema exibe uma mensagem de erro.
  - **Cenário 2**: O usuário fornece um campo de busca vazio, e o sistema exibe uma mensagem de erro.

#### Registrar Diagnóstico
- **Sucesso**: O diagnóstico é registrado com sucesso após a consulta.
- **Alternativo**: O diagnóstico é adicionado retroativamente após a consulta ter sido realizada.
- **Negativo**: O sistema exibe uma mensagem de erro caso o médico tente registrar um diagnóstico para uma consulta inexistente.

#### Registrar Prescrição
- **Sucesso**: O sistema salva a prescrição associando-a à consulta e ao paciente.
- **Alternativo**:
  - **Cenário 1**: O sistema alerta sobre alergias do paciente antes de confirmar a prescrição.
  - **Cenário 2**: O sistema avisa sobre uma prescrição ativa para o mesmo medicamento.
- **Negativo**: O sistema exibe uma mensagem de erro caso a consulta não esteja registrada ou os campos de prescrição estejam incompletos.

#### Prescrever Medicamento
- **Sucesso**: O medicamento é prescrito com sucesso após a consulta registrada.
- **Alternativo**: O sistema solicita a criação de uma consulta caso o paciente não tenha uma registrada.
- **Negativo**: O sistema exibe uma mensagem de erro caso os dados do medicamento sejam inválidos.

#### Ajustar Dosagem
- **Sucesso**: O sistema atualiza a dosagem com sucesso.
- **Alternativo**: O sistema ajusta a dosagem de uma prescrição ativa.
- **Negativo**: O sistema exibe uma mensagem de erro caso a dosagem seja inválida ou a prescrição tenha sido cancelada.

## 5. Conclusão
A realização desses testes visa garantir que o sistema de monitoramento e gestão de saúde ofereça um serviço eficiente, seguro e confiável para médicos e pacientes.
