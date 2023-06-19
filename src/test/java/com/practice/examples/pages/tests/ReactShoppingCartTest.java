package com.practice.examples.pages.tests;

import com.practice.examples.components.react_shop_site.ShoppingCart;
import com.practice.examples.pages.ReactShopPage;
import com.practice.examples.pages.core.TestCase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ReactShoppingCartTest extends TestCase {

    private ReactShopPage reactShopPage;

    @BeforeClass
    public void openReactShopSite() {
        reactShopPage = openReactShopPage();
    }
    @Test
    public void shouldAddTwoItemsToCart() {
        final String productName_2 = reactShopPage.getProductName(2);
        final String productName_4 = reactShopPage.getProductName(4);
        reactShopPage.addProductToCart(2);
        reactShopPage.addProductToCart(4);
        assertThat(reactShopPage.getNumberOfProductsInCart()).isEqualTo(2);
        assertThat(reactShopPage.getProductName(2)).isEqualTo(productName_2);
        assertThat(reactShopPage.getProductName(4)).isEqualTo(productName_4);
    }

    @Test(dependsOnMethods = "shouldAddTwoItemsToCart")
    public void checkTotalPriceFromCheckout() {
        ShoppingCart shoppingCart = reactShopPage.expandShoppingCart();
        double totalPriceCalculated = shoppingCart.countProductsSubtotal();
        assertThat(totalPriceCalculated).isEqualTo(shoppingCart.getSubtotalFromBasket());
        assertThat(shoppingCart.getCheckoutSubtotal()).contains("36.80");
    }
}
