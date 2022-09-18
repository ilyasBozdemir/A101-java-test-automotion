package firstCase;

import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

		driver.get("https://www.a101.com.tr/giyim-aksesuar/dizalti-corap/");

		driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div[1]/div[2]/button[4]")).click();

		driver.get("https://www.a101.com.tr/giyim-aksesuar/penti-kadin-50-denye-pantolon-corabi-siyah/");

		Thread.sleep(1000);

		String productName = driver.findElement(By.xpath(
				"/html/body/section/section[3]/div[2]/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/span"))
				.getText();

		String productColor = productName.toUpperCase(new Locale("tr-TR"));
		String istenilenRenk = "SİYAH";
		if (productColor.startsWith(istenilenRenk.substring(0, 2))) {

			driver.findElement(By.xpath("/html/body/section/section[3]/div[2]/div[1]/div/div[3]/div[2]/div[1]/button"))
					.click();// sepete ekle butonuna tıklama
		
			System.out.println("sepete ekle butonuna tıklama");

			driver.get("https://www.a101.com.tr/baskets/basket/");
			// Sepeti Görüntüle butonuna tıklama
			
			System.out.println("Sepeti Görüntüle butonuna tıklama");
			
		
			driver.findElement(By.xpath("/html/body/section/div[1]/div[2]/div/div[2]/div/a")).click();
			// Sepeti Onayla butonuna tıklama
			
			System.out.println("Sepeti Onayla butonuna tıklama");
			
		
			driver.findElement(By.xpath("/html/body/section/div[1]/div/div[1]/div[1]/div[2]/a")).click();
			// Üye olmadan devam et butonuna tıklama
			System.out.println("Üye olmadan devam et butonuna tıklama");
			

			driver.findElement(By.name("user_email")).sendKeys("bozdemir.ib70@gmail.com");
			
			System.out.println("send keys");
			
			//driver.findElement(By.xpath("/html/body/section/div[1]/div/div[2]/div/div/form/button")).click();// devam et

		


		} else
			System.out.println("Seçilen Ürün İstenilen Renkte Değildir");

	}
}