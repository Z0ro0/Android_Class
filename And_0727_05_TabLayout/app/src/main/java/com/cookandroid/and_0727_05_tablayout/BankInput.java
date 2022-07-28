package com.cookandroid.and_0727_05_tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BankInput extends Fragment {
    Button ntnInputOk;
    EditText edtInput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.bank_input, container, false);

        ntnInputOk = v.findViewById(R.id.ntnInputOk);
        edtInput = v.findViewById(R.id.edtInput);

        ntnInputOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edtInput.getText().toString());
                Bank_data.data+=n;
                Bank_data.txtData.setText("잔액: "+Bank_data.data);
            }
        });
        return v;
    }
}

