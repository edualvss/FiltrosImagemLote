
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Eduardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Aplica o tema do sistema a aplicação
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println("Erro ao selecionar tema");
        }
        // Inicia a aplicação
        view.Visao tela = new view.TelaPrincipal();
        control.Controle ctrl = new control.Controle(tela);
        ((view.TelaPrincipal)tela).setControle(ctrl);
        ctrl.iniciarApp();
        
    }
}
