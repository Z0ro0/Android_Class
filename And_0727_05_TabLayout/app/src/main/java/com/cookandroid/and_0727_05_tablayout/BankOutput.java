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

public class BankOutput extends Fragment {
    Button btn_outputok;
    EditText edtOutput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.bank_input, container, false);

        btn_outputok = v.findViewById(R.id.btn_outputok);
        edtOutput = v.findViewById(R.id.edtOutput);

        btn_outputok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edtOutput.getText().toString());
                Bank_data.data-=n;
                Bank_data.txtData.setText("잔액: "+Bank_data.data);
            }
        });
        return v;
    }
}

