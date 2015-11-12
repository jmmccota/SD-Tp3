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

//        // Usa TCP.
//        IMessagingSystemFactory aMessaging = new TcpMessagingSystemFactory();
//        IDuplexInputChannel anInputChannel = aMessaging.createDuplexInputChannel("tcp://127.0.0.1:38445/");
//
//        //Ouvir canal de entrada
//        aServiceL.attachDuplexInputChannel(anInputChannel);
//
//        int opc = -1;
//
//        while (opc != 0) {
//            opc = Integer.parseInt(JOptionPane.showInputDialog(null, "__________MENU__________\n"
//                    + "| 1 - Cadastrar Produto|\n"
//                    + "| 2 - Pesquisar Produto|\n"
//                    + "| 0 - Sair             |\n"));
//            if (opc == 1) {
//                String nome = JOptionPane.showInputDialog(null, "Digite o Nome");
//                double preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o Preco Inicial"));
//                int terminoSegundos = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tempo ativo em segundos"));
//                long termino = new Date().getTime();
//                termino = termino + (terminoSegundos * 1000);
//                JOptionPane.showMessageDialog(null, "Produto Cadastrado. Codigo dele:" + aLeiloeiro.arrayProdutos.size());
//                aLeiloeiro.AddProduto(nome, preco, termino);
//            } else if (opc == 2) {
//                int codigoProduto = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Codigo do Produto"));
//                if (codigoProduto < 0 || codigoProduto >= aLeiloeiro.arrayProdutos.size()) {
//                    JOptionPane.showMessageDialog(null, "Codigo Invalido");
//                } else {
//                    Produto prodAux = aLeiloeiro.arrayProdutos.get(codigoProduto);
//                    String nome = prodAux.getNome();
//                    double precoAtual = prodAux.getPreco();
//                    long termino = prodAux.getTermino();
//                    String cliente = prodAux.getCliente();
//                    String terminou;
//                    long aux = new Date().getTime();
//                    if (aux > termino) {
//                        terminou = "Terminou";
//                    } else {
//                        terminou = "NÃO Terminou";
//                    }
//                    JOptionPane.showMessageDialog(null, "Produto " + codigoProduto + "\n"
//                            + "Nome: " + nome + "\n"
//                            + "Preco Atual: " + precoAtual + "\n"
//                            + "Cliente: " + cliente + "\n"
//                            + "Termino(em seg.): " + (termino * 0.001) + "\n"
//                            + "Tempo Atual: " + (aux * 0.001) + "\n"
//                            + terminou);
//                }
//            }
//        }
        //Desanexa o canal de entrada e para de ouvir.
        
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
