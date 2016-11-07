/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * TODO Administrator (May 9, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class BucketSort {

    String[] bucketSort(final String[] a) {
        int i = 0;
        final HashMap<String, LinkedList<String>> sortedStrings = new HashMap<String, LinkedList<String>>();

        for (final String oneString : a) {
            final String s = charArray(oneString);
            if (!sortedStrings.containsKey(s)) {
                final LinkedList<String> toAdd = new LinkedList<String>();
                toAdd.push(oneString);
                sortedStrings.put(s, toAdd);
            } else {
                final LinkedList<String> key = sortedStrings.get(s);
                key.push(oneString);
            }
        }

        for (final String oneSet : sortedStrings.keySet()) {
            final LinkedList<String> list = sortedStrings.get(oneSet);
            for (final String oneList : list) {
                a[i] = oneList;
                i++;
            }

        }
        return a;
    }

    /**
     * TODO Administrator (May 9, 2016) - Insert a description of what this method does.
     *
     * @param oneString
     */
    private String charArray(final String oneString) {
        final char[] b = oneString.toCharArray();
        Arrays.sort(b);

        return b.toString();

    }
}
