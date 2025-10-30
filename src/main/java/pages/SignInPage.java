package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {
  public final By logo = By.cssSelector("a[aria-label='Amazon']");
  public final By headingSignin = By.xpath("//h1[contains(., 'Sign in')]");

  public final By emailInput = By.id("ap_email");
  public final By continueButton = By.id("continue");
  public final By createAccountButton = By.id("createAccountSubmit");
  public final By needHelpLink = By.linkText("Need help?");

  public final By emailError = By.cssSelector("#auth-email-missing-alert, #auth-error-message-box");
  public final By genericErrorBox = By.cssSelector(".a-alert-error");

  public final By passwordInput = By.id("ap_password");
  public final By signInSubmit = By.id("signInSubmit");
  public final By keepMeSignedInCheckbox = By.cssSelector("input[name='rememberMe'], input#rememberMe");
  public final By keepMeSignedInLabel = By.cssSelector("label[for='auth-remember-me']");
  public final By forgotPasswordLink = By.cssSelector("a[href*='forgotpassword'], a#auth-fpp-link-bottom");

  public final By otpInput = By.cssSelector("input[name='otpCode'], input#auth-mfa-otpcode, input[name='code']");
  public final By otpSubmit = By.cssSelector("#cvf-submit-otp-button, #auth-signin-button");

  public SignInPage(WebDriver driver) { super(driver); }

  public void submitEmail(String email) {
    type(emailInput, email);
    click(continueButton);
  }

  public void submitPassword(String password) {
    type(passwordInput, password);
    click(signInSubmit);
  }
}
