package assignment6;

public interface Boardable {
	// public abstract by default
	void setBoardStart(int month, int day, int year);

	void setBoardEnd(int month, int day, int year);

	boolean boarding(int month, int day, int year);
}
