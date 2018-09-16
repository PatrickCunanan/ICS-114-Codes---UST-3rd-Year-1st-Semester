package string.utility;

import java.sql.Connection;

import string.model.*;
public class StringFactory {
	public static StringBean getInstance(String input, Connection connection) {
		StringBean s = new StringBean();
		s.setInput(input);
		s.process(input);
		s.insertRecord(connection);
		return s;
	}
}
