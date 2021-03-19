package css.tipconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etBill;
    EditText etPartyNum;
    EditText etTotalTip;
    EditText etTPP;
    CheckBox cbOutstanding;
    Button btnCalculate;
    double outstanding = .15;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBill = (EditText) findViewById(R.id.editTextNumberDecimal);
        etPartyNum = (EditText) findViewById(R.id.editTextNumber);
        etTotalTip = (EditText) findViewById(R.id.editTextTotalTip);
        etTPP = (EditText) findViewById(R.id.editTextTPP);
        cbOutstanding = (CheckBox) findViewById(R.id.checkBox);
        btnCalculate = (Button) findViewById(R.id.button);

        if (cbOutstanding.isChecked()) {
            outstanding = .2;

        }
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cbOutstanding.isChecked()) {
                    outstanding = .2;

                }
                String bill = etBill.getText().toString();
                Double billSum = (Double.parseDouble(bill)) * outstanding;
                Double billSumDiv = billSum / (Double.parseDouble(etPartyNum.getText().toString()));
                etTotalTip.setText(billSum.toString());
                etTPP.setText(billSumDiv.toString());

            }
        });

    }


}