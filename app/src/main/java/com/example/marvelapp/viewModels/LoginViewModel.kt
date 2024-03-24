package com.example.marvelapp.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel:ViewModel () {
    private val auth: FirebaseAuth = Firebase.auth
    var showAlert by mutableStateOf(false)
    var messageError by mutableStateOf("")
    val token = "357101639681-55hdr13mkv9mp36qrn9088fk8bi3blkd.apps.googleusercontent.com"

    fun login(email: String, password: String, onSuccess: () -> Unit){
        viewModelScope.launch {
            try {
                if(email != "" && password != ""){
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if(task.isSuccessful){
                                messageError = ""
                                onSuccess()
                            }else{
                                showAlert = true
                                messageError = "User or password error"
                            }
                        }
                } else {
                    showAlert = true
                    messageError = "User and password is required"
                }
            }catch (e: Exception){
              Log.d("Error", "Error: ${e.localizedMessage}")
            }
        }
    }

    fun closeAlert(){ showAlert = false }

    fun loginGoogleAccount(credential: AuthCredential, onSuccess: () -> Unit){
        viewModelScope.launch {
            try {
                auth.signInWithCredential(credential)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            messageError = ""
                            onSuccess()
                        }else{
                            showAlert = true
                            messageError = "User or password error"
                        }
                    }.addOnFailureListener{
                        Log.d("Error", "Error")
                    }
            }catch (e: Exception){
                Log.d("Error", "Error: ${e.localizedMessage}")
            }
        }
    }

    fun signOut() {
        auth.signOut()
    }

}