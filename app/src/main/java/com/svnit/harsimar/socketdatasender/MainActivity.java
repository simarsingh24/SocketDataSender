package com.svnit.harsimar.socketdatasender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    public static final String serverIP="192.168.43.15";
    public static final int serverPort=8080;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendData();
    }
    public void sendData (){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("harsimarSingh","runnable Executing");
                    Socket socket=new Socket(serverIP,serverPort);
                    DataOutputStream DOS= new DataOutputStream(
                            socket.getOutputStream());
                    DOS.writeUTF("harsimar");
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
