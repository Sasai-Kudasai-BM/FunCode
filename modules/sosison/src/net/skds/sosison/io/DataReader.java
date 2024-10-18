package net.skds.sosison.io;

import java.io.DataInput;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface DataReader extends DataInput {

	@Override
	default String readLine() throws IOException {
		throw new UnsupportedEncodingException("readLine() in json");
	}

	void readBeginObject() throws IOException;

	void readEndObject() throws IOException;

	void readBeginArray() throws IOException;

	void readEndArray() throws IOException;
}
