package com.masai.sainath.mensxp.ui.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.masai.sainath.mensxp.R;
import com.masai.sainath.mensxp.databinding.ActivityLogin1Binding;

import java.util.concurrent.TimeUnit;



public class LoginActivity1 extends AppCompatActivity {

    public static String PREFS_NAME="MyPrefsFile";

    private ActivityLogin1Binding binding;
    private FirebaseAuth mAuth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogin1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (binding.etPhone.getText().toString().trim().isEmpty()) {
                    Toast.makeText(LoginActivity1.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                } else if (binding.etPhone.getText().toString().trim().length() != 10) {
                    Toast.makeText(LoginActivity1.this, "Type valid Phone Number", Toast.LENGTH_SHORT).show();
                } else {

                    otpSend();
                }

                SharedPreferences sharedPreferences =getSharedPreferences(LoginActivity1.PREFS_NAME,0);
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putBoolean("hasLoggedIn",true);
                editor.commit();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void otpSend() {
//       binding.progressBar.setVisibility(View.VISIBLE);
        binding.btnSend.setBackgroundColor(getColor(R.color.Orange));

        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
//                binding.progressBar.setVisibility(View.GONE);
//                binding.btnSend.setVisibility(View.VISIBLE);
                Toast.makeText(LoginActivity1.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
//                binding.progressBar.setVisibility(View.GONE);
//                binding.btnSend.setVisibility(View.VISIBLE);
                Toast.makeText(LoginActivity1.this, "OTP is successfully send.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity1.this, OptActivity1.class);
                intent.putExtra("phone", binding.etPhone.getText().toString().trim());
                intent.putExtra("verificationId", verificationId);
                startActivity(intent);
            }
        };

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91" + binding.etPhone.getText().toString().trim())
                        .setTimeout(60L, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(mCallbacks)
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
}