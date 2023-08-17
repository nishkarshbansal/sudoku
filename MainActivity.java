package com.example.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int[][] arr = new int[9][9];
    Button button;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText cell00;
                int resourceViewID;
                String Rid = "";
                for(int i = 0; i < 9; i++){
                    for(int j = 0; j < 9; j++){
                        Rid = "editTextNumber"+i+""+j;
                        resourceViewID = getResources().getIdentifier(Rid, "id", getPackageName());
                        cell00 = findViewById(resourceViewID);
                        if(!TextUtils.isEmpty(cell00.getText().toString())){
                            String text00 = cell00.getText().toString();
                            arr[i][j] = Integer.parseInt(text00);
                            cell00.setText(Integer.toString(arr[i][j]));
                            cell00.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_blue_bright));
                            }
                    }
                }
                button.setText("Solve");
                SudokuSolution solution = new SudokuSolution();
                int[][] newArr = solution.arrayReform(arr);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        EditText cell00;
                        int resourceViewID;
                        String Rid = "";
                        for(int i = 0; i < 9; i++){
                            for(int j = 0; j < 9; j++){
                                Rid = "editTextNumber"+i+""+j;
                                resourceViewID = getResources().getIdentifier(Rid, "id", getPackageName());
                                cell00 = findViewById(resourceViewID);
                                if(TextUtils.isEmpty(cell00.getText().toString())){
                                    cell00.setText(Integer.toString(arr[i][j]));
                                }
                            }
                        }
                        textView.setText("Here is the solved Sudoku");
                        button.setText("restart");
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                EditText cell00;
                                int resourceViewID;
                                String Rid = "";
                                for(int i = 0; i < 9; i++){
                                    for(int j = 0; j < 9; j++){
                                        Rid = "editTextNumber"+i+""+j;
                                        resourceViewID = getResources().getIdentifier(Rid, "id", getPackageName());
                                        cell00 = findViewById(resourceViewID);
                                        cell00.getText().clear();
                                    }
                                }
                                int[][] arr1 = new int[9][9];
                                arr = arr1;
                                recreate();
                            }
                        });
                    }
                });

            }
        });
    }

}