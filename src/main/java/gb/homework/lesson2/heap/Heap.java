package gb.homework.lesson2.heap;

import java.util.ArrayList;

//Вообще дженерики так себе для примитивов подходят :(, но куда диваться, с ними красивше
public class Heap<T extends Comparable<T>> implements HeapInterface<T>{
    private final ArrayList<T> data;
    public Heap(int initialCapacity){
        data=new ArrayList<>(initialCapacity);
    }
    public Heap(){
        this(10);
    }
    @Override
    public T max() {
        if(data.size() > 0)return data.get(0);
        else throw new IllegalStateException("Heap is empty!");
    }

    @Override
    public T removeMax() {
        if(data.size() > 0){
            T result = data.get(0);
            if(data.size() > 1){
                data.set(0, data.remove(data.size() - 1));
                int size = data.size();
                for(int pi = 0, li = 1, ri = 2; li < size || ri < size; li = 2*pi + 1, ri = 2*pi + 2){
                    int indexToExchange = -1;
                    if((ri < size) ^ (li < size)) indexToExchange = Math.min(ri, li);
                    else indexToExchange = findIndexToExchange(pi, li, ri);
                    if(indexToExchange != -1) {
                        swapElements(pi, indexToExchange);
                        pi = indexToExchange;
                    }
                    else break;
                }
            }
            else data.remove(0);
            return result;
        }
        else throw new IllegalStateException("Heap is empty!");
    }
    private int findIndexToExchange(int parentIndex, int leftIndex, int rightIndex){
        boolean leftLargeRight = data.get(leftIndex).compareTo(data.get(rightIndex)) > 0;
        T parent = data.get(parentIndex);
        int largerIndexToExchange = leftLargeRight ? leftIndex : rightIndex;
        T largerChild = data.get(largerIndexToExchange);
        if(largerChild.compareTo(parent) >= 0) return largerIndexToExchange;
        int smallerIndexToExchange = leftLargeRight ? rightIndex : leftIndex;
        T smallerChild = data.get(smallerIndexToExchange);
        if(smallerChild.compareTo(parent) >= 0) return smallerIndexToExchange;
        return -1;
    }
    private void swapElements(int i, int j){
        T temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
    @Override
    public void add(T element) {
        data.add(element);
        for (int child = data.size() - 1, parent = (child - 1)/2; parent >= 0; child = parent, parent=(parent-1)/2) {
            T p = data.get(parent);
            T c = data.get(child);
            if(c.compareTo(p) >= 0){
                data.set(parent, c);
                data.set(child, p);
            }
            else break;
            if(parent == 0) break;
        }
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
