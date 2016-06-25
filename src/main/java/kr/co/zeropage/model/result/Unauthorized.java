package kr.co.zeropage.model.result;

public class Unauthorized extends Result {

	public Unauthorized() {
		this.setStatus(401);
		this.setMsg("unauthorized");
	}
}
