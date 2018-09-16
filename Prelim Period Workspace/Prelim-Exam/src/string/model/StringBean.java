package string.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringBean {
	private String input;
	private String inputNumbers;
	private String inputChar;
	private int totalNum;
	private int totalChar;

	public String getInputNumbers() {
		return inputNumbers;
	}

	public void setInputNumbers(String inputNumbers) {
		this.inputNumbers = inputNumbers;
	}

	public String getInputChar() {
		return inputChar;
	}

	public void setInputChar(String inputChar) {
		this.inputChar = inputChar;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getTotalChar() {
		return totalChar;
	}

	public void setTotalChar(int totalChar) {
		this.totalChar = totalChar;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public void process(String input) {
		char i[] = input.toCharArray();
		inputNumbers = "";
		inputChar = "";
		for (int j = 0; j < i.length; j++) {
			if ((i[j] == '0') || (i[j] == '1') || (i[j] == '2') || (i[j] == '3') || (i[j] == '4') || (i[j] == '5')
					|| (i[j] == '6') || (i[j] == '7') || (i[j] == '8') || (i[j] == '9')) {
				inputNumbers += i[j];
			} else if ((i[j] == 'a') || (i[j] == 'b') || (i[j] == 'c') || (i[j] == 'd') || (i[j] == 'e')
					|| (i[j] == 'f') || (i[j] == 'g') || (i[j] == 'h') || (i[j] == 'i') || (i[j] == 'j')
					|| (i[j] == 'k') || (i[j] == 'l') || (i[j] == 'm') || (i[j] == 'n') || (i[j] == 'o')
					|| (i[j] == 'p') || (i[j] == 'q') || (i[j] == 'r') || (i[j] == 's') || (i[j] == 't')
					|| (i[j] == 'u') || (i[j] == 'v') || (i[j] == 'w') || (i[j] == 'x') || (i[j] == 'y')
					|| (i[j] == 'z') || (i[j] == 'A') || (i[j] == 'B') || (i[j] == 'C') || (i[j] == 'D')
					|| (i[j] == 'E') || (i[j] == 'F') || (i[j] == 'G') || (i[j] == 'H') || (i[j] == 'I')
					|| (i[j] == 'J') || (i[j] == 'K') || (i[j] == 'L') || (i[j] == 'M') || (i[j] == 'N')
					|| (i[j] == 'O') || (i[j] == 'P') || (i[j] == 'Q') || (i[j] == 'R') || (i[j] == 'S')
					|| (i[j] == 'T') || (i[j] == 'U') || (i[j] == 'V') || (i[j] == 'W') || (i[j] == 'X')
					|| (i[j] == 'Y') || (i[j] == 'Z')) {
				inputChar += i[j];
			} else {
			}

			String n = removeDuplicate(inputNumbers);
			String c = removeDuplicate(inputChar);
			int nc = n.length();
			int cc = c.length();
			setInputChar(c);
			setInputNumbers(n);
			setTotalChar(cc);
			setTotalNum(nc);
			inputNumbers = n;
			inputChar = c;
			totalNum = nc;
			totalChar = cc;
		}
	}

	public static String removeDuplicate(String s) {
		boolean seen[] = new boolean[256];
		StringBuilder sb = new StringBuilder(seen.length);

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!seen[c]) {
				seen[c] = true;
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public void insertRecord(Connection connection) {
		try {
			String sql = "";
			sql = "insert into prelimexam(inputString, inputLetters, inputNumbers, totalLetters, totalNumber) values(?,?,?,?,?)";
			PreparedStatement pstmnt = connection.prepareStatement(sql);
			pstmnt.setString(1, input);
			pstmnt.setString(2, inputChar);
			pstmnt.setString(3, inputNumbers);
			pstmnt.setInt(4, totalChar);
			pstmnt.setInt(5, totalNum);
			pstmnt.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public ResultSet getAllRecords(Connection connection) {
		ResultSet records = null;
		try {
			String sql = "select * from prelimexam";
			PreparedStatement pstmnt = connection.prepareStatement(sql);
			records = pstmnt.executeQuery();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return records;
	}

}
