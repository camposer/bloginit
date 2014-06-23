package exception;

@SuppressWarnings("serial")
public abstract class BlogException extends RuntimeException {
	public BlogException() {
		
	}

	public BlogException(String m) {
		super(m);
	}
}
