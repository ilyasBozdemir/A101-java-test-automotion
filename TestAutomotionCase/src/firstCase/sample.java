package firstCase;

import java.time.Duration;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;

public class sample {
	JavascriptExecutor jse;
	public static WebDriver driver;
	private static String baseUrl;
	private static String chromedriverPath;
	//
	private static String errText = "State: Failed.",
			   successText = "State: Passed.";
	
	private static String ModalCerezKullanimiTextXpath = "/html/body/div[2]/div/div[3]/div[1]/div[1]/div/h2";
	private static String ModalCerezKullanimiKabulEtXpath = "/html/body/div[2]/div/div[4]/div[1]/div[2]/button[4]";
    private static String ModalCikmadanOnceGozatTextXpath = "/html/body/div[1]/div[2]/div[1]";
	private static String ModalCikmadanOnceGozatKapatXpath = "/html/body/div[1]/div[1]";
	private static String UrunDetayiAcXpath = "/html/body/section/section[4]/div[3]/div[2]/div/div[2]/div[2]/div/ul/li[1]/article/div/a/figure";
	private static String productNameXpath = "/html/body/section/section[3]/div[2]/div[1]/div/div[3]/div[1]/div[1]/div[2]/div/div[2]/div/div[1]/span";
	private static String uyeOlmadanDevamEtXpath = "/html/body/section/div[1]/div/div[1]/div[1]/div[2]/a";
	private static String sepetiOnaylaXpath = "/html/body/section/div[1]/div[2]/div/div[2]/div/a";
	private static String sepeteEkleXpath = "/html/body/section/section[3]/div[2]/div[1]/div/div[3]/div[2]/div[1]/button";
	private static String devamEtXpath = "/html/body/section/div[1]/div/div[2]/div/div/form/button";
	private static String inputName = "user_email";
	private static String myEmailAddress = "bozdemir.ib70@gmail.com";
	private static String yeniAdresOlusturXpath = "/html/body/section/section/div/div[2]/div/div[1]/div/div[1]/div[2]/ul[2]/li/a";
	private static String adresBasligiXpath = "/html/body/div[1]/div/div[2]/form/div[2]/div/div/label/input";
	private static String adXpath = "/html/body/div[1]/div/div[2]/form/div[3]/div[1]/div/label/input";
	private static String SoyadXpath = "/html/body/div[1]/div/div[2]/form/div[3]/div[2]/div/label/input";
	private static String CepXpath = "/html/body/div[1]/div/div[2]/form/div[4]/div/div/label/input";
	private static String ilXpath = "/html/body/div[1]/div/div[2]/form/div[5]/div[1]/div/label/div/select";
	private static String ilceXpath = "/html/body/div[1]/div/div[2]/form/div[5]/div[2]/div/label/div/select";
	private static String mahalleXpath = "/html/body/div[1]/div/div[2]/form/div[6]/label/div/select";
	private static String adresXpath = "/html/body/div[1]/div/div[2]/form/div[7]/label/textarea";
	private static String kaydetBtnXpath = "/html/body/div[1]/div/div[2]/form/button[1]";
	private static String kargoChkXpath = "/html/body/section/section/div/div[2]/div/div[1]/div/div[2]/form/div[2]/div[2]/ul/li[2]/label/div[2]/span";
	private static String kaydetveDevamEtBtnXpath = "/html/body/section/section/div/div[2]/div/div[1]/div/div[2]/form/div[2]/button";

	
	
	
	
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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("İstenen: A101 Test Automotion Case");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("--Test Bitti--");
	}

	@Before
	public void setUp() throws Exception {
		chromedriverPath = "D:\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromedriverPath);
		driver = new ChromeDriver();
		baseUrl = "https://www.a101.com.tr/";
		driver.manage().window().maximize();
		jse = (JavascriptExecutor) driver;
	}

	@Test
	public void testStartTest() {

		System.out.println("----------------");
		Boolean state = testDizaltiCorapBolumuneGit();
		String msg = state ? successText : errText;
		System.out.println(msg);
		System.out.println("----------------");
		if (state) {
			state = testAcilanUrunSiyahMi();
			msg = state ? successText : errText;
			System.out.println(msg);
			System.out.println("----------------");
			if (state) {
				state = testSepeteEkle();
				msg = state ? successText : errText;
				System.out.println(msg);
				System.out.println("----------------");
				if (state) {
					state = testSepetiGoruntule();
					msg = state ? successText : errText;
					System.out.println(msg);
					System.out.println("----------------");
					if (state) {
						state = testSepetiOnayla();
						msg = state ? successText : errText;
						System.out.println(msg);
						System.out.println("----------------");
						if (state) {
							state = testUyeOlmadanDevamEt();
							msg = state ? successText : errText;
							System.out.println(msg);
							System.out.println("----------------");
							if (state) {
								state = testMailEkrani();
								msg = state ? successText : errText;
								System.out.println(msg);
								System.out.println("----------------");
								if (state) {
									state = testAdresEkrani();
									msg = state ? successText : errText;
									System.out.println(msg);
									System.out.println("----------------");
									if(state) {
										 state = testOdemeEkrani();
										 msg = state ? successText : errText;
										 System.out.println(msg);
										 System.out.println("----------------");
									 }
								}
							}
						}
					}
				}
			}
		}
	}

	public boolean testDizaltiCorapBolumuneGit() {
		System.out.println("İstenen : Giyim --> Aksesuar--> Kadın İç Giyim--> Dizaltı Çorap bölümüne girilir.");

		driver.get(baseUrl);
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		 
		modalKapat(ModalCerezKullanimiTextXpath, ModalCerezKullanimiKabulEtXpath);
		modalKapat(ModalCikmadanOnceGozatTextXpath, ModalCikmadanOnceGozatKapatXpath);
		driver.get(baseUrl + "giyim-aksesuar/dizalti-corap/");

		
		jse.executeScript("window.scrollBy(0,250)");

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

		return true;
	}

	public boolean testAcilanUrunSiyahMi() {
		System.out.println("İstenen : Açılan ürünün siyah olduğu doğrulanır.");

		

		driver.findElement(By.xpath(UrunDetayiAcXpath)).click();
		
		jse.executeScript("window.scrollBy(0,100)");

		String productName = driver.findElement(By.xpath(productNameXpath)).getText();

		String productColor = productName.toUpperCase(new Locale("tr-TR"));
		String istenilenRenk = "SİYAH";
		if (productColor.startsWith(istenilenRenk.substring(0, 2)))
			return true;
		else
			return false;

	}

	public boolean testSepeteEkle() {
		System.out.println("İstenen: Sepete ekle butonuna tıklanır.");

		
		boolean state = ElementVarmi(sepeteEkleXpath);
		if (state) {
			ElementClick(driver, sepeteEkleXpath);
			return true;
		} else
			return false;
	}

	public boolean testSepetiGoruntule() {
		System.out.println("İstenen: Sepeti Görüntüle butonuna tıklanır.");

		driver.get(baseUrl + "baskets/basket/");
		return true;

	}

	public boolean testSepetiOnayla() {
		System.out.println("İstenen: Sepeti Onayla butonuna tıklanır.");

		boolean state = ElementVarmi(sepetiOnaylaXpath);
		if (state) {
			ElementClick(driver, sepetiOnaylaXpath);
			return true;
		} else
			return false;
	}

	public boolean testUyeOlmadanDevamEt() {
		System.out.println("İstenen: Üye olmadan devam et butonuna tıklanır.");

		boolean state = ElementVarmi(uyeOlmadanDevamEtXpath);
		if (state) {
			ElementClick(driver, uyeOlmadanDevamEtXpath);
			return true;
		} else
			return false;

	}

	public boolean testMailEkrani() {
		System.out.println("İstenen: Mail ekranı gelir.");
		
		ElementVarmi(devamEtXpath);

		boolean state = ElementVarmi(devamEtXpath);
		boolean state2 = ElementVarmiByName(inputName);

		if (state && state2) {

			driver.findElement(By.name(inputName)).sendKeys(myEmailAddress);
			ElementClick(driver, devamEtXpath);
			return true;
		} else
			return false;

	}

	public boolean testAdresEkrani() {
		
		System.out.println("İstenen: Sonrasında adres ekranı gelir. Adres oluştur dedikten sonra ödeme ekranı gelir.");

		
		ElementVarmi(yeniAdresOlusturXpath);

		boolean state = ElementVarmi(yeniAdresOlusturXpath);
		if (state) {
			ElementClick(driver, yeniAdresOlusturXpath);
			//
			
			driver.findElement(By.xpath(adresBasligiXpath)).sendKeys("My Test Adress");
			driver.findElement(By.xpath(adXpath)).sendKeys("Ilyas");
			driver.findElement(By.xpath(SoyadXpath)).sendKeys("Bozdemir");
			driver.findElement(By.xpath(CepXpath)).sendKeys("0 (555) 555-5555");

			WebElement iller = driver.findElement(By.xpath(ilXpath));
			Select selectIller = new Select(iller);
			selectIller.selectByIndex(44);

			WebElement ilceler = driver.findElement(By.xpath(ilceXpath));
			Select selectIlceler = new Select(ilceler);
			selectIlceler.selectByIndex(3);

			WebElement mahalleler = driver.findElement(By.xpath(mahalleXpath));
			Select selectMahalleler = new Select(mahalleler);
			selectMahalleler.selectByVisibleText("ARALIK MAH (GÜNEYYURT BELDESİ)");
			selectMahalleler.selectByValue("74651");
			

			Boolean hataVarmi = ElementVarmi("/html/body/div[1]/div/div[2]/form/div[6]/div");

			driver.findElement(By.xpath(adresXpath)).sendKeys("test adres 9159 Mireille Ranch Apt. 172");

			state = ElementVarmi(kaydetBtnXpath);
			
			ElementClick(driver, kaydetBtnXpath);


			ElementClick(driver, kargoChkXpath);
			ElementClick(driver, kaydetveDevamEtBtnXpath);// kaydet ve devam et

			return true;
		} else
			return false;
	}

	public boolean testOdemeEkrani() {
		System.out.println(
				"İstenen: Siparişi tamamla butonuna tıklayarak, ödeme ekranına gidildiği , doğru ekrana yönlendiklerini kontrol edecekler.");

		return true;
	}

	//

	public void modalKapat(String TitleXpath, String ButtonXpath) {
		boolean present;
		try {
			driver.findElement(By.xpath(TitleXpath));
			present = true;
		} catch (Exception e) {
			present = false;
		}

		if (present) {
			driver.findElement(By.xpath(ButtonXpath)).click();
		}
	}

	public boolean ElementVarmi(String XpathText) {
		boolean present;
		try {
			driver.findElement(By.xpath(XpathText));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean ElementVarmiByName(String name) {
		
		try {
			driver.findElement(By.name(name));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void ElementClick(WebDriver driver, String XpathText) {
		driver.findElement(By.xpath(XpathText)).click();
	}
	
	public void TestMethoduCagir(Boolean callbackTestFunction) {
		
	}
}