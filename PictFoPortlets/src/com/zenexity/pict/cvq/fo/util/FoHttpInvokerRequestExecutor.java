package com.zenexity.pict.cvq.fo.util;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.springframework.remoting.httpinvoker.SimpleHttpInvokerRequestExecutor;

public class FoHttpInvokerRequestExecutor extends SimpleHttpInvokerRequestExecutor {

	private String name;

	protected void prepareConnection(HttpURLConnection con, int contentLength)
			throws IOException {
		super.prepareConnection(con, contentLength);
		con.setRequestProperty("ecitizenName", name);
	}

	public void setName(String name) {
		this.name = name;
	}
}
