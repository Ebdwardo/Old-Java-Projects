//         Name: Eduardo Teodosio Campuzano
// A linked list is a sequence of nodes with efficient
// element insertion and removal.
// This class contains a subset of the methods of the
// standard java.util.LinkedList class.

//import com.sun.org.apache.xpath.internal.objects.XObject;

import java.util.NoSuchElementException;

public class LinkedList {
    //nested class to represent a node
    private class Node {
        public Object data;
        public Node next;
    }

    //only instance variable that points to the first node.
    private Node first;

    // Constructs an empty linked list.
    public LinkedList() {
        first = null;
    }


    // Returns the first element in the linked list.
    public Object getFirst() {
        if (first == null) {
            NoSuchElementException ex
                    = new NoSuchElementException();
            throw ex;
        } else
            return first.data;
    }

    // Removes the first element in the linked list.
    public Object removeFirst() {
        if (first == null) {
            NoSuchElementException ex = new NoSuchElementException();
            throw ex;
        } else {
            Object element = first.data;
            first = first.next;  //change the reference since it's removed.
            return element;
        }
    }

    // Adds an element to the front of the linked list.
    public void addFirst(Object element) {
        //create a new node
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        //change the first reference to the new node.
        first = newNode;

    }

    // Returns an iterator for iterating through this list.
    public ListIterator listIterator() {
        return new LinkedListIterator();
    }


    public String toString() {
        // Start with an empty string
        String info = " ";
        //create a linked list object to iterate through the list
        LinkedListIterator string = new LinkedListIterator();

        //loop through the list and concatenate to the string
        while (string.hasNext()) {
            info += string.next().toString() + " ";
        }
        // return that key
        return "{" + info + "}\n";
    }

    public int size() {
        //create a linked list object to iterate through the list
        LinkedListIterator size = new LinkedListIterator();
        //create a counter variable to keep track of the number of elements in the array.
        int count = 0;
        //Iterate through the array list and count the number of elements in the list
        while (size.hasNext()) {
            count++;
            size.next();
        }
        // return the amount
        return count;
    }

    public void addElement(Object element) {
        ////create a linked list object to iterate through the list
        LinkedListIterator add = new LinkedListIterator();
        //could not figure out the alphabetical order so just adds it to the beginning of the list
        add.add(element);

    }

    public void removeElementsAtEvenIndices() {
        //create a linked list object to iterate through the list
        LinkedListIterator remove = new LinkedListIterator();
        int count = 0;
        //Does not work, but the idea was to iterate through the list and remove when the count index is even
        while (remove.hasNext()) {

            if (count % 2 == 0) {
                    remove.remove();
            }
            count++;

        }

    }

    public int howManyAppearBefore(Object element) {
        //create a linked list object to iterate through the list
        LinkedListIterator howMany = new LinkedListIterator();
        //counter variable to count how many are before
        int count = 0;
        //While loop that keep going until the next element is the one we want, so then we return the count variable
        //once the next one is the one we want we return count because that reflects how many elements are before it
        while (howMany.hasNext()) {
            if (howMany.next().equals(element))
                return count;
            count++;
        }
        return -1;
    }

    public int indexOfLast(Object obj) {
        //create a counter value and sentinel value
        int index = 0;
        int returned = -1;
        //create a linked list object to iterate through the list
        LinkedListIterator iter = new LinkedListIterator();

        //iterate through the array list until we find the last time we get the desired element
        while(iter.hasNext()) {
            if(iter.next().equals(obj))
                returned = index;

            index++;
        }

        return returned;
    }

    public void duplicateEach() {
        //create a linked list object to iterate through the list
        LinkedListIterator dup = new LinkedListIterator();
        //Does not work but the idea was to add the element we had to the list then move over 2 nodes and do the same
        while (dup.next() != null) {
            addElement(dup);
            dup.next();
            dup.next();

        }
    }

    public Object removeElementAt(int remove) {
        //create a linked list object to iterate through the list
        LinkedListIterator cut = new LinkedListIterator();
        //create a counter variable to keep track of the index we want to remove
        int count = 0;
        //create a variable to store the object we remove so we can return it
        Object store;
        //Iterate through the list until the counter reaches the index of what we want to remove
        while (cut.hasNext()) {

            if (count == remove) {
                store = cut.next();
                cut.remove();
                return store;
            }
            //update the count variable and call .next() to move to the next value in the list
            count++;
            cut.next();
        }
        return null;
    }


    //nested class to define its iterator
    private class LinkedListIterator implements ListIterator {
        private Node position; //current position
        private Node previous; //it is used for remove() method

        // Constructs an iterator that points to the front
        // of the linked list.

        public LinkedListIterator() {
            position = null;
            previous = null;
        }

        // Tests if there is an element after the iterator position.
        public boolean hasNext() {
            if (position == null) //not traversed yet
            {
                if (first != null)
                    return true;
                else
                    return false;
            } else {
                if (position.next != null)
                    return true;
                else
                    return false;
            }
        }

        // Moves the iterator past the next element, and returns
        // the traversed element's data.
        public Object next() {
            if (!hasNext()) {
                NoSuchElementException ex = new NoSuchElementException();
                throw ex;
            } else {
                previous = position; // Remember for remove

                if (position == null)
                    position = first;
                else
                    position = position.next;

                return position.data;
            }
        }

        // Adds an element after the iterator position
        // and moves the iterator past the inserted element.
        public void add(Object element) {
            if (position == null) //never traversed yet
            {
                addFirst(element);
                position = first;
            } else {
                //making a new node to add
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                //change the link to insert the new node
                position.next = newNode;
                //move the position forward to the new node
                position = newNode;
            }
            //this means that we cannot call remove() right after add()
            previous = position;
        }

        // Removes the last traversed element. This method may
        // only be called after a call to the next() method.
        public void remove() {
            if (previous == position)  //not after next() is called
            {
                IllegalStateException ex = new IllegalStateException();
                throw ex;
            } else {
                if (position == first) {
                    removeFirst();
                } else {
                    previous.next = position.next; //removing
                }
                //stepping back
                //this also means that remove() cannot be called twice in a row.
                position = previous;
            }
        }

        // Sets the last traversed element to a different value.
        public void set(Object element) {
            if (position == null) {
                NoSuchElementException ex = new NoSuchElementException();
                throw ex;
            } else
                position.data = element;
        }
    } //end of LinkedListIterator class
} //end of LinkedList class
