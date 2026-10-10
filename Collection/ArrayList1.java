package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayList1 {
    public static void main(String[] args) {
        // List<Integer> li = new ArrayList<>();
        // li.add(11);
        // li.add(22);
        // System.out.println(li.get(0));

        // List<Integer> li2 = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        // li2.add(13);
        // System.out.println(li2);

        // System.out.println(19 % 4);
        // System.out.println(4 % 6);
        
    }
    

}

//1> What is collection framework in java ?

// ans> In java collection framework is the hirarical based set of predefined interfaces and 
// classes that allow us to perform various operation's on group of objects in to a single unit.

// In collection framework Iterable is the top most interface present in the collection hirarchy.
    // 1> which allow to iterate over the element one by one by using its methods like
    // forEach();
    // Iterator

    // Then it have Collection interface itself which is one of the root interface of the collection framework
    // which give some common methods like add, addAll, remove, removeAll, size, stream, paeallalStream etc.

    // which is extended by the child interfaces like List, Set, Queue
    // Then it have abstractcollection class which is implement the collection 
    // Then the abstract collection have the child abstract classes linr abstractList, abstractSet, abstract Queue.

    // Then finally the concrete classes come that implement the upper hirarchy 
    // List have classes like ArrayList, LinkedList, vector and stack.
    // set have classes like HashSet, LinkedHashSet, TreeSet.
    // Queue have classes like prorityQueue, arrayDequeue, deque,
    // List-------------------------------------
    // ArrayList
    // 1> It is backed by a dynamic array which increse its size as element get added and decrease its size as element get removed.
    // 2> It preserved the insertion order.
    // 3> The time complexity of retrive the element is O(1) as it is index based.
    // 4> Time complexity of insert and deletion of the element in the middle take O(n) because it required element shefting.

    // LinkedList
    // 1> It is backed by a Doubly linkedList where it have threee thing one is element another is a node that point to previous and 
    // another that point to the next element.
    // 2> it is also preserved the insertion order.
    // 3> The adding and deletion of the element take O(1) time complexity because it only need to update the pointer.
    // 4> But the retrive the element take O(n) time complexity because it have to traverse from the beginning.

    // Vector 
    // 1> It is leagacy class that present from the java 1.0 but later on when java introduce the java collection framework in 1.2 it 
    //   become the part of the java collection framework.
    // 2> It's all methods are synchronized which is suitable in a multithreaded environment but it have time overhead so in a single 
    // threaded environment it better not to use it.
    // Stack
    // It extend the vector calss so it' all methodes are also synchronized.
    // It folow the LIFO principle that is Last In First Out.

    // SET
    // HashSet
    // 1> It backed by a hashmap.
    // 2> so it only store the unique value with in it.
    // 3> Because it backed by a hashmap so what ever the value we store inside it it first go through certen process like
    //      -> First the value we store in it it take as a key and internally the a dummy value will store corresespoinding to it.
    //      -> Then take the key and get the hash calculation of  it and then through it hashvalue a bucket get deside to store it
    //a array index.
    //      -> Because the hashcode can generate random index cvalue so the order is not preserved.



    
