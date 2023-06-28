import com.qaprosoft.carina.core.foundation.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends AbstractTest {
    @Test
    public void testSearchProducts() {
        String searchWord = "Shirt";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.typeProductName(searchWord);
        ProductListingPage productListingPage = homePage.clickSearchButton();

        List<String> productNames = productListingPage.getProductNames();

        for (String productName : productNames) {
            Assert.assertTrue(productName.toLowerCase().contains(searchWord.toLowerCase()), "Item should contain word dress but it was " + productName);
        }
    }
}
