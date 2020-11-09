/**
 * @author Pedro Filipe
 *
 */

public class Checker {
	
	public String regionCheck(String input) {
		String value = "";
		switch(input) {
			case "UK":
				value = "co.uk";
			break;
			case "ES":
				value = "es";
			break;
			case "ITA":
				value = "it";
			break;
			case "FR":
				value = "fr";
			break;
			case "GLOBAL":
				value = "com";
			break;
		}
		
		return value;
	}
	
}
