package kr.co.zeropage.model.result;

public class Error extends Result {

	public Error(String msg) {
		this.setStatus(500);
		this.setMsg(msg);
	}
	
	public Error() {
		this.setStatus(500);
		this.setMsg("internal server error");
	}
}
