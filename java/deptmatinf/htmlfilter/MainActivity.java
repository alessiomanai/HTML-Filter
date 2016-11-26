package deptmatinf.htmlfilter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String testo;
    Button filtra, copiaNegliAppunti;
    EditText casellaDiTesto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filtra = (Button) findViewById(R.id.filtra);
        copiaNegliAppunti = (Button) findViewById(R.id.copia);
        casellaDiTesto = (EditText) findViewById(R.id.casellaDiTesto);

        filtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                testo = casellaDiTesto.getText().toString();

				//LOL WHAT A ORRIBLE CODE
                testo = testo.replace("<p>", " ");
                testo = testo.replace("</p>", " ");
                testo = testo.replace("</a>", " ");
                testo = testo.replace("<strong>", " ");
                testo = testo.replace("</strong>", " ");
                testo = testo.replace("<div>", " ");
                testo = testo.replace("<h2>", " ");
                testo = testo.replace("</h2>", " ");
                testo = testo.replace("</b>", " ");
                testo = testo.replace("<b>", " ");
                testo = testo.replace("(<a href=\"", " ");
                testo = testo.replace("(<a href=\"mailto:", " ");
                testo = testo.replace("\">", " ");

                casellaDiTesto.setText(testo);
            }
        });

        copiaNegliAppunti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Testo copiato", testo);
                clipboard.setPrimaryClip(clip);

                Toast.makeText(MainActivity.this, "Testo copiato negli appunti", Toast.LENGTH_LONG).show();

            }
        });

    }
}
