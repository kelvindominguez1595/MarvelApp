package com.example.marvelapp.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelapp.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class RegisterViewModel:ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    var showAlert by mutableStateOf(false)
    var messageError by mutableStateOf("")

    fun createUser(email: String, password: String, confirmPass:String, onSuccess: () -> Unit){
        viewModelScope.launch {
            try {
                if(password == confirmPass){
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener {
                                task ->
                            if(task.isSuccessful){
                                saveUser(email)
                                onSuccess()
                                messageError=""
                            }else{
                                showAlert = true
                                messageError = "User or password error"
                            }
                        }
                } else {
                    showAlert = true
                    messageError = "Password don't mach!"
                }
            } catch (e: Exception){
                Log.d("Error", "Erro: ${e.localizedMessage}")
            }
        }
    }

    private fun saveUser(username: String){
        viewModelScope.launch (Dispatchers.IO){
            val id = auth.currentUser?.uid
            val email = auth.currentUser?.email
            val user = UserModel(userId = id.toString(), email = email.toString(),username = username)
            FirebaseFirestore.getInstance().collection("Users")
                .add(user)
                .addOnSuccessListener {
                    Log.d("Success", "New user created")
                }.addOnFailureListener{
                    Log.d("Error", "Error with server 500")
                }
        }
    }

    fun closeAlert(){ showAlert = false }


}