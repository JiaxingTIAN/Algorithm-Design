// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iter;
    Integer next;   //Cache the next for peek
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	    if(iter.hasNext()){
	        next = iter.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;    
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    //Return next and update the next
	    Integer num = next;
	    next = iter.hasNext()? iter.next(): null;
	    return num;
	}

	@Override
	public boolean hasNext() {
	    return iter.hasNext() || next != null;
	}
}
