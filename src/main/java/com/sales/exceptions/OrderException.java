package com.sales.exceptions;

@SuppressWarnings("serial")
public class OrderException extends Exception {
	
	private Long pid;
	private Long cid;
	private int qty;
	
	public OrderException(String message, Long long1, Long long2, int i) {
        super(message);
        this.pid = long1;
        this.cid = long2;
        this.qty = i;
    }

	public Long getPid() {
		return pid;
	}

	public Long getCid() {
		return cid;
	}

	public int getQty() {
		return qty;
	}
}