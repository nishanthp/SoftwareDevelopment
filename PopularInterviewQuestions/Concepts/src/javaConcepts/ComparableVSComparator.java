package javaConcepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableVSComparator {

	public static void main(String[] args) {
		List<Movie> list = new ArrayList<Movie>();
		Movie m1 =  new Movie("a", 2014, 9);
		Movie m2 =  new Movie("b", 2010, 5);
		Movie m3 =  new Movie("c", 2012, 2);
		Movie m4 =  new Movie("d", 2018, 8);
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		
		Comparator<Movie> externalCompRating = new Comparator<Movie>() {
			@Override
			                   //m1.compare(m2) -> ascending, vice versa is descending
			public int compare(Movie m1, Movie m2){
				return m2.rating.compareTo(m1.rating);
			}
		};
		// collections will sure compare method to sort elements when external comparator is passed.
		// sort by rating.
		Collections.sort(list, externalCompRating);
		printList("rating", list);
		
		Comparator<Movie> externalCompName = new Comparator<Movie>() {
			@Override
			 //m1.compare(m2) -> ascending, vice versa is descending
			public int compare(Movie m1, Movie m2){
				return m2.name.compareTo(m1.name);
			}
		};
		// sort by names.
		Collections.sort(list, externalCompName);
		printList("names",list);
		
		//This will use the comparableTo method within the object itself.
		Collections.sort(list);
		printList("year",list);
	}

	// print the list.
	private static void printList(String header, List<Movie> list) {
		System.out.println(header);
		for(Movie movie : list){
			System.out.println(movie.name);
		}
		
	}

}

//natural ordering. Object itself knows how it is to be ordered.
class Movie implements Comparable<Movie>{
	String name;
	Integer rating;
	Integer year;
	Movie(String name, int year, int rating){
		this.name = name;
		this.year = year;
		this.rating = rating;
	}
	@Override
	// //this.compareTo(m) -> ascending, vice versa is descending
	public int compareTo(Movie o) {
		// TODO Auto-generated method stub
		return o.year.compareTo(this.year);
	}
}
