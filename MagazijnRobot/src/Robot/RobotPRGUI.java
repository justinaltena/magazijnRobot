package Robot;

public class RobotPRGUI extends javax.swing.JFrame {

    private boolean orderCheck;

    public RobotPRGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bPPPanel1 = new Robot.BPPPanel();
        bPPPanel2 = new Robot.BPPPanel();
        bPPPanel3 = new Robot.BPPPanel();
        bPPPanel4 = new Robot.BPPPanel();
        bPPPanel5 = new Robot.BPPPanel();
        bPPPanel6 = new Robot.BPPPanel();
        bPPPanel7 = new Robot.BPPPanel();
        jbLaadorder = new javax.swing.JButton();
        jbStart = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jtaConsole = new java.awt.TextArea();
        tsppanel = null; TSPPanel tsppanel = new TSPPanel();
        bpppanel = null; BPPPanel bpppanel = new BPPPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AS/RS Robotopstelling");
        setMinimumSize(new java.awt.Dimension(1200, 900));
        setPreferredSize(new java.awt.Dimension(1500, 1000));

        jbLaadorder.setText("Inladen order");
        jbLaadorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLaadorderActionPerformed(evt);
            }
        });

        jbStart.setText("Start simulatie");
        jbStart.setEnabled(false);
        jbStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStartActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout tsppanelLayout = new javax.swing.GroupLayout(tsppanel);
        tsppanel.setLayout(tsppanelLayout);
        tsppanelLayout.setHorizontalGroup(
            tsppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1109, Short.MAX_VALUE)
        );
        tsppanelLayout.setVerticalGroup(
            tsppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout bpppanelLayout = new javax.swing.GroupLayout(bpppanel);
        bpppanel.setLayout(bpppanelLayout);
        bpppanelLayout.setHorizontalGroup(
            bpppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bpppanelLayout.setVerticalGroup(
            bpppanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtaConsole, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbStart, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbLaadorder))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tsppanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bpppanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bpppanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tsppanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtaConsole, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLaadorder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jbStart, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLaadorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLaadorderActionPerformed
        // TODO add your handling code here:
        if (orderCheck == true) {
            jtaConsole.append("Er is al een order ingeladen.\n");
        } else {
            XMLorderDOM.main();
            jtaConsole.setText(XMLorderDOM.orderFile.printOrder());
//                OrderPanel orderDetails = new OrderPanel();
//                add(orderDetails);
//                orderDetails.setVisible(true);
            jbStart.enabled(true);
            orderCheck = true;
        }
    }//GEN-LAST:event_jbLaadorderActionPerformed

    private void jbStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStartActionPerformed
        // TODO add your handling code here:
        RobotStart.main();
    }//GEN-LAST:event_jbStartActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(RobotPRGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RobotPRGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RobotPRGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RobotPRGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RobotPRGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Robot.BPPPanel bPPPanel1;
    private Robot.BPPPanel bPPPanel2;
    private Robot.BPPPanel bPPPanel3;
    private Robot.BPPPanel bPPPanel4;
    private Robot.BPPPanel bPPPanel5;
    private Robot.BPPPanel bPPPanel6;
    private Robot.BPPPanel bPPPanel7;
    private javax.swing.JPanel bpppanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbLaadorder;
    private javax.swing.JButton jbStart;
    private java.awt.TextArea jtaConsole;
    private javax.swing.JPanel tsppanel;
    // End of variables declaration//GEN-END:variables
}
