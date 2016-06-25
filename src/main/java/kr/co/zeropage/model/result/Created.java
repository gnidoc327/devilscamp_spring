package kr.co.zeropage.model.result;

public class Created extends Result {

	public Created() {
		this.setStatus(201);
		this.setMsg("created");
	}
}
