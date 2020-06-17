package co.siacademica.datoscontacto;

import android.content.Intent;
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
    private String fnac;
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

        Button btnSiguiente = (Button) findViewById(R.id.buttonSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                nnombre = nombreContacto.getText().toString();
                ttel = telefono.getText().toString();
                fnac = getFecha();
                ecor = email.getText().toString();
                dcont = descripcionContacto.getText().toString();

                Intent intent = new Intent(MainActivity.this, Confirmar.class);
                intent.putExtra(getResources().getString(R.string.LabelConfirmar_NombreCompleto), nnombre);
                intent.putExtra(getResources().getString(R.string.LabelConfirmar_FechaNacimiento), fnac);
                intent.putExtra(getResources().getString(R.string.LabelConfirmar_Telefono), ttel);
                intent.putExtra(getResources().getString(R.string.LabelConfirmar_Email), ecor);
                intent.putExtra(getResources().getString(R.string.LabelConfirmar_DescripcionContacto), dcont);
                startActivity(intent);
                finish();

            }
        });

    }


    public String getFecha() {

        StringBuilder fechaElegida = new StringBuilder();
        fechaElegida.append("Fecha de Nacimiento: " + fechaNacimiento.getDayOfMonth() + "/" + fechaNacimiento.getMonth() + "/" + fechaNacimiento.getYear());
        return fechaElegida.toString();

    }

}
