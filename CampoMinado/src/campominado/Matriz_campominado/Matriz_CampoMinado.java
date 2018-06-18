/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campominado.Matriz_campominado;


import Matriz.*;

/**
 *
 * @author felip
 */
public class Matriz_CampoMinado  implements InterfaceMatriz {
    
    private Posicao_campoMinado Matriz[][];
    private int dimensao;
    
    
    public Matriz_CampoMinado(int d) // inicia a matriz de tamanho d vazia
    {

            this.Matriz=new Posicao_campoMinado[d][d];
        this.dimensao=d;
    }
    
    
    
  
    @Override
     public void set_Matriz(int n) // atribui a todas as posiçoes da matriz o valor n
    {
        for(int i=0;i<dimensao;i++)
        {
            for(int j=0;j<dimensao;j++)
            {
                this.Matriz[i][j].conteudo=n;
            }
        }
    }
    @Override
    public void set_Posicao(int n,int i,int j)// atribui um valor n a posicao ij da matriz
    {    
      
        this.Matriz[i][j].conteudo=n;
     
    }
    
    @Override 
    public int get_Posicao_valor(int i,int j) 
    {   

           
        return this.Matriz[i][j].conteudo;
    }
   
    
    @Override
    public int get_Dimensao()//retorna a dimencao da matriz 
    {
        return this.dimensao;
    }

    

    


   
    @Override
    public void inicia_Matriz(int n) {
        for(int i=0;i<this.dimensao;i++)
        {
            for(int j=0;j<this.dimensao;j++)
            {
                this.Matriz[i][j]=new Posicao_campoMinado(n,i,j);
            }
        }
    }
    
    public Posicao_campoMinado get_Posicao(int i,int j)
    {
        return this.Matriz[i][j];
    }
    public boolean marcar(int i,int j)
    {
        if(this.Matriz[i][j].get_aberta())
            return false;
    
        if(this.Matriz[i][j].get_Flag())
            return false;
        
        this.Matriz[i][j].Marcar();
        return true;
    }
    public boolean Desmarca(int i,int j) 
    {   
        if(i<0 || j<0 || i>=this.dimensao || j>=this.dimensao)
            return false;
          
        if(this.Matriz[i][j].get_aberta())
            return false;
        
        if(!this.Matriz[i][j].get_Flag())
            return false;
        
        this.Matriz[i][j].desmarcar();
        return true;
    }
    
    public boolean abrirPosicao(int i,int j)
    {   
        if(i<0 || j<0 || i>=this.dimensao || j>=this.dimensao)
            return false;
        
          if(this.Matriz[i][j].get_aberta())
            return false;
          
          if(this.Matriz[i][j].get_Flag())
              return false;
        
        this.Matriz[i][j].abrir();
       return  true;
    }
}
