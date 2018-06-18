/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campominado.Jogo;

import Matriz.Posicao;

import campominado.Matriz_campominado.*;
import java.util.Random;

/**
 *
 * @author felip
 */
public class Tabuleiro {
            int Nbombas;
            int tamanho;
            private float proporcao;//razao do numero d bombas pelo numero de casas do tabuleiro n/b=proporcao [0,1]
            Matriz_CampoMinado m;
            Posicao_campoMinado posicao_bombas[];//guarda a posicao das bombas no tabuleiro;
            private int Bomba=-1;
         
            public Tabuleiro(int dimensao,float p)
            {   
                this.tamanho=dimensao;
                this.proporcao=p;
                this.cria_tabuleiro(dimensao);             
                this.Nbombas=this.calcula_bombas();
                
                this.posicao_bombas=new Posicao_campoMinado[this.Nbombas];
                this.posiciona_bombas();
                
            }
            
            private void cria_tabuleiro(int d)//cria um tabuleiro onde todas as casas sao vazias.
            {
                m=new Matriz_CampoMinado(d);
                m.inicia_Matriz(0);
            }
            private int calcula_bombas()
            {
                return Math.round(tamanho*tamanho*proporcao);
            }
            
            
            private void soma1_adjacentes(int i,int j)
            {  
                int valor;
             
              
               if(i<tamanho-1){
                valor=m.get_Posicao_valor(i+1, j); //baixo  
                    if(valor!=Bomba) m.set_Posicao(valor+1, i+1, j);
               }
               
              if(i>0){ 
                valor=m.get_Posicao_valor(i-1, j);//cima
                   if(valor!=Bomba)    m.set_Posicao(valor+1, i-1, j);
              }
              if(j<tamanho-1){
                valor=m.get_Posicao_valor(i, j+1);//direita
                   if(valor!= Bomba)    m.set_Posicao(valor+1, i, j+1);
              }
              
              if(j>0){
                valor=m.get_Posicao_valor(i, j-1);//esquerda
                     if(valor!= Bomba)  m.set_Posicao(valor+1, i, j-1);
              }
              
              if(i<tamanho-1 && j<tamanho-1)
              {    
                valor=m.get_Posicao_valor(i+1, j+1);//inferior direito
                    if(valor!= Bomba)   m.set_Posicao(valor+1, i+1, j+1);
              }
              
              if(i<tamanho-1 && j>0){
                valor=m.get_Posicao_valor(i+1, j-1);//inferior esquerdo
                     if(valor!= Bomba)  m.set_Posicao(valor+1, i+1, j-1); 
              }
              
              if(i>0 && j<tamanho-1){
                valor=m.get_Posicao_valor(i-1, j+1);//superior direito
                     if(valor!= Bomba)  m.set_Posicao(valor+1, i-1, j+1);
              }
              if(i>0 && j>0)       
              {valor=m.get_Posicao_valor(i-1, j-1);//superior esquerdo
                    if(valor!= Bomba)   m.set_Posicao(valor+1, i-1, j-1);     
              }      
            }
            
            
            private void posiciona_bombas()
            {   
                Random gerador=new Random();
                int count=0;
                int valor;
                int linha;
                int coluna;
             
                
                
                
                while(count<this.Nbombas)
                {  
                   linha=gerador.nextInt(this.tamanho);
                   coluna=gerador.nextInt(this.tamanho);
                   valor=m.get_Posicao_valor(linha,coluna);
                   
                 
                   if(valor==Bomba)
                   {
                       
                   }else
                   {
                       m.set_Posicao(Bomba, linha, coluna);
                       this.soma1_adjacentes(linha, coluna);
                       this.posicao_bombas[count++]=this.m.get_Posicao(linha, coluna);
                      
                   }
                }
            }
            
           
            
}
