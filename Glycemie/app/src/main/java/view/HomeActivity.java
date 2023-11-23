package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.glycemie.R;

public class HomeActivity extends AppCompatActivity {
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent1 = new Intent(this , MainActivity.class );
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
                finish();
            }
        });
    }


}