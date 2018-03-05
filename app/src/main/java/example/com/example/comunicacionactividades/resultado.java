package example.com.example.comunicacionactividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Victor on 26/02/2018.
 */

public class resultado extends Activity {
    // Declaramos las variables Button para posteriormente definir
    // sus métodos onClick.
    Button bOk, bNok;



    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        // Enlazamos las variables con los componentes que tenemos en el XML
        bOk = (Button) findViewById(R.id.bAceptar);
        bNok = (Button)findViewById(R.id.bRechazar);

        // Definimos el listener que ejecutará el método onClick del botón aceptar.
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("resultado", "valor");
                setResult(RESULT_OK, intent);
                finish();

                /*
                //Recogemos el intent que ha llamado a la actividad
                Intent i = getIntent();

                //Metemos el resultado que se quiere mandar a la actividad principal
                i.putExtra("RESULTADO", res);

                // Establecemos el resultado, y volvemos a la actividad
                // principal. La variable que introducimos en primer lugar
                // "RESULT_OK" es de la propia actividad, no tenemos que
                // declararla nosotros.
                setResult(RESULT_OK, i);

                //Finalizamos la Activity para volver a la anterior
                finish();*/
            };
        });

        // Definimos el listener que ejecutará el método onClick del botón cancelar
        bNok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("resultado", "valor");
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

        Bundle extras = getIntent().getExtras();
        String nom = extras.getString("nombre");
        //Texto del Textview indicando si aceptas las condiciones
        //System.out.println("Recibido: "+nom); //aparece el log
        TextView mensaje = (TextView) findViewById(R.id.tRecibido);
        mensaje.setText("Hola "+nom+" ¿Aceptas las condiciones?");







    }
}
