/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.composite;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import model.ModeladorImagem;

/**
 *
 * @author Eduardo
 */
public class Composite implements ModeladorImagem {

    private List<ModeladorImagem> modeladores = new ArrayList<ModeladorImagem>();
    
    @Override
    public BufferedImage aplicarEfeito(BufferedImage imagem) {
        
        for(ModeladorImagem efeito : this.modeladores) {
            imagem = efeito.aplicarEfeito(imagem);
        }
        return imagem;
    }

    @Override
    public void adicionarEfeito(ModeladorImagem efeito) {
        this.modeladores.add(efeito);
    }

    @Override
    public void removerEfeito(int posicao) {
        this.modeladores.remove(posicao);
    }

    @Override
    public ModeladorImagem getEfeitoPos(int i) {
        if( this.modeladores.isEmpty() ) {
            return null;
        }
        return this.modeladores.get(i);
    }

    @Override
    public int getQuantidadeEfeitos() {
        return this.modeladores.size();
    }
    
}
