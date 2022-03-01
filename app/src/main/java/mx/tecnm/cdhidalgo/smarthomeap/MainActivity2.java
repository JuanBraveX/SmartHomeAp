package mx.tecnm.cdhidalgo.smarthomeap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {
    EditText etTipo, etValor;
    Button bAdd, bRefresh;
    RecyclerView rvMsg;
    SharedPreferences sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etTipo = findViewById(R.id.etTipo);
        etValor = findViewById(R.id.etValor);
        bAdd = findViewById(R.id.bAdd);
        bRefresh = findViewById(R.id.bRefresh);
        rvMsg = findViewById(R.id.rvMsg);
        sesion = getSharedPreferences("sesion", 0);
        getSupportActionBar().setTitle("Mensajes: - "+ sesion.getString("user", ""));
        rvMsg.setHasFixedSize(true);
        rvMsg.setItemAnimator(new DefaultItemAnimator());
        rvMsg.setLayoutManager(new LinearLayoutManager(this));
        llenar();
        bRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llenar();
            }
        });
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar();
            }
        });
    }

    private void agregar() {

    }

    private void llenar() {
        String url = Uri.parse(Config.URL + "registro.php")
                .buildUpon().build().toString();
        JsonObjectRequest peticion = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        llenaRepuesta();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity2.this, "Error de conexion",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void llenaRepuesta() {

    }
}