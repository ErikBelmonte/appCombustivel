package ulbra.br.projetoCombustivel;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText edtAlcool, edtGasolina;
    private Button btnComparar;
    private TextView txtResult1, txtResult2;
    public double valorAl, valorGas, percentual, resultado;
    public String textoResult = "";
    DecimalFormat f = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        iniciarComponentes();
        btnComparar.setOnClickListener(new View.OnClickListener()){
            @Override
            public void onClick(View v){
                valorAl = Double.parseDouble(edtAlcool.getText().toString());
                valorGas = Double.parseDouble(edtGasolina.getText().toString());
                percentual = valorAl/valorGas * 100;
                txtResult1.setText(f.format(percentual)+"%");
                if(percentual > 73){
                    textoResult = "Opte por abastecer com GASOLINA";
                }else{
                    textoResult = "Opte por abastecer com ÁLCOOL";
                }
                txtResult2.setText(textoResult);
            }
        }
    }

    private void iniciarComponentes(){
        edtAlcool = findViewById(R.id.edtAlcool);
        edtGasolina = findViewById(R.id.edtGasolina);
        btnComparar = findViewById(R.id.btnComparar);
        txtResult1 = findViewById(R.id.txtResult1);
        txtResult2 = findViewById(R.id.txtResult2);
    }
}