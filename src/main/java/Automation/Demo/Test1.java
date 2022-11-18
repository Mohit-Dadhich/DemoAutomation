package Automation.Demo;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import groovy.time.Duration;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test1 {
	String baseURL = "https://randomuser.me/api/";
	String first_Name_API, last_Name_API, email_API,password_API,street_API,city_API,zip_API,phone_API;
	String jacket_Name = "Proteus Fitness Jackshirt";
	String size = "L";
	String color = "Blue";
	String price = "$5.00";
	String type = "Fixed";
	String successMsg_Expected = "Thank you for your purchase!";
	By signUp_Button = By.xpath("//a[text()='Create an Account']");
	By firstName_Textbox = By.xpath("//input[@name='firstname']");
	By lastName_Textbox = By.xpath("//input[@name='lastname']");
	By email_Textbox = By.xpath("//input[@name='email']");
	By password_Textbox = By.xpath("//input[@name='password']");
	By confirmPassword_Textbox = By.xpath("//input[@name='password_confirmation']");
	By createAccount_Button = By.xpath("//span[text()='Create an Account']");
	By whatsNew_Link = By.xpath("//span[contains(text(),'What')]");
	By mensJacket_Link = By.xpath("//span[contains(text(),'New in men')]//ancestor::strong//following-sibling::ul//a[text()='Jackets']");
	By purchaseJacket_Link = By.xpath("//a[contains(text(),'"+jacket_Name+"')]");
	By addToCart_Button = By.xpath("//span[text()='Add to Cart']");
	By size_option = By.xpath("//div[@option-label='"+size+"']");
	By color_option = By.xpath("//div[@option-label='"+color+"']");	
	By cart_Link = By.xpath("//a[text()='shopping cart']");
	By proceed = By.xpath("//span[text()='Proceed to Checkout']");
	By shipping_Method_RadioButton = By.xpath("//td[text()='"+type+"']//preceding-sibling::td[contains(@class,'col-price')]//span[text()='"+price+"']//ancestor::td//preceding-sibling::td[contains(@class,'col-method')]");
	By next_Button = By.xpath("//span[text()='Next']");
	By street_Textbox = By.xpath("//input[@name='street[0]']");
	By city_TextBox = By.xpath("//input[@name='city']");
	By state_TextBox = By.xpath("//select[@name='region_id']");
	By zip_TextBox = By.xpath("//input[@name='postcode']");
	By phone_TextBox = By.xpath("//input[@name='telephone']");
	By placeOrder_Button = By.xpath("//button[@title='Place Order' and @type='submit']");
	By success_Message = By.xpath("//span[text()='Thank you for your purchase!']");
	By item_In_Cart = By.xpath("//div[@class='block items-in-cart']");
	public WebDriver driver;
	@BeforeTest
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://magento.softwaretestingboard.com/";
		driver.get(url);
	}
	@Test
	public void task1() throws InterruptedException
	{
		WebElement signUp_button = driver.findElement(signUp_Button);
		signUp_button.click();
		WebElement firstName = driver.findElement(firstName_Textbox);
		WebElement lastName = driver.findElement(lastName_Textbox);
		WebElement user_Email = driver.findElement(email_Textbox);
		WebElement password = driver.findElement(password_Textbox);
		WebElement confirm_Password = driver.findElement(confirmPassword_Textbox);
		WebElement createAccount = driver.findElement(createAccount_Button);
				
		first_Name_API = getResponseFromAPI(baseURL,"firstName");
		last_Name_API = getResponseFromAPI(baseURL,"lastName");
		email_API = getResponseFromAPI(baseURL,"email");
		password_API = getResponseFromAPI(baseURL,"password");
		street_API = getResponseFromAPI(baseURL,"street");
		city_API = getResponseFromAPI(baseURL,"city");
		zip_API = getResponseFromAPI(baseURL,"zip");
		phone_API = getResponseFromAPI(baseURL,"phone");
		
		
		firstName.sendKeys(first_Name_API);
		lastName.sendKeys(last_Name_API);
		user_Email.sendKeys(email_API);
		password.sendKeys(password_API+"_A@B2");
		confirm_Password.sendKeys(password_API+"_A@B2");
		createAccount.click();	
		
		WebElement newItem = new WebDriverWait(driver,java.time.Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(whatsNew_Link));
		newItem.click();
		WebElement mensJacket = new WebDriverWait(driver,java.time.Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(mensJacket_Link));
		mensJacket.click();
		WebElement purchaseJacket = new WebDriverWait(driver,java.time.Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(purchaseJacket_Link));
		purchaseJacket.click();
		WebElement addToCart = new WebDriverWait(driver,java.time.Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(addToCart_Button));
		WebElement item_Size = new WebDriverWait(driver,java.time.Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(size_option));
		item_Size.click();
		WebElement item_color = new WebDriverWait(driver,java.time.Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(color_option));
		item_color.click();
		addToCart.click();
		WebElement cartLink = new WebDriverWait(driver,java.time.Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(cart_Link));
		cartLink.click();
		WebElement proceed_Checkout = new WebDriverWait(driver,java.time.Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(proceed));
		proceed_Checkout.click();
		WebElement shipping_Method = new WebDriverWait(driver,java.time.Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(shipping_Method_RadioButton));
		shipping_Method.click();
		WebElement next = new WebDriverWait(driver,java.time.Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(next_Button));
		next.click();
		WebElement street = driver.findElement(street_Textbox);
		WebElement city = driver.findElement(city_TextBox);
		WebElement zip = driver.findElement(zip_TextBox);
		WebElement phone = driver.findElement(phone_TextBox);
		WebElement state = driver.findElement(state_TextBox);
		WebElement nextButton = new WebDriverWait(driver,java.time.Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(next_Button));
		street.sendKeys(street_API);
		city.sendKeys(city_API);
		zip.sendKeys(zip_API);
		phone.sendKeys(phone_API);
		state.click();
		driver.findElement(By.xpath("//option[text()='Alabama']")).click();
		nextButton.click();
		Thread.sleep(10000);
		WebElement placeOrder = driver.findElement(placeOrder_Button);
		placeOrder.click();
		WebElement successMessage_Actual = new WebDriverWait(driver,java.time.Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(success_Message));
		String successMsg = successMessage_Actual.getText().toString();
		Assert.assertEquals(successMsg, successMsg_Expected);
	}
	public static String getResponseFromAPI(String baseURL,String parameter)
	{
		RestAssured.baseURI = baseURL;
        RequestSpecification request = RestAssured.given();
        Response response = request.get();
        JsonPath jsonPathEvaluator = new JsonPath(response.asString());
        String param = parameter;
        switch (param) {
        	case "firstName":
        		return jsonPathEvaluator.getString("results[0].name.first");
        	case "lastName":
        		return jsonPathEvaluator.getString("results[0].name.last");
        	case "email":
        		return jsonPathEvaluator.getString("results[0].email");
        	case "street":
        		return jsonPathEvaluator.getString("results[0].location.street.name");
        	case "password":
        		return jsonPathEvaluator.getString("results[0].login.password");
        	case "zip":
        		return jsonPathEvaluator.getString("results[0].location.postcode");
        	case "city":
        		return jsonPathEvaluator.getString("results[0].location.city");
        	case "phone":
        		return jsonPathEvaluator.getString("results[0].phone");
        	default : 
        		return "";
        }
	}
}