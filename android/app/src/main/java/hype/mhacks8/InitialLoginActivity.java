package hype.mhacks8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InitialLoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_login);

        Button doctorButton = (Button) findViewById(R.id.doctor_choice);
        doctorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(InitialLoginActivity.this, LoginActivity.class);
                InitialLoginActivity.this.startActivity(loginIntent);
            }
        });
    }
}
