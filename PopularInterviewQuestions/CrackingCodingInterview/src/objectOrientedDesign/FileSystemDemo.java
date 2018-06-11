package ObjectOrientedDesign;

import java.util.ArrayList;
import java.util.Date;

public class FileSystemDemo {

}

abstract class Entry {
	String name;
	Directory parent;
	int size;
	long creationTime;
	long lastUpdated;
	long lastAccessed;

	public Entry(String name, Directory parent) {
		this.name = name;
		this.parent = parent;
		creationTime = new Date().getTime();
		lastUpdated = new Date().getTime();
		lastAccessed = new Date().getTime();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	abstract int getSize();

	public long getCreationTime() {
		return creationTime;
	}

	public long getLastUpdated() {
		return lastUpdated;
	}

	public long getLastAccessed() {
		return lastAccessed;
	}

	public String changeName(String newName) {
		name = newName;
		return newName;
	}

	// important functionality
	public String getFullPath() {
		if (this.parent == null)
			return "/" + this.name;
		else
			return this.parent.getFullPath() + "/" + this.name;
	}

	// important functionality
	public boolean deleteEntry() {
		if (this.parent == null)
			return false;
		else {
			this.parent.removeContent(this);
			return true;
		}
	}
}

class Directory extends Entry {
	ArrayList<Entry> contents;

	public Directory(String name, Directory parent, int size) {
		super(name, parent);
		contents = new ArrayList<>();
	}

	public ArrayList<Entry> getContents() {
		return contents;
	}

	public void removeContent(Entry content) {
		contents.remove(content);
	}

	public void addContent(Entry content) {
		contents.add(content);

	}

	@Override
	public int getSize() {
		int size = 0;
		for (Entry entry : contents) {
			size += entry.getSize();
		}
		return size;
	}

	public int numberOfFiles() {
		int count = 0;
		for (Entry entry : contents) {
			if (entry instanceof Directory) {
				count = +((Directory) entry).numberOfFiles();
			} else if (entry instanceof File) {
				count++;
			}
		}
		return count;
	}

}

/**
 * The File object comes with the size as a parameter.
 *
 */
class File extends Entry {
	String contents;

	// Can create an empty file.
	File(String name, Directory parent, int size) {
		super(name, parent);
	}

	File(String name, Directory parent, String contents, int size) {
		super(name, parent);
		this.contents = contents;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public int getSize() {
		return size;
	}

}