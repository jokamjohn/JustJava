package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    // Number of coffee cups
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order
     * @return total price
     */
    private int calculatePrice() {

        //Base price of coffee
        int basePrice = 5;

        if (isWhipCreamChecked())
        {
            //Add one dollar if the user wants whipped cream topping
             basePrice = basePrice + 1;
        }

        if (isChocolateChecked())
        {
            //Add two dollars to the basePrice if the user wants chocolate topping
            basePrice = basePrice + 2;
        }

        return quantity * basePrice;
    }


    /**
     * Creates an order summary
     *
     * @param price of the coffee
     * @return order summary
     */
    private String createOrderSummary(int price)
    {
        String priceMessage= username() + "\n";
        priceMessage += "Price $: " + price + "\n";
        priceMessage += "Added whipped cream ? " + isWhipCreamChecked();
        priceMessage += "\nAdded chocolate ? " + isChocolateChecked();
        priceMessage += "\nThank you";

        return priceMessage;

    }


    /**
     * Checks whether the checkbox is checked
     *
     * @return boolean
     */
    private boolean isWhipCreamChecked()
    {
        CheckBox whipCream = (CheckBox) findViewById(R.id.whip_cream_check_box);

        return whipCream.isChecked();
    }


    /**
     * Shows the state of the chocolate checkbox
     *
     * @return boolean showing the state of the chocolate checkbox
     */
    private boolean isChocolateChecked ()
    {
        CheckBox chocobox = (CheckBox) findViewById(R.id.chocolate_check_box);
        return chocobox.isChecked();
    }


    /**
     * Name of the user
     * @return Name of the user
     */
    private String username ()
    {
        EditText username = (EditText) findViewById(R.id.username_edit_text);

        return String.valueOf(username.getText());
    }

    /**
     * Increment the quantity
     * @param view
     */
    public void increment(View view) {

        quantity = quantity + 1;
        displayQuantity(quantity);
    }


    /**
     * Decrement the quantity
     * @param view
     */
    public void decrement(View view) {

        quantity = quantity - 1;
        displayQuantity(quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextview = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextview.setText(message);
    }
}