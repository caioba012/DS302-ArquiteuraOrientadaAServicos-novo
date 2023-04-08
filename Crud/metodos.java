import bd.dbos.Aluno;

import bd.daos.Alunos;
import bd.dbos.Aluno;

public class metodos{

    Teclado teclado = new Teclado();

    int         SouN;
    int         operacao;
    int         ra;
    String      nome;
    String      dataNascimento;
    String      email;
    String      cep;
    int         numero;
    String      complemento;

    public void Inserir() throws Exception
    {
        System.out.println("Digite o ra: ");
        ra = teclado.getUmInt();

        System.out.println("Digite o nome: ");
        nome = teclado.getUmString();

        System.out.println("Digite a data de Nascimento: ");
        dataNascimento = teclado.getUmString();

        System.out.println("Digite o email: ");
        email = teclado.getUmString();

        System.out.println("Digite o cep: ");
        cep = teclado.getUmString();

        System.out.println("Digite o numero da casa: ");
        numero = teclado.getUmInt();

        System.out.println("Digite o complemento: ");
        complemento = teclado.getUmString();

        Aluno novoAluno = new Aluno(ra, nome, dataNascimento, email, cep, numero, complemento);
        Alunos.incluir(novoAluno);
    }

    public void Deletar() throws Exception
    {
        System.out.print("Digite o ra para exclusão: ");
        ra = teclado.getUmInt();

        Alunos.excluir(ra);
    }

    public void Alterar() throws Exception
    {
        System.out.println("Qual RA deseja alterar? ");
        ra = teclado.getUmInt();

        System.out.print("Deseja alterar o nome? (1-Sim ou 2-Não)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.println("Digite o novo nome: ");
            nome = teclado.getUmString();
        }
        else 
            nome = nome;

        System.out.println("Deseja alterar a data de nascimento? (1-Sim ou 2-Não)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.println("Digite a nova data de nascimento: ");
            dataNascimento = teclado.getUmString();
        }
        else
            dataNascimento = dataNascimento;

        System.out.print("Deseja alterar o email? (1-Sim ou 2-Não)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.println("Digite o novo email: ");
            email = teclado.getUmString();
        }
        else 
            email = email;
        
        System.out.print("Deseja alterar o cep? (1-Sim ou 2-Não)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.println("Digite o novo cep: ");
            cep = teclado.getUmString();
        }
        else 
            cep = cep;

        System.out.print("Deseja alterar o numero da casa? (1-Sim ou 2-Não)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.println("Digite o novo numero da casa: ");
            numero = teclado.getUmInt();
        }
        else 
            numero = numero;

        System.out.print("Deseja alterar o complemento? (1-Sim ou 2-Não)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.println("Digite o novo complemento: ");
            complemento = teclado.getUmString();
        }
        else 
            complemento = complemento;

        Aluno alterarAluno = new Aluno(ra, nome, dataNascimento, email, cep, numero, complemento);
        Alunos.alterar(alterarAluno);
        
    }
}
