# Classes
## nested, inner, anonymous
### & Iterators


---
## Today
1. Nested classes & interfaces:
  + static,
  + non-static: inner.
1. Random numbers
1. Local to a method.
1. Anonymous classes.
1. Iterators.


---
## Resources
1. Oracle Java Tutorial - [Nested Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html).
  

  
---
### Defining Types
Types (Classes and Interfaces) can be defined:

1. At the top level.
1. Inside another type.
1. Inside a method.


---
### Top level
A file can actually have more than one top level type.
1. They can be either public or package-private.
  + `private` and `protected` don't make sense.
1. At most one type can be public in a file, and the file name must match this type's name.

@css[fragment](Avoid having more than one type in a file, except for small helper types.)



---
### Nested Classes
*What follows applies to interfaces as well.*

Java allows us to define classes within classes. The nested class can be:
1. A static nested class.
  + Are actually quite similar to standard classes.
1. A non-static nested class, called an *inner class*.
  + Can access the members of the outer class, including private ones.

Nested classes can have all access types (including `protected` and package-private).
  
  
--- 
### Why use Nested Classes?
+ It is a way of logically grouping classes that are only used in one place.
+ It increases encapsulation.
+ It can lead to more readable and maintainable code.


---
### Static nested class example

Let's say we place 100 random points on a 100 X 100 sized grid.
What would be the expected distance of the closest point to the center?

To approximate the answer, we will run many random tests, and take the average. 

@css[fragment](*What is your guess for the answer?*) 



---
@code[java code-max code-noblend](src/PointSet.java)
@[4-17](This distance is known as *Manhattan distance*.)
@[19-26](Part of `PointSet`, not `Point`. Initializing `ArrayList` with a number starts it at the given size.)
@[28-36](We need `Point` to be non-private so that others can use this method.) 



---
@code[java code-max code-noblend](src/GridTest.java)
@[1-13](To access `Point` from outside, we need the full name.)
@[15-21](Answer is about 6.2. The math is not trivial...)


  
---

### Random 
+ A `Random` object is used to create random numbers.
+ `nextInt()` returns a random int.
+ `nextDouble()` returns a random double between 0 to 1.
+ `nextInt(int range)`, returns a number between `0` and `range-1`.

---
### Random
+ Reuse a `Random` instance. Don't create one each time you need a random number!
+ Can be created with `new Random(int seed)`.
  + `seed` determines the exact sequence of numbers.
  + Default is normally taken from the internal timer.
+ If you just want a random double between 0 and 1, there is no need for all this. Just use `Math.random()`

  
---
### Static Nested Classes
+ Can access the **static** members of the outer class.
  + even private ones!
  + but none of the non-static ones.
+ Can be instantiated even if there is no instance of the outer class.
+ Are not much different than normal top level classes. 
  + But can make the structure of the program clearer.
  



---
### Inner Classes

+ Declared within a class.
+ Are not `static`.
+ Are **always** related to an instance of the outer class.
  + Cannot be instantiated without an outer instance.
  + Have access to its members, including **private** ones.
+ Can be used to give controlled access to members of the outer class.



---
### Example
Like in the first homework assignment, about cities and roads. Our class will saves a set of cities and a set of roads.
+ A city is just `String`.
+ A road is between two cities.
  + There can only be one road between two cities (no matter their order).
  + It will be an inner class, and so can access the `Set`s of cities and roads.
   

---
@code[java code-max code-noblend](src/MainForRoadMap.java)
We want it to run like this.



