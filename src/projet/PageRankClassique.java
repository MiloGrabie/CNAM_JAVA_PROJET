package projet;

public class PageRankClassique {

	public static void main(String... args) {
		args = "-K 15.5 -P -A".split(" ");
		Configuration configuration = CLIClassique.configuration(args);
		System.out.println(configuration);
		// Le reste du programme... Omis.
	}
}
