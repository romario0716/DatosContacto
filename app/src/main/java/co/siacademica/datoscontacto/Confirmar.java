package co.siacademica.datoscontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.siacademica.datoscontacto.R;

public class Confirmar extends AppCompatActivity {

    private TextView textViewNombre;
    private TextView textViewFecha;
    private TextView textViewTelefono;
    private TextView textViewEmail;
    private TextView textViewDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        Bundle parametros = getIntent().getExtras();
        final String nombre = parametros.getString(getResources().getString(R.string.LabelConfirmar_NombreCompleto));
        //esta opcion no srive para utilizar la fucnion update de datepicker por lo que toca separar la fecha
        //final String fecha = parametros.getString(getResources().getString(R.string.LabelConfirmar_FechaNacimiento));
        final int fecha_dia    = parametros.getInt(getResources().getString(R.string.LabelConfirmar_FechaNacimiento));
        final int fecha_mes    = parametros.getInt(getResources().getString(R.string.LabelConfirmar_FechaNacimiento_Mes));
        final int fecha_anio    = parametros.getInt(getResources().getString(R.string.LabelConfirmar_FechaNacimiento_year));
        final String telefono = parametros.getString(getResources().getString(R.string.LabelConfirmar_Telefono));
        final String email = parametros.getString(getResources().getString(R.string.LabelConfirmar_Email));
        final String descripcion = parametros.getString(getResources().getString(R.string.LabelConfirmar_DescripcionContacto));

        //al mes le coloqué mas 1 para que muestre la fecha bien
        String fecha  =  fecha_dia+"/"+ (fecha_mes + 1)+"/"+fecha_anio;

        textViewNombre = (TextView) findViewById(R.id.textViewNombre);
        textViewFecha = (TextView) findViewById(R.id.textViewFecha);
        textViewTelefono = (TextView) findViewById(R.id.textViewTel);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewDescripcion = (TextView) findViewById(R.id.textViewDescripcion);

        textViewNombre.setText(nombre);
        textViewFecha.setText(fecha);
        textViewTelefono.setText(telefono);
        textViewEmail.setText(email);
        textViewDescripcion.setText(descripcion);

        Button btnEditarDatos = (Button) findViewById(R.id.buttonEditar);
        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Confirmar.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.LabelConfirmar_NombreCompleto),nombre);
                intent.putExtra(getResources().getString(R.string.LabelConfirmar_FechaNacimiento_year),fecha_anio);
                intent.putExtra(getResources().getString(R.string.LabelConfirmar_FechaNacimiento_Mes),fecha_mes);
                intent.putExtra(getResources().getString(R.string.LabelConfirmar_FechaNacimiento),fecha_dia);
                //esta opcion no srive para utilizar la fucnion update de datepicker por lo que toca separar la fecha
                //intent.putExtra(getResources().getString(R.string.LabelConfirmar_FechaNacimiento),fecha);
                intent.putExtra(getResources().getString(R.string.LabelConfirmar_Telefono),telefono);
                intent.putExtra(getResources().getString(R.string.LabelConfirmar_Email),email);
                intent.putExtra(getResources().getString(R.string.LabelConfirmar_DescripcionContacto),descripcion);
                startActivity(intent);
                finish();

            }
        });

    }

}
