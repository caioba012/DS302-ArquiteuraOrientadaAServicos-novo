package bd.daos;

import java.sql.*;

import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Alunos {

    public static boolean cadastrado (int ra) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * FROM Alunos WHERE ra = ?";

            conexao.COMANDO.prepareStatement(sql);

            conexao.COMANDO.setInt (1, ra);

            MeuResultSet resultado = (MeuResultSet)conexao.COMANDO.executeQuery();
                       
            retorno = resultado.first();
        }

        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar aluno");
        }
        return retorno;
    }

    public static void incluir (Aluno aluno) throws Exception
    {
        if (aluno==null)
            throw new Exception("Aluno nao cadastrado");

        try
        {
            String sql;

            sql = "INSERT INTO ALUNOS " + 
            "(ra, nome, dataNascimento, email, cep, numero, complemento) " +
            "VALUES" + "(?, ?, ?, ?, ?, ?, ?)";

            conexao.COMANDO.prepareStatement(sql);

            conexao.COMANDO.setInt            (1, aluno.getRa());
            conexao.COMANDO.setString         (2, aluno.getNome());
            conexao.COMANDO.setString         (3, aluno.getDataNascimento());
            conexao.COMANDO.setString         (4, aluno.getEmail());
            conexao.COMANDO.setString         (5, aluno.getCep());
            conexao.COMANDO.setInt            (6, aluno.getNumero());
            conexao.COMANDO.setString         (7, aluno.getComplemento());

            conexao.COMANDO.executeUpdate ();
            conexao.COMANDO.commit        ();
        }

        catch (SQLException erro)
        {
            conexao.COMANDO.rollback();
            throw new Exception ("Erro ao inserir um novo Aluno");
        }
    }

    public static void excluir (int ra) throws Exception
    {
        if (!cadastrado (ra))
            throw new Exception ("Aluno nao cadastrado");
        
        try
        {
            String sql;

            sql = "DELETE FROM Alunos WHERE ra=?";

            conexao.COMANDO.prepareStatement(sql);

            conexao.COMANDO.setInt (1, ra);

            conexao.COMANDO.executeUpdate ();
            conexao.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            conexao.COMANDO.rollback();
            throw new Exception ("Erro ao excluir cadastro de Aluno");
        }
    }

    public static void alterar (int ra, String nome, String dataNascimento, String email, String cep, int numero, String complemento) throws Exception
    {
        
        if (!cadastrado (ra))
            throw new Exception ("Aluno nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE Alunos SET nome=?, dataNascimento=?, email=?, cep=?, numero=?, complemento=? WHERE ra= ?";

            conexao.COMANDO.prepareStatement(sql);

            conexao.COMANDO.setString (1, nome);
            conexao.COMANDO.setString (2, dataNascimento);
            conexao.COMANDO.setString (3, email);
            conexao.COMANDO.setString (4, cep);
            conexao.COMANDO.setInt    (5, numero);
            conexao.COMANDO.setString (6, complemento);
            conexao.COMANDO.setInt    (7, ra);

            conexao.COMANDO.executeUpdate ();
            conexao.COMANDO.commit        ();
        }
        
        catch (SQLException erro)
        {
            conexao.COMANDO.rollback();
            throw new Exception("Erro ao atualizar os dados do aluno");
        }
    }

    public static Aluno getAluno (int ra) throws Exception
    {
        Aluno aluno = null;

        try
        {
            String sql;

            sql = "SELECT * FROM Alunos WHERE ra=?";

            conexao.COMANDO.prepareStatement(sql);

            conexao.COMANDO.setInt (1, ra);
        
        MeuResultSet resultado = (MeuResultSet)conexao.COMANDO.executeQuery();

        if (!resultado.first())
            throw new Exception ("Não cadastrado");
        
        aluno = new Aluno (resultado.getInt ("ra"), resultado.getString ("nome"),
                           resultado.getString ("dataNascimento"), resultado.getString ("email"),
                           resultado.getString ("cep"), resultado.getInt ("numero"), resultado.getString ("complemento"));
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar aluno");
        }

        return aluno;
    }

    /*public static MeuResultSet getAlunos () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * FROM Alunos";

            conexao.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)conexao.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar alunos");
        }

        return resultado;
    }*/

}
