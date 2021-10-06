/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TelaPrincipal.java
 *
 * Created on 04/11/2011, 10:53:44
 */
package view;

import control.Controle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;


/**
 *
 * @author Eduardo
 */
public class TelaPrincipal extends javax.swing.JFrame implements Visao {
    private static final long serialVersionUID = 1L;

    public TelaPrincipal() {
        initComponents();
        this.navegador = new JFileChooser("Escolha o diretório");
        this.navegador.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
        this.setIconImage( new javax.swing.ImageIcon( getClass().getResource("/icon/troll.png") ).getImage() );
        this.setResizable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollListaImagens = new javax.swing.JScrollPane();
        listaImagens = new javax.swing.JList<String>();
        scrollFiltrosDisponiveis = new javax.swing.JScrollPane();
        listaFiltrosDisponiveis = new javax.swing.JList<String>();
        scrollFiltrosSelecionados = new javax.swing.JScrollPane();
        listaFiltrosSelecionados = new javax.swing.JList<String>();
        scrollPropriedadesFiltro = new javax.swing.JScrollPane();
        painelImagemOriginal = new javax.swing.JPanel();
        imagePanelOriginal = new view.ImagePanel();
        paintelImagemFiltro = new javax.swing.JPanel();
        imagePanelFiltro = new view.ImagePanel();
        barraMenu = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        itemAbrirDiretorio = new javax.swing.JMenuItem();
        itemProcessarImagem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CadEAS");
        setName("tela"); // NOI18N

        scrollListaImagens.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Imagens", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 18), java.awt.Color.blue)); // NOI18N

        listaImagens.setForeground(new java.awt.Color(153, 153, 153));
        listaImagens.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaImagens.setName("listaImagens"); // NOI18N
        scrollListaImagens.setViewportView(listaImagens);

        scrollFiltrosDisponiveis.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros Disponíveis", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 18), java.awt.Color.gray)); // NOI18N

        listaFiltrosDisponiveis.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaFiltrosDisponiveis.setName("listaFiltrosDisponiveis"); // NOI18N
        scrollFiltrosDisponiveis.setViewportView(listaFiltrosDisponiveis);

        scrollFiltrosSelecionados.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros Selecionados", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 18), java.awt.Color.red)); // NOI18N

        listaFiltrosSelecionados.setModel(new DefaultListModel());
        listaFiltrosSelecionados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaFiltrosSelecionados.setName("listaFiltrosSelecionados"); // NOI18N
        scrollFiltrosSelecionados.setViewportView(listaFiltrosSelecionados);

        scrollPropriedadesFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Propriedades do filtro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 18), java.awt.Color.black)); // NOI18N

        painelImagemOriginal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imagem Original", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 14), java.awt.Color.green)); // NOI18N

        javax.swing.GroupLayout imagePanelOriginalLayout = new javax.swing.GroupLayout(imagePanelOriginal);
        imagePanelOriginal.setLayout(imagePanelOriginalLayout);
        imagePanelOriginalLayout.setHorizontalGroup(
            imagePanelOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );
        imagePanelOriginalLayout.setVerticalGroup(
            imagePanelOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelImagemOriginalLayout = new javax.swing.GroupLayout(painelImagemOriginal);
        painelImagemOriginal.setLayout(painelImagemOriginalLayout);
        painelImagemOriginalLayout.setHorizontalGroup(
            painelImagemOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanelOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelImagemOriginalLayout.setVerticalGroup(
            painelImagemOriginalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanelOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        paintelImagemFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Imagem com filtro(s)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monotype Corsiva", 0, 14), java.awt.Color.orange)); // NOI18N

        javax.swing.GroupLayout imagePanelFiltroLayout = new javax.swing.GroupLayout(imagePanelFiltro);
        imagePanelFiltro.setLayout(imagePanelFiltroLayout);
        imagePanelFiltroLayout.setHorizontalGroup(
            imagePanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );
        imagePanelFiltroLayout.setVerticalGroup(
            imagePanelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout paintelImagemFiltroLayout = new javax.swing.GroupLayout(paintelImagemFiltro);
        paintelImagemFiltro.setLayout(paintelImagemFiltroLayout);
        paintelImagemFiltroLayout.setHorizontalGroup(
            paintelImagemFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanelFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        paintelImagemFiltroLayout.setVerticalGroup(
            paintelImagemFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanelFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menuArquivo.setText("Arquivo");

        itemAbrirDiretorio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        itemAbrirDiretorio.setText("Abrir diretório de Imagens");
        itemAbrirDiretorio.setActionCommand("abrirDir");
        menuArquivo.add(itemAbrirDiretorio);

        itemProcessarImagem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        itemProcessarImagem.setText("Processar Imagens");
        itemProcessarImagem.setActionCommand("processarImagens");
        menuArquivo.add(itemProcessarImagem);

        barraMenu.add(menuArquivo);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(painelImagemOriginal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(scrollListaImagens, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollFiltrosDisponiveis, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollFiltrosSelecionados, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPropriedadesFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                    .addComponent(paintelImagemFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollListaImagens, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(scrollFiltrosDisponiveis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(scrollPropriedadesFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(scrollFiltrosSelecionados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paintelImagemFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelImagemOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-600)/2, 800, 600);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private view.ImagePanel imagePanelFiltro;
    private view.ImagePanel imagePanelOriginal;
    private javax.swing.JMenuItem itemAbrirDiretorio;
    private javax.swing.JMenuItem itemProcessarImagem;
    private javax.swing.JList<String> listaFiltrosDisponiveis;
    private javax.swing.JList<String> listaFiltrosSelecionados;
    private javax.swing.JList<String> listaImagens;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JPanel painelImagemOriginal;
    private javax.swing.JPanel paintelImagemFiltro;
    private javax.swing.JScrollPane scrollFiltrosDisponiveis;
    private javax.swing.JScrollPane scrollFiltrosSelecionados;
    private javax.swing.JScrollPane scrollListaImagens;
    private javax.swing.JScrollPane scrollPropriedadesFiltro;
    // End of variables declaration//GEN-END:variables
    private control.Controle controle;
    private JFileChooser navegador;

    public void setControle(Controle controle) {
        this.controle = controle;
        this.addListeners();
    }

    public void addListeners() {
        this.itemAbrirDiretorio.addActionListener( controle );
        this.itemProcessarImagem.addActionListener( controle );
        this.listaImagens.addListSelectionListener( controle );
        this.listaFiltrosDisponiveis.addMouseListener( controle );
        this.listaFiltrosSelecionados.addMouseListener( controle );
    }

    public DefaultListModel<String> getModeloListaFiltrosSelecionados() {
        return (DefaultListModel<String>) this.listaFiltrosSelecionados.getModel();
    }
    
    @Override
    public String abrirDiretorioCarregamento() {
        this.navegador.setDialogType( JFileChooser.OPEN_DIALOG );
        if( this.navegador.showOpenDialog(this) == JFileChooser.APPROVE_OPTION ) {
            return this.navegador.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    @Override
    public String abrirDiretorioSalvamento() {
        this.navegador.setDialogType( JFileChooser.SAVE_DIALOG );
        if( this.navegador.showSaveDialog(this) == JFileChooser.APPROVE_OPTION ) {
            return this.navegador.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    @Override
    public void carregarFotoOriginal(java.io.File local) {
        try {
            this.imagePanelOriginal.setImagem( local );
        } catch (Exception ex) {
            System.out.println("Erro ao carregar a foto original");
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void carregarFotoComFiltro(java.awt.Image imagem) {
        try {
            this.imagePanelFiltro.setImagem(imagem);
        } catch (Exception ex) {
            System.out.println("Erro ao carregar a foto com filtro");
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void adicionarFiltro(String filtro) {
        DefaultListModel<String> modelo = (DefaultListModel<String>) this.listaFiltrosSelecionados.getModel();
        modelo.addElement(filtro);
    }

    @Override
    public void removerFiltro(int indice) {
        DefaultListModel<String> modelo = (DefaultListModel<String>) this.listaFiltrosSelecionados.getModel();
        modelo.removeElementAt(indice);
    }

    @Override
    public void carregarListaFotos(String[] fotos) {
        DefaultListModel<String> modeloLista = new DefaultListModel<String>();
        for( String foto : fotos ) {
            modeloLista.addElement(foto);
        }
        
        this.listaImagens.setModel(modeloLista);
        this.listaImagens.setSelectedIndex(0);
    }

    @Override
    public void carregarListaFiltrosDisponiveis(String[] filtros) {
        DefaultListModel<String> modeloLista = new DefaultListModel<String>();
        for( String filtro : filtros ) {
            modeloLista.addElement(filtro);
        }
        this.listaFiltrosDisponiveis.setModel(modeloLista);
    }

    @Override
    public void exibirMensagem(String mensagem) {
        javax.swing.JOptionPane.showMessageDialog(this, mensagem);
    }
    
}
