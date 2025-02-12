package com.example.labelapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextLabel;
    private Button buttonPrint;
    private LabelPrinter labelPrinter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editTextLabel = findViewById(R.id.editTextLabel);
        buttonPrint = findViewById(R.id.buttonPrint);
        labelPrinter = new LabelPrinter(this);

        buttonPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String labelText = editTextLabel.getText().toString();
                if (!labelText.isEmpty()) {
                    labelPrinter.printLabel(labelText);
                }
            }
        });

        TextView marqueeText = findViewById(R.id.marqueeText);
        marqueeText.setSelected(true);

    }
}
