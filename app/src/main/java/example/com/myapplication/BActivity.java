package example.com.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class BActivity extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Button btn_start_main = findViewById(R.id.btn_start_main);
        btn_start_main.setOnClickListener(this);
        findViewById(R.id.btn_start_b).setOnClickListener(this);
        findViewById(R.id.btn_image).setOnClickListener(this);
        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null) {
                String name = bundle.getString("name", "no name");
                Toast.makeText(this, "username :" + name, Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start_main:
                Intent intent_main = new Intent(BActivity.this, MainActivity.class);
                startActivity(intent_main);
                break;
            case R.id.btn_start_b:
                startActivity(new Intent(BActivity.this, BActivity.class));
                break;
            case R.id.btn_image:
                Intent intent_view = new Intent(Intent.ACTION_PICK);
                intent_view.setType("image/*");
                if(intent_view.resolveActivity(getPackageManager())!=null) {
                    startActivityForResult(intent_view, 1234);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1234 && resultCode == RESULT_OK){
            Uri uri = data.getData();
            ImageView imageView = findViewById(R.id.img_image);
            imageView.setImageURI(uri);
        }
    }
}
