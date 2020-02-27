/*
 * Example that does NOT use the clever Null Object pattern.
 *
 * So, client code has to check for null reference all over
 * the place. :(
 * 
 */

// Clients will need certain Employee behaviors. 
public interface IEmployeeBefore {
    // Each IEmployee class must implement this method.
    void foo();
    
}


// Here is a concrete realization of the IEmployee behavior
// interface. 
class EmployeeBefore implements IEmployeeBefore {
    public void foo() { System.out.println("not null"); }
}



class ClientBefore {
    public static void main(String[] args) {

	System.out.println("Making 10 random IEmployee objects:");
	for (int i=0; i < 10; i++) {

	    // Not sure what we're getting from this method!
	    IEmployeeBefore a = makeEmployee();

	    // HERE'S THE SMELLY PART: have to check for null reference
	    if (a != null) {

		// So now we know it is safe to use the reference
		a.foo(); 
		System.out.println("\tIt wasn't null, was it?!");
	    }
	    else {

		// So now we know it is UNSAFE to use the reference
		System.out.println("NULL");
		System.out.println("\tIt was NULL, wasn't it?!");
	    }
	}
    }


    static java.util.Random randomizer = new java.util.Random();
    public static IEmployeeBefore makeEmployee() {

	// coin flip to return a reference to real object or a null
	if (randomizer.nextBoolean()) {
	    return new EmployeeBefore();
	}
	return null;
    }
}
    
