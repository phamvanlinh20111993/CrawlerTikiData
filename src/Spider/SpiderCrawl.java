package Spider;
import java.util.List;

import Model.TikiData;

public class SpiderCrawl extends Spider {
	
	public void getData() {
		List<TikiData> tikiData = this.spiderTikiPage();
		this.logFile.writeInProductAndCategoryFile(tikiData);
	}
	
	public void getDataAdvance() {
        this.spiderTikiPage1();
    }
	
	public void getDataAdvance1() {
	    // start crawl from index list 
        this.spiderTikiPage2(15);
    }
}
