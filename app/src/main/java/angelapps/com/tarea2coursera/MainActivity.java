package angelapps.com.tarea2coursera;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextInputEditText textoNombre;
    String nombre, telefono, email, des, fecha;
    TextInputEditText textoFecha;
    TextInputEditText seleccionFecha;
    TextInputEditText textoEmail;
    TextInputEditText textoDes;
    TextInputEditText textoTel;
    Button botonSiguiente;
    int año, mes, dia;
    static final int DIALOG_ID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textoFecha = (TextInputEditText) findViewById(R.id.textoFecha);
        textoNombre = (TextInputEditText) findViewById(R.id.textoNombre);
        textoEmail = (TextInputEditText) findViewById(R.id.text_email);
        textoDes = (TextInputEditText) findViewById(R.id.textoDes);
        textoTel = (TextInputEditText) findViewById(R.id.textoTel);
        final Calendar calendario = Calendar.getInstance();
        año = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mostrarPicker();

        botonSiguiente();

        Bundle par = getIntent().getExtras();

        if (par!=null) {
            String nombreI = par.getString(getResources().getString(R.string.pnombre));//nombre
            String fechaI = par.getString(getResources().getString(R.string.pfecha));
            String telefonoI = par.getString(getResources().getString(R.string.ptelefono));
            String emailI = par.getString(getResources().getString(R.string.pemail));
            String desI = par.getString(getResources().getString(R.string.pdescripcion));

            textoNombre.setText(nombreI);
            textoFecha.setText(fechaI);
            textoTel.setText(telefonoI);
            textoEmail.setText(emailI);
            textoDes.setText(desI);
        }
    }

    public void mostrarPicker(){
        seleccionFecha = (TextInputEditText) findViewById(R.id.textoFecha);

        seleccionFecha.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );

    }


    protected Dialog onCreateDialog(int id){

        if (id == DIALOG_ID)
            return new DatePickerDialog(this, dpickerListener, año, mes, dia);

        return null;
    }

    private DatePickerDialog.OnDateSetListener dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            año = year;
            mes = monthOfYear;
            dia = dayOfMonth;
            mostrarFecha();
        }

    };

    public void mostrarFecha(){

        String[] mesesString = getResources().getStringArray(R.array.meses);

        textoFecha.setText(dia + " de " + mesesString[mes] + " del " + año);

    }

  public void botonSiguiente(){
        botonSiguiente = (Button) findViewById(R.id.botonSiguiente);

        botonSiguiente.setOnClickListener(

        new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nombre = textoNombre.getText().toString();
                telefono = textoTel.getText().toString();
                email = textoEmail.getText().toString();
                fecha = textoFecha.getText().toString();
                des =  textoDes.getText().toString();

                Intent intent = new Intent(MainActivity.this, Detalle_Contacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),nombre);
                intent.putExtra(getResources().getString(R.string.ptelefono),telefono);
                intent.putExtra(getResources().getString(R.string.pfecha),fecha);
                intent.putExtra(getResources().getString(R.string.pemail),email);
                intent.putExtra(getResources().getString(R.string.pdescripcion),des);
                startActivity(intent);
                finish();
            }
        }
                );


    }

}
