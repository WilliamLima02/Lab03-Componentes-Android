package ao.co.isptec.aplm.simpleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG,"callback onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"callback onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"callback onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"callback onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"callback onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"callback onResume");
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"callback onRestart");
    }

    // this method is trigged onlick event
    public void finishButtonPressed(View view ){
        Log.i(TAG,"is finishing the activity...");
        finish(); //this function close the activuty
    }
}