/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;


/**
 * TODO Administrator (Jun 5, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class Swap {

    void method1(int a,
                 int b) {
        final int temp = a;
        a = b;
        b = temp;
        System.out.println(a);
        System.out.println(b);
    }
}
