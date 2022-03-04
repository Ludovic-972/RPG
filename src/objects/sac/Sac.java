package objects.sac;


import objects.items.Item;

import java.util.LinkedList;


public class Sac {
    private Case head;
    private Case last;

    private int size;
    private final int SIZE_MAX = 30;

    public Sac(){
        size = 0;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSizeMax() {
        return SIZE_MAX;
    }

    public boolean isFull() {
        return size == SIZE_MAX;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Item i){
        if(size < SIZE_MAX){
            Case p;
            if(isEmpty()){
                p = new Case(new Stack(i));
                head = p;
                last = p;
                size = 1;
            }else{
                p = head;
                while(p != null){
                    if(p.stack.add(i) == 0)
                        break;
                    else
                        p = p.next;
                }
                if(p == null) {
                    last.next = new Case(new Stack(i));
                    last = last.next;
                    size++;
                }
            }
        }
    }

    public Stack get(int index){
        if(index <= size) {
            int i = 0;
            Case p = head;
            while (i < index) {
                p = p.next;
                i++;
            }
            return p.stack;

        }else return null;
    }

    public void set(Item o,int index){
        if(index < size){
            int i = 0;
            Case p = head;
            while(i < index){
                p = p.next;
                i++;
            }
            p.stack = new Stack(o);

        }
    }

    public void remove(int index) {
        if(index < size){
            if(index == 0){
                if(head.stack.remove() == -1){
                    head = head.next;
                    size--;
                }
            }else{
                Case p = head;
                int i = 0;
                while(i < index -1){
                    p = p.next;
                    i++;
                }
                if(p.next.stack.remove() == -1){
                    p.next = p.next.next;
                    size--;
                }
            }
        }
    }

    public void clear() {
        head = null;
        last = null;
        size = 0;
    }

    public int itemTotal(){
        Case p = head;
        int i = 0;
        while(p != null){
            i += p.stack.getSize();
            p = p.next;
        }
        return i;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Contenu du sac ("+size+" item(s) sur "+SIZE_MAX+") :\n");

        if(isEmpty()){
            sb.append("\tVide");
        }else{
            Case p = head;
            int i = 1;
            while(p != null){
                sb.append(i+"-"+p.stack +"\n");
                p = p.next;
                i++;
            }
        }

        return sb.toString();
    }

    public static class Case{
        Stack stack;
        Case next;

        public Case(Stack s){
            stack = s;
            next = null;
        }
    }

}
