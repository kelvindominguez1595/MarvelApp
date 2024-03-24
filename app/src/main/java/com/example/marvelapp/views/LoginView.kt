package com.example.marvelapp.views

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import com.example.marvelapp.R
import com.example.marvelapp.components.AlertCustom
import com.example.marvelapp.components.ButtonOutline
import com.example.marvelapp.components.FontSize
import com.example.marvelapp.components.LabelCustom
import com.example.marvelapp.components.OutlineInputCustom
import com.example.marvelapp.components.SpacerHeight
import com.example.marvelapp.utils.Constants.Companion.BG_MARVEL
import com.example.marvelapp.viewModels.LoginViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider

@Composable
fun LoginView(navController: NavController, loginVM: LoginViewModel) {
    ContentLoginView(navController, loginVM)
}

@Composable
fun ContentLoginView(navController: NavController, loginVM: LoginViewModel) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()){
        val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
        try {
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            Log.d("Error", "Error:")
            loginVM.loginGoogleAccount(credential){
                navController.navigate("Home")
            }
        }catch (e: Exception){
            Log.d("Error", "Google Error Server")
        }

    }

    Box (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(BG_MARVEL.toColorInt()))
    ){
        
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(top = 150.dp)
            .background(Color.White, shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),

            ){
            var email by remember { mutableStateOf("")}
            var pass by remember { mutableStateOf("")}


            SpacerHeight()
            LabelCustom(text = "Login", fontWeight = FontWeight.Bold, fontSize = FontSize.H4)

            SpacerHeight(height = 15.dp)
            OutlineInputCustom(
                label = "Email",
                value = email ,
                onValueChange = {email = it},
                keyBoarType = KeyboardType.Email
                )
            OutlineInputCustom(
                label = "Password",
                value = pass ,
                onValueChange = {pass = it},
                keyBoarType = KeyboardType.Password,
                isPassword = true
                )
            ButtonOutline(onClick = {
                loginVM.login(email, pass){
                    navController.navigate("Home")
                }
            }, text = "Log In")
            if(loginVM.showAlert){
                AlertCustom(
                    title = "Error",
                    message = loginVM.messageError,
                    confirmText = "Accept",
                    onConfirmClick = {  loginVM.closeAlert() }) {

                }
            }
            SpacerHeight()
            LabelCustom(text = "Or",
                fontWeight = FontWeight.Bold,
                fontSize = FontSize.H6,
                horizontalPadding = 164.dp)
            SpacerHeight()
            ButtonOutline(onClick = {
                                    val opt = GoogleSignInOptions.Builder(
                                        GoogleSignInOptions.DEFAULT_SIGN_IN
                                    ).requestIdToken(loginVM.token)
                                        .requestEmail().build()
                val googleSignInClient = GoogleSignIn.getClient(context, opt)
                launcher.launch(googleSignInClient.signInIntent)
            }, text = "Log In with Google")
            SpacerHeight(40.dp)
            Row (modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center ){

                LabelCustom(text = "Don't have an account yet?",
                    fontSize = FontSize.Body,
                    horizontalPadding = 2.dp)
                LabelCustom(text = "Register",
                    fontSize = FontSize.Body,
                    color = Color.Red,
                    isOnClick = true,
                    onClick = { navController.navigate("Register") },
                    horizontalPadding = 2.dp)
            }
        }
        Image(
            painter = painterResource(id = R.drawable.marvel_logo),
            contentDescription = "Logo Marvel",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp)
        )
    }
}