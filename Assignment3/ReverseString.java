public class ReverseString {
	
	public String reverse(String input) {
		String[] words = input.split(" ");
		String rev = "";
		
		for (int i = words.length - 1; i >= 0; i--) {
			if (words[i].equals("")) {
				continue;
			}else {
				rev += words[i] + " ";
			}
		}
		
		return rev.trim();
	}

	public static void main(String[] args) {
		
		String input = "         the           sky is blue         ";
		
		ReverseString sol = new ReverseString();
		System.out.println(sol.reverse(input));
	}
}
