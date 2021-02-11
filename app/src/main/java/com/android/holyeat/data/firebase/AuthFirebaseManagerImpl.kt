package com.android.holyeat.data.firebase

import android.R.attr
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class AuthFirebaseManagerImpl : AuthFirebaseManager {

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance();

    override suspend fun getCurrentUser(): Flow<Boolean> {
        return if (mAuth.currentUser == null) {
            flow { emit(false) }
        } else {
            flow { emit(true) }
        }

    }

    override suspend fun login(
        email: String,
        password: String,
        result: (result: Pair<Boolean, String>) -> Unit
    ) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                when {
                    it.isSuccessful -> FirebaseAuth.getInstance().currentUser?.let { user ->
                        result(Pair(true, ""))
                    } ?: result(Pair(false, "${it.exception?.message}"))

                    it.exception is FirebaseAuthException -> result(
                            Pair(
                                false,
                                (it.exception as FirebaseAuthException).errorCode
                            )
                        )

                    it.exception is FirebaseNetworkException -> result(
                            Pair(
                                false,
                                "Network Error"
                            )
                        )


                    else -> result(Pair(false, "${it.exception?.message}"))
                }
            }
    }

    override fun signUp(email: String, password: String, result: (result: Pair<Boolean, String>) -> Unit) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                when {
                    it.isSuccessful -> FirebaseAuth.getInstance().currentUser?.let { user ->
                        result(Pair(true, ""))
                    } ?: result(Pair(false, "${it.exception?.message}"))

                    it.exception is FirebaseAuthException -> result(
                        Pair(
                            false,
                            (it.exception as FirebaseAuthException).errorCode
                        )
                    )

                    it.exception is FirebaseNetworkException -> result(
                        Pair(
                            false,
                            "Network Error"
                        )
                    )


                    else -> result(Pair(false, "${it.exception?.message}"))
                }
            }
    }


}