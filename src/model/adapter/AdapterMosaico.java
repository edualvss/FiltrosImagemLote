/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.adapter;

import com.jhlabs.image.BlockFilter;
import java.awt.image.BufferedImage;
import model.ModeladorImagem;

/**
 *
 * @author Eduardo
 */
public class AdapterMosaico implements ModeladorImagem {

    @Override
    public BufferedImage aplicarEfeito(BufferedImage imagem) {
        
        BlockFilter aplicador = new BlockFilter();
        aplicador.setBlockSize(10);
        return aplicador.filter(imagem, imagem);
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
