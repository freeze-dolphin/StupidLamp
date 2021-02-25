package io.freeze_dolphin.stupid_lamp;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class StupidLamp extends javax.swing.JFrame {

    public StupidLamp() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        a = new javax.swing.JTextField();
        b = new javax.swing.JTextField();
        c = new javax.swing.JTextField();
        d = new javax.swing.JTextField();
        calc = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta = new javax.swing.JTextArea();
        cb = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("StupidLamp");
        setAlwaysOnTop(true);
        setName("frame"); // NOI18N
        setResizable(false);

        a.setDocument(new NumberTextField());

        b.setDocument(new NumberTextField());

        c.setDocument(new NumberTextField());

        d.setDocument(new NumberTextField());

        calc.setText("Process");
        calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcActionPerformed(evt);
            }
        });

        jta.setEditable(false);
        jta.setColumns(20);
        jta.setRows(5);
        jta.setBorder(javax.swing.BorderFactory.createTitledBorder("Result"));
        jScrollPane1.setViewportView(jta);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "24", "21" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(calc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(calc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(a, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(d)
                            .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(c, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcActionPerformed

        if (a.getText().equals("") || b.getText().equals("") || c.getText().equals("") || d.getText().equals("")) {
            jta.setText("The parameters should not be empty");
            return;
        }

        if (Integer.parseInt(a.getText()) > 13 || Integer.parseInt(b.getText()) > 13 || Integer.parseInt(c.getText()) > 13 || Integer.parseInt(d.getText()) > 13) {
            jta.setText("The parameters should be less than 14");
            return;
        }

        jta.setText("");
        calc.setEnabled(false);
        calc.setText("...");

        try {
            ArrayList<Integer> in = new ArrayList<>();
            in.add(Integer.parseInt(a.getText()));
            in.add(Integer.parseInt(b.getText()));
            in.add(Integer.parseInt(c.getText()));
            in.add(Integer.parseInt(d.getText()));

            String result = new Point24Calculator(in, Integer.parseInt(cb.getSelectedItem().toString())).calc();
            ArrayList<String> ss = new ArrayList<>();
            for (String s : result.split("\n")) {
                if (ss.isEmpty() || !ss.contains(s)) {
                    ss.add(s);
                }
            }

            result = "";
            for (String s : ss) {
                result = result + s + "\n";
            }

            jta.setText(result);
            if (jta.getText().replaceAll("\t", "").replaceAll("\n", "").replaceAll(" ", "").equals("")) {
                jta.setText("No Result");
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(StupidLamp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            a.setText("");
            b.setText("");
            c.setText("");
            d.setText("");

            calc.setText("Calc");
            calc.setEnabled(true);
        }
    }//GEN-LAST:event_calcActionPerformed

    private static class NumberTextField extends PlainDocument {

        public NumberTextField() {
            super();
        }

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {

            if (str == null) {
                return;
            }

            char[] s = str.toCharArray();
            int length = 0;
            for (int i = 0; i < s.length; i++) {
                if ((s[i] >= '0') && (s[i] <= '9')) {
                    s[length++] = s[i];
                }
                super.insertString(offset, new String(s, 0, length), attr);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(StupidLamp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        EventQueue.invokeLater(() -> {
            new StupidLamp().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField a;
    private javax.swing.JTextField b;
    private javax.swing.JTextField c;
    private javax.swing.JButton calc;
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JTextField d;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jta;
    // End of variables declaration//GEN-END:variables
}
