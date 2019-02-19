package gt.com.irc.javacoffe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    // declaramos variables iniciales
    TextView initialValue, txtPrice;
    int quantity;

    final int PRICE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtenemos el valor inicial segun la configuracion del txtInitialValue definida en strings
        initialValue = findViewById(R.id.txtInitialValue);
        quantity = Integer.parseInt(initialValue.getText().toString());

    }

    /**
     * Metodo que me disminuye la cantidad de producto a pedir
     * @param view
     */

    public void decrement(View view) {
        // validamos que la cantidad sea mayor a 0
        if(quantity<=0){
            Toast toast = Toast.makeText(getApplicationContext(),
                    getString(R.string.messageMinimunQty),
                    Toast.LENGTH_SHORT);

            toast.show();
        } else {
            quantity--; // restamos la cantidad
        }

        initialValue.setText(quantity + "");
    }

    /**
     * Metodo que me incrementa la cantidad de producto a pedir
     * @param view
     */

    public void increment(View view) {
        quantity++; // incrementamos la cantidad
        initialValue.setText(quantity + "");
    }

    /**
     * Metodo que calcula el precio total del producto vendido
     */
    public int subTotal(int quantity) {
        return quantity * PRICE;
    }

    public void calculatePrice(View view) {
        txtPrice = findViewById(R.id.txtPrice);
        txtPrice.setText(getString(R.string.subTotal) + " " +  Integer.toString(subTotal(quantity)) + "\n" + getString(R.string.messageSubTotal));
    }


}
