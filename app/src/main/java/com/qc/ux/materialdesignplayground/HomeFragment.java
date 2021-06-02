package com.qc.ux.materialdesignplayground;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputLayout;
import com.qc.ux.materialdesignplayground.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private final String LOG_TAG = HomeFragment.class.getSimpleName();

    private FragmentHomeBinding fragmentHomeBinding;
    private TextInputLayout textInputLayoutOutline;
    private TextInputLayout textInputLayoutFilled;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreateView");
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false);
        textInputLayoutOutline = fragmentHomeBinding.layoutTextFields.textInputLayoutOutline;
        textInputLayoutFilled = fragmentHomeBinding.layoutTextFields.textInputLayoutFilled;
        fragmentHomeBinding.layoutTextFields.textInputEditTextOutline.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > textInputLayoutOutline.getCounterMaxLength()) {
                    textInputLayoutOutline.setError(getResources().getString(R.string.text_field_error));
                } else {
                    textInputLayoutOutline.setError(null);
                }
            }
        });

        fragmentHomeBinding.layoutTextFields.textInputEditTextFilled.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > textInputLayoutFilled.getCounterMaxLength()) {
                    textInputLayoutFilled.setError(getResources().getString(R.string.text_field_error));
                } else {
                    textInputLayoutFilled.setError(null);
                }
            }
        });

        return fragmentHomeBinding.getRoot();
    }
}
