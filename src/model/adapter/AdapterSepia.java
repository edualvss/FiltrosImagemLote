/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.adapter;

import java.awt.image.BufferedImage;
import model.GODClass;
import model.ModeladorImagem;

/**
 *
 * @author Eduardo
 */
public class AdapterSepia implements ModeladorImagem {

    @Override
    public BufferedImage aplicarEfeito(BufferedImage imagem) {
        try {
            return GODClass.getVersaoSepiaDaImagem(imagem);
        } catch (Exception ex) {
            System.out.println("Problema ao aplicar sépia na imagem, no adapter");
        }
        return null;
    }

    @Override
    public void adicionarEfeito(ModeladorImagem efeito) {}

    @Override
    public void removerEfeito(int posicao) {}

    @Override
    public ModeladorImagem getEfeitoPos(int i) {
        return this;
    }

    @Override
    public int getQuantidadeEfeitos() {
        return 1;
    }
    
}
