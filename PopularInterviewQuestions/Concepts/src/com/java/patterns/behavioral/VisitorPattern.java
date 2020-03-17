package com.java.patterns.behavioral;

public class VisitorPattern {
	// Separate operations from the object structure.
}

interface Visitable {
	void accpet(Visitor visitor);
}

// Object.
class Properties implements Visitable {
	int mCount = 0;
	int dCount = 0;
	public int getmCount() {
		return mCount;
	}
	public void setmCount(int mCount) {
		this.mCount = mCount;
	}
	public int getdCount() {
		return dCount;
	}
	public void setdCount(int dCount) {
		this.dCount = dCount;
	}
	@Override
	public void accpet(Visitor visitor) {
		visitor.visit(this);
	}

}

interface Visitor {
	void visit(Visitable visitable);

}

// Operations that can be performed on the Object.
class MCountIncrementVisitor implements Visitor {

	@Override
	public void visit(Visitable visitable) {
		if (visitable instanceof Properties) {
			visitable = (Properties) visitable;
			((Properties) visitable)
					.setmCount(((Properties) visitable).getmCount() + 1);
		}
	}

}

// Operations that can be performed on the Object.
class DCountIncrementVisitor implements Visitor {

	@Override
	public void visit(Visitable visitable) {
		if (visitable instanceof Properties) {
			visitable = (Properties) visitable;
			((Properties) visitable)
					.setdCount(((Properties) visitable).getdCount() + 1);
		}
	}

}
