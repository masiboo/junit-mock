# junit-mock

What is mock? 

A mock object is a dummy implementation for an interface or a class. It allows to define the output of certain method calls.

What is Stub?

Stub is a piece of code that represents another component's expected functionality. 
Let's in our class there is database call, and it returns 5. In the unit test, we don't make actual database call. 
So we just make stub of the database call which returns 5.  

What is Spy object?

Spy is known as partially mock objects. It means spy creates a partial object or a half dummy of the real object.
We stub or spy the real ones. In spying, the real object remains unchanged, and we just spy some specific methods of it.


