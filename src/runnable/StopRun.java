package runnable;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// 視聴を続けますか「はい」を押下する
public class StopRun implements Runnable {
	private WebDriver driver;

	public StopRun(WebDriver driver) {
		this.driver= driver;
	}

	@Override
	public void run() {
		boolean active = true;
		int count = 1;

		System.out.println("advertising stopping app start!");

		restart:
		while(active) {
			try {
				WebDriverWait advertising = new WebDriverWait(driver, 600);
				advertising.until(ExpectedConditions.visibilityOfElementLocated(By.className("yt-button-renderer")));
				driver.findElement(By.className("yt-button-renderer")).click();

			}catch (TimeoutException ex) {
				continue restart;

			}catch(Exception e) {
				System.out.println("StopRun Error:"+e);
				driver.quit();
				System.exit(0);
			}

			System.out.println("Skipped Stop count:" + count);
			count++;
		}
	}
}
