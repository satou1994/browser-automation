package runnable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// ウィンドウが閉じたら処理を停止する
public class CloseRun implements Runnable{
	private WebDriver driver;

	public CloseRun(WebDriver driver) {
		this.driver= driver;
	}

	public void run() {
		try {
			while(driver.findElement(By.xpath("html")).isDisplayed()) {
				Thread.sleep(10000);
			}
		}catch (NullPointerException ex) {
			System.out.println("Close Browser Automation");
		} catch (Exception e) {
			System.out.println("CloseRun Error:"+e);
		}finally {
			driver.quit();
			System.exit(0);
		}
	}
}
