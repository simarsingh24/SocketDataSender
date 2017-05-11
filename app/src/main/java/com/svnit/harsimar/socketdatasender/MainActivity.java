package com.svnit.harsimar.socketdatasender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    public static final String serverIP="127.0.0.1";
    public static final int serverPort=8080;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Socket socket=new Socket(serverIP,serverPort);
            DataOutputStream DOS= new DataOutputStream(
                    socket.getOutputStream());
            DOS.writeUTF("harsimar");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
