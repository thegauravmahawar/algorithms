## Strings

A string is an array of **unicode characters**.

<h3>String Comparison</h3>

```java
public class Main {

    public static void main(String... args) {
        
        String s1 = "Hello World!";
        String s2 = s1; //reference to s1;
        System.out.println(s1 == s2); //true
        System.out.println(s1.equals(s2)); //true
        System.out.println(s1.compareTo(s2)); //true

        String s3 = new String(s1);
        System.out.println(s1 == s3); //false
        System.out.println(s1.equals(s3)); //true
        System.out.println(s1.compareTo(s3)); //true

    }

}
```

<h3>Immutability</h3>

Immutable means that you can't change the content of the string once it's initialized.

