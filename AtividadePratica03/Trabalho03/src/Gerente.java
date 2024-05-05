public class Gerente extends Funcionario implements Trabalhavel {
    private double bonusAnual;
    private int equipe;

    public Gerente (String nome, int matricula, double bonusAnual, int equipe) {
        super(nome, matricula);
        this.bonusAnual = bonusAnual;
        this.equipe = equipe;
    }

    @Override
    public double calcularSalario() {
        return 5000 + bonusAnual;
    }

    @Override
    public void trabalhar () {
        System.out.println(getNome () + "Esta comandando a equipe" + equipe);
    }

    @Override
    public void relataProgresso () {
        System.out.println(getNome() + "Esta relatando o progreso da equipe" + equipe);
    }
}