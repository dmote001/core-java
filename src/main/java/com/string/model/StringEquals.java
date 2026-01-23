package com.string.model;

public class StringEquals {
    String ref;
    public static void main(String[] args) {
        StringEquals stringEquals = new StringEquals();
        String ref1;

        System.out.println(stringEquals.ref); // Null is a default value for String
//        System.out.println(ref1); // No default value for local String.

        String str = "hello world";
        String str1 = new String(str);
        String str2 = new String(str);
        String str3 = "hello world";

        // == checks the reference equality but not the content
        System.out.println(str == str1);  // false
        System.out.println(str1 == str2); // false
        System.out.println(str1 == str3); // false

        // equals method checks the actual content of the string
        System.out.println(str.equals(str1));
        System.out.println(str1.equals(str2));
        System.out.println(str.equals(str3));

        // immutability
        String s = "hello";
        s.concat("world");
        System.out.println(s); // o/p - hello : new object is created after concatenation but not assigned.

        s = s.concat("world");
        System.out.println(s); // o/p - hello world : new object is assigned.

        // Compile-time concatenation Vs Run-time concatenation

        // Compile-time concatenation:
        // When the string is created with string literal along with "+" operator.
        String str4 = "first" + "second" + "third" + "four";
        System.out.println(str4);

        // Run-time concatenation:
        // When the string is created with string literal and variable along with "+" operator.
        String str5 = "five";
        String str6 = str4 + str5;


        //hashcode comparison
        String n = "A";              // String literal
        String m = new String("A");  // New String object

        System.out.println(n.hashCode() == m.hashCode()); // true : Hashcode is calculated based on content

        System.out.println(m.intern() == n); // true : intern reference to the SCP object so n and m.intern() both refer same object.

        // What will be the result of following block?
        String emty = "";
        for (int i = 0; i < 1000; i++) {
            emty = emty + i;  // It will create a new object every time in SCP.
        }

        //recommended is
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
        }

        /*

        class MyString extends String {}
        o/p : compile-time error.

         String class can not be inherited or extended.
         - Due to security reasons as strings are used for db connections, passwords etc. and inheritance can change the behaviour.
         - String objects are immutable and Inheritance could break immutability by overriding methods.
         - Java uses SCP for memory efficiency and Allowing inheritance could affect pooling behavior


        String str1 = new String(str);
        Q. How many objects are created?
        A. 2  - one is in SCP and other in heap.

        Q. Why Is String Immutable?
        A. Because of
            - thread safety
            - security
            - hashcode caching
            - SCP optimization

        Q. Does String Override equals()?
        A. Yes :
                Object.equals() → reference comparison
                String.equals() → content comparison

        Q. Can Two Strings Have Same Hashcode but Not Equal?
        A. Yes(Hash collision)

        Q. What Is the Default Value of String?
        A. For instance variable → null
           For local variable → no default value

         //String is immutable, final, thread-safe, stored in SCP, and overrides equals() and hashCode().
         */


        final String s1 = "Java";
        String s2 = s1 + "World";
        String s3 = "JavaWorld";
        System.out.println(s2==s3); // true : final allows compile-time optimization.


        StringBuilder sb1 = new StringBuilder("Java");
        StringBuilder sb2 = new StringBuilder("Java");

        System.out.println(sb1 == sb2); //false
        System.out.println(sb1.equals(sb2)); // false : StringBuilder does NOT override equals(). just compare the reference
        System.out.println(sb1.compareTo(sb2)); // 0

    }
}
