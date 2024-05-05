public class Estagiario extends Funcionario implements Trabalhavel {
    private int horasTrabalhadas;
    private String supervisor;

    public Estagiario (String nome, int matricula, int horasTrabalhadas, String supervisor) {
        super (nome,matricula);
        this.horasTrabalhadas = horasTrabalhadas;
        this.supervisor = supervisor;
    }

    @Override
    public double calcularSalario () {
        return horasTrabalhadas * 10;
    }

    @Override
    public void trabalhar() {
        System.out.println(getNome () + "Trabalhando sob supervisao de " + supervisor);
    }

    @Override
    public void relataProgresso() {
        System.out.println(getNome () + "Esta relatando o seu progresso do estagio");
    }

}