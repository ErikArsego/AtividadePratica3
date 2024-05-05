public class Desenvolvedor extends Funcionario implements Trabalhavel {
    private String [] tecnologias;

    public Desenvolvedor (String nome, int matricula, String[] tecnologias) {
        super (nome, matricula);
        this.tecnologias = tecnologias;
    }

    @Override
    public double calcularSalario () {
        return 3000;
    }

    @Override
    public void trabalhar() {
        System.out.println(getNome() + "Esta desenvolvendo em: ");
        for (String tecnologia : tecnologias ) {
            System.out.println(tecnologia);
        }
    }

    @Override
    public void relataProgresso () {
        System.out.println(getNome () + "Progresso do desenvolvimento em progresso ");
    }
}
