package com.umbrella.worker.util;

public interface Gateway {

	public void init() throws Exception;
	
	public boolean sendDetail(String[] mobile, String content, long seq);
}
