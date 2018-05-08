package com.example.thais.testeretrofit3.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thais.testeretrofit3.R;
import com.example.thais.testeretrofit3.services.UserAPI;
import com.example.thais.testeretrofit3.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        final TextView txtExibirUsuario = findViewById(R.id.txtExibirUsuario);
        //final TextView txtName = findViewById(R.id.txtName);
        //final TextView txtLogin = findViewById(R.id.txtLogin);
        final EditText edtUsuario = findViewById(R.id.edtUsuario);
        ImageButton btnBuscarUsuario = findViewById(R.id.btnBuscarUsuario);

        btnBuscarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserAPI userAPI = UserAPI.retrofit.create(UserAPI.class);
                final Call<Usuario> call = userAPI.getUsuario(edtUsuario.getText().toString());
                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                        int code = response.code();
                        if (code == 200) {
                            Usuario usuario = response.body();
                            txtExibirUsuario.setText(usuario.toString());
                            //txtId.setText(usuario.name);
                            //txtName.setText(usuario.getName());
                            //txtLogin.setText(usuario.getLogin());
                            //Toast.makeText(getBaseContext(),
                              //      "Nome  do  usuário:  " + usuario.getName(),
                                //    Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getBaseContext(),
                                    "Falha:  " + String.valueOf(code),
                                    Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });



        }
    }