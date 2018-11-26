package com.java.concepts;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ObjectReferencesDemo {
	public static void main(String[] args) {
		// Strong reference.
		Object1 obj = new Object1();

		// weak reference. This will be collected during the next gc.
		WeakReference<Object1> weak = new WeakReference<Object1>(obj);

		// soft reference. This will be collected when it runs out of memory.
		SoftReference<Object> soft = new SoftReference<Object>(obj);

		// Phantom reference. Will be notified when this is garbage collected.
		ReferenceQueue<Object1> referenceQueue = new ReferenceQueue<>();
		PhantomReference<Object1> phantom = new PhantomReference<Object1>(obj, referenceQueue);
		try {
			// this is a blocking call.
			Reference<? extends Object1> removed = referenceQueue.remove();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

// A sample object.
class Object1 {

}
