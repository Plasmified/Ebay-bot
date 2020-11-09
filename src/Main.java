import java.io.IOException;
import java.util.Scanner;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * @author Pedro Filipe
 *
 */

public class Main {
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.printf("Ebay Region -> ");
		String region = in.nextLine().toUpperCase();
		System.out.printf("Search for -> ");
		String input = in.nextLine().toUpperCase();
		
		retrieveResults(region,input);
		
		in.close();
		
	}
	
	private static void retrieveResults(String region, String input) {
		Document doc;
		Checker ch = new Checker();
		
		String[] pName = new String[1000];
		String[] pPrice = new String[1000];
		String[] pUrl = new String[1000];
		
		try {
			
			doc = Jsoup.connect("https://www.ebay."+ch.regionCheck(region)+"/sch/i.html?_from=R40&_nkw="+input+"&_sacat=0&_pgn=9&rt=nc/").userAgent("mozilla/17.0").get();
			Elements temp = doc.select("h3.s-item__title");
			Elements price = doc.select("span.s-item__price");
			Elements url = doc.select("a.s-item__link");
			
			System.out.printf("======================================================================================================================");
			System.out.println("\n                                       You searched for: "+doc.title().toUpperCase());
			System.out.println("                                                      Items List");
			System.out.println("======================================================================================================================");
			
			int i = 0;
			for (Element itemsList:temp) {
				pName[i] = itemsList.text();
				i++;
			}
			int j = 0;
			for (Element itemsPrice:price) {
				pPrice[j] = itemsPrice.text();
				j++;
			}
			int l = 0;
			for (Element itemsUrl:url) {
				pUrl[l] = itemsUrl.attr("abs:href");
				l++;
			}
			
			System.out.println("----------------------------------------------------------------------------------------------------------------------");
			int k = 0;
			while (k < j) {
				if (pName[k] != null) {
					System.out.println("Item Found -> "+pName[k]+" \nPrice : "+pPrice[k]+ " \nLink : "+pUrl[k]);
					System.out.println("----------------------------------------------------------------------------------------------------------------------");
				}
				k++;
			}
			System.out.println("======================================================================================================================");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
