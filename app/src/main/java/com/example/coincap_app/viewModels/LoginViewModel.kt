package com.example.coincap_app.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.coincap_app.models.AppiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel (
    private val repository: AppiClient = AppiClient()
    ): ViewModel() {

        private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
        val loginState: StateFlow<LoginState> = _loginState

        fun login(email: String, password: String) {
            viewModelScope.launch {
                if (email.isBlank() || password.isBlank()) {
                    _loginState.value = LoginState.Error("Campos obligatorios")
                    return@launch
                }

                _loginState.value = LoginState.Loading

                val result = repository.login(email, password)
                if (result.isSuccess) {
                    _loginState.value = LoginState.Success
                } else {
                    _loginState.value = LoginState.Error(result.exceptionOrNull()?.message ?: "Error en el Login")
                }
            }
        }
    }
    sealed class LoginState {
        object Idle : LoginState()
        object Loading : LoginState()
        object Success : LoginState()
        data class Error(val message: String) : LoginState()
    }