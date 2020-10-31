package assignment6;

import java.util.*;

public class Mreview implements Comparable<Mreview> {
	private String title;
	private ArrayList<Integer> ratings;

	// constructors
	public Mreview() {
		title = "";
		ratings = new ArrayList<>();
	}

	public Mreview(String title) {
		this.title = title;
		ratings = new ArrayList<>();
	}

	public Mreview(String title, int firstRating) {
		this.title = title;
		ratings = new ArrayList<>();
		ratings.add(firstRating);
	}

	// methods
	public void addRating(int r) {
		this.ratings.add(r);
	}

	public double aveRating() {
		double sum = 0;
		for (int i : ratings) {
			sum += i;
		}
		return sum / numRatings();
	}

	public int numRatings() {
		return ratings.size();
	}

	public String getTitle() {
		return title;
	}

	@Override
	public boolean equals(Object obj) {
		Mreview m = (Mreview) obj;
		return title.equals(m.title);
	}

	@Override
	public int compareTo(Mreview obj) {
		return title.compareTo(obj.title);
	}

	@Override
	public String toString() {
		return title + ", average " + aveRating() + " out of " + numRatings() + " ratings";
	}

	public static void main(String[] args) {
		Mreview m = new Mreview("Kill Bill", 1);
		Mreview m2 = new Mreview("Kill bill");
		System.out.println(m.equals(m2));
		m.addRating(2);
		m.addRating(3);
		System.out.println(m.toString());
		System.out.println("Average rating: " + m.aveRating());
	}
}
