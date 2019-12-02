package Spider;
import java.util.List;

import Model.TikiData;

public class SpiderCrawl extends Spider {
	
	public SpiderCrawl() {
		
	}
	
	public void getData() {
		List<TikiData> tikiData = this.spiderTikiPage();
		this.logFile.writeInProductAndCategoryFile(tikiData);
	}
}
