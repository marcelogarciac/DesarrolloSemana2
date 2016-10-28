package angelapps.com.tarea2coursera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Detalle_Contacto extends AppCompatActivity {


    TextView tvNombre;
    TextView tvEmail;
    TextView tvTelefono;
    TextView tvDescripcion;
    TextView tvFecha;
    Button botonSig;
    String nombre, tel, email, fecha, descri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detalle__contacto);

            Bundle parametros = getIntent().getExtras();
            String nombre = parametros.getString(getResources().getString(R.string.pnombre));//nombre
            String fecha = parametros.getString(getResources().getString(R.string.pfecha));
            String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
            String email = parametros.getString(getResources().getString(R.string.pemail));
            String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

            tvNombre = (TextView) findViewById(R.id.tvnombre);
            tvEmail = (TextView) findViewById(R.id.tvEmail);
            tvTelefono = (TextView) findViewById(R.id.tvTelefono);
            tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
            tvFecha = (TextView) findViewById(R.id.tvFecha);

            tvNombre.setText(nombre);
            tvFecha.setText(fecha);
            tvTelefono.setText(telefono);
            tvEmail.setText(email);
            tvDescripcion.setText(descripcion);

            botonsig();



    }


    public void botonsig(){
        botonSig = (Button) findViewById(R.id.bSig);

       botonSig.setOnClickListener(

               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       nombre=tvNombre.getText().toString();
                       fecha=tvFecha.getText().toString();
                       tel=tvTelefono.getText().toString();
                       email=tvEmail.getText().toString();
                       descri=tvDescripcion.getText().toString();


                       Intent explicitIntent = new Intent(Detalle_Contacto.this, MainActivity.class);
                       explicitIntent.putExtra(getResources().getString(R.string.pnombre),nombre);
                       explicitIntent.putExtra(getResources().getString(R.string.ptelefono),tel);
                       explicitIntent.putExtra(getResources().getString(R.string.pfecha),fecha);
                       explicitIntent.putExtra(getResources().getString(R.string.pemail),email);
                       explicitIntent.putExtra(getResources().getString(R.string.pdescripcion),descri);
                       startActivity(explicitIntent);
                       finish();
                   }
               }


       );




}



}
