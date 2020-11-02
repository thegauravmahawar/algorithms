## Lists

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String... args) {

        List<Integer> v1 = new ArrayList<>(); //initialize list
        List<Integer> v2; //v2 == null

        //Cast array to a list
        int[] a = new int[]{1, 2, 3, 4, 5};
        v2 = new ArrayList<>(Arrays.asList(a));

        //Make copy
        List<Integer> v3 = v2; //another reference to v2
        List<Integer> v4 = new ArrayList<>(v2); //make actual copy of v2

        //Sort
        Collections.sort(v2);

        //Add new elements
        v2.add(6);
        v2.add(7);

        //Modify list
        v2.set(0, 3); //change value at first index.

        //Delete element
        v2.remove(v2.size() - 1); //delete element at last index.

    }

}
```