---
@code[java code-max code-noblend](src/RoadMap.java)
@[6-8](`Road` will be a class holding two cities.)
@[10-21](The constructor accesses the outer class fields `roads` and `cities`.)
@[23-35](Two roads are considered equal even if the cities are reversed. `hashCode` follows this as well.)
@[37-44](Since `addRoad()` is non-static it can create an instance of `Road`.)
@[46-55](Returns the list of neighbouring cities.)
@[57-58](Can be defined in the same file because it's not public.)






---
### Another Use Case

Java has a useful interface:
```java code-noblend
interface Comparator<T> {
	int compare(T o1, T o2)
}
```
+ `Arrays.sort` can sort an array given an instance of a `Comparator` (strategy pattern). 
+ So we can sort an array in any order we want.
  + Without changing the `compareTo` of elements in the array. 


---
@code[java code-max code-noblend](src/ComparatorExample.java)
@[4-14](Don't do `Reverse<Integer> implements ...`.)
@[16-21](Indeed, the reversed order.)

@css[fragment](What if we wanted to count how many times our comparator is used?)



---
@code[java code-max code-noblend](src/ComparatorTest.java)
@[5-8](`count` will count the number of comparisons.)
@[10-18](Now `Reverse` is non-static!)
@[20-26](Sorting a random array of integers.)
@[28-34](Pretty efficient compared to bubble sort...)




---
### Local classes
+ Classes can be defined within methods, and they exist within the method only.
  + But instances can keep living!
+ They can access members of the outer class just like inner classes.
+ They can also access local variables of the method,
  + but only if they are `final`, 
  + or "practically final" - no code changes them.
  + The reason is because instances can persist even if the method call itself is done.
  


---
### Example

+ In the Fibonacci series, each number is the sum of the previous two:
$$
1, 1, 2, 3, 5, 8, 13, 21, 34, ...
$$
+ What if we wanted a different rule to calculate the next number from the previous two?
```java code-noblend
public interface Func {
	int f(int x, int y);
}
```


---
@code[java code-max code-noblend](src/Recurser.java)
@[1-9](base cases are the 0th and 1st elements.) 
@[11-17](Note that this is an exponential algorithm and can be improved. How?)



---
@code[java code-max code-noblend](src/MainForRecurser.java)
@[1-10](Fibonacci.)
@[12-20](Each element is the multiplication of the last two.)



---
### Anonymous Classes
+ Are just local classes, but save a few lines of code.
+ Useful when a class is just needed once, 
+ Common with the strategy pattern like the last example.
  
  
---
@code[java code-max code-noblend](src/MainForRecurser2.java)
+ The anonymous class is defined in the same place it is instantiated.
+ Just doing `new Func();` will give a compilation error.



---
### Defining Anonymous Classes
+ The definition of the new class takes place at the same time of instantiation.
+ It is a way to Instantiate (`new`) some class or interface, and directly add code to it.
  + If it is an interface (or abstract class), we must override all abstract methods right here. 


---
## Iterators
+ Used for going over elements of a class.
+ A very elegant example of using inner classes.
+ Java has strong support for them.

```java code-noblend
public interface Iterator<E> {
	E next();
	boolean hasNext();
}
```

@css[fragment](*Let's first use it in a simple way:*)



---
@code[java code-max code-noblend](src/IteratedArray.java)
@[3-11](Just an array of strings.)
@[13-23](`initIterator` is needed for restarting.)



---
@code[java code-max code-noblend](src/MainForIteratedArray.java)
Simple and can be very useful if the iteration order is complex, and is used many times.
 
Think of a spiraling snake ordering on a 2D array. 



---
It is a little limiting:
+ Can't iterate a few times simultaneously (like in a nested loop).
+ Only one way to iterate.
So let's separate the iterator from the actual collection:
```java code-noblend
interface Iterable<T> {
	Iterator<T> iterator();
}
```

This returns an `Iterator` object to be used for iterating the collection. 
@css[fragment](*what?!*)



---
@code[java code-max code-noblend](src/IteratedArray2.java)
@[3-10](Same as before, except no `counter`, and implements `Iterable<String>` and not `Iterator<String>`.)
@[12-23](An inner class that holds its own `counter`.)
@[25-28](Creates and gives an iterator to the outside world.)




---
@code[java code-max code-noblend](src/MainForIteratedArray2.java)
Although `Iterator1` is a private class, since it is an instance of `Iterator<String>`, we can use it here.

This is nice, @css[fragment](*but this is nicer:*)



---
@code[java code-max code-noblend](src/Main2ForIteratedArray2.java)

If you implement `Iterable`, java lets you use the `for` loop and use it transparently.


---
### Normally:
+ The Iterator is a private class within the collection to be iterated (why?).
+ It has some internal state, which changes with each `next()`.
+ The collection implements `Iterable<E>`, and the internal class implements `Iterator<E>`, where `E` is the type of the elements.



---
### Iterator Design Pattern
@quote[Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation](Design Patterns)

Defines a separate object that encapsulates accessing and traversing an aggregate object.


---
@img[span-80](resources/iterator.png)

The "aggregate" here is our `Iterable`.












---
### Another Example 

A simple generic one-directional list, which is `Iterable`. 

It is used as follows:

---
@code[java code-max code-noblend](src/MainForMyList.java)




---
First:

@box[bordered rounded](A good tip for writing generic classes is to first write thinking of the generic type as `String`, and later change to `E`.)

In this case, this would also mean calling the class `NodeString` instead of `Node<E>`.



---
@code[java code-max code-noblend](src/Node.java)




---
@code[java code-max code-noblend](src/MyList.java)
@[3-13](Basics.)
@[15-28](Since this is a non-static inner class, it knows `E`, and so it will be wrong to define `MyListIterator<E>`.)



---
### A thought Experiment
What happens behind the scenes here?
```java code-noblend
for (int val : l) 
	for (int val2 : l)
		System.out.println(val + val2);
```
@css[fragment](One iterator is created for the outer loop, and then each time, one is created for the inner loop. They have different inner `current`.)



---
### Remark
The real iterator interface is 
```java code-noblend
public interface Iterator<E> {
	E next();
	boolean hasNext(); 
	default void remove();
}
```
`remove` should remove the last element returned by `next`. 
+ This does not make sense for some collections.
+ `default` means it actually has an implementation in the interface!



---
### Default methods
An `interface` can have `default` methods:
+ Their code is in the interface.
+ We don't have to override them.
+ In this case (and this is common), it is:
```java code-noblend
default void remove() {
	throw new UnsupportedOperationException();
}
```
+ It is commonly used for **backwards compatibility**: to add methods to an interface without breaking existing implementations.
  

---
### Static methods in interfaces
Interfaces can have static variables and methods, and they behave just like static members in classes.
+ These (like always with static members) cannot be overridden.
  + So polymorphism doesn't work with them.
+ They are accessed using the interface name.
  


---
### Exercise

Write a class `RandList`, which takes in its constructor a `List<String>`. `RandList` is iterable, and the iteration order is a random order over the elements of the list it got.
+ Each time it is iterated, the order can be different.
+ You can (but there are many solutions), use `Collections.shuffle`.

@css[fragment](*A solution is in the package `ex1`.*)
