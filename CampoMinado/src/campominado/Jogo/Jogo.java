/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campominado.Jogo;

/**
 *
 * @author felip
 */
public class Jogo {
      private Tabuleiro tabuleiro;
      private int abertas;
      private int marcadas;
      private boolean derrota;
        
      
      public Jogo(int dimensao,float proporcao) // inicia o jogo dimensao é o tamanho da matriz que ira formar o tabuleiro  , proporçao é a razao entre o Nbombas e o tamanho do tabuleiro 
      {
          this.tabuleiro=new Tabuleiro(dimensao,proporcao);
          this.abertas=0;
          this.marcadas=0;
          derrota=false;
      }
            
            public boolean Marcar(int i,int j)
            {  
                
              
                this.marcadas++;
                return  this.tabuleiro.m.marcar(i, j);
            }
            
            public boolean desmarcar(int i,int j)
            {
               
               this.marcadas--;
               return this.tabuleiro.m.Desmarca(i, j);
            }
            
            public boolean abrir (int i,int j)
            {   
                
                if(this.verificaBomba(i, j))
                {
                    this.derrota=true;
                }
                this.abertas++;
                 return this.tabuleiro.m.abrirPosicao(i, j);
            }
            
             public String imprime()
            { 
               
                String s="";
                for(int i=0;i<this.tabuleiro.tamanho;i++)
                {
                    for(int j=0;j<this.tabuleiro.tamanho;j++)
                    {
                        s=s+" "+String.valueOf(this.tabuleiro.m.get_Posicao_valor(i, j));
                        
                        
                    }
                    s=s+"\n";
                }
               return s;
           
            }
            
            public int getPosicaoValor(int i,int j)
            {    
                return this.tabuleiro.m.get_Posicao_valor(i, j);
            }
            
            public boolean verificaBomba(int i,int j)
            {
                for(int k=0;k<this.tabuleiro.Nbombas;k++)
                {
                    if(this.tabuleiro.posicao_bombas[k].get_linha()==i && this.tabuleiro.posicao_bombas[k].get_coluna()==j)
                    {
                        return true;
                    }
                }
                
                return false;
            }
            
            
            
            public int tamanho ()
            {
               return this.tabuleiro.tamanho;
            }
            
            public boolean vitoria()
            {  
                
                int bomba =this.tabuleiro.Nbombas;
                int size=this.tabuleiro.tamanho;
                
            /*  if(this.marcadas!=bomba)
              {
                  return false;
              }
                
              if(this.abertas!= (size*size)-bomba)
              {
                  return false;
              }
              */
              for(int i=0;i<bomba;i++)
              {
                  if(!this.tabuleiro.posicao_bombas[i].get_Flag())
                  {
                      return false;
                  }
              }
              
              return true;
            }
            
            public boolean derrota()
            {
               return this.derrota;
            }
}
