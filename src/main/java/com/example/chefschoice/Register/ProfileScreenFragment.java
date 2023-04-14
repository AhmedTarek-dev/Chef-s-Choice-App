package com.example.chefschoice.Register;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.example.chefschoice.R;
import com.example.chefschoice.databinding.FragmentProfileScreenBinding;
import com.google.firebase.auth.FirebaseAuth;


public class ProfileScreenFragment extends Fragment {

    private FragmentProfileScreenBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragviewprofile = inflater.inflate(R.layout.fragment_profile_screen, container, false);
        binding = FragmentProfileScreenBinding.bind(fragviewprofile);
        // Inflate the layout for this fragment

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        binding.viewname.setText(AppSharedPref.getName(getContext()));
        binding.viewemail.setText(AppSharedPref.getemail(getContext()));
        binding.viewphone.setText(AppSharedPref.getphone(getContext()));


        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppSharedPref.getSharedPref(getContext()).edit().clear().apply();

                firebaseAuth.signOut();
                startActivity(new Intent(getActivity(), MainRegisterScreen.class));


            }
        });

binding.switchbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
         @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(compoundButton.isChecked()){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
               compoundButton.setText("Night mode");

          }
          else{
             AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
              compoundButton.setText("Light mode");
          }
         }
});


    }


}