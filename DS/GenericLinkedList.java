package DS;

import java.util.NoSuchElementException;

public class GenericLinkedList<T> {
    private Node<T> head;

    static class Node<T> {
        private T data; 
        private Node<T> next;
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    //isEmpty
    public boolean isEmpty() {
        return this.head == null;
    }
    //size
    public int size() {
        Node<T> temp = head;
        int count = 0;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
    //insert(data)
    public GenericLinkedList<T> add(T data) {
        Node<T> newNode = new Node<>(data);
        //check if the list is empty:
        if(isEmpty()) {
            head = newNode;
        } else {
            //traverse to the end of the list and add the data
            Node<T> temp = this.head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return this;
    }
    //insert(index, data)
    public GenericLinkedList<T> add(int index, T data) {
        Node<T> newNode = new Node<>(data);
        //considertng indexing starts from zero:
        int count = 0;
        //insert if isEmpty:
        if(isEmpty()) {
            head = newNode;
        }
        if(index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> temp = head;
            while(count != index - 1) {
                temp = temp.next;
                count++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return this;
    }
    //boolean remove(data)  if the data is occurring mutiple times just delete the first occurance
    public boolean remove(T data) {
        int count = 0;
        boolean isDeleted = false;
        //if list isEmpty you can't remove
        if(isEmpty())
            throw new UnsupportedOperationException("Element can't be deleted from an empty list");
        else {
            Node<T> curr = head;
            Node<T> prev = null;
            while(curr.data != data) {
                prev = curr;
                curr = curr.next;
                count++;
            }
            if(count == 0) {    //speacial-case removeFirst
                head = curr.next;
            } else {    //normal-case
                prev.next = curr.next;
            }
            isDeleted = true;
        }
        return isDeleted;
    }
    //oldData remove(index)
    public T remove(int index) {
        //if list isEmpty element at any index can't be deleted
        if(isEmpty()) {
            throw new UnsupportedOperationException("Element at index: " + index + " can't be deleted from an empty list");
        }
        if(index >= size()) {
            throw new UnsupportedOperationException("Index: " + index + " is greater than the no.of elements stored inside the list");
        }
        Node<T> curr = head;
        Node<T> prev = null;
        T dataDeleted;
        //if index is zero -> special-case:
        if(index == 0) {
            dataDeleted = curr.data;
            head = curr.next;
        } else {    //general-case
            int idx = 0;
            while(idx != index) {
                prev = curr;
                curr = curr.next;
                idx++;
            }
            dataDeleted = curr.data;
            prev.next = curr.next;
        }
        return dataDeleted;
    }
    //oldData update(oldData, newData)  if the data is occurring multiple time just update the first occurance
    public T update(T oldData, T newData) {
        Node<T> temp = head;
        int count = 0;
        T oldDataValue;
        while(temp != null && temp.data != oldData) {
            temp = temp.next;
            count++;
        }
        //if data is not present then it can't be updated
        if(count >= size()) {
            throw new NoSuchElementException("Element with: " + oldData + " is not present inside the list");
        }
        //if data is present update with newData and return oldData
        else {
            oldDataValue = temp.data;
            temp.data = newData;
        }
        return oldDataValue;
    }
    //oldData update(index, newData)
    public T update(int index, T newData) {
        //if index is not-present throw index is larger than the elements stored inside the list
        T oldDataValue;
        if(index >= size()) {
            throw new UnsupportedOperationException("Index: " + index + " is larger than the elements stored inside the list");
        }
        //else update the data at index with newData and return the oldData
        else {
            Node<T> temp = head;
            int idx = 0;
            while(idx != index) {
                temp = temp.next;
                idx++;
            }
            oldDataValue = temp.data;
            temp.data = newData;
        }
        return oldDataValue;
    }
    //toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> temp = head;
        while(temp != null) {
            sb.append(temp.data + " ");
            temp = temp.next;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        // LinkedLists list = new LinkedLists();
        // list.add(1);
        // list.add(2);
        // list.add(4);
        // list.add(5);
        // list.add(6);
        // // list.add(0, 0);
        // list.add(2, 3);
        // System.out.println(list);
        // // list.remove(1);
        // // list.remove(5);
        // System.out.println(list);
        // // LinkedLists list2 = new LinkedLists();
        // // list2.remove(2);
        // // list.remove(2);
        // // System.out.println(list.update(1, -1));
        // // System.out.println(list.update(99, -1)); //throws NoSuchElementException
        // System.out.println(list.update(99, Integer.valueOf(-2)));
        // System.out.println(list);
        GenericLinkedList<Integer> intList = new GenericLinkedList<>();
        intList.add(1);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(1, 2);
        intList.add(6);
        intList.update(Integer.valueOf(2), Integer.valueOf(-2));
        // intList.update(99, Integer.valueOf(-99));
        // intList.remove(6);
        intList.remove(Integer.valueOf(1));
        System.out.println(intList);
        GenericLinkedList<String> strList = new GenericLinkedList<>();
        strList.add("mani");
        strList.add("potti");
        strList.add("neela");
        System.out.println(strList);

    }
}
