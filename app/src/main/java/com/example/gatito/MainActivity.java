package com.example.gatito;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private EditText editNome;
    private TextInputEditText editEmail;
    private EditText editCpf;
    private TextInputEditText editSenha;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        editEmail = findViewById(R.id.editEmail);
        editCpf = findViewById(R.id.editCpf);
        editSenha = findViewById(R.id.editSenha);
        textResultado = findViewById(R.id.textResultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void recuperar(View view) {
        String emailDigitado = editEmail.getText().toString();
        String nomeDigitado = editNome.getText().toString();
        String cpfDigitado = editCpf.getText().toString();
        String senhaDigitada = editSenha.getText().toString();

        if (nomeDigitado.isEmpty() || cpfDigitado.isEmpty() || emailDigitado.isEmpty() || senhaDigitada.isEmpty()) {
            Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
        } else {
            textResultado.setText("Informações:" + "\n" + emailDigitado + "\n" + nomeDigitado + "\n" + cpfDigitado + "\n" + "Senha: " + senhaDigitada);
            // Adicione aqui a lógica de autenticação
            Toast.makeText(this, "Dados autenticados com sucesso!", Toast.LENGTH_SHORT).show();
        }
    }
}

