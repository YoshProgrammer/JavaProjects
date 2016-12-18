package jsjf;

import jsjf.exceptions.*;

import java.io.Serializable;

/**
 * ArrayOrderedList represents an array implementation of an ordered list.
 * This ordered list is ordered by the criteria set in the compareTo method in the Course class.
 * Base code comes from Java Foundations, extended by Joshua Brown
 */
public class ArrayOrderedList<T> extends ArrayList<T>
         implements OrderedListADT<T>, Serializable
{
    /**
     * Creates an empty list using the default capacity.
     */
    public ArrayOrderedList()
    {
        super();
    }

    /**
     * Creates an empty list using the specified capacity.
     *
     * @param initialCapacity the initial size of the list
     */
    public ArrayOrderedList(int initialCapacity)
    {
        super(initialCapacity);
    }

    /**
     * Adds the specified Comparable element to this list, keeping
     * the elements in a correct sorted order. Uses the compareTo from the Course class.
     *
     * @param element the element to be added to the list
     */
    public void add(T element)
    {
        int search = 0;

        if (!(element instanceof Comparable)) {
            throw new NonComparableElementException("OrderedList");
        }
		
		Comparable<T> comparableElement = (Comparable<T>)element;
        
		if (size() == list.length) {
            expandCapacity();
        }

		// search for the insertion location
        while (search < rear && comparableElement.compareTo(list[search]) > 0) {
            search++;
        }

		// move existing elements up one
        for (int spaceToMove = rear; spaceToMove > search; spaceToMove--) {
            list[spaceToMove] = list[spaceToMove - 1];
        }

		// insert element
        list[search] = element;
        rear++;
		modCount++;
    }
}
