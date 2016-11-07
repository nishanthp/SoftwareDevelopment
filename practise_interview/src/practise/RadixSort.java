/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;

import java.util.ArrayList;


/**
 * TODO Administrator (Jun 5, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class RadixSort {

    void radixSort(final int a[]) {
        // create Buckets
        final int Radix = 10;
        final int results[] = new int[10];
        final ArrayList<Integer>[] bucket = new ArrayList[Radix];
        // Initialize the buckets.
        for (int i = 0; i < Radix; i++) {
            bucket[i] = new ArrayList<Integer>();
        }
        boolean maxLength = false;
        int placement = 1;
        int tmp = 1;
        while (!maxLength) {
            maxLength = true;
            for (final int eachEntry : a) {
                tmp = eachEntry / placement;
                bucket[eachEntry % placement].add(eachEntry);
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }

            // place the results in the bucket.
            int i = 0;
            for (int j = 0; j < Radix; j++) {
                for (final Integer eachDigit : bucket[j]) {
                    results[i++] = eachDigit;
                }
                bucket[j].clear();
            }
            placement *= 10;
        }
    }
}
