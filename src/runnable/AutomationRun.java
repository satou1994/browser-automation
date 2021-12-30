package runnable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// 広告をスキップする
public class AutomationRun implements Runnable{

	private WebDriver driver;

	public AutomationRun(WebDriver driver) {
		this.driver= driver;
	}

	@Override
	public void run() {
		boolean active = true;
		int count =1;

		System.out.println("advertising automation app start!");

		restart:
		while(active) {
			try {
				WebDriverWait advertising = new WebDriverWait(driver, 600);
				advertising.until(ExpectedConditions.visibilityOfElementLocated(By.className("ytp-ad-skip-button-text")));
				driver.findElement(By.className("ytp-ad-skip-button-text")).click();

			}catch(org.openqa.selenium.TimeoutException ex) {
				continue restart;

			}catch(Exception e) {
				System.out.println("AutomationRun Error:"+e);
				driver.quit();
				System.exit(0);
			}

			System.out.println("Skipped automation count:" + count);
			count++;
		}
	}
}
