package com.mycompany.javagraph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;


//calss links correspondants aux routes séparants les lieux
public class Link extends Line2D.Double {

    private String type; // A, N, D
    private double length;
    private String name;
    private Node[] nodes = new Node[2];
    private boolean isActive = false;
    private boolean isSelected = false;
    
    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected() {
        this.isSelected = true;
    }
    
    public void setNotSelected() {
        this.isSelected = false;
    }

    public void setActive() {
        this.isActive = true;
    }
    
    public void setInActive() {
        this.isActive = false;
    }
    
    private static int counter = 0; // compteur de routes

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node[] getNodes() {
        return nodes;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

    public Link(String type, double length) {
        this.type = type;
        this.length = length;
        this.name = type + "-" + counter++; // donne un nom à la route
    }

    public Link(String type, double length, Node n1, Node n2) {
        this.type = type;
        this.length = length;
        this.name = type + "-" + counter++; // donne un nom à la route
        this.nodes[0] = n1;
        this.nodes[1] = n2;
    }

    public void draw(Graphics2D g2d) {
        Node n1 = nodes[0];
        Node n2 = nodes[1];
        g2d.setStroke(new BasicStroke(2));
        if (isActive) {
            g2d.setColor(Color.red);
        }
        if (isSelected) {
            g2d.setColor(Color.green);
        }
        double n1cx = n1.getCenterX(), n1cy = n1.getCenterY();
        double n2cx = n2.getCenterX(), n2cy = n2.getCenterY();
        this.setLine(n1cx, n1cy, n2cx, n2cy);
        g2d.drawString(name, (int) (n1cx + n2cx)/2, (int) (n1cy + n2cy)/2);
        g2d.draw(this);
        g2d.setColor(Color.black);
    }

}
