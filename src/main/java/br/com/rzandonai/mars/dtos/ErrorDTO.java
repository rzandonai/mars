package br.com.rzandonai.mars.dtos;

public class ErrorDTO {
	private String message;
	private String guidance;

	public void setMessage(String message) {
		this.message = message;
	}

	public void setGuidance(String guidance) {
		this.guidance = guidance;
	}

	@Override
	public String toString() {
		return String.format("msg: %s | guidance: %s",this.message,this.guidance);
	}
}
