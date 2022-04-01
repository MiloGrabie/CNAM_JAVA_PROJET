package projet;

public class CLIClassique {

	public static Configuration configuration(String... args) {
		Configuration config = new Configuration();
		boolean finOptions = false;
		int i = 0;
		while (i < args.length && ! finOptions) {
			String arg = args[i];
			switch (arg) {
				case "-K": // Valeur de l'indice à calculer
					try {
						config.indice = Integer.parseInt(args[++i]);
					} catch (NumberFormatException e){
						System.out.println("Le format du paramètre -K n'est pas bon");
					}
					break;
				case "-E": // Valeur de la précision à atteindre
					try {
						config.epsilon = Double.parseDouble(args[++i]);
					} catch (NumberFormatException e){
						System.out.println("Le format du paramètre -E n'est pas bon");
					}
					break;
				case "-A": // Valeur de alpha
					try {
						config.alpha = Double.parseDouble(args[++i]);
					} catch (NumberFormatException e){
						System.out.println("Le format du paramètre -A n'est pas bon");
					}
					break;
				case "-C": // Mode matrice creuse
					config.mode = Mode.CREUSE;
					break;
				case "-P": // Mode matrice pleine
					config.mode = Mode.PLEINE;
					break;
				default:
					finOptions = arg.length() == 0 || arg.charAt(0) != '-';
					if (! finOptions) {
						System.out.println("Option inconnue : " + arg);
					}
			}
			i++;
		}
		return config;
	}
}

