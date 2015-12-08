public class InterviewPractice10
{
	private static String reverse_sentence(String sentence)
	{
		String[] splited = sentence.split(" ");
		StringBuilder builder = new StringBuilder();
		for (int i = splited.length - 1; i >= 0; i--) {
			builder.append(splited[i]);
			if (i > 0) builder.append(" ");
		}
		return builder.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(reverse_sentence("I am a student."));
		System.out.println(reverse_sentence("Testing 1 2 3"));
	}
}
