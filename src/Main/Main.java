package Main;

import Spider.Spider;
import Spider.SpiderCrawl;

public class Main {
	
	public static void main(String[] args) {
		// using proxy to connect web:
		// https://stackoverflow.com/questions/13288471/jsoup-over-vpn-proxy
		Spider spiderCrawl = new Spider();
	//	spiderCrawl.getData();
		System.out.println("Total product " + spiderCrawl.countTotalProduct());
		return ;
	}
}
