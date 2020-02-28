/*
 * Working List code! (You should compile/run to verify!)
 * 
 * But want to refactor to employ NullObject pattern.
 */

public class ListClient {
    public static void main(String[] args) {
	ListNode list;
	list = new IntListNode(1, 
		     new IntListNode(22, 
			  new IntListNode(333, null)));
	list.print();
	System.out.println("List length = " + list.length());
    }
}

abstract class ListNode {
    // All XxxListNode classes need next field and associated
    //  accessor, mutator.
    private ListNode next;
    public ListNode next() { return next; }
    public void setNext(ListNode newNext) { next = newNext; }

    // All XxxListNode classes need length method
    public int length() { 
	if (next() == null) return 1;
	else return 1 + next().length();
    }

    // Each concrete XxxListNode has to print itself
    abstract void print();
}

// Concrete ListNode class for int values
class IntListNode extends ListNode {
    private int value;
    // next field is inherited

    // Constructors
    public IntListNode() { setValue(0); setNext(null); }
    public IntListNode(int value, IntListNode next) {
	setValue(value);
	setNext(next);
    }

    // Concrete field accessor/mutators
    public int value() { return value; }
    public void setValue(int newValue) { value = newValue; }

    // Required interface behaviors
    public void print() {
	System.out.println(value);
	if (next() != null) next().print();
    }
}
