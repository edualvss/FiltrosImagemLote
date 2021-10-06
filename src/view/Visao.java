/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


/**
 *
 * @author Eduardo
 */
public interface Visao {
 
    public String abrirDiretorioCarregamento();

    public String abrirDiretorioSalvamento();
    
    public void carregarListaFotos(String[] fotos);

    public void carregarListaFiltrosDisponiveis(String[] filtros);
    
    public void carregarFotoOriginal(java.io.File local);
    
    public void carregarFotoComFiltro(java.awt.Image imagem);
    
    public void adicionarFiltro(String filtro);
    
    public void removerFiltro(int indice);
    
    public void exibirMensagem(String mensagem);
}
