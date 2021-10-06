/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.ModeladorImagem;
import model.composite.Composite;
import view.TelaPrincipal;
import view.Visao;

/**
 *
 * @author Eduardo
 */
public class Controle implements ActionListener, ListSelectionListener, MouseListener {
    
    private Visao visao;
    private String diretorioAtual;
    private File[] arquivosCarregados;
    private int indiceImagemSelecionada;
    
    private String[] filtrosDisponiveis = {"Blur","Redimensionar","Riscar","Sépia","Tons de Cinza","Mosaico"};
    private String[] classesFiltrosDisponiveis = {"Blur","Redimensionar","Riscar","Sepia","TonsCinza","Mosaico"};
    
    private ModeladorImagem filtro;
    
    private Image imagemNula = new ImageIcon(getClass().getResource("/icon/nula.png")).getImage();
    
    private BufferedImage imagemFiltrada;
    
    public Controle(Visao visao) {
        this.visao = visao;
    }

    public void iniciarApp() {
        ((TelaPrincipal)visao).setVisible(true);
        this.carregarListaFiltrosDisponiveis();
    }

    public void abrirDiretorioCarregamento() {
        this.diretorioAtual = visao.abrirDiretorioCarregamento();
        if( this.diretorioAtual != null ) {
            File dir = new File(this.diretorioAtual);
            this.arquivosCarregados = dir.listFiles();
            carregarListaFotos();
        }
    }

    public void abrirDiretorioSalvamento() {
        this.diretorioAtual = visao.abrirDiretorioSalvamento();
        if( this.diretorioAtual != null) {
            if(this.arquivosCarregados != null) {
                if( this.filtro.getQuantidadeEfeitos() != 0 ) {
                    this.salvarImagensComFiltro();
                } else {
                    this.visao.exibirMensagem("Não há filtros selecionados");
                }
            } else {
                this.visao.exibirMensagem("Não há imagens carregadas para serem processadas");
            }
        }
    }

    public void carregarFotoOriginal() {
        this.visao.carregarFotoOriginal(this.arquivosCarregados[this.indiceImagemSelecionada]);
    }

    public void carregarFotoComFiltro() {
        try {
            this.visao.carregarFotoComFiltro( this.imagemFiltrada );
        } catch (Exception ex) {
            System.out.println( "Erro ao carregar foto com filtro(s)" );
        }
    }

    public void carregarListaFotos() {
        String[] fotos = new String[this.arquivosCarregados.length];
        for( int i = 0; i < this.arquivosCarregados.length; i++ ) {
            fotos[i] = this.arquivosCarregados[i].getName();
        }
        
        this.visao.carregarListaFotos(fotos);
        this.indiceImagemSelecionada = 0;
        this.carregarImagemSelecionada();
    }
    
    public void carregarListaFiltrosDisponiveis() {
        this.filtro = new Composite();
        this.visao.carregarListaFiltrosDisponiveis(this.filtrosDisponiveis);
    }
    
    private void carregarImagemSelecionada() {
        this.carregarFotoOriginal();
        try {
            this.imagemFiltrada = ImageIO.read(this.arquivosCarregados[this.indiceImagemSelecionada]);
        } catch (IOException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }
        if( this.filtro != null ) {
            this.imagemFiltrada = this.filtro.aplicarEfeito(imagemFiltrada);
            this.carregarFotoComFiltro();
        }
    }

    private void adicionarItemListaFiltrosSelecionados(int indiceItemSelecionado) {
        ModeladorImagem molde = null;
        try {
            molde = (ModeladorImagem) Class.forName("model.adapter.Adapter"+classesFiltrosDisponiveis[indiceItemSelecionado]).newInstance();
            this.filtro.adicionarEfeito(molde);
        } catch (Exception ex) {
            System.err.println("Erro ao adicionar filtro selecionado, no controle");
        }
        this.visao.adicionarFiltro(this.filtrosDisponiveis[indiceItemSelecionado]);
        if( this.imagemFiltrada != null ) {
            this.imagemFiltrada = molde.aplicarEfeito(imagemFiltrada);
        }
        this.carregarFotoComFiltro();
    }
    
    private void removerItemListaFiltrosSelecionados(int indiceItemSelecionado) {
        this.filtro.removerEfeito(indiceItemSelecionado);
        if(this.arquivosCarregados != null) {
            try {
                this.imagemFiltrada = this.filtro.aplicarEfeito(ImageIO.read(this.arquivosCarregados[this.indiceImagemSelecionada]));
            } catch (IOException ex) {
                Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.carregarFotoComFiltro();
        this.visao.removerFiltro(indiceItemSelecionado);
    }

    private String obterNomeClasse(String elemento) {
        for( int i = 0; i < this.filtrosDisponiveis.length; i++ ) {
            if( elemento.equals(this.filtrosDisponiveis[i]) ) {
                return this.classesFiltrosDisponiveis[i];
            }
        }
        return null;
    }
    
    private void salvarImagensComFiltro() {
        String dir = this.diretorioAtual;
        System.out.println("Pode esperar que aqui demora");
        for (File arquivo : this.arquivosCarregados) {
            String dirSalvar = dir +"\\"+ arquivo.getName();
            try {
                ImageIO.write(this.filtro.aplicarEfeito(ImageIO.read(arquivo)), "jpg", new File(dirSalvar));
            } catch (Exception ex) {
                System.out.println("Deu pau no salvamento");
            }
        }
        System.out.println("Deu ta tudo numa boa já");
    }
    
    ///////////////////////// Action Listener /////////////////////////
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String comando = ae.getActionCommand();
        
        if( comando.equals("abrirDir") ) {
            this.abrirDiretorioCarregamento();
        } else if( comando.equals("processarImagens") ) {
            this.abrirDiretorioSalvamento();
        }
        
    }


    ///////////////////////// ListSelectionListener /////////////////////////
    @Override
    public void valueChanged(ListSelectionEvent lse) {
        if( lse.getValueIsAdjusting() ) {
            @SuppressWarnings("unchecked")
            JList<String> lista = (JList<String>) lse.getSource();
            this.indiceImagemSelecionada = lista.getSelectedIndex();
            try {
                this.imagemFiltrada = ImageIO.read(this.arquivosCarregados[this.indiceImagemSelecionada]);
            } catch (IOException ex) {
                Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.carregarImagemSelecionada();
        }
    }

    ///////////////////////// MouseListener /////////////////////////
    @Override
    public void mouseClicked(MouseEvent me) {
        if( me.getClickCount() == 2 && me.getButton() == MouseEvent.BUTTON1 ) {
            @SuppressWarnings("unchecked")
            JList<String> lista = (JList<String>) me.getSource();
            int indiceItemSelecionado = lista.getSelectedIndex();
            String listaSelecionada = lista.getName();
            if( listaSelecionada.equals( "listaFiltrosDisponiveis" ) ) {
                this.adicionarItemListaFiltrosSelecionados(indiceItemSelecionado);
            } else if( listaSelecionada.equals( "listaFiltrosSelecionados" ) ) {
                if( lista.getModel().getSize() != 0 ) {
                    this.removerItemListaFiltrosSelecionados( indiceItemSelecionado );
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
    
}
