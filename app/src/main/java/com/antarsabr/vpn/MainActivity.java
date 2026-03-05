package com.antarsabr.vpn;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.provpn.openvpn.OpenVpnApi; // المكتبة الجاهزة
import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // تشغيل الاتصال فور فتح التطبيق
        startVpn();
        
        // إغلاق الواجهة ليعمل في الخلفية
        finish();
    }

    private void startVpn() {
        try {
            // قراءة ملف السيرفر من مجلد assets الذي سننشئه لاحقاً
            InputStream is = getAssets().open("saudi.ovpn");
            Scanner s = new Scanner(is).useDelimiter("\\A");
            String config = s.hasNext() ? s.next() : "";

            // تنفيذ الاتصال بلمسة واحدة
            OpenVpnApi.startVpn(this, config, "AntarSabr Saudi", "@covyg");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
