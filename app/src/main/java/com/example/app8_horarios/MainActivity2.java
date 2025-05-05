package com.example.app8_horarios;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.app8_horarios.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    private Intent intent = null;
    private ActivityMain2Binding binding = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());;

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TableRow encabezadoRow = new TableRow(this);

        TextView horarioEncabezado = new TextView(this);
        horarioEncabezado.setText("Horario");
        horarioEncabezado.setTextSize(16);
        horarioEncabezado.setPadding(16, 16, 16, 16);
        horarioEncabezado.setGravity(Gravity.CENTER);
        horarioEncabezado.setTextColor(Color.WHITE);
        horarioEncabezado.setBackgroundColor(Color.parseColor("#4c6688"));

        TextView materiaEncabezado = new TextView(this);
        materiaEncabezado.setText("Materia");
        materiaEncabezado.setTextSize(16);
        materiaEncabezado.setPadding(16, 16, 16, 16);
        materiaEncabezado.setGravity(Gravity.CENTER);
        materiaEncabezado.setTextColor(Color.WHITE);
        materiaEncabezado.setBackgroundColor(Color.parseColor("#4c6688"));

        TextView docenteEncabezado = new TextView(this);
        docenteEncabezado.setText("Docente");
        docenteEncabezado.setTextSize(16);
        docenteEncabezado.setPadding(16, 16, 16, 16);
        docenteEncabezado.setGravity(Gravity.CENTER);
        docenteEncabezado.setTextColor(Color.WHITE);
        docenteEncabezado.setBackgroundColor(Color.parseColor("#4c6688"));

        encabezadoRow.addView(horarioEncabezado);
        encabezadoRow.addView(materiaEncabezado);
        encabezadoRow.addView(docenteEncabezado);

        binding.tableLayout.addView(encabezadoRow);

        intent = getIntent();

        String nombreAlumno = intent.getStringExtra("Alumno");
        String fase = intent.getStringExtra("Fase");

        binding.txtNombre.setText(String.format("Alumno: %s", nombreAlumno));

        if (fase != null && fase.equals("Programación")) {
            String[][] horario = {
                    {"08:00 - 08:50 AM", "Derecho Informático", "Mtra. Delma Mendoza Tirado"},
                    {"08:50 - 09:40 AM", "Sistemas de información geográfica", "Prof. Erik Iván Sánchez Valdez"},
                    {"09:40 - 10:30 AM", "Desarrollo de aplicaciones móviles", "Prof. Juan Jose Rodriguez Malpica G"},
                    {"10:30 - 11:20 AM", "Programación de videojuegos", "Prof. Ulises Zaldívar colado"},
                    {"11:20 - 12:10 PM", "Administración de páginas web", "Prof. Juan Francisco Peraza Garzón"},
                    {"12:10 - 1:00 PM", "Interacción Hombre-Máquina", "Prof. Esteban Bernal Malagon"}};

            for (String[] row : horario) {
                TableRow tablaRow = new TableRow(this);

                TextView horarioText = new TextView(this);
                horarioText.setText(row[0]);
                horarioText.setTextSize(14);
                horarioText.setPadding(90, 16, 16, 16);
                horarioText.setGravity(Gravity.CENTER);
                horarioText.setTextColor(Color.WHITE);
                horarioText.setBackgroundColor(Color.parseColor("#336699"));

                TextView materiaText = new TextView(this);
                materiaText.setText(row[1]);
                materiaText.setTextSize(14);
                materiaText.setPadding(90, 16, 16, 16);
                materiaText.setGravity(Gravity.CENTER);
                materiaText.setTextColor(Color.WHITE);
                materiaText.setBackgroundColor(Color.parseColor("#336699"));

                TextView docente = new TextView(this);
                docente.setText(row[2]);
                docente.setTextSize(14);
                docente.setPadding(90, 16, 16, 16);
                docente.setGravity(Gravity.CENTER);
                docente.setTextColor(Color.WHITE);
                docente.setBackgroundColor(Color.parseColor("#336699"));

                tablaRow.addView(horarioText);
                tablaRow.addView(materiaText);
                tablaRow.addView(docente);

                binding.tableLayout.addView(tablaRow);

            }
        }

        binding.button2.setOnClickListener(v ->{
            finish();
        });

    }
}