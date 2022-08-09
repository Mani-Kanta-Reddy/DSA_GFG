package DS;

import java.math.BigInteger;

public class GenericDoublyLinkedList<T> {
    Node<T> head;
    Node<T> tail;

    static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //boolean isEmpty()
    public boolean isEmpty() {
        return head == null && tail == null;
    }
    //int size()
    public int size() {
        int count = 0;
        Node<T> temp = head;
        while(temp != null) {
            count++;
            temp = temp.right;
        }
        return count;
    }
    //add(T data)
    public GenericDoublyLinkedList<T> add(T data) {
        Node<T> newNode = new Node<>(data);
        //if list is empty add first
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.left = tail;
            tail.right = newNode;
            tail = newNode;
        }
        return this;
    }
    //add(int index, T data)   
    public GenericDoublyLinkedList<T> add(int index, T data) {
        Node<T> newNode = new Node<>(data);
        if(index > size()) {
            throw new UnsupportedOperationException("Index: " + index + " is larger than the no.of elements in the list");
        }
        else if(index == 0) {
            newNode.right = head;
            head.left = newNode;
            head = newNode;
        }
        else if(index == size()) {
            newNode.left = tail;
            tail.right = newNode;
            tail = newNode;
        } else {
            int idx = 0;
            Node<T> temp = head;
            while(idx != index) {
                temp = temp.right;
                idx++;
            }
            temp.left.right = newNode;
            newNode.left = temp.left;
            temp.left = newNode;
            newNode.right = temp;
        }
        return this;
    } 
    //set(T oldData, T newData) updates first occurrance with the new value
    public T set(T oldData, T newData) {
        Node<T> temp = head;
        while(temp.data != oldData) {
            temp = temp.right;
        }
        T dataBeforeUpdate = temp.data;
        temp.data = newData;
        return dataBeforeUpdate;
    }
    //set(int index, T newData) Updates element at index with the new Value
    public T set(int index, T newData) {
        T dataBeforeUpdate;
        if(index >= size()) {
            throw new UnsupportedOperationException("Index: " + index + " is larger than the total no.of elements present inside the list");
        } else{
            int mid = size() / 2;
            Node<T> temp;
            if(index <= mid) {  //use left-pointer i.e., head
                int idx = 0;
                temp = head;
                while(idx != index) {
                    temp = temp.right;
                    idx++;
                }

            } else {    //use right-pointer i.e., tail
                int idx = size() - 1;
                temp = tail;
                while(idx != index) {
                    temp = temp.left;
                    idx--;
                }
            }
            dataBeforeUpdate = temp.data;
            temp.data = newData;
        }
        return dataBeforeUpdate;
    }
    //remove(int index)
    public T remove(int index) {
        //if index is lager than the no.of elements in the list
        T dataDeleted;
        if(index > size() - 1) {
            throw new UnsupportedOperationException("Index: " + index + " is greater than the total no.of elements present in the list");
        }
        //if index is '0' i.e., there is only one element 
        else if(index == 0) {
            dataDeleted = head.data;
            head = head.right;
            head.left.right = null;
            head.left = null;
        }
        //if index is `size() - 1` 
        else if(index == size() - 1) {
            dataDeleted = tail.data;
            tail = tail.left;
            tail.right.left = null;
            tail.right = null;
        } else {
            int idx = 0;
            Node<T> temp = head;
            while(idx != index) {
                temp = temp.right;
            }
            dataDeleted = temp.data;
            temp.left.right = temp.right;
            temp.right.left = temp.left;
            temp.left = temp.right = null;
        }
        return dataDeleted;
    }
    //remove(T data)            removes first occurance
    public T remove(T data) {
        T dataDeleted;
        int n = size();
        int idx = 0;
        Node<T> temp = head;
        while(idx < n && data != temp.data) {
            temp = temp.right;
            idx++;
        }
        if(idx >= n) {
            throw new UnsupportedOperationException("Data: " + data + " is not present inside the list");
        } else if(idx == 0) {
            dataDeleted = head.data;
            head = head.right;
            head.left.right = null;
            head.left = null;
        } else if(idx == n - 1) {
            dataDeleted = tail.data;
            tail = tail.left;
            tail.right.left = null;
            tail.right = null;
        } else {
            dataDeleted = temp.data;
            temp.left.right = temp.right;
            temp.right.left = temp.left;
            temp.left = temp.right = null;
        }
        return dataDeleted;
    }
    //toString()
    @Override
    public String toString() {
        Node<T> temp = head;
        StringBuilder sb = new StringBuilder();
        while(temp != null) {
            sb.append(temp.data + " ");
            temp = temp.right;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        GenericDoublyLinkedList<Integer> intList = new GenericDoublyLinkedList<>();
        intList.add(1);
        intList.add(1, Integer.valueOf(2));
        intList.add(3);
        intList.add(4);
        intList.add(5);
        // intList.add(99, Integer.valueOf(100));
        System.out.println(intList);
        // System.out.println(intList.remove(4));
        System.out.println(intList);
        // System.out.println(intList.remove(0));
        System.out.println(intList);
        // System.out.println(intList.remove(99));
        // System.out.println(intList.remove(Integer.valueOf(2)));
        // System.out.println(intList.remove(Integer.valueOf(99)));
        // System.out.println(intList.remove(Integer.valueOf(1)));
        System.out.println(intList);
        // System.out.println(intList.remove(Integer.valueOf(5)));
        System.out.println(intList);
        // System.out.println(intList.set(Integer.valueOf(2) , Integer.valueOf(-2)));
        // System.out.println(intList.set(4, Integer.valueOf(-4)));
        // System.out.println(intList.set(99, Integer.valueOf(-99)));
        System.out.println(intList);
        
    }
}