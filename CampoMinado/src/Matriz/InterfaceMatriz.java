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
public interface InterfaceMatriz {
       
     
    public void inicia_Matriz(int n);
    public void set_Matriz(int n);
    public void set_Posicao(int n,int i,int j);
    public int get_Posicao_valor(int i,int j);
    public int get_Dimensao();
}
