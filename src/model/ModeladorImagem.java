/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Eduardo
 */
public interface ModeladorImagem {
        
    public java.awt.image.BufferedImage aplicarEfeito(java.awt.image.BufferedImage imagem);
    
    public void adicionarEfeito(ModeladorImagem efeito);
    
    public void removerEfeito(int posicao);
    
    public ModeladorImagem getEfeitoPos(int i);
    
    public int getQuantidadeEfeitos();
}
