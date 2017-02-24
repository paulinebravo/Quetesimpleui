package fr.wcs.quetesimpleui;

import android.app.Activity;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    EditText Name;
    EditText Surname;
    CheckBox checkBox;
    Button button;
    EditText congrats;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main) ;

        Name = (EditText) findViewById(R.id.Name);
        Surname = (EditText) findViewById(R.id.Surname);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        button = (Button) findViewById(R.id.button);
        congrats= (EditText) findViewById(R.id.congrats);


        checkBox .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Name.setEnabled(checkBox.isChecked());
                Surname.setEnabled(checkBox.isChecked());

        button .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Surname.getText().toString();
                Name.getText().toString();

                if (Surname.length()!=0 && Name.length()!=0) {
                congrats.setText("Félicitations !"+Name .getText()+" "+Surname.getText());
                    congrats.setVisibility(View.VISIBLE);
                }

        else

                { Context context = getApplicationContext();
                CharSequence text = "Tu dois renseigner le nom et le prénom!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


            }
        };

            });


        }




    });

    }

}





