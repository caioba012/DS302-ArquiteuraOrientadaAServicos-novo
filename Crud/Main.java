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
       
        while (true){
        try
        {
            System.out.println("----------------- ALUNO ----------------");

            System.out.println("Operações: \n1 - Inserir \n2 - Deletar \n3 - Alterar \n4 - Visualizar \n0 - Sair do código \n\nQual operação deseja realizar?");
            
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
            if(operacao == 4)
            {
                metodos.RecuperaUm();
            }
            if(operacao == 0)
            {
                System.exit(0);
            }
        }
        catch (Exception erro)
        {
			erro.printStackTrace();
            System.out.println (erro.getMessage());
        }
    
        }
    }
}
