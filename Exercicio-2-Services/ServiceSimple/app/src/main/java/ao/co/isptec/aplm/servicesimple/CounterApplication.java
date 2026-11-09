package ao.co.isptec.aplm.servicesimple;

import android.app.Application;

public class CounterApplication extends Application {
    private int serviceStartCount = 0;

    public int incrementServiceStartCount() {
        serviceStartCount++;
        return serviceStartCount;
    }

    public int getServiceStartCount() {
        return serviceStartCount;
    }
}
