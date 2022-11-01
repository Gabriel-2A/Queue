package com.example.queue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.queue.Queue.Queue;
import com.example.queue.Queue.QueueNode;

public class MainActivity extends AppCompatActivity {

    private EditText etAgregar;
    private Button bAñadir, bAtender, bMostrar;
    Queue queue = new Queue();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAgregar = findViewById(R.id.etAgregar);
        bAñadir = findViewById(R.id.bAñadir);
        bAtender = findViewById(R.id.bAtender);
        bMostrar = findViewById(R.id.bMostrar);


        bAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etAgregar.getText().toString().equals("")){
                    Log.i("Log", "Valor no Aceptado");
                }else if((queue.getCont()) < 8){
                    int aux = Integer.parseInt(etAgregar.getText().toString().trim());

                    int flag = 0;
                    QueueNode auxP = queue.getFirst();
                    while (auxP != null){
                        if(aux == auxP.getData()) {
                            flag = -1;
                            break;
                        }
                            auxP = auxP.getNext();
                    }

                    if(flag != -1){
                        queue.add(aux);
                        //Log.i("Log", queue.getCont()+"");
                        //flag = 0;
                    } else {
                        Log.i("Log", "No es posible agregarlo a la cola");
                    }

                } else {
                    Log.i("Log", "No queda mas espacio");
                }

                etAgregar.setText("");

            }
        });

        bAtender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(queue.getFirst() != null){
                    Log.i("Log", "Usuario "+queue.remove()+" ha sido atendido");
                    //Log.i("Log", queue.getCont()+"");
                } else {
                    Log.i("Log", "No hay quien atender");
                    queue.setCont(0);
                    //Log.i("Log", queue.getCont()+"");
                }
            }
        });

        bMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queue.print();
            }
        });

    }
}