import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/')

WebUI.setText(findTestObject('LoginPage/input_UserName'), 'standard_user')

WebUI.setEncryptedText(findTestObject('LoginPage/input_Password'), 'qcu24s4901FyWDTwXGr6XA==')

WebUI.click(findTestObject('LoginPage/button_Login'))

WebUI.click(findTestObject('ProductCatalogPage/button_AddToOrder_SauceabsBackpack'))

WebUI.click(findTestObject('ProductCatalogPage/link_GoToCart'))

WebUI.click(findTestObject('YourCartPage/button_CheckOut'))

WebUI.setText(findTestObject('YourInformationPage/input_FirstName'), firstName)

WebUI.setText(findTestObject('YourInformationPage/input_LastName'), lastName)

WebUI.setText(findTestObject('YourInformationPage/input_ZipCode'), zip)

WebUI.click(findTestObject('YourInformationPage/button_Continue'))

def paymentInfo = WebUI.getText(findTestObject('CheckoutPage/text_PaymentInfo'))

def shippingInfo = WebUI.getText(findTestObject('CheckoutPage/text_ShippingInfo'))

def itemTotal = WebUI.getText(findTestObject('CheckoutPage/text_ItemTotal'))

def tax = WebUI.getText(findTestObject('CheckoutPage/text_Tax'))

def total = WebUI.getText(findTestObject('CheckoutPage/text_Total'))

WebUI.click(findTestObject('CheckoutPage/button_Finish'))

WebUI.click(findTestObject('FinishPage/text_ThankYouForYourOrder'))

Date today = new Date()
String todaysDate = today.format('yyyMMMdd')
String nowTime = today.format('HH:mms:s')


def output = new File('output.txt')

output.createNewFile()

output.text = (output.text + "${testID};${firstName};${lastName};${zip};${paymentInfo};${shippingInfo};${itemTotal};${tax};${total};${todaysDate};${nowTime}\n")

WebUI.closeBrowser()

