package example.com.example.comunicacionactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void verificar (View view){
        Intent i = new Intent(this, resultado.class);
        EditText nom = (EditText) findViewById(R.id.eNombre);
        String contenidnombre = nom.getText().toString();
        i.putExtra("nombre", contenidnombre);
        //System.out.println("cadena: "+contenidnombre);
        //startActivity(i);
        startActivityForResult(i,1234);
    }

    @Override protected void onActivityResult (int requestCode,
                                               int resultCode, Intent data){
        System.out.println("RequestCode: "+requestCode);
        System.out.println("ResultCode: "+resultCode);
        if (requestCode==1234 && resultCode==RESULT_OK) {
            String res = data.getExtras().getString("resultado");
            //System.out.println("Resultado que viene de vuelta: "+res);
            TextView TextViewRes = (TextView) findViewById(R.id.tResultado);
            TextViewRes.setText("Aceptado");
        }else if (requestCode==1234 && resultCode==RESULT_CANCELED){
            String res = data.getExtras().getString("resultado");
            TextView TextViewRes = (TextView) findViewById(R.id.tResultado);
            TextViewRes.setText("Cancelado con tus muertos");
        }
    }
}
