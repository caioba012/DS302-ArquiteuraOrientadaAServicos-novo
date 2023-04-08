import java.lang.runtime.SwitchBootstraps;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import bd.daos.Alunos;
import bd.dbos.Aluno;

public class Main
{
    public static void main (String[] args)
    {
        metodos metodos = new metodos();
        Teclado teclado = new Teclado();

        int operacao;
       

        try
        {
            System.out.println("----------------- ALUNO ----------------");

            System.out.println("Operações: \n1 - Inserir \n2 - Deletar \n3 - Alterar \n4 - Visualizar um \n5 - Visualizar\n0 - Sair\n Qual operação deseja realizar?");
            
            operacao = teclado.getUmInt();

            if(operacao == 1)
            {
                metodos.Inserir();        
            }
            if(operacao == 2)
            {
                metodos.Deletar();
            }
            if(operacao == 3)
            {
                metodos.Alterar();
            }
        }
        catch (Exception erro)
        {
			erro.printStackTrace();
            System.out.println (erro.getMessage());
        }
    }
}
