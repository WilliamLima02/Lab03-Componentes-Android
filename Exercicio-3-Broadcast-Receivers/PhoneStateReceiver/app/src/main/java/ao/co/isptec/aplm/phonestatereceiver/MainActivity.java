package ao.co.isptec.aplm.phonestatereceiver;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends Activity {
    private static final String TAG = "TAG_MainActivity";
    private static final int PHONE_STATUS_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView message = new TextView(this);
        message.setText("Phone State Receiver - permissões necessárias para observar o estado do telefone.");
        message.setPadding(32, 48, 32, 32);
        setContentView(message);
    }

    @Override
    protected void onStart() {
        super.onStart();
        askPhonePermission();
    }

    private void askPhonePermission() {
        boolean phonePermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED;
        boolean callLogPermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CALL_LOG) == PackageManager.PERMISSION_GRANTED;

        if (!phonePermission || !callLogPermission) {
            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.READ_CALL_LOG
                    },
                    PHONE_STATUS_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PHONE_STATUS_REQUEST_CODE) {
            boolean allGranted = grantResults.length == 2;
            for (int result : grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    allGranted = false;
                }
            }
            Log.i(TAG, allGranted ? "Permissões concedidas" : "Permissões não concedidas");
        }
    }
}
