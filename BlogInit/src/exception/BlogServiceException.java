package exception;


@SuppressWarnings("serial")
public class BlogServiceException extends BlogException {
	private Throwable source;
	
	public BlogServiceException() {
	}

	public BlogServiceException(String m) {
		super(m);
	}

	public BlogServiceException(String m, Throwable source) {
		super(m);
		this.source = source;
	}

	public Throwable getSource() {
		return source;
	}

	public void setSource(Throwable source) {
		this.source = source;
	}
}
