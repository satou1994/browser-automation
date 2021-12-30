package browser;
import java.util.concurrent.Executor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import runnable.AutomationRun;
import runnable.BurnerRun;
import runnable.CloseRun;
import runnable.StopRun;

public class BrowserStart {
	public static void main(String args[]) {
	// ChromeDriverのパスを設定
		System.setProperty("webdriver.chrome.driver","chromeDriver/chromedriver");
		// WebDriverのインスタンスを作成
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.youtube.com/");

		try {
//------ Executor -------
		Runnable burner = new BurnerRun(driver);
		Executor exBuner = new MyExecutor();
		exBuner.execute(burner);

		Runnable stop = new StopRun(driver);
		Executor exStop = new MyExecutor();
		exStop.execute(stop);

		Runnable automation = new AutomationRun(driver);
		Executor exAutomation = new MyExecutor();
		exAutomation.execute(automation);

		Runnable close = new CloseRun(driver);
		Executor exClose = new MyExecutor();
		exClose.execute(close);

	} catch (Exception e) {
		System.out.println("BrowserStart Error:"+e);
	}
	}
}

//----- Threadでの操作 -----
//Burner burner = new Burner(driver);
//burner.start();
//Stop stop = new Stop(driver);
//stop.start();
//Automation automation = new Automation(driver);
//automation.start();
//-------------------------------

//再生ボタン押下
//WebDriverWait wait = new WebDriverWait(driver, 10);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ytp-play-button")));
//driver.findElement(By.className("ytp-play-button")).click();

//class="ytp-ad-text ytp-ad-skip-button-text"
//// 開きたいサイトのURLを引数に指定
//driver.get("https://www.google.com/");
//// 検索を実行
//WebElement searchBox = driver.findElement(By.name("q"));
//searchBox.sendKeys("youtube");
//searchBox.submit();
////		要素取得
//String path = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div[1]/div/div/div/div[1]/a")).getText();
//System.out.println(path);
////		 クリック
//driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div[1]/div/div/div/div[1]/a")).click();
////		指定したdriverに対して最大で10秒間待つように設定する
//WebDriverWait wait = new WebDriverWait(driver, 10);
////指定された要素(検索テキストボックス)が表示状態になるまで待機する
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));
//WebElement element = driver.findElement(By.name("search_query"));
//element.sendKeys("ラファイル");
//element.submit();