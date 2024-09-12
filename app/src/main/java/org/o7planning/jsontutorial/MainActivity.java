package org.o7planning.jsontutorial;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.o7planning.jsontutorial.Company;
import org.o7planning.jsontutorial.JsonWriterExample;

import java.io.StringWriter;

public class MainActivity extends AppCompatActivity {

    private EditText outputText;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.outputText = (EditText)this.findViewById(R.id.editText);
        this.button1 = (Button) this.findViewById(R.id.button1);
        this.button2 = (Button) this.findViewById(R.id.button2);

        // Set OnClickListener for button1 to read JSON
        this.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readJsonExample(view);
            }
        });

        // Set OnClickListener for button2 to write JSON
        this.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeJsonExample(view);
            }
        });
    }

    // Method to handle reading JSON (for button1)
    public void readJsonExample(View view) {
        try {
            Company company = ReadJSONExample.readCompanyJSONFile(this);
            outputText.setText(company.toString());
        } catch (Exception e) {
            outputText.setText(e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to handle writing JSON (for button2)
    public void writeJsonExample(View view) {
        try {
            StringWriter output = new StringWriter();

            Company company = JsonWriterExample.createCompany();
            JsonWriterExample.writeJsonStream(output, company);

            String jsonText = output.toString();
            outputText.setText(jsonText);
        } catch (Exception e) {
            outputText.setText(e.getMessage());
            e.printStackTrace();
        }
    }
}
