package co.siacademica.datoscontacto;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.siacademica.datoscontacto.R;

public class MainActivity extends AppCompatActivity  {

    private TextInputEditText nombreContacto;
    private DatePicker fechaNacimiento;
    private TextInputEditText telefono;
    private TextInputEditText email;
    private TextInputEditText descripcionContacto;

    private String nnombre;
    private String ttel;
    private String ecor;
    private String dcont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreContacto = (TextInputEditText) findViewById(R.id.textInputNombre);
        telefono = (TextInputEditText) findViewById(R.id.textInputTelefono);
        fechaNacimiento = (DatePicker) findViewById(R.id.datePicker);
        email = (TextInputEditText) findViewById(R.id.textInputEmail);
        descripcionContacto = (TextInputEditText) findViewById(R.id.textInputDescripcion);

        Bundle parametros = getIntent().getExtras();

        if(parametros != null ){
            String nombre = parametros.getString(getResources().getString(R.string.LabelConfirmar_NombreCompleto));
            final int fechanacimiento_dia    = parametros.getInt(getResources().getString(R.string.LabelConfirmar_FechaNacimiento));
            final int fechanacimiento_mes    = parametros.getInt(getResources().getString(R.string.LabelConfirmar_FechaNacimiento_Mes));
            final int fechanacimiento_anio    = parametros.getInt(getResources().getString(R.string.LabelConfirmar_FechaNacimiento_year));
            String telefonocon = parametros.getString(getResources().getString(R.string.LabelConfirmar_Telefono));
            String emailcon = parametros.getString(getResources().getString(R.string.LabelConfirmar_Email));
            String descripcion = parametros.getString(getResources().getString(R.string.LabelConfirmar_DescripcionContacto));

            nombreContacto.setText(nombre);
            fechaNacimiento.updateDate(fechanacimiento_anio,fechanacimiento_mes,fechanacimiento_dia);
            telefono.setText(telefonocon);
            email.setText(emailcon);
            descripcionContacto.setText(descripcion);
        }

        Button btnSiguiente = (Button) findViewById(R.id.buttonSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                nnombre = nombreContacto.getText().toString();
                ttel = telefono.getText().toString();
                ecor = email.getText().toString();
                dcont = descripcionContacto.getText().toString();

                if(nnombre.length()<=0 ) {

                    Snackbar.make(v,getResources().getString(R.string.mensaje_CampoNombre_Obligatorios),Snackbar.LENGTH_SHORT)
                            .show();

                }else if(ttel.length()<=0 ) {

                    Snackbar.make(v,getResources().getString(R.string.mensaje_CampoTelefono_Obligatorios),Snackbar.LENGTH_SHORT)
                            .show();

                }else if(ecor.length()<=0 ) {

                    Snackbar.make(v,getResources().getString(R.string.mensaje_CampoEmail_Obligatorios),Snackbar.LENGTH_SHORT)
                            .show();

                }else{

                    Intent intent = new Intent(MainActivity.this, Confirmar.class);
                    intent.putExtra(getResources().getString(R.string.LabelConfirmar_NombreCompleto), nnombre);
                    intent.putExtra(getResources().getString(R.string.LabelConfirmar_FechaNacimiento_year),fechaNacimiento.getYear());
                    intent.putExtra(getResources().getString(R.string.LabelConfirmar_FechaNacimiento_Mes),fechaNacimiento.getMonth());
                    intent.putExtra(getResources().getString(R.string.LabelConfirmar_FechaNacimiento),fechaNacimiento.getDayOfMonth());
                    intent.putExtra(getResources().getString(R.string.LabelConfirmar_Telefono), ttel);
                    intent.putExtra(getResources().getString(R.string.LabelConfirmar_Email), ecor);
                    intent.putExtra(getResources().getString(R.string.LabelConfirmar_DescripcionContacto), dcont);
                    startActivity(intent);
                    finish();

                }
            }
        });

    }

}
