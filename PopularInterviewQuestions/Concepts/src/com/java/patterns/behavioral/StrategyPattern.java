package com.java.patterns.behavioral;

public class StrategyPattern {

	public static void main(String[] args) {
		// separate the behaviour of a class from the object structure.

	}

	interface Compression {
		void compress(String file);
	}

	class RarCompression implements Compression {

		@Override
		public void compress(String file) {
			System.out
					.println("RarCompression on file " + file + " completed.");

		}

	}

	class ZipCompression implements Compression {

		@Override
		public void compress(String file) {
			System.out
					.println("ZipCompression on file " + file + " completed.");

		}

	}

	class File {
		Compression compressionStrategy;
		String name;
		File(String name, Compression compStrategy) {
			this.name = name;
			this.compressionStrategy = compStrategy;
		}

		public void compressFileName() {
			this.compressionStrategy.compress(this.name);
		}
	}

}
