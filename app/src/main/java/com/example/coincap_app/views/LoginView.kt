package com.example.coincap_app.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coincap_app.viewModels.LoginViewModel
import com.example.coincap_app.viewModels.LoginState
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.PasswordVisualTransformation
import android.widget.Toast
import androidx.compose.material3.CircularProgressIndicator

@Composable
fun LoginView( viewModel: LoginViewModel = viewModel(),
               onLoginSuccess: () -> Unit
) {

    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginState by viewModel.loginState.collectAsState()

        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            Text("Iniciar Sesión", style = MaterialTheme.typography.headlineMedium)

            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("User") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(0.8f),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {viewModel.login(email, password) },
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Iniciar Sesión")
            }

            when (loginState) {
                is LoginState.Loading -> {
                    Spacer(modifier = Modifier.height(16.dp))
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                }
                is LoginState.Success -> {
                    Toast.makeText(context, "La sesion se ha iniciado con exito", Toast.LENGTH_SHORT).show()
                    onLoginSuccess()
                }
                is LoginState.Error -> {
                    Toast.makeText(context, (loginState as LoginState.Error).message, Toast.LENGTH_LONG).show()
                }
                else -> Unit
            }
    }
}