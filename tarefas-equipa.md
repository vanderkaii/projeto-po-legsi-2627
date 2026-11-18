# Plano de tarefas — Projeto de Programação com Objetos 2026/2027

Substituam “Membro 1”, “Membro 2” e “Membro 3” pelos nomes dos elementos do grupo. As tarefas estão organizadas para poderem avançar em paralelo depois de acordarem as interfaces entre classes.

## Margarida — Habitantes e colónias

- [ ] Implementar `Habitante` como classe abstrata, com ID gerado automaticamente, nome, email institucional, profissão/tipo, .
- [ ] Implementar `Cientista`, `Engenheiro` e `Explorador`, incluindo os atributos específicos indicados no enunciado.
- [ ] Implementar `Colonia`, com ID automático, nome, planeta e a lista de habitantes.
- [ ] Definir e aplicar validações para nomes, emails, profissão, área científica, especialidade técnica e dados da colónia.
- [ ] Implementar a associação entre habitantes e a respetiva colónia, impedindo associações inválidas ou duplicadas.
- [ ] Disponibilizar estatísticas pessoais calculadas a partir dos dados do sistema: missões realizadas e descobertas registadas.
- [ ] Disponibilizar o número de missões concluídas da colónia, calculado a partir das missões associadas.
- [ ] Criar testes ou casos de teste para criação, edição, validação e estatísticas.
- [ ] Atualizar a parte correspondente do UML e explicar aos restantes membros os métodos públicos disponíveis.

**Concluído quando:** os três tipos de habitante e as colónias podem ser criados e validados; as associações e estatísticas refletem os dados reais, sem contadores manuais inconsistentes.

## Clara — Gestores, missões e descobertas

- [ ] Implementar `GestorColonia`, com ID automático, nome, email e missões supervisionadas.
- [ ] Implementar `Missao`, com ID automático, designação, objetivo, equipa participante, gestor responsável e estado.
- [ ] Implementar os estados `Planeada`, `EmCurso` e `Concluida`, incluindo validação das alterações de estado.
- [ ] Implementar `Descoberta`, com ID automático, missão associada, habitante responsável, tipo, data e descrição.
- [ ] Implementar as relações entre missão, colónia, gestor, participantes e descobertas, respeitando o UML e o enunciado.
- [ ] Disponibilizar o número de missões supervisionadas pelo gestor, calculado a partir das missões.
- [ ] Definir regras para adicionar/remover participantes e registar descobertas, preservando a integridade das relações.
- [ ] Criar testes ou casos de teste para estados, participantes, supervisão e descobertas.
- [ ] Atualizar a parte correspondente do UML e explicar aos restantes membros os métodos públicos disponíveis.

**Concluído quando:** é possível gerir uma missão e a sua equipa, alterar o estado e registar descobertas válidas, mantendo as relações e estatísticas coerentes.

## Cláudio — Administrador, interface, autenticação e persistência

- [ ] Implementar `Administrador`, com ID automático, nome e email.
- [ ] Criar a classe de coordenação do sistema para registar, consultar, editar e remover colónias, habitantes, gestores e missões.
- [ ] Implementar a prevenção de duplicados e as regras de remoção, em coordenação com os membros 1 e 2.
- [ ] Implementar autenticação e controlo das operações disponíveis para habitante, gestor e administrador. A equipa deve acordar primeiro como representar as credenciais, pois o enunciado não especifica esse detalhe.
- [ ] Criar a interface de texto com menus para os três perfis e tratamento de entradas inválidas.
- [ ] Implementar gravação do estado do sistema em ficheiro e recuperação dos dados no arranque.
- [ ] Manter `Main` como ponto de entrada e ligar os menus às operações das classes de negócio.
- [ ] Criar testes ou casos de teste para menus, permissões, duplicados e persistência.

**Concluído quando:** os perfis conseguem executar as operações permitidas através da interface de texto e os dados permanecem disponíveis depois de fechar e voltar a abrir o programa.

## Tarefas conjuntas e integração

- [ ] **Antes de programar em paralelo:** acordar os pacotes de negócio e interface, nomes dos métodos, formato/geração dos IDs e regras de validação e duplicação.
- [ ] Acordar como representar a profissão do habitante e as credenciais de autenticação; o enunciado não define esses pormenores.
- [ ] Definir contratos entre classes: construtores, getters, operações de associação e exceções/erros esperados.
- [ ] Integrar primeiro o registo de colónias e habitantes; depois missões e descobertas; b por fim, autenticação, menus e persistência.
- [ ] Testar um percurso completo: criar colónia, registar habitantes e gestor, criar missão, gerir participantes, concluir missão e registar descoberta.
- [ ] Testar dados inválidos, duplicados, remoções e recuperação do estado após reiniciar.
- [ ] Rever o UML e confirmar que os pacotes separam a interface do negócio.
- [ ] Fazer uma demonstração final cobrindo as funcionalidades dos três perfis.

## Ordem sugerida

1. Reunião curta para fechar os contratos e decisões partilhadas.
2. Implementação das classes de negócio pelos membros 1 e 2; o membro 3 prepara a estrutura da aplicação e a persistência.
3. Integração incremental com commits pequenos e revisão mútua.
4. Testes de ponta a ponta, correções e ensaio da demonstração.
