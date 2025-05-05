package com.example.app8_horarios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.app8_horarios.databinding.ActivityMainBinding;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] lista = {"Selecciona un Alumno","Miguel Alexis Diaz Diaz","Katherine Galilea Guardado Garza", "Angel Adrian Ruiz Páez"};
        ArrayAdapter<String> list1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,lista);
        list1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.comboBox.setAdapter(list1);

        binding.comboBox.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nombre = parent.getItemAtPosition(position).toString();

                if (nombre.equals("Miguel Alexis Diaz Diaz") || nombre.equals("Katherine Galilea Guardado Garza") || nombre.equals("Angel Adrian Ruiz Páez")) {
                    binding.txtFaseAlumno.setText("Programación");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No hacer nada
            }
        });

        binding.button.setOnClickListener(v ->{
            String nombre = binding.comboBox.getSelectedItem().toString();
            if(nombre.equals("Miguel Alexis Diaz Diaz") || nombre.equals("Katherine Galilea Guardado Garza") || nombre.equals("Angel Adrian Ruiz Páez")){
                intent = new Intent(this, MainActivity2.class);
                intent.putExtra("Alumno",nombre);
                intent.putExtra("Fase","Programación");
                startActivity(intent);
            }else{
                Toast.makeText(MainActivity.this, "Por Favor de Seleccionar un Integrante", Toast.LENGTH_SHORT).show();
            }
        });
    }
}