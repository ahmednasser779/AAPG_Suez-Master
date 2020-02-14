package net.aapgsuez.aapgsuez;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class GpaCalc extends Fragment {


    public GpaCalc() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.gpa_calc, container, false);
        Button gpa = (Button)rootView.findViewById(R.id.button_cal);

        gpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            EditText GradeValue = (EditText) rootView.findViewById(R.id.ET_gradeValue);
            TextView scale = (TextView) rootView.findViewById(R.id.scale);
            TextView letterGrade = (TextView) rootView.findViewById(R.id.letter_grade);

            if (GradeValue.getText().toString().length() > 0) {

                double value = Double.parseDouble(GradeValue.getText().toString());

                if (value > 100) {
                    Toast.makeText(getActivity().getApplicationContext(), "Enter a value between 0 and 100!", Toast.LENGTH_SHORT).show();
                } else if (value < 0) {

                    Toast.makeText(getActivity().getApplicationContext(), "Enter a value between 0 and 100!", Toast.LENGTH_SHORT).show();
                } else if (value >= 0 && value <= 100) {
                    double grade = Double.parseDouble(GradeValue.getText().toString());
                    if (grade < 65) {
                        scale.setVisibility(View.VISIBLE);
                        letterGrade.setVisibility(View.VISIBLE);
                        scale.setText(Double.toString(0.0));
                        letterGrade.setText("E/F");
                    } else if (grade >= 65 && grade <= 66) {
                        scale.setVisibility(View.VISIBLE);
                        letterGrade.setVisibility(View.VISIBLE);
                        scale.setText(Double.toString(1.0));
                        letterGrade.setText("D");
                    } else if (grade >= 67 && grade <= 69) {
                        scale.setVisibility(View.VISIBLE);
                        letterGrade.setVisibility(View.VISIBLE);
                        scale.setText(Double.toString(1.3));
                        letterGrade.setText("D+");
                    } else if (grade >= 70 && grade <= 72) {
                        scale.setVisibility(View.VISIBLE);
                        letterGrade.setVisibility(View.VISIBLE);
                        scale.setText(Double.toString(1.7));
                        letterGrade.setText("C-");
                    } else if (grade >= 73 && grade <= 76) {
                        scale.setVisibility(View.VISIBLE);
                        letterGrade.setVisibility(View.VISIBLE);
                        scale.setText(Double.toString(2.0));
                        letterGrade.setText("C");
                    } else if (grade >= 77 && grade <= 79) {
                        scale.setVisibility(View.VISIBLE);
                        letterGrade.setVisibility(View.VISIBLE);
                        scale.setText(Double.toString(2.3));
                        letterGrade.setText("C+");
                    } else if (grade >= 80 && grade <= 82) {
                        scale.setVisibility(View.VISIBLE);
                        letterGrade.setVisibility(View.VISIBLE);
                        scale.setText(Double.toString(2.7));
                        letterGrade.setText("B-");
                    } else if (grade >= 83 && grade <= 86) {
                        scale.setVisibility(View.VISIBLE);
                        letterGrade.setVisibility(View.VISIBLE);
                        scale.setText(Double.toString(3));
                        letterGrade.setText("B");
                    } else if (grade >= 87 && grade <= 89) {
                        scale.setVisibility(View.VISIBLE);
                        letterGrade.setVisibility(View.VISIBLE);
                        scale.setText(Double.toString(3.3));
                        letterGrade.setText("B+");
                    } else if (grade >= 90 && grade <= 92) {
                        scale.setVisibility(View.VISIBLE);
                        letterGrade.setVisibility(View.VISIBLE);
                        scale.setText(Double.toString(3.7));
                        letterGrade.setText("A-");
                    } else if (grade >= 93 && grade <= 96) {
                        scale.setVisibility(View.VISIBLE);
                        letterGrade.setVisibility(View.VISIBLE);
                        scale.setText(Double.toString(4.0));
                        letterGrade.setText("A");
                    } else if (grade >= 97 && grade <= 100) {
                        scale.setVisibility(View.VISIBLE);
                        letterGrade.setVisibility(View.VISIBLE);
                        scale.setText(Double.toString(4.0));
                        letterGrade.setText("A+");
                    }

                }
            } else {
                // HANDLE EMPTY VALUE HERE
                Toast.makeText(getActivity().getApplicationContext(), "Invalid Grade Value /n Please enter a " +
                        "value between 0 and 100", Toast.LENGTH_SHORT).show();

            }

            }
        });
            return rootView;
        }
    }

