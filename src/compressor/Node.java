/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compressor;

/**
 *
 * @author Sakemi
 */
public class Node {

    private String element;
    private Node next;

    public Node(String element, Node next) {
        this.element = element;
        this.next = next;
    }

    public String getElement() {
        return element;
    }

    public Node getNext() {
        return next;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public boolean equals(Node node) {
        return this.element.equals(node.element);
    }

    @Override
    public String toString() {
        return "Node{element = " + element + ", prox= " + next + "}";

    }

}
