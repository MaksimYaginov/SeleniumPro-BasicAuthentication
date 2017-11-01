import helpers.Helper;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AerobaticAuthPage;

import net.lightbody.bmp.proxy.ProxyServer;
import pages.AerobaticAuthSuccessPage;

public class TestTask9 {

    private WebDriver driver;
    private ProxyServer proxyServer;
    AerobaticAuthPage aerobaticAuthPage;
    AerobaticAuthSuccessPage aerobaticAuthSuccessPage;

    @BeforeTest
    @Parameters({"domain", "username", "password"})
    public void setUp(String domain, String username, String password) {
        proxyServer = new ProxyServer(4441);
        proxyServer.start();
        proxyServer.autoBasicAuthorization(domain, username, password);
        Proxy proxy = proxyServer.seleniumProxy();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);
        driver = new ChromeDriver(capabilities);
    }

    @Test
    @Parameters({"url"})
    public void basicAuthenticationTest(String url) {
        aerobaticAuthPage = Helper.goToAerobaticAuthPage(url, driver);
        aerobaticAuthSuccessPage = aerobaticAuthPage.clickOnStandardAuthButton();
        Assert.assertTrue(aerobaticAuthSuccessPage.authSuccess());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        proxyServer.stop();
    }
}