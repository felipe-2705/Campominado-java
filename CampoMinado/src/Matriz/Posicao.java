/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matriz;

/**
 *
 * @author felip
 */
public class Posicao {
      int i;
      int j;
     public int conteudo;
      
      public Posicao(int n,int line,int column)
      {
          this.i=line;
          this.j=column;
          this.conteudo=n;
                  
      }
      
   
      
      public int get_linha()
      {
          return i;
      }
      
      public int get_coluna()
      {
          return j;
      }
    
}
