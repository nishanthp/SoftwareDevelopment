
public class MainClass2 {
	public static void main(String[] args) {
		resource r = new resource();
		object o = new object(r);
		o.start();
		System.out.println("HOLDS LOCK" + object.holdsLock(r));
		// new Thread(new object(r)).start();

	}
}

class object extends Thread {
	resource res;

	public object(resource r) {
		this.res = r;
	}

	@Override
	public void run() {
		synchronized (this.res) {
			System.out.println(holdsLock(this.res));
			this.res.display();
		}
	}
}

class resource {
	public void display() {
		System.out.println("This is resource obejct");
	}
}