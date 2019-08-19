package br.com.rzandonai.mars.exceptions;

public class MovimentException extends RuntimeException {
	private final String guidance;

	public MovimentException(String exception, String guidance) {
		super(exception);
		this.guidance = guidance;
	}

	public String getGuidance() {
		return guidance;
	}
}
