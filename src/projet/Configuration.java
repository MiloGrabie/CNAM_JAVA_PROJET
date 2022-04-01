package projet;

public class Configuration {
	public double alpha = 0.85;
	public double epsilon = -1.0;
	public int indice = 150;
	public Mode mode = Mode.CREUSE;

	@Override public String toString() {
		return "alpha=" + alpha + ", epsilon=" + epsilon
			+ ", indice=" + indice + ", mode=" + mode;
	}
}
