package firstCase;

import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui;

public class sample {

	public static void main(String[] args) throws Exception {

		/*
		 * Course Name:A101 Test Otomasyon Practicum Type:First Case Language:Java
		 * Technologies to be used:Selenium Case Detail Uçtan uca ödeme ekranına kadar
		 * Selenium’da java dili ile chrome browser kullanarak test otomasyon ödevi
		 * yapılacak. Ödeme ekranı doldurulmayacak. Aşağıdaki senaryoyu web ve mobil
		 * olmak üzere 2 çeşit oluşturabilirlerse çok iyi olur. En az Web’de yapmak
		 * zorunlu. - Senaryoya üye kaydı oluşturmadan devam edilecek. - Giyim-->
		 * Aksesuar--> Kadın İç Giyim-->Dizaltı Çorap bölümüne girilir. - Açılan ürünün
		 * siyah olduğu doğrulanır. - Sepete ekle butonuna tıklanır. - Sepeti Görüntüle
		 * butonuna tıklanır. - Sepeti Onayla butonuna tıklanır. - Üye olmadan devam et
		 * butonuna tıklanır. - Mail ekranı gelir. - Sonrasında adres ekranı gelir.
		 * Adres oluştur dedikten sonra ödeme ekranı gelir. - Siparişi tamamla butonuna
		 * tıklayarak, ödeme ekranına gidildiği , doğru ekrana yönlendiklerini kontrol
		 * edecekler.
		 */

		String chromedriverPath = "D:\\chromedriver_win32\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", chromedriverPath);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.a101.com.tr/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
		driver.get("https://www.a101.com.tr/");

		boolean present;
		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div[1]/div[2]/button[4]"));
			present = true;
		} catch (Exception e) {
			present = false;
		}

		if (present) {
			driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div[1]/div[2]/button[4]")).click();
		}

		WebElement giyimAksesuar = driver
				.findElement(By.xpath("/html/body/section/section[1]/div/div/div/div[1]/div/div/ul/li[4]"));

		Actions action = new Actions(driver);
		action.moveToElement(giyimAksesuar).perform();

		driver.findElement(By.xpath(
				"/html/body/section/section[1]/div/div/div/div[1]/div/div/ul/li[4]/div/div/div/div/div[1]/ul[2]/li[8]/a"))
				.click();
		driver.get("https://www.a101.com.tr/giyim-aksesuar/dizalti-corap/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,50)");

		driver.get("https://www.a101.com.tr/giyim-aksesuar/penti-kadin-50-denye-pantolon-corabi-siyah/");

		String productName = driver.findElement(By.xpath(
				"/html/body/section/section[3]/div[2]/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/span"))
				.getText();

		String productColor = productName.toUpperCase(new Locale("tr-TR"));
		String istenilenRenk = "SİYAH";
		if (productColor.startsWith(istenilenRenk.substring(0, 2))) {

			driver.findElement(By.xpath("/html/body/section/section[3]/div[2]/div[1]/div/div[3]/div[2]/div[1]/button"))
					.click();// sepete ekle butonuna tıklama

			driver.get("https://www.a101.com.tr/baskets/basket/");
			// Sepeti Görüntüle butonuna tıklama

			driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div/div[2]/div/a")).click();
			// Sepeti Onayla butonuna tıklama

			driver.findElement(By.xpath("/html/body/section/div[1]/div/div[1]/div[1]/div[2]/a")).click();
			// Üye olmadan devam et butonuna tıklama

			driver.findElement(By.name("user_email")).sendKeys("bozdemir.ib70@gmail.com");

			driver.findElement(By.xpath("/html/body/section/div[1]/div/div[2]/div/div/form/button")).click();// devam et

			driver.findElement(
					By.xpath("/html/body/section/section/div/div[2]/div/div[1]/div/div[1]/div[2]/ul[2]/li/a")).click();// Yeni

			// Adres Güncelleme

			// bireysel: /html/body/div[1]/div/div[2]/form/div[1]/div[2]/label[1]
			// kurumsal: /html/body/div[1]/div/div[2]/form/div[1]/div[2]/label[2]

			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[1]/div[2]/label[1]")).click();// bireysel

			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[2]/div/div/label/input"))
					.sendKeys("test adress");

			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[3]/div[1]/div/label/input"))
					.sendKeys("ilyas");

			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[3]/div[2]/div/label/input"))
					.sendKeys("bozdemir");

			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[4]/div/div/label/input"))
					.sendKeys("0 (555) 555-5555");

			WebElement iller = driver
					.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[5]/div[1]/div/label/div/select"));
			Select selectIller = new Select(iller);
			selectIller.selectByIndex(44);

			WebElement ilceler = driver
					.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[5]/div[2]/div/label/div/select"));
			Select selectIlceler = new Select(ilceler);
			selectIlceler.selectByIndex(3);

			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(300));

			WebElement mahalleler = driver.findElement(
					By.xpath("//*[@id=\"js-orders-modal-container\"]/div/div[2]/form/div[6]/label/div/select"));
			Select selectMahalleler = new Select(mahalleler);
			selectMahalleler.selectByVisibleText("ARALIK MAH (GÜNEYYURT BELDESİ)");
			selectMahalleler.selectByValue("74651");

			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/div[7]/label/textarea"))
					.sendKeys("test adres asdasdaf dsfsfdgf dfgdfg dfg fg");

			driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/button[1]")).click();
			// kaydet

			driver.findElement(By.xpath("/html/body/section/section/div/div[2]/div/div[1]/div/div[2]/form/div[2]/div[2]/ul/li[2]/label/div[2]/span")).click();// kargo için

			driver.findElement(By.xpath("/html/body/section/section/div/div[2]/div/div[1]/div/div[2]/form/div[2]/button")).click();/// son adım

		} else
			System.out.println("Seçilen Ürün İstenilen Renkte Değildir");

	}
}