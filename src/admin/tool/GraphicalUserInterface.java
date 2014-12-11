/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.tool;
import javax.swing.*;

/**
 *
 * @author Paul
 */
public class GraphicalUserInterface extends JFrame {

    /**
     * Creates new form GraphicalUserInterface
     */
    public GraphicalUserInterface() {
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

        pnl_template = new javax.swing.JPanel();
        btn_start = new javax.swing.JButton();
        btn_categories = new javax.swing.JButton();
        btn_questions = new javax.swing.JButton();
        btn_quit = new javax.swing.JButton();
        btn_options = new javax.swing.JButton();
        pnl_content = new javax.swing.JPanel();
        pnl_start = new javax.swing.JPanel();
        pnl_categoryList = new javax.swing.JPanel();
        lbl_categoryHeadline = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("qTool");

        pnl_template.setBackground(new java.awt.Color(255, 255, 255));

        btn_start.setBackground(new java.awt.Color(255, 255, 255));
        btn_start.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btn_start.setText("Start");
        btn_start.setFocusable(false);
        btn_start.setMaximumSize(new java.awt.Dimension(120, 35));
        btn_start.setMinimumSize(new java.awt.Dimension(120, 35));
        btn_start.setPreferredSize(new java.awt.Dimension(120, 35));

        btn_categories.setBackground(new java.awt.Color(255, 255, 255));
        btn_categories.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btn_categories.setText("Kategorien");
        btn_categories.setFocusable(false);
        btn_categories.setMaximumSize(new java.awt.Dimension(100, 35));
        btn_categories.setMinimumSize(new java.awt.Dimension(100, 35));
        btn_categories.setPreferredSize(new java.awt.Dimension(120, 35));
        btn_categories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoriesActionPerformed(evt);
            }
        });

        btn_questions.setBackground(new java.awt.Color(255, 255, 255));
        btn_questions.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btn_questions.setText("Fragen");
        btn_questions.setFocusable(false);
        btn_questions.setMaximumSize(new java.awt.Dimension(100, 35));
        btn_questions.setMinimumSize(new java.awt.Dimension(100, 35));
        btn_questions.setPreferredSize(new java.awt.Dimension(120, 35));
        btn_questions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_questionsActionPerformed(evt);
            }
        });

        btn_quit.setBackground(new java.awt.Color(255, 255, 255));
        btn_quit.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btn_quit.setText("Beenden");
        btn_quit.setFocusable(false);
        btn_quit.setMaximumSize(new java.awt.Dimension(100, 35));
        btn_quit.setMinimumSize(new java.awt.Dimension(100, 35));
        btn_quit.setPreferredSize(new java.awt.Dimension(120, 35));
        btn_quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quitActionPerformed(evt);
            }
        });

        btn_options.setBackground(new java.awt.Color(255, 255, 255));
        btn_options.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btn_options.setText("Fragen");
        btn_options.setFocusable(false);
        btn_options.setMaximumSize(new java.awt.Dimension(100, 35));
        btn_options.setMinimumSize(new java.awt.Dimension(100, 35));
        btn_options.setPreferredSize(new java.awt.Dimension(120, 35));
        btn_options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_optionsActionPerformed(evt);
            }
        });

        pnl_content.setLayout(new java.awt.CardLayout());
        pnl_content.add(pnl_start, "card2");

        lbl_categoryHeadline.setFont(new java.awt.Font("Calibri Light", 0, 36)); // NOI18N
        lbl_categoryHeadline.setText("Kategorien");

        javax.swing.GroupLayout pnl_categoryListLayout = new javax.swing.GroupLayout(pnl_categoryList);
        pnl_categoryList.setLayout(pnl_categoryListLayout);
        pnl_categoryListLayout.setHorizontalGroup(
            pnl_categoryListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_categoryListLayout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(lbl_categoryHeadline)
                .addContainerGap(386, Short.MAX_VALUE))
        );
        pnl_categoryListLayout.setVerticalGroup(
            pnl_categoryListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_categoryListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_categoryHeadline)
                .addContainerGap(353, Short.MAX_VALUE))
        );

        pnl_content.add(pnl_categoryList, "card3");

        javax.swing.GroupLayout pnl_templateLayout = new javax.swing.GroupLayout(pnl_template);
        pnl_template.setLayout(pnl_templateLayout);
        pnl_templateLayout.setHorizontalGroup(
            pnl_templateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_templateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_templateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_templateLayout.createSequentialGroup()
                        .addComponent(btn_start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_categories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_questions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_quit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnl_templateLayout.setVerticalGroup(
            pnl_templateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_templateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_templateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_categories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_questions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_quit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_template, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_template, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_categoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoriesActionPerformed
        
    }//GEN-LAST:event_btn_categoriesActionPerformed

    private void btn_questionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_questionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_questionsActionPerformed

    private void btn_quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_quitActionPerformed

    private void btn_optionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_optionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_optionsActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_categories;
    private javax.swing.JButton btn_options;
    private javax.swing.JButton btn_questions;
    private javax.swing.JButton btn_quit;
    private javax.swing.JButton btn_start;
    private javax.swing.JLabel lbl_categoryHeadline;
    private javax.swing.JPanel pnl_categoryList;
    private javax.swing.JPanel pnl_content;
    private javax.swing.JPanel pnl_start;
    private javax.swing.JPanel pnl_template;
    // End of variables declaration//GEN-END:variables
}
