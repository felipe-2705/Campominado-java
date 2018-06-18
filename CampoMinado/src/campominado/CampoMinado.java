/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campominado;

import campominado.Jogo.Jogo;
import campominado.Jogo.Tabuleiro;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class CampoMinado {
     Jogo jogo;
     String matriz[][];
     String fechado="X";
     String Bomba="B";
     String Marca="M";
     int tamanho;
     
     public CampoMinado(int dimensao,float proporcao)
     {
         jogo=new Jogo(dimensao,proporcao);
         tamanho=dimensao;
         matriz=new String[dimensao][dimensao];
         
         for(int i=0;i<dimensao;i++)
         {
             for(int j=0;j<dimensao;j++)
             {  
                 matriz[i][j]=new String();
                 matriz[i][j]=fechado;
             }
         }
     }
     
    public void  start()
    {   
        

        String op;
        do{
            this.imprimir();
            this.imprime_menu();
            op=JOptionPane.showInputDialog("digite a op:");
            int i;
            int j;
            
            switch(op)
            {
                case "1": i=Integer.parseInt(JOptionPane.showInputDialog("Digite a linha:"));
                          j=Integer.parseInt(JOptionPane.showInputDialog("Digite a Coluna:"));
                          this.marcar_posicao(i, j);
                          break;
                case "2": i=Integer.parseInt(JOptionPane.showInputDialog("Digite a linha:"));
                          j=Integer.parseInt(JOptionPane.showInputDialog("Digite a Coluna:"));
                          this.desmarcar_posicao(i, j);
                          break;
                case "3": i=Integer.parseInt(JOptionPane.showInputDialog("Digite a linha:"));
                          j=Integer.parseInt(JOptionPane.showInputDialog("Digite a Coluna:"));
                          this.abrir_posicao(i, j);
                          break;
                default :break;          
            }
            System.out.printf("\n\n\n\n");
        }while(!this.jogo.derrota() && !this.jogo.vitoria());
        
        if(this.jogo.derrota())
        {
            JOptionPane.showMessageDialog(null,"DERROTA!!!");
        }else
        {
              JOptionPane.showMessageDialog(null,"Vitoria!!!");
        }
    }
     
    public void  imprimir()
    {   
        System.out.printf("     [0] ");
          for(int j=1;j<this.tamanho;j++)
            {
                System.out.printf(" [%d] " ,j);
            }
          System.out.printf("\n");
        for(int i=0;i<this.tamanho;i++)
        {   
            System.out.printf("[%d] ",i);
            for(int j=0;j<this.tamanho;j++)
            {
                System.out.printf(" [%s] " ,this.matriz[i][j]);
            }
            System.out.printf("\n");
        }
    }
   
    public void abrir_posicao(int i,int j)
    {   
         if(i<0 || j<0 || i>=this.tamanho || j>=this.tamanho)
            return;
        
         
        if(!this.jogo.abrir(i,j))
        {
            return;
        }
        
        int v=this.jogo.getPosicaoValor(i, j);
        
        if(v==-1)
        {
            this.matriz[i][j]=Bomba;
        }else
        {   
            this.matriz[i][j]=String.valueOf(v);
        
        }
        
        if(v==0)
        {
            this.abrir_posicao(i+1,j);
              this.abrir_posicao(i,j+1);
                this.abrir_posicao(i-1,j);
                  this.abrir_posicao(i,j-1);
                    this.abrir_posicao(i+1,j+1);
                      this.abrir_posicao(i-1,j-1);
                        this.abrir_posicao(i+1,j-1);
                          this.abrir_posicao(i-1,j+1);
            
        }
        
    }
    
    public void marcar_posicao(int i,int j)
    {
        if(this.jogo.Marcar(i, j))
        this.matriz[i][j]=Marca;
        
    }
    
    public void desmarcar_posicao(int i,int j)
    {
        if(this.jogo.desmarcar(i, j))
        this.matriz[i][j]=fechado;
    }
    
    public void imprime_menu()
    {
       System.out.printf("\n1-Marcar_Posicao;\n"+
                         "2-Desmarcar_posicao;\n"+
                         "3-Abrir_Posicao;\n\n");
    }
    
    public static void main(String[] args) {
       CampoMinado c=new CampoMinado(10,0.1f);
       
       System.out.printf(c.jogo.imprime());
       c.start();
    }
    
}
