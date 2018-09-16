package gas.estore.utility;

import java.util.regex.Pattern;

public class ConvertTagalog {
	private String[] first = { "isa", "dalawa", "tatlo", "apat", "lima", "anim", "pito", "walo", "siyam" };
	private String[] second = { " labing", " dalawampu't ", " tatlumpu't ", " apatnapu't ", " limampu't ",
			" animnapu't ", " pitumpu't ", " walumpu't ", " siyamnapu't " };
	private String[] third = { " sampu ", " dalawampu ", " tatlumpu ", " apatnapu ", " limampu ", " animnapu ",
			" pitumpu ", " walumpu ", " siyamnapu " };
	private String[] fourth = { "isang ", "dalawang ", "tatlong ", "apat na ", "limang ", "anim na ", "pitong ",
			"walong ", "siyam na " };
	private String[] fifth = { "daan ", "libo", "pung libo" };
	private String message = "";
	private boolean a4, b4, c4, d4;

	public String convert(double total) {
		String totalPrice = total + "";
		String[] parts = totalPrice.split(Pattern.quote("."));
		int part1 = Integer.parseInt(parts[0]);
		int part2 = Integer.parseInt(parts[1]);
		int tenThousands, thousands, hundreds, tens, units;
		int tens2, units2;

		tenThousands = part1 / 10000;
		thousands = part1 % 10000 / 1000;
		hundreds = part1 % 10000 % 1000 / 100;
		tens = part1 % 10000 % 1000 % 100 / 10;
		units = part1 % 10000 % 1000 % 100 % 10 / 1;

		if (tenThousands > 0) {
			message = combineTwoDigitv1(tenThousands, thousands) + fifth[2];
		} else {
			a4 = true;
		}
		if (thousands > 0 && a4) {
			message += OneDigit(thousands) + fifth[1];
		} else if (thousands > 0 && a4 == false) {
			b4 = false;
		} else {
			b4 = true;
		}
		if (hundreds > 0 && b4) {
			message += OneDigit(hundreds) + fifth[0];
		} else if (hundreds > 0 && b4 == false) {
			message += " at " + OneDigit(hundreds) + fifth[0];
		} else {
			c4 = true;
		}
		if (tens > 0 && c4) {
			message += combineTwoDigitv1(tens, units);
		} else if (tens > 0 && c4 == false) {
			message += " at " + combineTwoDigitv1(tens, units);
		} else {
			d4 = true;
		}
		if (units > 0 && d4 && c4) {
			message += OneDigit(units);
		} else if (units > 0 && d4 == false && c4) {

		} else if (units > 0 && d4 && c4 == false) {
			message += " at " + OneDigit(units);
		}

		message += " piso";

		tens2 = part2 / 10;
		units2 = part2 % 10 / 1;

		if (tens2 > 0 || units2 > 0) {
			message += " at " + combineTwoDigitv1(tens2, units2) + " centimo";
		}

		return message;
	}

	public String combineTwoDigitv1(int a, int b) {
		String a1 = "";
		switch (a) {
		case 1: {
			a1 = second[0];
			break;
		}
		case 2: {
			a1 = second[1];
			break;
		}
		case 3: {
			a1 = second[2];
			break;
		}
		case 4: {
			a1 = second[3];
			break;
		}
		case 5: {
			a1 = second[4];
			break;
		}
		case 6: {
			a1 = second[5];
			break;
		}
		case 7: {
			a1 = second[6];
			break;
		}
		case 8: {
			a1 = second[7];
			break;
		}
		case 9: {
			a1 = second[8];
			break;
		}
		default: {
			a1 = "";
			break;
		}
		}

		String b1 = "";
		switch (b) {
		case 1: {
			b1 = first[0];
			break;
		}
		case 2: {
			b1 = fourth[1];
			break;
		}
		case 3: {
			b1 = fourth[2];
			break;
		}
		case 4: {
			b1 = fourth[3];
			break;
		}
		case 5: {
			b1 = fourth[4];
			break;
		}
		case 6: {
			b1 = fourth[5];
			break;
		}
		case 7: {
			b1 = fourth[6];
			break;
		}
		case 8: {
			b1 = fourth[7];
			break;
		}
		case 9: {
			b1 = fourth[8];
			break;
		}
		default: {
			b1 = "";
			break;
		}
		}
		String w = a + "" + b;
		String c = a1 + b1;
		switch (w) {
		case "10": {
			c = third[0];
			break;
		}
		case "20": {
			c = third[1];
			break;
		}
		case "30": {
			c = third[2];
			break;
		}
		case "40": {
			c = third[3];
			break;
		}
		case "50": {
			c = third[4];
			break;
		}
		case "60": {
			c = third[5];
			break;
		}
		case "70": {
			c = third[6];
			break;
		}
		case "80": {
			c = third[7];
			break;
		}
		case "90": {
			c = third[8];
			break;
		}
		default: {
			break;
		}
		}

		return c;
	}

	public String OneDigit(int a) {
		String b1 = "";
		switch (a) {
		case 1: {
			b1 = fourth[0];
			break;
		}
		case 2: {
			b1 = fourth[1];
			break;
		}
		case 3: {
			b1 = fourth[2];
			break;
		}
		case 4: {
			b1 = fourth[3];
			break;
		}
		case 5: {
			b1 = fourth[4];
			break;
		}
		case 6: {
			b1 = fourth[5];
			break;
		}
		case 7: {
			b1 = fourth[6];
			break;
		}
		case 8: {
			b1 = fourth[7];
			break;
		}
		case 9: {
			b1 = fourth[8];
			break;
		}
		default: {
			b1 = "";
			break;
		}
		}
		return b1;
	}
}