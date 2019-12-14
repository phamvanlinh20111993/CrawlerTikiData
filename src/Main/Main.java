package Main;

import Spider.Spider;
import Spider.SpiderCrawl;

public class Main {
	
	public static void main(String[] args) {
		// using proxy to connect web:
		// https://stackoverflow.com/questions/13288471/jsoup-over-vpn-proxy
		SpiderCrawl spiderCrawl = new SpiderCrawl();
		//spiderCrawl.getDataAdvance();
		spiderCrawl.getDataAdvance1();
	// 	Spider spiderCrawl = new Spider();
	//	System.out.println("Total product " + spiderCrawl.countTotalProduct());
		return ;
	}
}
