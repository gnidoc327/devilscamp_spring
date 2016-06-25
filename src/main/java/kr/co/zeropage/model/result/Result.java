package kr.co.zeropage.model.result;

import kr.co.zeropage.utils.ModelUtils;

public class Result {

	private int status;
	private String msg;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
