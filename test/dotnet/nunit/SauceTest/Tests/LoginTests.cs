using System.Text.RegularExpressions;
using System.Threading.Tasks;
using Microsoft.Playwright;
using Microsoft.Playwright.NUnit;
using NUnit.Framework;

namespace SauceTest
{
    [TestFixture]
    [Category("Login")]
    public class LoginTests : PageTest
    {
        private const string BaseUrl = "https://www.saucedemo.com";

        public override BrowserNewContextOptions ContextOptions()
        {
            return new BrowserNewContextOptions
            {
                ViewportSize = new ViewportSize { Width = 1920, Height = 1080 }
            };
        }

        [Test]
        [Description("Verify successful login with standard_user credentials")]
        public async Task LoginWithStandardUser_ShouldSucceed()
        {
            // Arrange
            await Page.GotoAsync(BaseUrl);
            
            // Act
            await Page.FillAsync("#user-name", "standard_user");
            await Page.FillAsync("#password", "secret_sauce");
            await Page.ClickAsync("#login-button");
            
            // Assert
            await Expect(Page).ToHaveURLAsync(new Regex("inventory\\.html"));
            
            var productsTitle = Page.Locator(".title");
            await Expect(productsTitle).ToHaveTextAsync("Products");
        }
    }
}