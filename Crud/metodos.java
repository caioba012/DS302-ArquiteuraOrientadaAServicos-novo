 import bd.dbos.Aluno;

import bd.daos.Alunos;
import bd.dbos.Aluno;

public class metodos extends Aluno{

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
        Logradouro logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", cep);
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
        Aluno aluno = Alunos.getAluno(ra);

        System.out.print("Deseja alterar o nome? (1-Sim ou 2-Não)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.println("Digite o novo nome: ");
            nome = teclado.getUmString();
        }
        else{
           nome = aluno.getNome();
        }

        System.out.println("Deseja alterar a data de nascimento? (1-Sim ou 2-Não)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.println("Digite a nova data de nascimento: ");
            dataNascimento = teclado.getUmString();
        }
        else{
            dataNascimento = aluno.getDataNascimento();
        }

        System.out.print("Deseja alterar o email? (1-Sim ou 2-Não)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.println("Digite o novo email: ");
            email = teclado.getUmString();
        }
        else 
            email = aluno.getEmail();
        
        System.out.print("Deseja alterar o cep? (1-Sim ou 2-Não)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.println("Digite o novo cep: ");
            cep = teclado.getUmString();
        }
        else 
           cep = aluno.getCep();

        System.out.print("Deseja alterar o numero da casa? (1-Sim ou 2-Não)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.println("Digite o novo numero da casa: ");
            numero = teclado.getUmInt();
        }
        else 
           numero = aluno.getNumero();

        System.out.print("Deseja alterar o complemento? (1-Sim ou 2-Não)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.println("Digite o novo complemento: ");
            complemento = teclado.getUmString();
        }
        else 
           complemento = aluno.getComplemento();

        Alunos.alterar(ra, nome, dataNascimento, email, cep, numero, complemento);
        
    }

    public void RecuperaUm() throws Exception
    {
        
        
    }

    public void RecupereTodos() throws Exception
    {
        Alunos.getAlunos();
    }


}
