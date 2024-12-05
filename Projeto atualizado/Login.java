package com.example.myapplication_teste;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    // Declaração das variáveis dos elementos da interface
    private EditText editTextEmail, editTextPassword;
    private Button loginButton;
    private TextView forgotPassword, createAccount;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Corrigido para carregar o layout correto para a tela de login
        setContentView(R.layout.activity_login);

        // Inicializa os elementos da interface com seus respectivos IDs
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        loginButton = (Button) findViewById(R.id.loginButton);
        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        createAccount = (TextView) findViewById(R.id.createAccount);

        // Configuração do listener para o botão de login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtém os dados inseridos nos campos de e-mail e senha
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Validação simples dos campos (você pode personalizar conforme necessário)
                if (email.isEmpty()) {
                    Toast.makeText(Login.this, "Por favor, insira o e-mail.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(Login.this, "Por favor, insira a senha.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Exemplo de validação fictícia para e-mail e senha
                if (email.equals("usuario@exemplo.com") && password.equals("senha123")) {
                    // Aqui você pode adicionar a navegação para uma nova Activity após o login bem-sucedido
                    Toast.makeText(Login.this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
                    // Intent para a próxima Activity (exemplo)
                    Intent intent = new Intent(Login.this, MainActivity.class);  // Corrigido para navegar para a MainActivity
                    startActivity(intent);
                    finish();  // Finaliza a activity atual
                } else {
                    Toast.makeText(Login.this, "E-mail ou senha incorretos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configuração do listener para o link "Esqueci a Senha"
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ação ao clicar em "Esqueci a senha", por exemplo, abrir uma nova Activity ou mostrar uma mensagem
                Toast.makeText(Login.this, "Redirecionando para recuperação de senha...", Toast.LENGTH_SHORT).show();
            }
        });

        // Configuração do listener para o link "Criar Conta"
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ação ao clicar em "Criar Conta", que abrirá uma nova Activity para cadastro
                Intent intent = new Intent(Login.this, Cadastre_se.class);  // Activity para criar conta
                startActivity(intent);
            }
        });
    }
}
