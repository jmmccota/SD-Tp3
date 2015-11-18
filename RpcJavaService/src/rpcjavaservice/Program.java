package rpcjavaservice;

import eneter.messaging.endpoints.rpc.IRpcService;
import eneter.messaging.endpoints.rpc.RpcFactory;

public class Program {

    public static void main(String[] args) throws Exception {
        // Inst�ncia do Leiloeiro.
        Leiloeiro aLeiloeiro = new Leiloeiro();

        // Coloca o Leilao como um servico
        RpcFactory anRpcFactory = new RpcFactory();

        IRpcService<ILeiloeiro> aServiceL = anRpcFactory.createSingleInstanceService(aLeiloeiro, ILeiloeiro.class);
       
         /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuPrincipal mp = new MenuPrincipal(aLeiloeiro,aServiceL);
                mp.setVisible(true);
                mp.setLocationRelativeTo(null);
            }
        });
        aServiceL.detachDuplexInputChannel();
    }
}
