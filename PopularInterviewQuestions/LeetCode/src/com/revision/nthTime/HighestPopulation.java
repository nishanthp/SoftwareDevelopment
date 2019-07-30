package com.revision.nthTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class HighestPopulation {

	public static void main(String[] args) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		List<Integer> list = new LinkedList<>();
		// fb question.
		List<Dates> population = new LinkedList<>();
		population.add (new Dates(1991, 2008));
		population.add (new Dates(1994, 2007));
		population.add (new Dates(1987, 2018));
		population.add (new Dates(2009, 2018));
		population.add (new Dates(2010, 2018));
		population.add (new Dates(2011, 2018));
		findTheHigheshPopulation(population);

	}

	private static void findTheHigheshPopulation(List<Dates> population) {
		Collections.sort(population, new Comparator<Dates>(){
			@Override
			public int compare(Dates d1, Dates d2) {
				if(d1.birthDate == d2.birthDate) return Integer.compare(d1.deathDate, d2.deathDate);
				else return Integer.compare(d1.birthDate , d2.birthDate);
			}
		});
		Dates temp = population.get(0);
		for(Dates i : population) {
			
		}
	}

}


class Dates {
	int birthDate;
	int deathDate;
	Dates(int start, int end){
		this.birthDate = start;
		this.deathDate = end;
	}
}
