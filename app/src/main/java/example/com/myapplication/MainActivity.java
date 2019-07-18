package example.com.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String KEY_NAME = "name user";
    Button btn_ok, btn_show_name;
    TextView tv_privet;
    EditText ed_username;
    int inx = 0;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_ok = findViewById(R.id.btn_ok);
        tv_privet = findViewById(R.id.tv_hello);
        ed_username = findViewById(R.id.ed_name);
        btn_show_name = findViewById(R.id.btn_show);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            // get text from edittext
            public void onClick(View v) {
              name = ed_username.getText().toString();
            }
        });
        btn_show_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"your name is "+name,Toast.LENGTH_SHORT).show();
            }
        });
        Log.d("tag","onCreate");
        if(savedInstanceState !=null){
            name = savedInstanceState.getString(KEY_NAME,"not saved");
        }
    }

    public void onMyClick(View vgfdgfdg){
        Intent intent = new Intent(MainActivity.this,BActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_NAME,name);
    }
}
