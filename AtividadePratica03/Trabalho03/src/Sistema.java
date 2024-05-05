public class Sistema {
    private static GerenciadorFuncionarios gerenciador = new GerenciadorFuncionarios();

    public static void exibirMenu() {
        System.out.println("\n========== Menu ==========");
        System.out.println("1. Adicionar funcionário");
        System.out.println("2. Remover funcionário");
        System.out.println("3. Listar funcionários");
        System.out.println("4. Buscar funcionário por matrícula");
        System.out.println("5. Buscar funcionário por nome");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void adicionarFuncionario() {
        System.out.println("\nAdicionar Funcionário:");
        String nome = System.console().readLine("Nome: ");
        int matricula = Integer.parseInt(System.console().readLine("Matrícula: "));

        System.out.println("\nEscolha o tipo de funcionário:");
        System.out.println("1. Gerente");
        System.out.println("2. Desenvolvedor");
        System.out.println("3. Estagiário");
        System.out.print("Opção: ");
        int tipo = Integer.parseInt(System.console().readLine());

        switch (tipo) {
            case 1:
                double bonusAnual = Double.parseDouble(System.console().readLine("Bônus Anual: "));
                int equipe = Integer.parseInt(System.console().readLine("Numero da Equipe: "));
                gerenciador.adicionarFuncionario(new Gerente(nome, matricula, bonusAnual, equipe));
                break;
            case 2:
                int numTecnologias = Integer.parseInt(System.console().readLine("Número de tecnologias que domina: "));
                String[] tecnologias = new String[numTecnologias];
                for (int i = 0; i < numTecnologias; i++) {
                    tecnologias[i] = System.console().readLine("Tecnologia " + (i + 1) + ": ");
                }
                gerenciador.adicionarFuncionario(new Desenvolvedor(nome, matricula, tecnologias));
                break;
            case 3:
                int horasTrabalhadas = Integer.parseInt(System.console().readLine("Horas de trabalho: "));
                String supervisor = System.console().readLine("Supervisor: ");
                gerenciador.adicionarFuncionario(new Estagiario(nome, matricula, horasTrabalhadas, supervisor));
                break;
            default:
                System.out.println("Tipo de funcionário inválido");
                break;
        }
    }

    public static void removerFuncionario() {
        System.out.println("\nRemover Funcionário:");
        int matricula = Integer.parseInt(System.console().readLine("Digite a matrícula do funcionário que deseja remover: "));
        gerenciador.removerFuncionario(matricula);
    }

    public static void buscarPorMatricula() {
        System.out.println("\nBuscar Funcionário por Matrícula:");
        int matricula = Integer.parseInt(System.console().readLine("Digite a matrícula do funcionário que deseja buscar: "));
        Funcionario funcionario = gerenciador.buscarFuncionario(matricula);
        if (funcionario != null) {
            System.out.println("Funcionário encontrado:");
            System.out.println("Nome: " + funcionario.getNome() + ", Matrícula: " + funcionario.getMatricula() +
                    ", Salário: R$" + funcionario.calcularSalario());
        } else {
            System.out.println("Funcionário com a matrícula " + matricula + " não encontrado.");
        }
    }

    public static void buscarPorNome() {
        System.out.println("\nBuscar Funcionário por Nome:");
        String nome = System.console().readLine("Digite o nome do funcionário que deseja buscar: ");
        Funcionario funcionario = gerenciador.buscarFuncionario(nome);
        if (funcionario != null) {
            System.out.println("Funcionário encontrado:");
            System.out.println("Nome: " + funcionario.getNome() + ", Matrícula: " + funcionario.getMatricula() +
                    ", Salário: R$" + funcionario.calcularSalario());
        } else {
            System.out.println("Funcionário com o nome " + nome + " não encontrado.");
        }
    }

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = Integer.parseInt(System.console().readLine());
            switch (opcao) {
                case 1:
                    adicionarFuncionario();
                    break;
                case 2:
                    removerFuncionario();
                    break;
                case 3:
                    gerenciador.listarFuncionarios();
                    break;
                case 4:
                    buscarPorMatricula();
                    break;
                case 5:
                    buscarPorNome();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 0);
    }
}
