
package com.cookandroid.And_0727_bank;

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
    Button btnOutputOk;    EditText edtOutput;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.bank_output, container, false);
        btnOutputOk = v.findViewById(R.id.btnOutputOk);
        edtOutput = v.findViewById(R.id.edtOutput);
        btnOutputOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edtOutput.getText().toString());
                com.cookandroid.And_0727_bank.BankData.data += n;
                com.cookandroid.And_0727_bank.BankData.txtData.setText("잔액:"+ com.cookandroid.And_0727_bank.BankData.data+"원");
            }
        });
        return v;
    }
}
