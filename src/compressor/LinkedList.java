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
public class LinkedList {

    private Node first;
    private Node last;
    private int size;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int getSize() {
        return this.size;
    }

    public Node getFirst() {
        return this.first;
    }

    public Node getLast() {
        return this.last;
    }

    public void addAtStart(String element) {
        Node temp = new Node(element, this.first);

        if (isEmpty()) {
            this.last = temp;
        }

        this.first = temp;
        this.size++; 
    }

    public void addAtEnd(String element) {
        Node temp = new Node(element, null);

        if (isEmpty()) {
            this.first = temp;
            this.last = temp;
        } else {
            this.last.setNext(temp);
            this.last = last.getNext();
        }
        
        this.size++; 
    }
    
    public int linearSearch(String element) {
        Node temp = first;
        int cont = 0;

        while (temp != null) {
            if (temp.getElement() == element) {
                return cont;
            }
            temp = temp.getNext();
            cont++;
        }

        return -1;
    }
    
    @Override
    public String toString() {
        Node temp = this.first;
        String list = "";
        
        while(temp != null) {
            list += temp.getElement() + " ";
            temp = temp.getNext();
        }
        
        return list;
    }
}
