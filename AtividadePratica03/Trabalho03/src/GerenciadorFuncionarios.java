import java.util.ArrayList;

public class GerenciadorFuncionarios {
    private ArrayList<Funcionario> funcionarios;

    public GerenciadorFuncionarios() {
        funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(int matricula) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getMatricula() == matricula) {
                funcionarios.remove(i);
                return;
            }
        }
        System.out.println("Funcionário com a matrícula " + matricula + " não encontrado.");
    }

    public void listarFuncionarios() {
        System.out.println("Lista de Funcionários:");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome() + ", Matrícula: " + funcionario.getMatricula() +
                    ", Salário: R$" + funcionario.calcularSalario());
        }
    }

    public Funcionario buscarFuncionario(int matricula) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getMatricula() == matricula) {
                return funcionario;
            }
        }
        return null;
    }

    public Funcionario buscarFuncionario(String nome) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                return funcionario;
            }
        }
        return null;
    }
}
