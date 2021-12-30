package runnable;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// バーナー「X」を押下する
public class BurnerRun implements Runnable {
	private WebDriver driver;

	public BurnerRun(WebDriver driver) {
		this.driver= driver;
	}

	@Override
	public void run() {
		boolean active = true;
		int count = 1;

		System.out.println("advertising burner app start!");

		restart:
		while(active) {
			try {
				WebDriverWait advertising = new WebDriverWait(driver, 600);
				advertising.until(ExpectedConditions.visibilityOfElementLocated(By.className("yt-confirm-dialog-renderer")));// ytp-ad-overlay-close-button
				driver.findElement(By.className("ytp-ad-overlay-close-button")).click();

			}catch(TimeoutException ex) {
				continue restart;

			}catch(Exception e) {
				System.out.println("BurnerRun Error:" + e);
				driver.quit();
				System.exit(0);
			}

			System.out.println("Skipped Burner count:" + count);
			count++;
		}
	}
}
