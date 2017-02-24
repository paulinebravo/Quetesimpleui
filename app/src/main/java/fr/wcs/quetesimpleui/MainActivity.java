package fr.wcs.quetesimpleui;

import android.app.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main) ;

        final EditText Name = (EditText) findViewById(R.id.Name);
        final EditText Surname = (EditText) findViewById(R.id.Surname);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        final Button button = (Button) findViewById(R.id.button);
        final TextView congrats= (TextView) findViewById(R.id.congrats);

        congrats.setVisibility(View.INVISIBLE);
        button.setEnabled (false);

        checkBox .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Name.setEnabled(checkBox.isChecked());
                Surname.setEnabled(checkBox.isChecked());
                button.setEnabled(checkBox.isChecked());

            if (!isChecked) {

            Name.setText(null);
            Surname.setText(null);
            congrats.setVisibility(View.INVISIBLE);

        }

                button .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)

            {


                if (Surname.length()==0 || Name.length()==0)
                {


                    Context context = getApplicationContext();
                    CharSequence text = getString(R.string.Toast);
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    congrats.setVisibility(View.INVISIBLE);

                }

        else

                { congrats.setText(getString(R.string.congrats)+" "+Name.getText()+ " "+Surname.getText());

                    congrats.setVisibility(View.VISIBLE);
                }
            }

                    });


                }




        } ) ;

    }

}





