package mx.tecnm.cdhidalgo.smarthomeap;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {

    EditText etUser, etPass;
    Button bInicio;
    SharedPreferences sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        bInicio = findViewById(R.id.bInicio);
        sesion = getSharedPreferences("sesion", 0);
        bInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    private void login() {
        String url = Uri.parse(Config.URL+"login.php")
                .buildUpon()
                .appendQueryParameter("user", etUser.getText().toString())
                .appendQueryParameter("pass", etPass.getText().toString())
                .build().toString();
        JsonObjectRequest peticion = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        respuesta(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error de inicio de sesion", Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void respuesta(JSONObject response) {
        Toast.makeText(this, "servidor contesto", Toast.LENGTH_SHORT).show();
    }

}