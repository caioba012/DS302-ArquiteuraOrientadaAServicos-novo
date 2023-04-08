package bd.dbos;


public class Aluno implements Cloneable{
    
    private int         ra;
    private String      nome;
    private String      dataNascimento; 
    private String      email;
    private String      cep;
    private int         numero;
    private String      complemento;

    public int getRa()
    {
        return this.ra;
    }

    public void setRa (int ra) throws Exception
    {
        if (ra <= 0)
            throw new Exception("Ra invalido");
        
        this.ra = ra;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome (String nome) throws Exception
    {
        if (nome==null || nome.equals(""))
            throw new Exception("Nome nao fornecido");
        
        this.nome = nome;
    }

    public String getDataNascimento()
    {
        return this.dataNascimento;
    }

    public void setDataNascimento (String dataNascimento) throws Exception
    {
        if (dataNascimento==null || dataNascimento.equals(""))
            throw new Exception ("Data invalida");

        this.dataNascimento = dataNascimento;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail (String email) throws Exception
    {
        if (email==null || email.equals(""))
            throw new Exception ("Email nao fornecido");
        
        this.email = email;
    }

    public String getCep()
    {
        return this.cep;
    }

    public void setCep (String cep) throws Exception
    {
        if (cep==null || cep.length()==0)
            throw new Exception ("Logradouro ausente");

         this.cep = cep;
    }

    public int getNumero()
    {
        return this.numero;
    }

    public void setNumero (int numero) throws Exception
    {
        if (numero <=0 )
            throw new Exception ("número inexistente");

         this.numero = numero;
    }

    public String getComplemento()
    {
        return this.complemento;
    }

    public void setComplemento (String complemento) throws Exception
    {
        this.complemento = complemento;
    }


    public Aluno (int ra, String nome, String dataNascimento, 
                    String email, String cep, int numero, 
                    String complemento) throws Exception
    {
        this.setRa              (ra);
        this.setNome            (nome);
        this.setDataNascimento  (dataNascimento);
        this.setEmail           (email);
        this.setCep             (cep);
        this.setNumero          (numero);
        this.setComplemento     (complemento);
    }

    public Aluno () {}

    public String toString()
    {
        return  "Ra: "+ 
                this.ra+
                "\nNome: "+ 
                this.nome +
                "\nData Nascimento: "+ 
                this.dataNascimento +
                "\nEmail: "+
                this.email+
                "\nCEP: "+
                this.cep+
                "\nNumero: "+
                this.numero+
                "\nComplemento: "+
                this.complemento;            
    }

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;
        
        if (!(obj instanceof Aluno))
            return false;

        Aluno aluno = (Aluno)obj;

        if (this.ra!=aluno.ra)    
            return false;

        if (!this.nome.equals(aluno.nome))
            return false;
        
        if (this.dataNascimento!=aluno.dataNascimento)
            return false;

        if (!this.email.equals(aluno.email))
            return false;
        
        if (!this.cep.equals(aluno.cep))
            return false;
        
        if (this.numero!=aluno.numero)
            return false;

        if ((this.complemento==null && aluno.complemento!=null) ||
            (this.complemento!=null && aluno.complemento==null) ||
            !this.complemento.equals(aluno.complemento))
            return false;
        
        return true;
        
    }

    public int hashCode()    
    {
        int ret=12;

        ret = 2*ret + new Integer(this.ra)      .hashCode();

        ret = 2*ret + this.nome                 .hashCode();
        ret = 2*ret + this.dataNascimento       .hashCode();
        ret = 2*ret + this.email                .hashCode();
        ret = 2*ret + this.cep                  .hashCode();
        ret = 2*ret + new Integer(this.numero)  .hashCode();  

        if (this.complemento!=null)
            ret = 2*ret + this.complemento      .hashCode();
            
        return ret;
        
    }

    public Aluno (Aluno modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo inexistente");

        this.ra             = modelo.ra;
        this.nome           = modelo.nome;
        this.dataNascimento = modelo.dataNascimento;
        this.email          = modelo.email;
        this.cep            = modelo.cep;
        this.numero         = modelo.numero;
        this.complemento    = modelo.complemento;
    }

    public Object clone()
    {
        Aluno ret=null;

        try
        {
            ret = new Aluno (this);
        }
        catch (Exception erro)
        {}

        return ret;
    
    }
}
