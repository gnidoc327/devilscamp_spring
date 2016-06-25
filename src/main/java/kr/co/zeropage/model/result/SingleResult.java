package kr.co.zeropage.model.result;

public class SingleResult extends Normal {

	private Object data;

	public SingleResult(Object data) {
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
