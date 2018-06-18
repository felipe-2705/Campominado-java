/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campominado.Matriz_campominado;


import Matriz.Posicao;

/**
 *
 * @author felip
 */
public class Posicao_campoMinado extends Posicao{
   private boolean Flag;
   private boolean aberta;
    
    
    public  Posicao_campoMinado (int n,int i,int j)
    {
        super(n,i,j);
        Flag=false;
        aberta=false;
    }
    
   public boolean get_Flag()
    {
        return Flag;
    }
    
    public boolean get_aberta()
    {
        return aberta;
    }
    
    void Marcar() 
    {  
      
           
        Flag=true;
    }
    void desmarcar()
    {
       
        Flag=false;
    }
    void abrir() 
    {
       
        aberta=true;
    }
    
  
    
}
