/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.javagraph;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class Screen1 extends javax.swing.JFrame {
    
    private Graph graph;
    
    public static Screen1 sc;
    
    public void setSelectedNode(Node n) {
        n.setIsSelected(true);
        nodesList.setSelectedItem(n.getName());
    }
    public void setSelectedLink(Link lnk) {
        lnk.setSelected();
        linksList.setSelectedItem(lnk.getName());
    }

    /**
     * Creates new form HomeScreen
     */
    public Screen1(Graph graph) {
        if (sc != null) return;
        
        this.graph = graph;
        
        GraphPanel gpanel = new GraphPanel(graph);
        getContentPane().add(gpanel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setVisible(true);
        
        gpanel.setSize(600, 500);
        
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH); // To maximize a frame
        
        sc = this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nodesList = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        neighboursList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        linksList = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        connectedNodes = new javax.swing.JList<>();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1399, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 51, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Voisins");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 340, 29));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel2.setText("Voisins de");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        nodesList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nodesListActionPerformed(evt);
            }
        });
        for (int i=0; i<graph.getNodes().size(); i++) {
            nodesList.addItem(graph.getNodes().get(i).getName());
        }
        jPanel2.add(nodesList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 160, 30));

        neighboursList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Choisir une catégorie" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(neighboursList);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 160, 320));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel3.setText("Nœuds de");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        linksList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linksListActionPerformed(evt);
            }
        });
        for (int i=0; i<graph.getLinks().size(); i++) {
            linksList.addItem(graph.getLinks().get(i).getName());
        }
        jPanel2.add(linksList, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 150, 30));

        connectedNodes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Sélectionner le genre" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(connectedNodes);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 150, 320));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 40, 420, 580));

        backBtn.setBackground(new java.awt.Color(204, 204, 204));
        backBtn.setText("Back");
        backBtn.setFocusable(false);
        backBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nodesListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nodesListActionPerformed
        String selectedNode = (String) nodesList.getSelectedItem();
        
        graph.setAllInActive();
        
        Node foundNode = Graph.findNode(selectedNode, graph.getNodes());
        foundNode.setIsSelected(true);
        
        ArrayList<Node> neighbours = foundNode.getNeighbours();
        DefaultListModel<String> model = new DefaultListModel<>();
        
        for(Node neighbour : neighbours){
            model.addElement(neighbour.getName());
            // setting selected type active
            neighbour.setActive();
        }
        neighboursList.setModel(model);
        this.repaint();
    }//GEN-LAST:event_nodesListActionPerformed

    private void linksListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linksListActionPerformed
        // Detecte si on clique sur un lien, si c'est le cas le met en couleur ainsi que les noeuds qu'il relie
        String selectedLink = (String) linksList.getSelectedItem();
        graph.setAllInActive();
        
        Link foundLink = Graph.findLink(selectedLink, graph.getLinks());
        foundLink.setActive();
        foundLink.getNodes()[0].setActive();
        foundLink.getNodes()[1].setActive();
        
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement(foundLink.getNodes()[0].getName());
        model.addElement(foundLink.getNodes()[1].getName());
        connectedNodes.setModel(model);
        this.repaint();
    }//GEN-LAST:event_linksListActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // C'est le bouton retour permettant de revenir à l'écran de base
        this.setVisible(false);
        HomeScreen.hs.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JList<String> connectedNodes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox linksList;
    private javax.swing.JList<String> neighboursList;
    private javax.swing.JComboBox nodesList;
    // End of variables declaration//GEN-END:variables
}
