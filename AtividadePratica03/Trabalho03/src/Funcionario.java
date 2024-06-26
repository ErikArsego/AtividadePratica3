public abstract class Funcionario {

    private String nome;
    private int matricula;

    public Funcionario (String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public  String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public abstract double calcularSalario();
}