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

        if(Alunos.cadastrado(ra))
        {
            System.out.println("Aluno ja cadastrado");
        }

        else
        {
            System.out.println("Digite o nome: ");
            nome = teclado.getUmString();

            System.out.println("Digite a data de Nascimento: ");
            dataNascimento = teclado.getUmString();

            System.out.println("Digite o email: ");
            email = teclado.getUmString();

            System.out.println("Digite o cep: ");
            cep = teclado.getUmString();

            Logradouro logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", cep);
            
            System.out.println("Estado: " );
            System.out.println(logradouro.getEstado());
            System.out.println("Cidade: ");
            System.out.println(logradouro.getCidade());
            System.out.println("Bairro: ");
            System.out.println(logradouro.getBairro());
            System.out.println("Logradouro: ");
            System.out.println(logradouro.getLogradouro());

            System.out.println("Digite o numero da casa: ");
            numero = teclado.getUmInt();

            System.out.println("Digite o complemento: ");
            complemento = teclado.getUmString();
            
            Aluno aluno = new Aluno(ra, nome, dataNascimento, email, cep, numero, complemento);
            Alunos.incluir(aluno);

            logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", aluno.getCep());

            System.out.println("\nRelatório:");

            System.out.println("\nRa: " +               aluno.getRa()); 
            System.out.println("Nome: " +               aluno.getNome()); 
            System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
            System.out.println("Email: " +              aluno.getEmail());
            System.out.println("Cep: " +                aluno.getCep());
            System.out.println("Estado: " +             logradouro.getEstado());
            System.out.println("Cidade: " +             logradouro.getCidade());
            System.out.println("Bairro: " +             logradouro.getBairro());
            System.out.println("Logradouro: "+          logradouro.getLogradouro());
            System.out.println("Número: " +             aluno.getNumero());
            System.out.println("Complemento: " +        aluno.getComplemento() + "\n");   
            }
    }

    public void Deletar() throws Exception
    {
        System.out.print("Digite o ra para exclusão: ");
        ra = teclado.getUmInt();

        Aluno aluno = Alunos.getAluno(ra);
        Logradouro logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", aluno.getCep());

        System.out.println("\nRa: " +               aluno.getRa()); 
        System.out.println("Nome: " +               aluno.getNome()); 
        System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
        System.out.println("Email: " +              aluno.getEmail());
        System.out.println("Cep: " +                aluno.getCep());        
        System.out.println("Estado: " +             logradouro.getEstado());
        System.out.println("Cidade: " +             logradouro.getCidade());
        System.out.println("Bairro: " +             logradouro.getBairro());
        System.out.println("Logradouro: "+          logradouro.getLogradouro());
        System.out.println("Número: " +             aluno.getNumero());
        System.out.println("Complemento: " +        aluno.getComplemento() + "\n");   

        System.out.println("Deseja confirmar a ação? 1-Sim 2-Não");
        SouN = teclado.getUmInt();
        if(SouN == 1){
            System.out.println("Operação Concluida");
            Alunos.excluir(ra);
        }
        if(SouN == 2){
            System.out.println("Operação Cancelada");
        }
    }

    public void Alterar() throws Exception
    {
        System.out.println("\nQual RA deseja alterar? ");
        ra = teclado.getUmInt();
        Aluno aluno = Alunos.getAluno(ra);

        Logradouro logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", aluno.getCep());
        
        System.out.println("\nRa: " +               aluno.getRa()); 
        System.out.println("Nome: " +               aluno.getNome()); 
        System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
        System.out.println("Email: " +              aluno.getEmail());
        System.out.println("Cep: " +                aluno.getCep());
        System.out.println("Estado: " +             logradouro.getEstado());
        System.out.println("Cidade: " +             logradouro.getCidade());
        System.out.println("Bairro: " +             logradouro.getBairro());
        System.out.println("Logradouro: "+          logradouro.getLogradouro());
        System.out.println("Número: " +             aluno.getNumero());
        System.out.println("Complemento: " +        aluno.getComplemento() + "\n");   

        System.out.print("\nDeseja alterar o nome? (1-Sim - 2-Não - 0-Sair do código)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.print("\nDigite o novo nome: ");
            nome = teclado.getUmString();
        }
        if(SouN == 2)
        {
           nome = aluno.getNome();
        }
        if(SouN == 0)
        {
            System.exit(0);
        }

        System.out.print("\nDeseja alterar a data de nascimento? (1-Sim - 2-Não - 0-Sair do código)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.print("\nDigite a nova data de nascimento: ");
            dataNascimento = teclado.getUmString();
        }
        if(SouN == 2)
        {
            dataNascimento = aluno.getDataNascimento();
        }
        if(SouN == 0)
        {
            System.exit(0);
        }      

        System.out.print("\nDeseja alterar o email? (1-Sim - 2-Não - 0-Sair do código)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.print("\nDigite o novo email: ");
            email = teclado.getUmString();
        }
        if(SouN == 2) 
        {
            email = aluno.getEmail();
        }
        if(SouN == 0)
        {
            System.exit(0);
        }

        System.out.print("\nDeseja alterar o cep? (1-Sim - 2-Não - 0-Sair do código)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.print("\nDigite o novo cep: ");
            cep = teclado.getUmString();
        }
        if(SouN == 2) 
        {
           cep = aluno.getCep();
        }
        if(SouN == 0)
        {
            System.exit(0);
        }

        System.out.print("\nDeseja alterar o numero da casa? (1-Sim - 2-Não - 0-Sair do código)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.print("\nDigite o novo numero da casa: ");
            numero = teclado.getUmInt();
        } 
        if(SouN ==2)
        {
            numero = aluno.getNumero();
        }
        if(SouN == 0)
        {
            System.exit(0);
        }

        System.out.print("\nDeseja alterar o complemento? (1-Sim - 2-Não - 0-Sair do código)");
        SouN = teclado.getUmInt();

        if(SouN == 1)
        {
            System.out.print("\nDigite o novo complemento: ");
            complemento = teclado.getUmString();
        }
        if(SouN == 2) 
        {
           complemento = aluno.getComplemento();
        }
        if(SouN == 0)
        {
            System.exit(0);
        }

        Alunos.alterar(ra, nome, dataNascimento, email, cep, numero, complemento);
        
        logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", cep);

        System.out.println("\nRelatório: ");
        System.out.println("\nRa: " +               ra); 
        System.out.println("Nome: " +               nome); 
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Email: " +              email);
        System.out.println("Cep: " +                cep);
        System.out.println("Estado: " +             logradouro.getEstado());
        System.out.println("Cidade: " +             logradouro.getCidade());
        System.out.println("Bairro: " +             logradouro.getBairro());
        System.out.println("Logradouro: "+          logradouro.getLogradouro());
        System.out.println("Número: " +             numero);
        System.out.println("Complemento: " +        complemento + "\n");  
    }

    public void RecuperaUm() throws Exception
    {
        System.out.println("\nDigite o ra para visualizar os dados: ");
        ra = teclado.getUmInt();

        Aluno aluno = Alunos.getAluno(ra);
        Logradouro logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "https://api.postmon.com.br/v1/cep", aluno.getCep());
        

        System.out.println("\nRa: " + aluno.getRa()); 
        System.out.println("Nome: " + aluno.getNome()); 
        System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
        System.out.println("Email: " + aluno.getEmail());
        System.out.println("Cep: " + aluno.getCep());
        System.out.println("Estado: " + logradouro.getEstado());
        System.out.println("Cidade: " + logradouro.getCidade());
        System.out.println("Bairro: " + logradouro.getBairro());
        System.out.println("Logradouro: "+          logradouro.getLogradouro());
        System.out.println("Número: " + aluno.getNumero());
        System.out.println("Complemento: " + aluno.getComplemento() + "\n");       
    }

}
