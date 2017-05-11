package com.svnit.harsimar.socketdatasender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    public static final String serverIP="192.168.43.15";
    public static final int serverPort=8080;

    private ListView listView;
    private Button addBtn;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialise();
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData(editText.getText().toString());
            }
        });
    }

    public void initialise(){
        listView=(ListView)findViewById(R.id.list_view);
        addBtn=(Button)findViewById(R.id.add_btn);
        editText=(EditText)findViewById(R.id.edit_text);
    }
    public void sendData (final String s){
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket=new Socket(serverIP,serverPort);
                    DataOutputStream DOS= new DataOutputStream(
                            socket.getOutputStream());
                    DOS.writeUTF(s);
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
