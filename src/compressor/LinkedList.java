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
            if (temp.getElement().equals(element)) {
                return cont;
            }
            temp = temp.getNext();
            cont++;
        }

        return -1;
    }

    public void addAtPosition(String element, int position) {
        Node temp = first;
        Node node = new Node(element, null);

        if (isEmpty() || position <= 0) {
            addAtStart(element);
            return;
        }

        for (int i = 0; i < position - 1; i++) {
            if (temp.getNext() == null) {
                temp.setNext(node);
                return;
            }
            temp = temp.getNext();
        }
        node.setNext(temp.getNext());
        temp.setNext(node);
    }

    public void removeFromStart() {
        if (isEmpty()) {
            return;
        }
        first = first.getNext();
    }

    public void removeFrom(int position) {
        int i = 0;
        Node temp = first;

        if (isEmpty()) {
            return;
        }

        if (position == 0) {
            first = first.getNext();
            return;
        }

        while (i < position - 1) {
            temp = temp.getNext();
            i++;
        }

        temp.setNext(temp.getNext().getNext());
    }

    @Override
    public String toString() {
        Node temp = this.first;
        String list = "";

        while (temp != null) {
            list += temp.getElement();
            temp = temp.getNext();
        }

        return list;
    }
}
