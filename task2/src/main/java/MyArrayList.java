import java.util.*;

public class MyArrayList<E> implements List<E> {

    private E[] arr;
    private int counter = 0;
    private static final int DEFAULT_ARRAY_SIZE = 10;

    public MyArrayList() {
        this.arr = (E[])new Object[DEFAULT_ARRAY_SIZE];

    }

    public MyArrayList(E[] array) {
        this.arr = (E[])new Object[array.length];
        for (int i = 0; i < array.length; i++){
            add(array[i]);
        }
    }

    public MyArrayList(int size) {
        this.arr = (E[])new Object[size];
    }

    public int size(){
        return counter;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean add(E value){

        if(value == null){
            System.out.println("\n" + "Value not valid");
            return false;
        }


        int newSize = arr.length;

        if(!checkSize(counter + 1)){
            newSize = moreSize(arr.length);
        }

        E[] mas = (E[]) new Object[newSize];

        System.arraycopy(arr, 0, mas, 0, counter);
        mas[counter] = value;

        counter++;

        this.arr = Arrays.copyOf(mas, newSize);

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E o : c) {
            add(o);
        }
        return true;

    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void add(int index, E value){

        if(!checkIndex(index)) return;

        if(value == null){
            System.out.println("\n" + "Value not valid");
            //return false;
        }


        int newSize = arr.length;

        if(!checkSize(counter + 1)){
            newSize = moreSize(arr.length);
        }

        E[] mas = (E[]) new Object[newSize];

        System.arraycopy(arr, 0, mas, 0, index);
        mas[index] = value;
        System.arraycopy(arr, index, mas, index + 1, counter - index);

        counter++;

        this.arr = Arrays.copyOf(mas, newSize);

        //return  true;
    }

    public E get(int index){

        if(!checkIndex(index)) return null;

        return arr[index];
    }

    public E set(int index, E value){

        if(!checkIndex(index)) return null;

        if(value == null){
            System.out.println("\n" + "Value not valid");
            return null;
        }


        E origin = arr[index];
        arr[index] = value;

        return origin;
    }

    public void clear(){
        this.arr = (E[]) new Object[0];
        counter = 0;
    }
    //     Fixed KISS
    public E remove(int index){

        if(!checkIndex(index)) return null;

        E origin = arr[index];

        System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);

        counter--;

        return origin;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    //   Fixed KISS
    public boolean remove(Object value){

        if(value == null){
            System.out.println("\n" + "Value not valid");
            return false;
        }


        for (int i = 0; i <arr.length ; i++) {

            if(value.equals(arr[i])){

                System.arraycopy(arr, i + 1, arr, i, arr.length - i - 1);

                counter--;

                return  true;
            }
        }
        System.err.println(value + " - not found, try again");

        return false;
    }

    public boolean contains(Object value){

        if(value == null){
            System.out.println("\n" + "Value not valid");
            return false;
        }


        for (int i = 0; i < arr.length ; i++) {

            if(value.equals(arr[i])){
                return true;
            }
        }
        return false;
    }

    private boolean checkIndex(int index){

        if(index < 0 || index >= counter){
            System.out.println("Index not valid");
            return false;
        }

        return true;
    }

    private boolean checkSize(int count){

        if(count > arr.length) {return false;}

        return true;
    }

    private int moreSize(int size){

        return (size * 3) / 2 + 1;
    }

}
