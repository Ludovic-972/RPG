package objects.sac;

import objects.items.Item;

public class Stack{

    private static final int SIZE_MAX = 30;


    private int size;
    private Item item;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Stack(Item i){
        item = i;
        size = 1;
    }

    public int add(Item i){
        if(size < SIZE_MAX && i instanceof Stackable && this.item.equals(i)){
            size++;
            return 0;
        }else
            return -1;
    }

    public int remove(){
        if(size > 0)
            size --;
        if (size == 0)
            return -1;
        else return 0;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(item);
        if(item instanceof Stackable)
            sb.append("(").append(size).append(")");
        return sb.toString();
    }
}

