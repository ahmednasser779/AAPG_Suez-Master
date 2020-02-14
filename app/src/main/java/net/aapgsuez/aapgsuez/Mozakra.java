package net.aapgsuez.aapgsuez;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Mozakra extends AppCompatActivity {

    /*These variables in rts and Humanities science Faculty*/
    String dep;   // stands for which department is selected
    // E stands for english department , F for french department and so on
    int ye;      // stands for which year is selected
    int sem;    //stands for which semester is selected
    String ur;//virable to store links of materials

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mozakra);


        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        final Spinner faculty = (Spinner) findViewById(R.id.faculty);
        final Spinner department = (Spinner) findViewById(R.id.department);
        final Spinner year = (Spinner) findViewById(R.id.year);
        final Spinner semester = (Spinner) findViewById(R.id.semester);
        final Spinner material = (Spinner) findViewById(R.id.material);


        Button contact = (Button) findViewById(R.id.contactUS);
        final Button goButton = (Button) findViewById(R.id.Go);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO
                        , Uri.fromParts("mailto", "aapgsusc.app@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Order a missing Material");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "File Name:\n" +
                        "Faculty:\n" +
                        "Department:\n" +
                        "Academic Year:");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

            }
        });
        /*faculties*/
        ArrayAdapter facultyAdapter = ArrayAdapter.createFromResource(this, R.array.faculty,
                android.R.layout.simple_spinner_dropdown_item);
        faculty.setAdapter(facultyAdapter);

        faculty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ye = 0;
                sem = 0;
                year.setVisibility(View.GONE);
                semester.setVisibility(View.GONE);
                material.setVisibility(View.GONE);
                if (faculty.getSelectedItem().toString().equals("Choose your Faculty....")) {
                    Toast.makeText(Mozakra.this, "Choose your faculty..", Toast.LENGTH_SHORT).show();
                    department.setVisibility(View.GONE);
                    year.setVisibility(View.GONE);
                    semester.setVisibility(View.GONE);
                    material.setVisibility(View.GONE);
                    goButton.setVisibility(View.GONE);

                    /*Politics and Economy*/
                } else if (faculty.getSelectedItem().toString().equals("Politics and Economy Faculty")) {
                    department.setVisibility(View.GONE);
                    semester.setVisibility(View.GONE);
                    material.setVisibility(View.GONE);
                    goButton.setVisibility(View.GONE);
                    year.setVisibility(View.VISIBLE);
                    ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                            R.array.year2, android.R.layout.simple_spinner_dropdown_item);
                    year.setAdapter(yearAdapter);

                    /*medicine*/
                } else if (faculty.getSelectedItem().toString().equals("Medicine Faculty")) {
                    department.setVisibility(View.GONE);
                    semester.setVisibility(View.GONE);
                    material.setVisibility(View.GONE);
                    goButton.setVisibility(View.GONE);
                    year.setVisibility(View.VISIBLE);
                    ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                            R.array.year1, android.R.layout.simple_spinner_dropdown_item);
                    year.setAdapter(yearAdapter);


                    /*Science*/
                } else if (faculty.getSelectedItem().toString().equals("Science Faculty")) {
                    department.setVisibility(View.VISIBLE);
                    semester.setVisibility(View.GONE);
                    material.setVisibility(View.GONE);
                    goButton.setVisibility(View.GONE);
                    year.setVisibility(View.GONE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                            R.array.departmentSC, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);

                    /*Fish Resources and Marine Studies Faculty*/
                } else if (faculty.getSelectedItem().toString().equals("Fish Resources and Marine Studies Faculty")) {
                    department.setVisibility(View.VISIBLE);
                    year.setVisibility(View.GONE);
                    semester.setVisibility(View.GONE);
                    material.setVisibility(View.GONE);
                    goButton.setVisibility(View.GONE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                            R.array.departmentfr, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);

                    /*Computers and Information Faculty*/
                } else if (faculty.getSelectedItem().toString().equals("Computers and Information Faculty")) {
                    department.setVisibility(View.GONE);
                    semester.setVisibility(View.GONE);
                    material.setVisibility(View.GONE);
                    goButton.setVisibility(View.GONE);
                    year.setVisibility(View.VISIBLE);
                    ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                            R.array.year2, android.R.layout.simple_spinner_dropdown_item);
                    year.setAdapter(yearAdapter);

                    /*Education*/
                } else if (faculty.getSelectedItem().toString().equals("Education Faculty")) {
                    department.setVisibility(View.VISIBLE);
                    year.setVisibility(View.GONE);
                    semester.setVisibility(View.GONE);
                    material.setVisibility(View.GONE);
                    goButton.setVisibility(View.GONE);
                    ArrayAdapter edu_departmentAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                            R.array.Education_departments, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(edu_departmentAdapter);

                    /*Petroleum and Mining Engineering Faculty*/
                } else if (faculty.getSelectedItem().toString().equals("Petroleum and Mining Engineering Faculty")) {
                    department.setVisibility(View.VISIBLE);
                    year.setVisibility(View.GONE);
                    semester.setVisibility(View.GONE);
                    material.setVisibility(View.GONE);
                    goButton.setVisibility(View.GONE);
                    ArrayAdapter pme_departmentAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                            R.array.pme_department, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(pme_departmentAdapter);

                    /*Arts and Humanities Science Faculty*/
                } else if (faculty.getSelectedItem().toString().equals("Arts and Humanities Science Faculty")) {
                    department.setVisibility(View.VISIBLE);
                    year.setVisibility(View.GONE);
                    semester.setVisibility(View.GONE);
                    material.setVisibility(View.GONE);
                    goButton.setVisibility(View.GONE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                            R.array.department, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);


                    /*Industrial Education*/
                } else if (faculty.getSelectedItem().toString().equals("Industrial Education")) {
                    department.setVisibility(View.VISIBLE);
                    year.setVisibility(View.GONE);
                    semester.setVisibility(View.GONE);
                    material.setVisibility(View.GONE);
                    goButton.setVisibility(View.GONE);
                    ArrayAdapter departmentAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                            R.array.departmentIE, android.R.layout.simple_spinner_dropdown_item);
                    department.setAdapter(departmentAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        /*departments*/
        department.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        ye = 0;
                        sem = 0;
                        if (department.getSelectedItem().toString().equals("Choose your Department ....")) {
                            year.setVisibility(View.GONE);
                        } else
                            year.setVisibility(View.VISIBLE);
                        semester.setVisibility(View.GONE);
                        material.setVisibility(View.GONE);
                        goButton.setVisibility(View.GONE);
                        ArrayAdapter year4Adapter = ArrayAdapter.createFromResource(Mozakra.this,
                                R.array.year4, android.R.layout.simple_spinner_dropdown_item);
                        year.setAdapter(year4Adapter);


                        /*Education*/
                        if (faculty.getSelectedItem().toString().equals("Education Faculty")) {
                            if (department.getSelectedItem().toString().equals("بيولوجى")) {
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.year3, android.R.layout.simple_spinner_dropdown_item);
                                year.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("تربوى")) {
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.year3, android.R.layout.simple_spinner_dropdown_item);
                                year.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("تربية فرنسى")) {
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.year3, android.R.layout.simple_spinner_dropdown_item);
                                year.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("تربية فنية")) {
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.year3, android.R.layout.simple_spinner_dropdown_item);
                                year.setAdapter(yearAdapter);
                            }


                            /*Arts and Humanities*/
                        } else if (faculty.getSelectedItem().toString().equals("Arts and Humanities Science Faculty")) {
                            if (department.getSelectedItem().toString().equals("Sociology Department")) {
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.year3, android.R.layout.simple_spinner_dropdown_item);
                                year.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Physiology Department")) {
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.year3, android.R.layout.simple_spinner_dropdown_item);
                                year.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("History Department")) {
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.year3, android.R.layout.simple_spinner_dropdown_item);
                                year.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Geography Department")) {
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.year3, android.R.layout.simple_spinner_dropdown_item);
                                year.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("French Department")) {
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.year3, android.R.layout.simple_spinner_dropdown_item);
                                year.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("English Department")) {
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.E_dep_year, android.R.layout.simple_spinner_dropdown_item);
                                year.setAdapter(yearAdapter);
                            } else if (department.getSelectedItem().toString().equals("Arabic Department")) {
                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.year3, android.R.layout.simple_spinner_dropdown_item);
                                year.setAdapter(yearAdapter);
                            }



                            /*Science*/
                        } else if (faculty.getSelectedItem().toString().equals("Science Faculty")) {

                            if (department.getSelectedItem().toString().equals("Physics")) {
                                dep = "Phy";
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter materialPH = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialPH, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(materialPH);

                            } else if (department.getSelectedItem().toString().equals("Microbiology")) {
                                dep = "MI";
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter materialMI = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialMI, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(materialMI);

                            } else if (department.getSelectedItem().toString().equals("Mathematics")) {
                                dep = "MA";
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter materialMA = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialMA, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(materialMA);

                            } else if (department.getSelectedItem().toString().equals("Industrial Chemistry")) {
                                dep = "IC";
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.GONE);
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1BmgXw1d80j6B5jN-qbSclyfrUEuK7DHH?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (department.getSelectedItem().toString().equals("Geology")) {
                                dep = "GEO";
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter materialPG = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialPG, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(materialPG);
                            } else if (department.getSelectedItem().toString().equals("First Level")) {
                                dep = "FL";
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter material_science_first = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.material_science_first, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(material_science_first);
                            } else if (department.getSelectedItem().toString().equals("Biochemistry")) {
                                dep = "BC";
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter materialBC = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialBC, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(materialBC);
                            } else if (department.getSelectedItem().toString().equals("Biotechnology")) {
                                dep = "BT";
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter materialBI = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialBI, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(materialBI);
                            }

                            /*Fish Resources*/
                        } else if (faculty.getSelectedItem().toString().equals("Fish Resources and Marine Studies Faculty")) {
                            if (department.getSelectedItem().toString().equals("متطلبات")) {
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.GONE);
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1lAt1dMW3ecjw9oe8LUXIV7oDld2P0fj2?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (department.getSelectedItem().toString().equals("هندسة بحرية")) {
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.GONE);
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1y4UKv577ZO_4RsLvlloB98YWtH8kXaqo?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (department.getSelectedItem().toString().equals("قسم ملاحة")) {
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.GONE);
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1Ipx1CkBxqUCoBWxmZzCmhNxs2oAX78rb?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (department.getSelectedItem().toString().equals("قسم مصايد")) {
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter material_msayd = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.material_msayd, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(material_msayd);
                            } else if (department.getSelectedItem().toString().equals("قسم تصنيع")) {
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.GONE);
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1mL89oI13g2qnrvl3lkJ6uQT2asd49wT0?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (department.getSelectedItem().toString().equals("قسم تنمية بشرية")) {
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.GONE);
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1zAQfe5f03h8wLAI3mABE_pzJ3W-_v3_q?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (department.getSelectedItem().toString().equals("قسم الاقتصاد السمكى")) {
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.GONE);
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1Wfg1-JvzB0grHrObUlBsuBYpbvyBKKZq?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (department.getSelectedItem().toString().equals("قسم استزراع")) {
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.GONE);
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1w5foMYEw9IgpY-gpxQpnfMAzxcCJp-9E?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (department.getSelectedItem().toString().equals("الفرقة الاولى مميز")) {
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.VISIBLE);
                                material.setVisibility(View.GONE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.semester2, android.R.layout.simple_spinner_dropdown_item);
                                semester.setAdapter(semesterAdapter);
                            } else if (department.getSelectedItem().toString().equals("الفرقة الاولى اساسى")) {
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.VISIBLE);
                                material.setVisibility(View.GONE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.semester2, android.R.layout.simple_spinner_dropdown_item);
                                semester.setAdapter(semesterAdapter);
                            } else if (department.getSelectedItem().toString().equals("سلامة بحرية")) {
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter material_slama = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.material_slama, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(material_slama);
                            }

                            /*Industrial Education*/
                        } else if (faculty.getSelectedItem().toString().equals("Industrial Education")) {

                            ArrayAdapter year32Adapter = ArrayAdapter.createFromResource(Mozakra.this,
                                    R.array.year32, android.R.layout.simple_spinner_dropdown_item);
                            year.setAdapter(year32Adapter);

                            if (department.getSelectedItem().toString().equals("الفرقة الاولى")) {
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.VISIBLE);
                                material.setVisibility(View.GONE);
                                goButton.setVisibility(View.GONE);

                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.semester2, android.R.layout.simple_spinner_dropdown_item);
                                semester.setAdapter(semesterAdapter);
                            }

                            /*PME*/
                        } else if (faculty.getSelectedItem().toString().equals("Petroleum and Mining Engineering Faculty")) {

                            if (department.getSelectedItem().toString().equals("Preparatory")) {
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.VISIBLE);
                                material.setVisibility(View.GONE);
                                goButton.setVisibility(View.GONE);

                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.semester2, android.R.layout.simple_spinner_dropdown_item);
                                semester.setAdapter(semesterAdapter);
                            } else if (department.getSelectedItem().toString().equals("Petroleum Production and Exploration Program")) {
                                year.setVisibility(View.GONE);
                                semester.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                goButton.setVisibility(View.GONE);
                                ArrayAdapter pme_program_material = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.pme_program_material, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(pme_program_material);
                            } else if (department.getSelectedItem().toString().equals("General")) {
                                ArrayAdapter year2Adapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.year2, android.R.layout.simple_spinner_dropdown_item);
                                year.setAdapter(year2Adapter);
                            }else if (department.getSelectedItem().toString().equals("Geology Dept.")) {
                                ArrayAdapter year3Adapter = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.year3, android.R.layout.simple_spinner_dropdown_item);
                                year.setAdapter(year3Adapter);
                            }
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        year.setVisibility(View.GONE);
                    }
                });

        /*year*/
        year.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener()

                {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        sem = 0;
                        if (year.getSelectedItem().toString().equals("Choose the year...")) {
                            semester.setVisibility(View.GONE);
                        } else if (year.getSelectedItem().toString().equals("First year")) {
                            ye = 1;
                            semester.setVisibility(View.VISIBLE);
                            material.setVisibility(View.GONE);
                            goButton.setVisibility(View.GONE);
                        } else if (year.getSelectedItem().toString().equals("Second year")) {
                            ye = 2;
                            semester.setVisibility(View.VISIBLE);
                            material.setVisibility(View.GONE);
                            goButton.setVisibility(View.GONE);
                        } else if (year.getSelectedItem().toString().equals("Third year")) {
                            ye = 3;
                            semester.setVisibility(View.VISIBLE);
                            material.setVisibility(View.GONE);
                            goButton.setVisibility(View.GONE);
                        } else if (year.getSelectedItem().toString().equals("Fourth year")) {
                            ye = 4;
                            semester.setVisibility(View.VISIBLE);
                            material.setVisibility(View.GONE);
                            goButton.setVisibility(View.GONE);
                        }
                        ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                R.array.semester2, android.R.layout.simple_spinner_dropdown_item);
                        semester.setAdapter(semesterAdapter);


                        if (faculty.getSelectedItem().toString().equals("Education Faculty")) {
                            if (department.getSelectedItem().toString().equals("تربوى")) {
                                if (ye == 1) {
                                    semester.setVisibility(View.GONE);
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materialsتربوىى_1 = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materialsتربوىى_1, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materialsتربوىى_1);
                                } else if (ye == 2) {
                                    semester.setVisibility(View.GONE);
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materialsتربوىى_2 = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materialsتربوىى_2, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materialsتربوىى_2);
                                }
                            }
                        } else if (faculty.getSelectedItem().toString().equals("Arts and Humanities Science Faculty")) {
                            if (department.getSelectedItem().toString().equals("English Department")) {
                                if (year.getSelectedItem().toString().equals("امتحانات قسم انجليزى"))
                                    ;
                                semester.setVisibility(View.GONE);
                                goButton.setVisibility(View.VISIBLE);
                                material.setVisibility(View.GONE);
                                ur = "https://drive.google.com/drive/folders/1dvFWHkRZ8jNmAzwfWpc1aAl-tJ0C7-fs?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";

                            }
                        } else if (faculty.getSelectedItem().toString().equals("Petroleum and Mining Engineering Faculty")) {
                            if (department.getSelectedItem().toString().equals("Geology Dept.")) {
                                if (ye == 3) {
                                    ArrayAdapter semester1Adapter = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.semester, android.R.layout.simple_spinner_dropdown_item);
                                    semester.setAdapter(semester1Adapter);
                                }
                            }
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });





        /*semester*/
        semester.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener()

                {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        sem = 0;
                        if (semester.getSelectedItem().toString().equals("Choose the semester...")) {
                            material.setVisibility(View.GONE);
                        } else material.setVisibility(View.VISIBLE);
                        if (semester.getSelectedItem().toString().equals("First semester")) {
                            sem = 1;
                        } else if (semester.getSelectedItem().toString().equals("Second semester")) {
                            sem = 2;
                        }

                        /*Education Faculty*/
                        if (faculty.getSelectedItem().toString().equals("Education Faculty")) {

                            /*اساسى علوم*/
                            if (department.getSelectedItem().toString().equals("أساسى علوم")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter اساسى11_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_11اساسى, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(اساسى11_materialAdapter);
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter اساسى12_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_12اساسى, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(اساسى12_materialAdapter);
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter اساسى21_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_21اساسى, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(اساسى21_materialAdapter);
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter اساسى22_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_22اساسى, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(اساسى22_materialAdapter);
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter اساسى31_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_31اساسى, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(اساسى31_materialAdapter);
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter اساسى32_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_32اساسى, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(اساسى32_materialAdapter);
                                } else if (ye == 4 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter اساسى41_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_41اساسى, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(اساسى41_materialAdapter);
                                } else if (ye == 4 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1XGbS8tvw8gdoyOk4m1H-D52gaRvKzBo3?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }

                                /*بيولوجى*/
                            } else if (department.getSelectedItem().toString().equals("بيولوجى")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_11بيولوجى = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_11بيولوجى, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_11بيولوجى);
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1FpitOgj2Va_Vds9ae73fTVT0ufgIKy94?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1UbC6zyeuLUSJudiAQdPAGijF4-5hQCmD?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1up7dtEUczdz_xPmuGK9h4yyV0F1TADUt?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_31بيولوجى = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_31بيولوجى, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_31بيولوجى);
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1M9DWq6vABYuXYCz5h4MXY2lmtnj0MSTu?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }


                                /*تربوى*/
                            } else if (department.getSelectedItem().toString().equals("تربوى")) {
                                if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials3تربوى_1 = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials3تربوى_1, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials3تربوى_1);
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials3تربوى_2 = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials3تربوى_2, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials3تربوى_2);
                                }

                                /*تربية رياضية*/
                            } else if (department.getSelectedItem().toString().equals("تربية رياضية")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1DdvIpC7ltLmA_mZAkZ2g2-fqBtZR-hxp?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1dTP9837AcJvtoUvjNG5mZYPW2ZMtEam2?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1IQu2pJpXXazMd1FAbVbPhj68VCE5juQF?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/115YNd2PHzgtL-jgRve3B94D523TVxE6b?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1ztvUAWJzZa40evrjDFW_o4GYaVl6ia7-?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1wzSCf9-ZRsGxydtuE2ELDhbydD7ix19j?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 4 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/11rV-VvjnzXNBO6srzdewIEYJ6pTGVaDe?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 4 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1ZNQMUMn-UP-VO6ZYC-j9ZXeV4GDFw5rk?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }

                                /*تربية طفولة*/
                            } else if (department.getSelectedItem().toString().equals("تربية طفولة")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1aBhLOPq1QrMjD6S8hRB1scj5fG0vtQP7?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_12طفولة = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_12طفولة, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_12طفولة);
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_21طفولة = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_21طفولة, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_21طفولة);
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/134PQ7Qh18PpcaloGffuei-_s6JOJihJL?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_31طفولة = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_31طفولة, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_31طفولة);
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_32طفولة = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_32طفولة, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_32طفولة);
                                } else if (ye == 4 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_4طفولة = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_4طفولة, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_4طفولة);
                                } else if (ye == 4 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1m9hHe16Zf91Bkh85LA13F1evxYr-MGRe?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }

//                                /*تربية فرنسى*/
                            } else if (department.getSelectedItem().toString().equals("تربية فرنسى")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_1فرنسى1 = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_1فرنسى1, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_1فرنسى1);
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_1فرنسى2 = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_1فرنسى2, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_1فرنسى2);
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1wUwtIrqnmYe2MvcLUVHqXVvu3CLc_1kA?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1M_1jkrRNsrr2EuvtyXj3NB_BTa9aucg0?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_فرنسى3 = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_فرنسى3, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_فرنسى3);
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1VBxEel99ngIzd5ooJUi0U89phd7yDc6L?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }

                                /*تربية فنية*/
                            } else if (department.getSelectedItem().toString().equals("تربية فنية")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1VD7PepnzQGfJhi93OZfR1YKOfk49ZT5F?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1nIaUP1SNTWlY9dw5tKnj-QI_SNWndcQL?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1PNFb3pNlFB0k7SxADscR-voxEZjRbeSm?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1lgLqCsFOPeZ2PvYoR4fpM69gfaYMuPMu?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1Hs3tGY8OB32HIQ0VsUPKllUjvzhwFV1S?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/13QXMCAxxx668rmeehlQCVjLlpif3j-so?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }

                                /*كيمياء*/
                            } else if (department.getSelectedItem().toString().equals("كيمياء")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_11كيمياء = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_11كيمياء, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_11كيمياء);
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_12كيمياء = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_12كيمياء, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_12كيمياء);
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_2كيمياء = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_2كيمياء, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_2كيمياء);
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1QbakAfmJ9JArdPvh37t-6o4XxDp_ju1z?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1tFufg-HGYGMZvPWoD39LC-0hXsFQ2OEW?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1k36dTgBayqB2p0uHwN2Hx2oqu5adHYdM?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 4 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_4كيمياء = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_4كيمياء, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_4كيمياء);
                                } else if (ye == 4 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/12oSiqqiPBVWUva4KurjfupiGrRSnmLj_?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }

                                /*انجليزى*/
                            } else if (department.getSelectedItem().toString().equals("لغة إنجليزية")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1yME1OuWxxcMmfs1zJwtllcMeAb6vHiif?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1fzxNYf4P35-F1qkBcfr7EOdZsh7vs1R5?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_21لغةانجليزية = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_21لغةانجليزية, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_21لغةانجليزية);
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/176HxqiRJ8bO_V7GNixoKwCBuZq1sfY2E?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1OFWk72Olp2J9kQTM8XGWl6JKMzvz67vv?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1-TRYIie79X_CJOzWByB-qe_qspFJaDVe?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 4 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/195dpA985jT3wLQfZ7shrrb2XdXhYpT1R?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 4 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1rPTQqAeNr8LPhfXy6_XffH8_NEG11dXM?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }

                                /*عربى*/
                            } else if (department.getSelectedItem().toString().equals("لغة عربية")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_11لغةعربية = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_11لغةعربية, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_11لغةعربية);
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1XPVa7HmUMrqWWKxpwWcQFPLTiwMyEf0A?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1bkGGC_hQQN6gCc4YAlgbdtIn4LUAQEyN?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1o8wy8MlRFLDtyCkxu0Xx_o4zXL_Z8vMF?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materials_31لغةعربية = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materials_31لغةعربية, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materials_31لغةعربية);
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1AdtFv7D8gDndFl2WnDpqC6AiopQAdYQX?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 4 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1u-VsYk53n75zYtVJXM370LenbbeToG0D?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 4 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1si7CuwsOLxJGfTRIA0GVR9bEE92z1BL4?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }
                            }


                            /*Politics And Economy*/
                        } else if (faculty.getSelectedItem().toString().equals("Politics and Economy Faculty")) {
                            if (ye == 1 & sem == 1) {
                                goButton.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                ArrayAdapter materialpe11 = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialpe11, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(materialpe11);
                            } else if (ye == 1 & sem == 2) {
                                goButton.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                ArrayAdapter materialpe12 = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialpe12, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(materialpe12);
                            } else if (ye == 2 & sem == 1) {
                                goButton.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                ArrayAdapter materialpe21 = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialpe21, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(materialpe21);
                            } else if (ye == 2 & sem == 2) {
                                goButton.setVisibility(View.VISIBLE);
                                material.setVisibility(View.GONE);
                                ur = "https://drive.google.com/drive/folders/1fjnvE5kbbH1tDPyMQfWvpwkvRx5raGdB?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";

                            }
                            /*Medicine*/
                        } else if (faculty.getSelectedItem().toString().equals("Medicine Faculty")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materialMedicine11 = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materialMedicine11, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materialMedicine11);
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter materialMedicine12 = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.materialMedicine12, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(materialMedicine12);
                                }
                            /*computer science*/
                        } else if (faculty.getSelectedItem().toString().equals("Computers and Information Faculty")) {
                            if (ye == 1 & sem == 1) {
                                goButton.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                ArrayAdapter materialcs11 = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialcs11, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(materialcs11);
                            } else if (ye == 1 & sem == 2) {
                                goButton.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                ArrayAdapter materialcs12 = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialcs12, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(materialcs12);
                            } else if (ye == 2 & sem == 1) {
                                goButton.setVisibility(View.GONE);
                                material.setVisibility(View.VISIBLE);
                                ArrayAdapter materialcs21 = ArrayAdapter.createFromResource(Mozakra.this,
                                        R.array.materialcs21, android.R.layout.simple_spinner_dropdown_item);
                                material.setAdapter(materialcs21);
                            } else if (ye == 2 & sem == 2) {
                                goButton.setVisibility(View.VISIBLE);
                                material.setVisibility(View.GONE);
                                ur = "https://drive.google.com/drive/folders/108CyKhadTUNHqoAoMzL90jg9VcfynSL2?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";

                            }

                            /*Arts and Humanities*/
                        } else if (faculty.getSelectedItem().toString().equals("Arts and Humanities Science Faculty")) {

                            /*Sociology*/
                            if (department.getSelectedItem().toString().equals("Sociology Department")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter S_Y1_S1_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.S_Y1_S1_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(S_Y1_S1_material);
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter S_Y1_S2_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.S_Y1_S2_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(S_Y1_S2_material);
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter S_Y2_S1_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.S_Y2_S1_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(S_Y2_S1_material);
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1w2nKvBcWy2Cv7RP3h5Ndh1lhgd4_Uzi2?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1kcE2g9Bt_waXruxIF-1K-E4s-H5cEoPt?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1QrFNxIEJSde-bfKLoKZYM5HOQuTawhVE?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }

                                /*Physiology*/
                            } else if (department.getSelectedItem().toString().equals("Physiology Department")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter PH_Y1_S1_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.PH_Y1_S1_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(PH_Y1_S1_material);
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/14lkG8IM8pF34RkzXQOnYVx4NP6-WuI3p?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }
                                if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter PH_Y2_S1_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.PH_Y2_S1_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(PH_Y2_S1_material);
                                }
                                if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1In6rcCxb-RPGixwVzO_MTShyBjW-8Zfx?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }
                                if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1Qmdw_bjRAfYky62IgqMCui__TevjBGya?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }
                                if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1P0DdkwIAL46C7h8pVLXKG3cfpFx_vfBm?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }

                                /*History*/
                            } else if (department.getSelectedItem().toString().equals("History Department")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1gMPEzQj3-QJXmHlERGnlW6I-yBXVuZRA?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1zXrVPTzjXxS3Tkm-BcPnZaQHv16hdbaM?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1cOMXVaQP3-WoYmFugq0eJ0SIgAMwoBAK?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1QF31dy_9bJ-RQEb6caiPyhQ_Ksqc1GMj?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1Md1bgSnOnNhPA4rJKq5afjDoe2NbcfP_?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1JkL1p7V5qcCZErsIo3HfhA9_ILVumLvd?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }

                                /*geography*/
                            } else if (department.getSelectedItem().toString().equals("Geography Department")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter G_Y1_S1_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.G_Y1_S1_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(G_Y1_S1_material);
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1m2LPMOzZtU-FPuv3n-ta8Eca3nSN3OvB?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1FU4fl1QVEH-KcejEyu_ALV9Pk5Rty8dr?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1uHZOBD_a9mKy6eytkNK9pERaWLGgG3SR?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1qfwg6Sq74GCKAWn9K1RJoq4CydEdNRG5?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1OizQM0x8tqRw-n96QGVVvjaIt5txVL-d?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }

                                /*French*/
                            } else if (department.getSelectedItem().toString().equals("French Department")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter F_Y1_S1_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.F_Y1_S1_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(F_Y1_S1_material);
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter F_Y1_S2_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.F_Y1_S2_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(F_Y1_S2_material);
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter F_Y2_S1_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.F_Y2_S1_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(F_Y2_S1_material);
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter F_Y2_S2_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.F_Y2_S2_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(F_Y2_S2_material);
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter F_Y3_S1_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.F_Y3_S1_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(F_Y3_S1_material);
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1958h61R7AliRup6QJCSHPgZrkJOosYW8?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }

                                /*English*/
                            } else if (department.getSelectedItem().toString().equals("English Department")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter E_Y1_S1_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.E_Y1_S1_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(E_Y1_S1_material);
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter E_Y1_S2_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.E_Y1_S2_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(E_Y1_S2_material);
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter E_Y2_S1_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.E_Y2_S1_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(E_Y2_S1_material);
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter E_Y2_S2_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.E_Y2_S2_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(E_Y2_S2_material);
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter E_Y3_S1_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.E_Y3_S1_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(E_Y3_S1_material);
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter E_Y3_S2_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.E_Y3_S2_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(E_Y3_S2_material);
                                }

                                /*Arabic*/
                            } else if (department.getSelectedItem().toString().equals("Arabic Department")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1zPkRmx_ajMjBtezvoSv0iFKiciDXzzUW?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1JCDuQCd4isfnSEkjOxUlUlb05_0Rz3Ux?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1v5gVz68rMshL6uqjL0ryzwS1M5k_9fRG?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/10_dVMxitNhSw9MRu7TvMPZ7hUmLxxcNg?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1HTI-En5sdY9XoVMSaNlDgalq0fKgSopn?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1f13MvNQXqu72LLKHwMty5H2EpEmc8hCW?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }
                            }

                            /*Fish Resources*/
                        } else if (faculty.getSelectedItem().toString().equals("Fish Resources and Marine Studies Faculty")) {
                            if (department.getSelectedItem().toString().equals("الفرقة الاولى مميز")) {
                                if (sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1qnU9BjgZsKfRHlKZfcyjfoV0B8DZ_NjJ?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1s1EMkVTUz1dssq4FhYBBgea5kygz6Hev?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }
                            } else if (department.getSelectedItem().toString().equals("الفرقة الاولى اساسى")) {
                                if (sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1XBFPzpFH1xnLgQ83pVi5qBfd9nNbPfVu?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1RmbeyZkP82xa9zxEfAbV8nqjcx5JUunL?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }
                            }
                            /*Industrial Eductaion*/
                        } else if (faculty.getSelectedItem().toString().equals("Industrial Education")) {

                            /*قسم انشاءات مدنية ومعمارية*/
                            if (department.getSelectedItem().toString().equals("قسم انشاءات مدنية ومعمارية")) {
                                if (ye == 4 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1udwZ8CHBKbQ2THjppwazetMkI4xNFC8M?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 4 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1uEZN9sFB7_e7OXqzkUrdG6iCgNENpyFV?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1cDui6yCt-2S0Z9SvtHgxu-HBP7Dg3rh2?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1WWu6UNbxuDtq87JQIlgVbHxDtQ-kq4eg?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1VOSF19yxMg80LONquiYXiO1OagV_v3OH?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1vu2Mha3T1XsWKUNI0fPA82IorV9B1uAs?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }

                                /*قسم كهرباء*/
                            } else if (department.getSelectedItem().toString().equals("قسم كهرباء")) {
                                if (ye == 4 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1iWQSXTED0eCy1ZMuexXvXhxiHBWDw17n?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 4 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1Vg9OGMySQYTTlPd_u3__hzHuYYFzBMIW?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1RCiQ-FVVPKQXb4FbeexmPwPYTXs5TyI-?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1CE0JxhLK3580fZU94rxu9Q2YICMgdqHH?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1idgMAIhRWaVRkHGKS94xQGz8HFVbc0_p?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1Td3HncXTJkVhxXO9bD_g7qQs02aFyX55?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }

                                /*قسم ميكانيكا*/
                            } else if (department.getSelectedItem().toString().equals("قسم ميكانيكا")) {
                                if (ye == 4 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1f3q7Y1Sls7-4wPfPJtrzRu1JtjXiDvP8?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 4 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1L7lJjnb-WTrPqUcL7cmy2N9pfadhkqtN?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1LUM-6i4A_tb3hB7FIciz3yXqIB9G4_-b?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1FTuKsWBuaN6PScVCGC_JCR8GVmta50nY?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1x8Mcz88OEgPBZFmKVqWC_QSvA1fru-N0?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1LzfjF2tUrhNo1dbc9C_R5mn6aleYzheE?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }
                                /*first year*/
                            } else if (department.getSelectedItem().toString().equals("الفرقة الاولى")) {
                                if (sem == 1) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1eqyyfNWLa2ZGvLok_h2vpAGjxVsTlKCn?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (sem == 2) {
                                    goButton.setVisibility(View.VISIBLE);
                                    material.setVisibility(View.GONE);
                                    ur = "https://drive.google.com/drive/folders/1LEkn0kSzqjHSMV2EpLnKVGa0WqGGXuSB?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }
                            }

                            /*PME*/
                        } else if (faculty.getSelectedItem().toString().equals("Petroleum and Mining Engineering Faculty")) {
                            /*Preparatory*/
                            if (department.getSelectedItem().toString().equals("Preparatory")) {
                                if (sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_preparatory_firstSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_preparatory_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_preparatory_firstSemester_material);
                                } else if (sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_preparatory_secondSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_preparatory_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_preparatory_secondSemester_material);
                                }

                                /*Petroleum*/
                            } else if (department.getSelectedItem().toString().equals("Petroleum Engineering Dept.")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_petroleum1_firstSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_petroleum1_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_petroleum1_firstSemester_material);
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_petroleum1_secondSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_petroleum1_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_petroleum1_secondSemester_material);
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_petroleum1_firstSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_petroleum2_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_petroleum1_firstSemester_material);
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_petroleum2_secondSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_petroleum2_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_petroleum2_secondSemester_material);
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_petroleum3_firstSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_petroleum3_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_petroleum3_firstSemester_material);
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_petroleum3_secondSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_petroleum3_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_petroleum3_secondSemester_material);
                                } else if (ye == 4 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_petroleum4_firstSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_petroleum4_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_petroleum4_firstSemester_material);
                                } else if (ye == 4 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_petroleum4_secondSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_petroleum4_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_petroleum4_secondSemester_material);
                                }

                                /*Refining*/
                            } else if (department.getSelectedItem().toString().equals("Refining Engineering Dept.")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_refining1_firstSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_refining1_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_refining1_firstSemester_material);
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_refining1_secondSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_refining1_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_refining1_secondSemester_material);
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_refining1_firstSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_refining2_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_refining1_firstSemester_material);
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_refining2_secondSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_refining2_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_refining2_secondSemester_material);
                                } else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_refining3_firstSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_refining3_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_refining3_firstSemester_material);
                                } else if (ye == 3 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_refining3_secondSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_refining3_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_refining3_secondSemester_material);
                                } else if (ye == 4 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_refining4_firstSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_refining4_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_refining4_firstSemester_material);
                                } else if (ye == 4 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_refining4_secondSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_refining4_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_refining4_secondSemester_material);
                                }

                                /*General*/
                            } else if (department.getSelectedItem().toString().equals("General")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_general1_firstSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_general1_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_general1_firstSemester_material);
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_general1_secondSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_general1_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_general1_secondSemester_material);
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_general1_firstSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_general2_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_general1_firstSemester_material);
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_general2_secondSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_general2_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_general2_secondSemester_material);
                                }

                                /*Geology*/
                            } else if (department.getSelectedItem().toString().equals("Geology Dept.")) {
                                if (ye == 1 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_Geology1_firstSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_Geology1_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_Geology1_firstSemester_material);
                                } else if (ye == 1 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_Geology1_secondSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_Geology1_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_Geology1_secondSemester_material);
                                } else if (ye == 2 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_Geology1_firstSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_Geology2_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_Geology1_firstSemester_material);
                                } else if (ye == 2 & sem == 2) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_Geology2_secondSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_Geology2_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_Geology2_secondSemester_material);
                                }else if (ye == 3 & sem == 1) {
                                    goButton.setVisibility(View.GONE);
                                    material.setVisibility(View.VISIBLE);
                                    ArrayAdapter pme_Geology3_firstSemester_material = ArrayAdapter.createFromResource(Mozakra.this,
                                            R.array.pme_Geology3_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
                                    material.setAdapter(pme_Geology3_firstSemester_material);
                                }
                            }
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

//                        /*Fish Resources and Marine Studies Faculty*/
//                        if (faculty.getSelectedItem().toString().equals("Fish Resources and Marine Studies Faculty")) {
//                            if (department.getSelectedItem().toString().equals("Ocean")) {
//                                year.setVisibility(View.VISIBLE);
//                                semester.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.yearRF1, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("هندسة بحرية")) {
//                                year.setVisibility(View.VISIBLE);
//                                semester.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.yearRF2, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("مميز")) {
//                                year.setVisibility(View.VISIBLE);
//                                semester.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.yearRF, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("سلامة بحرية")) {
//                                year.setVisibility(View.GONE);
//                                semester.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialfr, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(yearAdapter);
//                            }
//
//                            /*Science*/
//                        } else if (faculty.getSelectedItem().toString().equals("Science Faculty")) {
//                            if (department.getSelectedItem().toString().equals("حقوق انسان مشترك")) {
//                                material.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.material_حقوق_انسان, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("Industrial Chemistry")) {
//                                material.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialIC, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("Biochemistry")) {
//                                material.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialBC, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("Geology")) {
//                                material.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialPG, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("Physics")) {
//                                material.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialPH, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("Mathematics")) {
//                                material.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialMA, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("Microbiology")) {
//                                material.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialMI, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("Biotechnology")) {
//                                material.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialBI, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(yearAdapter);
//                            }
//
//                            /*Education*/
//                        } else if (faculty.getSelectedItem().toString().equals("Education Faculty")) {
//                            if (department.getSelectedItem().toString().equals("أساسى علوم")) {
//                                year.setVisibility(View.VISIBLE);
//                                semester.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter اساسى_yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.years_اساسى, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(اساسى_yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("امتحانات تالته")) {
//                                year.setVisibility(View.GONE);
//                                semester.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter امتحانات = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_3_امتحانات, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(امتحانات);
//                            } else if (department.getSelectedItem().toString().equals("بيولوجى")) {
//                                year.setVisibility(View.VISIBLE);
//                                semester.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter bio_yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.years_بيولوجى, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(bio_yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("تربوى")) {
//                                year.setVisibility(View.VISIBLE);
//                                semester.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter تربوى_yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.years_تربوى, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(تربوى_yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("تربية طفولة")) {
//                                year.setVisibility(View.VISIBLE);
//                                semester.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter طفولة_yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.years_طفولة, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(طفولة_yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("تربية فرنسى")) {
//                                year.setVisibility(View.VISIBLE);
//                                semester.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter فرنسى_yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.years_فرنسى, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(فرنسى_yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("كيمياء")) {
//                                year.setVisibility(View.VISIBLE);
//                                semester.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter كيمياء_yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.years_كيمياء, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(كيمياء_yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("لغة إنجليزية")) {
//                                year.setVisibility(View.VISIBLE);
//                                semester.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter انجليزى_yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.years_انجليزى, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(انجليزى_yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("لغة عربية")) {
//                                year.setVisibility(View.VISIBLE);
//                                semester.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter عربى_yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.years_عربى, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(عربى_yearAdapter);
//                            }
//
//                            /*Petroleum and Mining Engineering Faculty*/
//                        } else if (faculty.getSelectedItem().toString().equals("Petroleum and Mining Engineering Faculty")) {
//                            if (department.getSelectedItem().toString().equals("Petroleum Engineering Dept.")) {
//                                year.setVisibility(View.VISIBLE);
//                                semester.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter pme_petroleum_yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_petroleum_year, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(pme_petroleum_yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("Refining Engineering Dept.")) {
//                                year.setVisibility(View.VISIBLE);
//                                semester.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                ArrayAdapter pme_refining_yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_refining_year, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(pme_refining_yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("Preparatory")) {
//                                year.setVisibility(View.GONE);
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter pme_preparatory_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_preparatory_semester, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(pme_preparatory_semesterAdapter);
//                            } else if (department.getSelectedItem().toString().equals("Petroleum Production and Exploration Program")) {
//                                year.setVisibility(View.GONE);
//                                semester.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_program_materialAdapterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_program_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_program_materialAdapterAdapter);
//                            } else if (department.getSelectedItem().toString().equals("Geology Dept.")) {
//                                year.setVisibility(View.GONE);
//                                semester.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_geologyDept_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_geologyDept_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_geologyDept_materialAdapter);
//                            }
//                            /*Arts and Humanities Science Faculty*/
//                        } else if (faculty.getSelectedItem().toString().equals("Arts and Humanities Science Faculty")) {
//                            if (department.getSelectedItem().toString().equals("English Dapartment")) {
//                                dep = "E";
//                                year.setVisibility(View.VISIBLE);
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                semester.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.E_dep_year, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("French Department")) {
//                                dep = "F";
//                                year.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                semester.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.F_dep_year, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("Geography")) {
//                                dep = "G";
//                                year.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                semester.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.G_dep_year, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("Physiology Department")) {
//                                dep = "PH";
//                                year.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                semester.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.PH_and_S_dep_year, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(yearAdapter);
//                            } else if (department.getSelectedItem().toString().equals("Sociology Department")) {
//                                dep = "S";
//                                year.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                semester.setVisibility(View.GONE);
//                                ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.PH_and_S_dep_year, android.R.layout.simple_spinner_dropdown_item);
//                                year.setAdapter(yearAdapter);
//                            }
//                        }
//
//                    }
//
//                    public void onNothingSelected(AdapterView<?> parent) {
//                    }
//                });
//        /*year*/
//        year.setOnItemSelectedListener(
//                new AdapterView.OnItemSelectedListener() {
//                    public void onItemSelected(
//                            AdapterView<?> parent, View view, int position, long id) {
//                        material.setVisibility(View.GONE);
//                        /*Politics and Economy*/
//                        if (faculty.getSelectedItem().toString().equals("Politics and Economy")) {
//                            if (year.getSelectedItem().toString().equals("first year P.E")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semesterpe1, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("second year P.E")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semesterpe2, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//                            }
//                            /*Fish Resources and Marine Studies Faculty*/
//                        } else if (faculty.getSelectedItem().toString().equals("Fish Resources and Marine Studies Faculty")) {
//                            if (year.getSelectedItem().toString().equals("First year F.R")) {
//                                semester.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialfr1, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(semesterAdapter);
//
//                            } else if (year.getSelectedItem().toString().equals("Second year F.R")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semesterfr1, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//
//                            } else if (year.getSelectedItem().toString().equals("first year F.R")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semesterfr11, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//
//                            }
//                            /*Computers and Information Faculty*/
//                        } else if (faculty.getSelectedItem().toString().equals("Computers and Information Faculty")) {
//                            if (year.getSelectedItem().toString().equals("first year C.S")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semestercs1, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("second year C.S")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semestercs2, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//                            }
//
//                            /*Education*/
//                        } else if (faculty.getSelectedItem().toString().equals("Education Faculty")) {
//                            if (year.getSelectedItem().toString().equals("اولى اساسى")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter اساسى1_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester_اساسى_1, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(اساسى1_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("تانية اساسى")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter اساسى2_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester_اساسى_2, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(اساسى2_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("تالتة اساسى")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter اساسى3_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester_اساسى_3, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(اساسى3_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("رابعة اساسى")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter اساسى4_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester_اساسى_4, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(اساسى4_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("اولى بيولوجى")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter بيولوجى1_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester_بيولوجى_1, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(بيولوجى1_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("تالتة بيولوجى")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter بيولوجى3_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester_بيولوجى_3, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(بيولوجى3_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("اولى تربوى")) {
//                                semester.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter تربوى1_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialsتربوىى_1, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(تربوى1_materialAdapter);
//                            } else if (year.getSelectedItem().toString().equals("تانية تربوى")) {
//                                semester.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter تربوى2_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialsتربوىى_2, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(تربوى2_materialAdapter);
//                            } else if (year.getSelectedItem().toString().equals("تالتة تربوى")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter تربوى3_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester_تربوى_3, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(تربوى3_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("اولى طفولة")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter طفولة1_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester_طفولة_1, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(طفولة1_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("تانية طفولة")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter طفولة2_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester_طفولة_2, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(طفولة2_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("تالتة طفولة")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter طفولة3_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester_طفولة_3, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(طفولة3_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("رابعة طفولة")) {
//                                semester.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter طفولة4_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_4طفولة, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(طفولة4_materialAdapter);
//                            } else if (year.getSelectedItem().toString().equals("اولى فرنسى")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter فرنسى1_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester_فرنسى_1, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(فرنسى1_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("تانية فرنسى")) {
//                                semester.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter فرنسى2_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_2فرنسى, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(فرنسى2_materialAdapter);
//                            } else if (year.getSelectedItem().toString().equals("تالتة فرنسى")) {
//                                semester.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter فرنسى3_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_فرنسى3, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(فرنسى3_materialAdapter);
//                            } else if (year.getSelectedItem().toString().equals("اولى كيمياء")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter كيمياء1_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester_كيمياء_1, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(كيمياء1_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("تانية كيمياء")) {
//                                semester.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter كيمياء2_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_2كيمياء, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(كيمياء2_materialAdapter);
//                            } else if (year.getSelectedItem().toString().equals("رابعه كيمياء")) {
//                                semester.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter كيمياء4_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_4كيمياء, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(كيمياء4_materialAdapter);
//                            } else if (year.getSelectedItem().toString().equals("تانية انجليزى")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter انجليزى2_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester_انجليزى_2, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(انجليزى2_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("اولى عربى")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter عربي1_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester_عربى_1, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(عربي1_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("تالتة عربى")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter عربي3_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester_عربى_3, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(عربي3_semesterAdapter);
//                            }
//
//                            /*Petroleum and Mining Engineering Faculty*/
//                        } else if (faculty.getSelectedItem().toString().equals("Petroleum and Mining Engineering Faculty")) {
//                            if (year.getSelectedItem().toString().equals("first year Petroleum")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter pme_petroleum1_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_petroleum1_semester, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(pme_petroleum1_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("second year Petroleum")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter pme_petroleum2_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_petroleum2_semester, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(pme_petroleum2_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("third year Petroleum")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter pme_petroleum3_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_petroleum3_semester, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(pme_petroleum3_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("fourth year Petroleum")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter pme_petroleum4_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_petroleum4_semester, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(pme_petroleum4_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("first year Refining")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter pme_refining1_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_refining1_semester, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(pme_refining1_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("second year Refining")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter pme_refining2_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_refining2_semester, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(pme_refining2_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("third year Refining")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter pme_refining3_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_refining3_semester, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(pme_refining3_semesterAdapter);
//                            } else if (year.getSelectedItem().toString().equals("fourth year Refining")) {
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter pme_refining4_semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_refining4_semester, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(pme_refining4_semesterAdapter);
//                            }
//                            /*Arts and Humanities Science Faculty*/
//                        } else if (faculty.getSelectedItem().toString().equals("Arts and Humanities Science Faculty")) {
//                            if (dep == "E" & year.getSelectedItem().toString().equals("first year")) {
//                                ye = 1;
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester2, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//                            } else if (dep == "E" & year.getSelectedItem().toString().equals("second year")) {
//                                ye = 2;
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester2, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//                            } else if (dep == "E" & year.getSelectedItem().toString().equals("third year")) {
//                                ye = 3;
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester2, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//                            } else if (dep == "E" & year.getSelectedItem().toString().equals("امتحانات قسم انجليزى")) {
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.VISIBLE);
//                                semester.setVisibility(View.GONE);
//                                ur = "https://drive.google.com/drive/folders/1dvFWHkRZ8jNmAzwfWpc1aAl-tJ0C7-fs";
//                            } else if (dep == "F" & year.getSelectedItem().toString().equals("first year")) {
//                                ye = 1;
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester2, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//                            } else if (dep == "F" & year.getSelectedItem().toString().equals("second year")) {
//                                ye = 2;
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester2, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//                            } else if (dep == "F" & year.getSelectedItem().toString().equals("third year")) {
//                                ye = 3;
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.GONE);
//                                semester.setVisibility(View.VISIBLE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//                            } else if (dep == "G" & year.getSelectedItem().toString().equals("first year")) {
//                                ye = 1;
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester3, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//                            } else if (dep == "PH" & year.getSelectedItem().toString().equals("first year")) {
//                                ye = 1;
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//                            } else if (dep == "PH" & year.getSelectedItem().toString().equals("second year")) {
//                                ye = 2;
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//                            } else if (dep == "S" & year.getSelectedItem().toString().equals("first year")) {
//                                ye = 1;
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester2, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//                            } else if (dep == "S" & year.getSelectedItem().toString().equals("second year")) {
//                                ye = 2;
//                                semester.setVisibility(View.VISIBLE);
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.GONE);
//                                ArrayAdapter semesterAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.semester, android.R.layout.simple_spinner_dropdown_item);
//                                semester.setAdapter(semesterAdapter);
//                            }
//                        }
//                    }
//
//                    public void onNothingSelected(AdapterView<?> parent) {
//
//                    }
//                });
//        /*semester*/
//        semester.setOnItemSelectedListener(
//                new AdapterView.OnItemSelectedListener() {
//                    public void onItemSelected(
//                            AdapterView<?> parent, View view, int position, long id) {
//                        /*Politics and Economy*/
//                        if (faculty.getSelectedItem().toString().equals("Politics and Economy")) {
//                            if (semester.getSelectedItem().toString().equals("first semester Y1")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialpe11, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("second semester Y1")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialpe12, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("first semester Y2")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialpe21, android.R.layout.simple_spinner_dropdown_item);
//                                goButton.setVisibility(View.GONE);
//                                material.setAdapter(materialAdapter);
//                            }
//                            /*Fish Resources and Marine Studies Faculty*/
//                        } else if (faculty.getSelectedItem().toString().equals("Fish Resources and Marine Studies Faculty")) {
//                            if (semester.getSelectedItem().toString().equals("first semester - second year")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialfr112, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("first semester - first year")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialfr11, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            }
//                            /*Computers and Information Faculty*/
//                        } else if (faculty.getSelectedItem().toString().equals("Computers and Information Faculty")) {
//                            if (semester.getSelectedItem().toString().equals("first semester Y1-C.S")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialcs11, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("second semester Y1-C.S")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialcs12, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("first semester Y2-C.S")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materialcs21, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            }
//
//                            /*Education*/
//                        } else if (faculty.getSelectedItem().toString().equals("Education Faculty")) {
//                            if (semester.getSelectedItem().toString().equals("ترم اول اساسى 1")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter اساسى11_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_11اساسى, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(اساسى11_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم تانى اساسى 1")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter اساسى12_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_12اساسى, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(اساسى12_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم اول اساسى 2")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter اساسى21_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_21اساسى, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(اساسى21_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم تانى اساسى 2")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter اساسى22_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_22اساسى, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(اساسى22_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم اول اساسى 3")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter اساسى31_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_31اساسى, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(اساسى31_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم تانى اساسى 3")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter اساسى32_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_32اساسى, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(اساسى32_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم اول اساسى 4")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter اساسى41_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_41اساسى, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(اساسى41_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم اول بيولوجى 1")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter بيوجولى11_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_11بيولوجى, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(بيوجولى11_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم اول بيولوجى 3")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter بيوجولى31_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_31بيولوجى, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(بيوجولى31_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم اول تربوى 3")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter تريوى31_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials3تربوى_1, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(تريوى31_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم تانى تربوى 3")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter تريوى32_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials3تربوى_2, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(تريوى32_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم تانى طفولة 1")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter طفولة12_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_12طفولة, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(طفولة12_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم اول طفولة 2")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter طفولة21_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_21طفولة, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(طفولة21_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم اول طفولة 3")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter طفولة31_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_31طفولة, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(طفولة31_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم تانى طفولة 3")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter طفولة32_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_32طفولة, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(طفولة32_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم اول فرنسى 1")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter فرنسى11_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_1فرنسى1, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(فرنسى11_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم تانى فرنسى 1")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter فرنسى12_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_1فرنسى2, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(فرنسى12_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم اول كيمياء 1")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter كيمياء11_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_11كيمياء, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(كيمياء11_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم تانى كيمياء 1")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter كيمياء12_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_12كيمياء, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(كيمياء12_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم اول انجليزى 2")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter انجليزى11_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_21لغةانجليزية, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(انجليزى11_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم اول عربى 1")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter عربى11_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_11لغةعربية, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(عربى11_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("ترم اول عربى 3")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter عربى31_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.materials_31لغةعربية, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(عربى31_materialAdapter);
//                            }
//
//                            /*Petroleum and Mining Engineering Faculty*/
//                        } else if (faculty.getSelectedItem().toString().equals("Petroleum and Mining Engineering Faculty")) {
//                            if (semester.getSelectedItem().toString().equals("first semester preparatory")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_preparatory_firstSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_preparatory_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_preparatory_firstSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("second semester preparatory")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_preparatory_secondSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_preparatory_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_preparatory_secondSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("first semester petroleum1")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_petroleum1_firstSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_petroleum1_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_petroleum1_firstSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("second semester petroleum1")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_petroleum1_secondSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_petroleum1_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_petroleum1_secondSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("first semester petroleum2")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_petroleum2_firstSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_petroleum2_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_petroleum2_firstSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("second semester petroleum2")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_petroleum2_secondSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_petroleum2_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_petroleum2_secondSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("first semester petroleum3")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_petroleum3_firstSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_petroleum3_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_petroleum3_firstSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("second semester petroleum3")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_petroleum3_secondSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_petroleum3_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_petroleum3_secondSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("first semester petroleum4")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_petroleum4_firstSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_petroleum4_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_petroleum4_firstSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("second semester petroleum4")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_petroleum4_secondSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_petroleum4_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_petroleum4_secondSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("first semester refining1")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_refining1_firstSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_refining1_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_refining1_firstSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("second semester refining1")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_refining1_secondSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_refining1_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_refining1_secondSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("first semester refining2")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_refining2_firstSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_refining2_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_refining2_firstSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("second semester refining2")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_refining2_secondSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_refining2_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_refining2_secondSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("first semester refining3")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_refining3_firstSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_refining3_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_refining3_firstSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("second semester refining3")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_refining3_secondSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_refining3_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_refining3_secondSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("first semester refining4")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_refining4_firstSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_refining4_firstSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_refining4_firstSemester_materialAdapter);
//                            } else if (semester.getSelectedItem().toString().equals("second semester refining4")) {
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter pme_refining4_secondSemester_materialAdapter = ArrayAdapter.createFromResource(Mozakra.this,
//                                        R.array.pme_refining4_secondSemester_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(pme_refining4_secondSemester_materialAdapter);
//                            }
//                            /*Arts and Humanities Science Faculty*/
//                        } else if (faculty.getSelectedItem().toString().equals("Arts and Humanities Science Faculty")) {
//                            if (dep == "E" & ye == 1 & semester.getSelectedItem().toString().equals("first semester")) {
//                                sem = 1;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.E_Y1_S1_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (dep == "E" & ye == 1 & semester.getSelectedItem().toString().equals("second semester")) {
//                                sem = 2;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.E_Y1_S2_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (dep == "E" & ye == 2 & semester.getSelectedItem().toString().equals("first semester")) {
//                                sem = 1;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.E_Y2_S1_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (dep == "E" & ye == 2 & semester.getSelectedItem().toString().equals("second semester")) {
//                                sem = 2;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.E_Y2_S2_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (dep == "E" & ye == 3 & semester.getSelectedItem().toString().equals("first semester")) {
//                                sem = 1;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.E_Y3_S1_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//
//                            } else if (dep == "E" & ye == 3 & semester.getSelectedItem().toString().equals("second semester")) {
//                                sem = 2;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.E_Y3_S2_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//
//                            } else if (dep == "F" & ye == 1 & semester.getSelectedItem().toString().equals("first semester")) {
//                                sem = 1;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.F_Y1_S1_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (dep == "F" & ye == 1 & semester.getSelectedItem().toString().equals("second semester")) {
//                                sem = 2;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.F_Y1_S2_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (dep == "F" & ye == 2 & semester.getSelectedItem().toString().equals("first semester")) {
//                                sem = 1;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.F_Y2_S1_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (dep == "F" & ye == 2 & semester.getSelectedItem().toString().equals("second semester")) {
//                                sem = 2;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.F_Y2_S2_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (dep == "F" & ye == 3 & semester.getSelectedItem().toString().equals("first semester")) {
//                                sem = 1;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.F_Y3_S1_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//
//                            } else if (dep == "G" & ye == 1 & semester.getSelectedItem().toString().equals("امتحانات ترم اول")) {
//                                sem = 1;
//                                material.setVisibility(View.GONE);
//                                goButton.setVisibility(View.VISIBLE);
//                                ur = "https://drive.google.com/drive/folders/14VKt2K9_b_0ZKmZaRxzi7wB3et7-Iwtj";
//                            } else if (dep == "PH" & ye == 1 & semester.getSelectedItem().toString().equals("first semester")) {
//                                sem = 1;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.PH_Y1_S1_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (dep == "PH" & ye == 2 & semester.getSelectedItem().toString().equals("first semester")) {
//                                sem = 1;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.PH_Y2_S1_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (dep == "S" & ye == 1 & semester.getSelectedItem().toString().equals("first semester")) {
//                                sem = 1;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.S_Y1_S1_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (dep == "S" & ye == 1 & semester.getSelectedItem().toString().equals("second semester")) {
//                                sem = 2;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.S_Y1_S2_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            } else if (dep == "S" & ye == 2 & semester.getSelectedItem().toString().equals("first semester")) {
//                                sem = 1;
//                                goButton.setVisibility(View.GONE);
//                                material.setVisibility(View.VISIBLE);
//                                ArrayAdapter materialAdapter = ArrayAdapter.createFromResource(Mozakra.this
//                                        , R.array.S_Y2_S1_material, android.R.layout.simple_spinner_dropdown_item);
//                                material.setAdapter(materialAdapter);
//                            }
//                        }
//                    }
//
//                    public void onNothingSelected(AdapterView<?> parent) {
//
//                    }
//                });
        /*material*/
        material.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener()

                {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        /*Politics and Economy*/
                        if (faculty.getSelectedItem().toString().equals("Politics and Economy Faculty")) {
                            if (material.getSelectedItem().toString().equals("مبادئ القانون 1")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B71nZ7yuupSCdFY2NF96NVFoQVU";
                            } else if (material.getSelectedItem().toString().equals("مبادئ العلوم السياسة")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B71nZ7yuupSCLS15d1Juc0dENEk";
                            } else if (material.getSelectedItem().toString().equals("مبادئ السلوك التنظيمى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B71nZ7yuupSCLU5IdmNodXFBOXM";

                            } else if (material.getSelectedItem().toString().equals("اقتصاد جزئى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B71nZ7yuupSCLW5FdEVHdXk2a2M";

                            } else if (material.getSelectedItem().toString().equals("امتحانات 1")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B71nZ7yuupSCLUpjaTVSYmRCaGs";

                            } else if (material.getSelectedItem().toString().equals("مبادئ القانون 2")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B71nZ7yuupSCLU5lNnBld1BkVW8";

                            } else if (material.getSelectedItem().toString().equals("مبادئ احصاء")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B71nZ7yuupSCLUZLVmJENmVsYW8";

                            } else if (material.getSelectedItem().toString().equals("حقوق انسان")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B71nZ7yuupSCLVZWSmRMb0d5Smc";

                            } else if (material.getSelectedItem().toString().equals("الادارة العامة")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B71nZ7yuupSCLVFyUEhzVElVYVU";

                            } else if (material.getSelectedItem().toString().equals("اقتصاد كلى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B71nZ7yuupSCLVZfUHhncGM3UXM";

                            } else if (material.getSelectedItem().toString().equals("اقتصاد جزئى2")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B71nZ7yuupSCLUpVWUhTNlJDc0E?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";

                            } else if (material.getSelectedItem().toString().equals("international organization")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B71nZ7yuupSCLVVGYjJIUmgwMlE";

                            } else if (material.getSelectedItem().toString().equals("امتحانات 2")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B71nZ7yuupSCLUt0aTFyZ2hHeEE?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";

                            } else if (material.getSelectedItem().toString().equals("امتحان اقتصاد")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1-1BCTt6cZxAxQZ-9he2esNYisgNFspmu";

                            }
                            /*Medicine*/
                        } else if (faculty.getSelectedItem().toString().equals("Medicine Faculty")) {
                                if (material.getSelectedItem().toString().equals("Anatomy 1")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1dfyBhTWWAVaGy3eUE86spoFmxXmJ18m4";
                                } else if (material.getSelectedItem().toString().equals("Biochemistry 1")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1shJN49zYMFO-En3NBwKH6EhZlaJxbFHH";
                                } else if (material.getSelectedItem().toString().equals("Community 1")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1NTS64LoONoIOpTmjEnPz50HsRYoXPkAr";

                                } else if (material.getSelectedItem().toString().equals("Histology 1")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1hhmQulPvRgO-cN8Yxp9db_JCRfDwyscH";

                                } else if (material.getSelectedItem().toString().equals("Medical term list")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1tuC_oXWXmEOtSRdsNJkikZOZvkQnbOJm";

                                } else if (material.getSelectedItem().toString().equals("Microbiology 1")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1nHsuW-7OcBZUxQ-G6Pj7iIAgVq1_aouX";

                                } else if (material.getSelectedItem().toString().equals("Para 1")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1ue-I5kE_1Mq2m84mZXiKp6zUNPO4pqvQ";

                                } else if (material.getSelectedItem().toString().equals("Pathology 1")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/12eT3afAwLTWmjsbCDG_TgAYJjnhajLwc";

                                } else if (material.getSelectedItem().toString().equals("Pharmacology 1")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1lxcMmA8GBCzz8TCnlz3SY_jqsl-4a2ay";

                                } else if (material.getSelectedItem().toString().equals("Physiology 1")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1nLyOO4B-R8a9MhELA3tI9pBqUo3I6Kzx";

                                } else if (material.getSelectedItem().toString().equals("Anatomy 2")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/19zvWhSMjbhR47mrOJY2qnQzyAwMm84-p";
                                }
                                else if (material.getSelectedItem().toString().equals("Biochemistry 2")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1A6iudVxM5sv-QDEkNI4OWUzEVOzrTBlC";
                                } else if (material.getSelectedItem().toString().equals("Community 2")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1ACRq2ThLPzjFEeXdYZmdIu9mPZS_2uF5";

                                } else if (material.getSelectedItem().toString().equals("Histology 2")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1AF99BcAGixQkRZIwHosSnDUVCIj3l_I6";

                                } else if (material.getSelectedItem().toString().equals("Microbiology 2")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1AOBLvSd6JVAQCaYTpegK1NSHccgMPhMK";

                                } else if (material.getSelectedItem().toString().equals("Para 2")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1APrqYBMJMqPbZO6XBHrdZERSTJwon6LJ";

                                } else if (material.getSelectedItem().toString().equals("Pathology 2")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1AbbiMJV_lET4Yim8cnVYSc3Cgw5tkexR";

                                } else if (material.getSelectedItem().toString().equals("Pharmacology 2")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1AfBWELk5WDOiJM7wpeTLgGihtoR3aTj5";

                                } else if (material.getSelectedItem().toString().equals("Physiology 2")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/0/folders/1AfTffndtEUFtV3glxVC73Jr_HLJUvxZK";
                                }
                                else if (material.getSelectedItem().toString().equals("Choose Material...")) {
                                    goButton.setVisibility(View.GONE);
                                }
                            /*Fish Resources and Marine Studies Faculty*/
                        } else if (faculty.getSelectedItem().toString().equals("Fish Resources and Marine Studies Faculty")) {
                            if (department.getSelectedItem().toString().equals("قسم مصايد")) {
                                if (material.getSelectedItem().toString().equals("حرف صيد سلبية")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/folders/1oxAOoAaK4P6HQxxxWwYJTI2BlIp_a1xD?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (material.getSelectedItem().toString().equals("سلامة بحرية")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/folders/1Y967treGnZ8WGVlMO0zPwnA842IV1d_1?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                } else if (material.getSelectedItem().toString().equals("فنون بحرية")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/folders/11PJxNs936drq8uCIU30LSehe-4FukxFK?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                                }
                                else if (material.getSelectedItem().toString().equals("Others")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/folders/1joqaRfel22T7VI8P22EagClmZ5wc6zhv";
                                }
                            } else if (department.getSelectedItem().toString().equals("سلامة بحرية")) {
                                if (material.getSelectedItem().toString().equals("Others")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/folders/1CcoJnTFf3HTuW1aJTuRkCYstVwcaBjDX";
                                } else if (material.getSelectedItem().toString().equals("امتحانات")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/folders/14RODVM-Y3tIIQ-iDwHqrkH8iZ84roVau";
                                }
                            }
//                            if (material.getSelectedItem().toString().equals("final oceanography")) {
//                                goButton.setVisibility(View.VISIBLE);
//                                ur = "https://accounts.google.com/signin/v2/sl/pwd?service=wise&passive=1209600&continue=https://drive.google.com/file/d/1nWnuAB3orMucrw8K1cuqn7um6sY_fFFf/view%3Fusp%3Ddrive_web&hl=ar&followup=https://drive.google.com/file/d/1nWnuAB3orMucrw8K1cuqn7um6sY_fFFf/view%3Fusp%3Ddrive_web&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
//
//                            } else if (material.getSelectedItem().toString().equals("فلك وأرصاد جوية")) {
//                                goButton.setVisibility(View.VISIBLE);
//                                ur = "https://accounts.google.com/signin/v2/sl/pwd?service=wise&passive=1209600&continue=https://drive.google.com/file/d/18OTLPuLL-Na4VG9WWNW52SGqve77gyH9/view%3Fusp%3Ddrive_web&hl=ar&followup=https://drive.google.com/file/d/18OTLPuLL-Na4VG9WWNW52SGqve77gyH9/view%3Fusp%3Ddrive_web&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
//
//
//                            } else if (material.getSelectedItem().toString().equals("بحيرات")) {
//                                goButton.setVisibility(View.VISIBLE);
//                                ur = "https://accounts.google.com/ServiceLogin?service=wise&passive=1209600&continue=https://drive.google.com/file/d/1y89UHfyCaZAgkwnra30FAymDSIskNlja/view?usp%3Ddrive_web&hl=ar&followup=https://drive.google.com/file/d/1y89UHfyCaZAgkwnra30FAymDSIskNlja/view?usp%3Ddrive_web";
//
//
//                            } else if (material.getSelectedItem().toString().equals("MidTerm")) {
//                                goButton.setVisibility(View.VISIBLE);
//                                ur = "https://accounts.google.com/signin/v2/sl/pwd?service=wise&passive=1209600&continue=https://drive.google.com/file/d/1P9oinJETZoRASPIcVy6Y9xTGBWcS2ZWG/view%3Fusp%3Ddrive_web&hl=ar&followup=https://drive.google.com/file/d/1P9oinJETZoRASPIcVy6Y9xTGBWcS2ZWG/view%3Fusp%3Ddrive_web&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
//
//
//                            } else if (material.getSelectedItem().toString().equals("Exams1")) {
//                                goButton.setVisibility(View.VISIBLE);
//                                ur = "https://accounts.google.com/signin/v2/sl/pwd?service=wise&passive=1209600&continue=https://drive.google.com/file/d/1LF64vl-ZfjO-jwe29bnruZWTIrSCHNdO/view%3Fusp%3Ddrive_web&hl=ar&followup=https://drive.google.com/file/d/1LF64vl-ZfjO-jwe29bnruZWTIrSCHNdO/view%3Fusp%3Ddrive_web&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
//
//
//                            } else if (material.getSelectedItem().toString().equals("Exams2")) {
//                                goButton.setVisibility(View.VISIBLE);
//                                ur = "https://accounts.google.com/signin/v2/sl/pwd?service=wise&passive=1209600&continue=https://drive.google.com/file/d/1TE26J2WqvHjizB9SUGdaKs8Ws8IJQ-Js/view%3Fusp%3Ddrive_web&hl=ar&followup=https://drive.google.com/file/d/1TE26J2WqvHjizB9SUGdaKs8Ws8IJQ-Js/view%3Fusp%3Ddrive_web&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
//
//
//                            } else if (material.getSelectedItem().toString().equals("Exams")) {
//                                goButton.setVisibility(View.VISIBLE);
//                                ur = "https://accounts.google.com/signin/v2/sl/pwd?service=wise&passive=1209600&continue=https://drive.google.com/file/d/1q20dfK13htE1YhCXBMKqqra-1MWMVOVp/view%3Fusp%3Ddrive_web&hl=ar&followup=https://drive.google.com/file/d/1q20dfK13htE1YhCXBMKqqra-1MWMVOVp/view%3Fusp%3Ddrive_web&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
//
//
//                            } else if (material.getSelectedItem().toString().equals("فلك وارصاد جوية")) {
//                                goButton.setVisibility(View.VISIBLE);
//                                ur = "https://accounts.google.com/signin/v2/sl/pwd?service=wise&passive=1209600&continue=https://drive.google.com/file/d/18OTLPuLL-Na4VG9WWNW52SGqve77gyH9/view%3Fusp%3Ddrive_web&hl=ar&followup=https://drive.google.com/file/d/18OTLPuLL-Na4VG9WWNW52SGqve77gyH9/view%3Fusp%3Ddrive_web&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
//
//
//                            } else if (material.getSelectedItem().toString().equals("بحيـرات")) {
//                                goButton.setVisibility(View.VISIBLE);
//                                ur = "https://accounts.google.com/signin/v2/sl/pwd?service=wise&passive=1209600&continue=https://drive.google.com/file/d/1y89UHfyCaZAgkwnra30FAymDSIskNlja/view%3Fusp%3Ddrive_web&hl=ar&followup=https://drive.google.com/file/d/1y89UHfyCaZAgkwnra30FAymDSIskNlja/view%3Fusp%3Ddrive_web&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
//
//
//                            } else if (material.getSelectedItem().toString().equals("Caga culture")) {
//                                goButton.setVisibility(View.VISIBLE);
//                                ur = "https://accounts.google.com/ServiceLogin?service=wise&passive=1209600&continue=https://drive.google.com/file/d/0Bx1TXZ-UjRguYlo3NWFET1RadGM/view?usp%3Ddrive_web&hl=ar&followup=https://drive.google.com/file/d/0Bx1TXZ-UjRguYlo3NWFET1RadGM/view?usp%3Ddrive_web";
//
//
//                            } else if (material.getSelectedItem().toString().equals("تسويق")) {
//                                goButton.setVisibility(View.VISIBLE);
//                                ur = "https://accounts.google.com/signin/v2/sl/pwd?service=wise&passive=1209600&continue=https://drive.google.com/file/d/0B9nviOTHpzByeFdpdko1Ny1UcXM/view%3Fusp%3Ddrive_web&hl=ar&followup=https://drive.google.com/file/d/0B9nviOTHpzByeFdpdko1Ny1UcXM/view%3Fusp%3Ddrive_web&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
//
//
//                            } else if (material.getSelectedItem().toString().equals("Caga culture-fourth year")) {
//                                goButton.setVisibility(View.VISIBLE);
//                                ur = "https://accounts.google.com/ServiceLogin?service=wise&passive=1209600&continue=https://drive.google.com/file/d/0Bx1TXZ-UjRguaGRrNHJJa01CSnc/view?usp%3Ddrive_web&hl=ar&followup=https://drive.google.com/file/d/0Bx1TXZ-UjRguaGRrNHJJa01CSnc/view?usp%3Ddrive_web";
//                            }
//
//                            /*Science*/
                        } else if (faculty.getSelectedItem().toString().equals("Science Faculty")) {
                            if (material.getSelectedItem().toString().equals("نووية واشعاعية")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B9fM-j_4HhpGTUExanB2eXhCLTA";
                            } else if (material.getSelectedItem().toString().equals("فزياء رياضية")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B9fM-j_4HhpGd2hsZXM0aHNsWVk";
                            } else if (material.getSelectedItem().toString().equals("امتحانات Biotechnology")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1G5xS8xV6XYswwlDTvZ3OCOIFy-BZ7RRN?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (material.getSelectedItem().toString().equals("امتحانات فيزياء")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1Mv26yxxGWZbqvl0QnIOWejJXQc_HO3bF?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (material.getSelectedItem().toString().equals("ذرية")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B9fM-j_4HhpGemJ2Q2NFQmpTdlk";
                            } else if (material.getSelectedItem().toString().equals("ضوء فيزيائى د.آمنة")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1Rw_mT9tt0CUWer9GZnrJ_oB2Bb3n5tz7";
                            } else if (material.getSelectedItem().toString().equals("حرارة وخواص د/بهجت")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1v8hjyJPjkIm5KYXaHR7XO8An_UTbOJbM";
                            } else if (material.getSelectedItem().toString().equals("جوامد 1")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguSHM0UDRCQ2xBeDQ";
                            } else if (material.getSelectedItem().toString().equals("وراثة حيوية وجزيئية د.سامية")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguU3U5NWtQbm03b0U";
                            } else if (material.getSelectedItem().toString().equals("ميكروبايولوجى الغذاء وامراض النبات د.صالحة")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguOW43STdyMnRqa0U";
                            } else if (material.getSelectedItem().toString().equals("فطريات ووراثة ميكروبات د.عبدالحميد")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguYTFmOTlOWjlaQVE";
                            } else if (material.getSelectedItem().toString().equals("طحالب د.الهام")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguNldCQTNXMGNfYTQ";
                            } else if (material.getSelectedItem().toString().equals("ترشيح نبات وشكل ظاهرى د.الشحات")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguZmU2OS1GeXBTd00";
                            } else if (material.getSelectedItem().toString().equals("ترشيح متقدم د.الشحات")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguTXYzM1VsSS1qelU";
                            } else if (material.getSelectedItem().toString().equals("بكتريا عامة د.صالحة")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRgubUpnSnd0UTllWk0";
                            } else if (material.getSelectedItem().toString().equals("امتحانات ميكروبايولوجى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1OgbZxN1Qt7Os9zgk8vx3s4TiEAR57ygV";
                            } else if (material.getSelectedItem().toString().equals("مقدمة فى علم الحاسب د/وائل فواز")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRgucXo5ZHc5T3N0d00";
                            } else if (material.getSelectedItem().toString().equals("معادلات تفاضلية عادية د.هبة")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFRE5oWHpteTlnRm8";
                            } else if (material.getSelectedItem().toString().equals("توبولوجى د.محمد رمضان")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguRW93UldCdlU4QXM";
                            } else if (material.getSelectedItem().toString().equals("تحليل مركب د.محمد صالح")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFZlZ2OERSRVBKVDA";
                            } else if (material.getSelectedItem().toString().equals("تحليل رياضة 2 د/هبة")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFTW1pdWhqd0txQlk";
                            } else if (material.getSelectedItem().toString().equals("امتحانات قسم رياضة")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFaVhMYjFFMDlEeTA";
                            } else if (material.getSelectedItem().toString().equals("احصاء حيوى د/محمد الشحات")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRgub29taGdWZ2EwbDQ";
                            } else if (material.getSelectedItem().toString().equals("امتحانات كيمياء صناعية")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1XV6UYQd5iMj1-TEoPvajfRqePdyKHOtq";
                            } else if (material.getSelectedItem().toString().equals("نارية")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFUEQtNUZXOWJqdzQ";
                            } else if (material.getSelectedItem().toString().equals("مقدمة فى علم الحاسب د/وائل")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B31vLTnOP-SIV2FfekF5RnFpVEk";
                            } else if (material.getSelectedItem().toString().equals("مقدمة فى علم الحيوان د/رانيا+د/هويدا")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B31vLTnOP-SIVVVqbjVISURyLTg";
                            } else if (material.getSelectedItem().toString().equals("حرارة وخواص1 د/بهجت")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B31vLTnOP-SIeVN5VnJ4cEZBVkE";
                            } else if (material.getSelectedItem().toString().equals("جيولوجيا عامة د/اسماعيل سيد")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B31vLTnOP-SITzV1N3had3hFdUE";
                            } else if (material.getSelectedItem().toString().equals("اسس كيمياء فيزيائية د/شيماء خلف")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B31vLTnOP-SIZzFfOWFlUkpYa3M";
                            } else if (material.getSelectedItem().toString().equals("Structural Geology د.فارس")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B31vLTnOP-SIUzIyNVgzMzdiV2M";
                            } else if (material.getSelectedItem().toString().equals("Remote sensing د.فارس")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFSFJDeV9kbjB6d0k";
                            } else if (material.getSelectedItem().toString().equals("فرقة تالتة ترم اول")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1-fT5hGzujVdWjo4SqV6-Suw2aI6dXdrv";
                            } else if (material.getSelectedItem().toString().equals("عينات صخور ومعادن")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRgucmJ5bWFIXzBRRFU";
                            } else if (material.getSelectedItem().toString().equals("خرائط جيولوجية")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFVF9qMktEU1dMRmM";
                            } else if (material.getSelectedItem().toString().equals("امتحان marine")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFZzU3R1otbHUwOGc";
                            } else if (material.getSelectedItem().toString().equals("امتحانات جيولوجيا")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1ncPXZQ5Uua96VGZC3nSQByt3GMngrvnq?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (material.getSelectedItem().toString().equals("Survey")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFT21IZFFNdDAza3c";
                            } else if (material.getSelectedItem().toString().equals("Sedimentology د.حسن")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFM193WHVJTlFuYlk";
                            } else if (material.getSelectedItem().toString().equals("Microfossils د.حسن")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFSjVySGdCbGhuemM";
                            } else if (material.getSelectedItem().toString().equals("Metamorphic")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFUWUtbzJtR1ZSOE0";
                            } else if (material.getSelectedItem().toString().equals("Introduction of Structural Geology د.حسن")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFRGRlYzVzUmhIMlE";
                            } else if (material.getSelectedItem().toString().equals("Hydrogeology")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1te4KR6RLNiSaGqCmWA-c-3HsPTM2ZTtC";
                            } else if (material.getSelectedItem().toString().equals("Hydrogeochemistry")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/19pUfg8WNBwoVC5naG7LxbepJPExnK0Zy";
                            } else if (material.getSelectedItem().toString().equals("Geophysics د.سعادة")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFYkNvX29BamlPOVk";
                            } else if (material.getSelectedItem().toString().equals("Geophysics Methods")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFSEV2cEFWVy1veGM";
                            } else if (material.getSelectedItem().toString().equals("Electrics د.سعادة")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFQ0NDWFBuWlJseVE";
                            } else if (material.getSelectedItem().toString().equals("Archeological Dating methods 2")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFUGRRWUloN0lfMkk";
                            } else if (material.getSelectedItem().toString().equals("Absolute Dating")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFX294dFF5cG1kUnc";
                            } else if (material.getSelectedItem().toString().equals("حقوق انسان")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1cXTaXur72mmMK9KMI4K1VUK40ShyvOjW";
                            } else if (material.getSelectedItem().toString().equals("General Geology")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1LzCs98WuS3Rhu1mWAY4KLzNPOkjXkUIr";
                            }
                            else if (material.getSelectedItem().toString().equals("Marine Geology")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1yNUjZ_YqxiLQ3MjJmBgYhI0khPQCMmLE";
                            }
                            else if (material.getSelectedItem().toString().equals("Mathematical Analysis")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1KE3EGMQQTyhAiZxFKF0OMuRoHWWWTalL";
                            }
                            else if (material.getSelectedItem().toString().equals("Physical Chemistry")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1VIATyQIJ-qC0HitdiGrM6KLEuVNitjpW";
                            }
                            else if (material.getSelectedItem().toString().equals("Zoology")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1pWUQYAYEXffEO5vqs-xKppXT71XCZPxV";
                            }
                            else if (material.getSelectedItem().toString().equals("ملخص كيمياء حيوى د.وليد")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/182w5-kX6cLynxvoIVS89T6b6CUwALHan";
                            } else if (material.getSelectedItem().toString().equals("امتحانات كيمياء حيوى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1FtkFhC06SKaYNeLiIhZK8NLknD5-Ga6E";
                            } else if (material.getSelectedItem().toString().equals("وراثة خلوية د.احمد عيسى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B9fM-j_4HhpGZEhlc3FkQW1fREU";
                            } else if (material.getSelectedItem().toString().equals("كيمياء حيوى (كربوهيدرات) د.وليد سراج")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B9fM-j_4HhpGazhPVXpRWVFFYm8";
                            } else if (material.getSelectedItem().toString().equals("علم الدم د.عايدة")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0B9fM-j_4HhpGV3ZUTE1IX05iekk";
                            } else if (material.getSelectedItem().toString().equals("علم الدم د.عايدة")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1G5xS8xV6XYswwlDTvZ3OCOIFy-BZ7RRN?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (dep == "Phy" & material.getSelectedItem().toString().equals("others")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1vKXqsIAtzV7C6xwbEPSf3yaII8jHvhtR?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (dep == "MI" & material.getSelectedItem().toString().equals("others")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1ukZbFJq4SQ-XJHw2Hj_UJMPBxTcXpYej?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (dep == "MA" & material.getSelectedItem().toString().equals("others")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1QrAYjjXI-AHkbOeyqJ9NbDZhR93yKUpP?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (dep == "GEO" & material.getSelectedItem().toString().equals("others")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1vvcRuJxlHQ1_S8_yQGY5p1Ntckw5YQWF?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (dep == "FL" & material.getSelectedItem().toString().equals("others")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1vatanntsVjGa524fyEGse53KjAaaI1wX?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (dep == "BC" & material.getSelectedItem().toString().equals("others")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1YHG8KCNC51XEeDNtG8QNklmgHD49rttT?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (dep == "BT" & material.getSelectedItem().toString().equals("others")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1J4N7N5NOrz9C5CCR8U9TsOz96GuVwzoZ?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            }

//                            /*Computers and Information Faculty*/
                        } else if (faculty.getSelectedItem().toString().equals("Computers and Information Faculty")) {
                            if (material.getSelectedItem().toString().equals("Physics1 Dr.Yasser Amoun")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFYWZnaVk3cE56SU0";
                            } else if (material.getSelectedItem().toString().equals("Math1 Dr.Mohamed Ramadan")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFSjN2NnoxTGN2UjA";

                            } else if (material.getSelectedItem().toString().equals("Ch9 Physics")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1xsLLOm7idZLatNs0JEHm1GD4zAg4R-8L?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";

                            } else if (material.getSelectedItem().toString().equals("امتحانات اولى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1Prasgg1gi-ZHjN27pKxJJ6Tfclkb_bxo?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";

                            } else if (material.getSelectedItem().toString().equals("General English Dr.Dosoky")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFZ0NaZUpEMjJ4N0k";

                            } else if (material.getSelectedItem().toString().equals("Programming Dr.Mohammed Ali")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFY01nMlZTTEt6bGM";

                            } else if (material.getSelectedItem().toString().equals("Mathematics2 Dr.Taha El-Garib")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFUWd0UlZDVjA1bFk";

                            } else if (material.getSelectedItem().toString().equals("English writing Dr.Dosoky")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFRUpOTloxN1dydlE";

                            } else if (material.getSelectedItem().toString().equals("Discrete structure Dr.Hussein Sharaf")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFUW1RYUhxVl9HLVE";

                            } else if (material.getSelectedItem().toString().equals("Cables")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1_4TNzdTh-H6GWT-plDMO4clpaISOBUwA";

                            } else if (material.getSelectedItem().toString().equals("Data Communication")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1yexQTZj0ADIPxVtq0akMJZIUeNyNSSbg";

                            } else if (material.getSelectedItem().toString().equals("IP adress")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/12RI9VYznM5tbafheV2VBqFzLgJW25ES_%3Fpli%3D1";

                            } else if (material.getSelectedItem().toString().equals("Is امتحانات")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1uiAfeScfWpFXZdGhC_5toGb-izWTLIO6";

                            } else if (material.getSelectedItem().toString().equals("Laplace transformation")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1l_3IWgxIKVc7wotlFkGE7xA7E3Y0MkUs";

                            } else if (material.getSelectedItem().toString().equals("maths 3 fouri series")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1gTWol5njJaY9YTAj9UMGYTyzqw6bZBaK&service=writely";

                            } else if (material.getSelectedItem().toString().equals("الأعداد المركبة maths 3")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1aa6mv-brReV_cUIShequ7Mekjo2QmqNv&service=writely";

                            } else if (material.getSelectedItem().toString().equals("System analysis")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1PpHQpO7OIfl42aYJ-geHRuJKdDlwAJ3X&service=writely";

                            } else if (material.getSelectedItem().toString().equals("امتحانات دكتور هيثم")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1dSXTZ8mQMjvW86irDapdj5c-wnoSkQvC&service=writely";

                            } else if (material.getSelectedItem().toString().equals("Business adminstartion")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1nCw7vTFEKCfTSAm_R5TBOc9pvW_2arH3";

                            } else if (material.getSelectedItem().toString().equals("definition of Java")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1CnDW5EZXLhpGuQqvhmJHVGICRXl64q4Q&service=writely";

                            } else if (material.getSelectedItem().toString().equals("امتحانات تانية حاسبات")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1Ob72APSF1k8Da_otzmYoUJWTukriDuSw";
                            }
                            /*Education*/
                        } else if (faculty.getSelectedItem().toString().equals("Education Faculty")) {
                            if (material.getSelectedItem().toString().equals("امتحانات اساسى11")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaZVFiN1RTR1JCaXM";
                            } else if (material.getSelectedItem().toString().equals("عينات سيكشن تقسيم مملكة نباتية")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguakJ0cldZbzVzQ0U";
                            } else if (material.getSelectedItem().toString().equals("كيمياء عضوية- د/رضا فتحى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguX3RKc2Itc1NXc3c";
                            } else if (material.getSelectedItem().toString().equals("كيمياء غير عضوية- د/أحمد الشحات")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguZGZ2QmxXXzlrSkk";
                            } else if (material.getSelectedItem().toString().equals("امتحانات اساسى12")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/14OA3mzUO8vp1256Rx8sNa441WGlMDDeB";
                            } else if (material.getSelectedItem().toString().equals("امتحانات اساسى21")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaR0d6NmFrRzVDWVU";
                            } else if (material.getSelectedItem().toString().equals("كيمياء عضوية اليفاتية- د/رضا عبدالعال")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguOE02X3drTmMwSVk";
                            } else if (material.getSelectedItem().toString().equals("كيمياء غير عضوية-فلزات ولافلزات- د/رشا")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguaXlIbFRpUEJXdWc";
                            } else if (material.getSelectedItem().toString().equals("نبات عام- د/الشحات")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaLTVvcEV5SnBfams";
                            } else if (material.getSelectedItem().toString().equals("امتحانات اساسى22")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaMWJrNWV2a0dtWnc";
                            } else if (material.getSelectedItem().toString().equals("امتحانات اساسى31")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1bIZNaQb0jQc9p2bGrZfooJmWRPRZmoUc";
                            } else if (material.getSelectedItem().toString().equals("ملخص فيزياء بيئية")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1-RyhS8hDf1aCfLW5FgLdvjIMdsL1437U";
                            } else if (material.getSelectedItem().toString().equals("امتحانات اساسى32")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1DkXXOBOGSg3EuEgzohJxqgTI8Gb12dXM";
                            } else if (material.getSelectedItem().toString().equals("رياضة عام")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1oFG4QW4vizs_ePVsxhTvU2T1vf1wjBmu";
                            } else if (material.getSelectedItem().toString().equals("امتحانات اساسى لغة عربية+ لغة انجليزية")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFNXp3N1dMNHI2elU";
                            } else if (material.getSelectedItem().toString().equals("تقسيم مملكة نباتية- د/أكرم")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguSUFBdWFucl8zWTA";
                            } else if (material.getSelectedItem().toString().equals("رياضة")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguS2FzRFIwYXdVZEE";
                            } else if (material.getSelectedItem().toString().equals("عينات تقسيم مملكة نباتية- مشترك")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFX3gyTnZMWFVrSnc";
                            } else if (material.getSelectedItem().toString().equals("كيمياء غير عضوية- د/أحمد الشحات.")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguMGY5aWN3UHBubU0";
                            } else if (material.getSelectedItem().toString().equals("امتحانات بيولوجى31")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1JYf0-9neoc2EnhrmpPfP_y1NvAe2l4Us";

                            } else if (material.getSelectedItem().toString().equals("امتحانات تربوىى1")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguc1JhYXhOcUt4dk0";
                            } else if (material.getSelectedItem().toString().equals("حاسب آلى - د/وائل")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguTU1NbmhBSFl2RDA";
                            } else if (material.getSelectedItem().toString().equals("حقوق إنسان")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguUGIzRmNCZTJXelE";
                            } else if (material.getSelectedItem().toString().equals("مبادئ تربية- د/محمد درويش")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFQTFxeWxWNWNqYjA";
                            } else if (material.getSelectedItem().toString().equals("المدرسة والمجتمع- د/نبيل عبدالخالق")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguNHlJRUJ2YlVSTXM";
                            } else if (material.getSelectedItem().toString().equals("المدرسة والمجتمع- د/إيمان عبدالراضى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguMkhaSFctUU9zcms";
                            } else if (material.getSelectedItem().toString().equals("امتحانات تربوىى2")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguMF9NS3AyRVpYLTA";
                            } else if (material.getSelectedItem().toString().equals("حاسب آلى - د/سماح")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguLWRuVUc2NnY1WWM";
                            } else if (material.getSelectedItem().toString().equals("حقوق إنسان")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaY2VMZUhJRmxLQUk";
                            } else if (material.getSelectedItem().toString().equals("سيكولوجية التعلم- د/هشام")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRgualNsbUdITTR2R2s";
                            } else if (material.getSelectedItem().toString().equals("امتحانات تربوىى31")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1iC22T-U3pz0v5gfEinmssTHfcbE0z0sx";
                            } else if (material.getSelectedItem().toString().equals("سيكولوجية ذوى احتياجات خاصة- د/سحر منصور")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguZ0tYb055NXFsVXc";
                            } else if (material.getSelectedItem().toString().equals("طرق تدريس ذوى احتياجات خاصة- د/نجوى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguaUxsa0tGMW5tLWc";
                            } else if (material.getSelectedItem().toString().equals("سيكولوجية التعلم")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFanlMYjZtcnVkbW8";
                            } else if (material.getSelectedItem().toString().equals("محو امية -كل الشعب")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFSjJLRm96NFVhMjA";
                            } else if (material.getSelectedItem().toString().equals("امتحانات طفولة12")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1xdj4k4yKUaxrZINHMWwV-M8-ghhzkzaa";
                            } else if (material.getSelectedItem().toString().equals("حقوق إنسان")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFN1NBZjhxWjFuRkE";
                            } else if (material.getSelectedItem().toString().equals("امتحانات طفولة21")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/14dSiGML71oBjVIusmjqq3j_PnHU8C_7D";
                            } else if (material.getSelectedItem().toString().equals("الثقافة العلمية للأطفال")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFX2hCZkdfWmJfb3M";
                            } else if (material.getSelectedItem().toString().equals("امتحانات طفولة31")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1SjvBgTxnpMCWIjG4T1HIQBQvJDz5t13N";
                            } else if (material.getSelectedItem().toString().equals("تربية عسكرية")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFNW11WEYtRmtpd1U";
                            } else if (material.getSelectedItem().toString().equals("تنشئة اجتماعية")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFcldzQjhuTkxqQ2s";
                            } else if (material.getSelectedItem().toString().equals("علوم متكاملة- د/إيمان شرف")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFaVg3aEgyN3huY3c";
                            } else if (material.getSelectedItem().toString().equals("امتحانات طفولة32")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFR05tdWVaakFqdjA";
                            } else if (material.getSelectedItem().toString().equals("امتحانات ترم اول")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1EkoM8oPMNJcbczaqU0SzxjYqQ7p7XXy3";
                            } else if (material.getSelectedItem().toString().equals("نصوص - د/رحاب سعد")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguZnBCV0RKUnVRdm8";
                            } else if (material.getSelectedItem().toString().equals("نصوص")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFenFPc2RTS1pBb3c&service=writely";
                            } else if (material.getSelectedItem().toString().equals("نصوص - د/رحاب سعد.")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRgua0hPUGtvbEZTaU0";
                            } else if (material.getSelectedItem().toString().equals("امتحانات فرنسى3")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1ROc0pJhzkEfV2NwPHg6tu5S17jbrfdWO";
                            } else if (material.getSelectedItem().toString().equals("عضويةوحيوية - د/رضا فتحى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguaHlGZ080R3d3Y3c";
                            } else if (material.getSelectedItem().toString().equals("عضويةوحركية - د/وليد سراج")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguTmNsak9aaFFSZHc";
                            } else if (material.getSelectedItem().toString().equals("كيمياء غير عضوية - د/احمد الشحات.")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguN2pXV3NLbzdkZG8";
                            } else if (material.getSelectedItem().toString().equals("عينات تقسيم مملكة نباتية- مشترك.")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguRUtSUkUtVGhJTFk";
                            } else if (material.getSelectedItem().toString().equals("كيمياء فيزيائية- د/شيماء خلف.")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguYk1OZGp0ZjNZRmc";
                            } else if (material.getSelectedItem().toString().equals("نبات عام - د/أكرم.")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFOFlCUngySVNxOUk";
                            } else if (material.getSelectedItem().toString().equals("امتحانات تربية كيمياء")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/16_nwRySwklWYSE5RXwubsN00SSjWpaOg";
                            } else if (material.getSelectedItem().toString().equals("كيمياء فيزيائية- د/حسن.")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguTE91ZFlIVjVpTWc";
                            } else if (material.getSelectedItem().toString().equals("كيمياء غير عضوية متجانسة")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguRUdYX3dKV2xQZDg";
                            } else if (material.getSelectedItem().toString().equals("شعر")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaY3Ztb1NmMVlSSjg";
                            } else if (material.getSelectedItem().toString().equals("علم صوتيات- د/شاكر رزق")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguQ2RjWjg0NTJGeHM";
                            } else if (material.getSelectedItem().toString().equals("امتحانات عربى11")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguZUZoam45NU0wREE";
                            } else if (material.getSelectedItem().toString().equals("نحو وصرف")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguVVR3WDV0elZvTzg";
                            } else if (material.getSelectedItem().toString().equals("امتحانات عربى31")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1PvSspe52oNggSepFltlkjdtS5KhcMDe6?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            }



                            /*Petroleum and Mining Engineering Faculty*/
                        } else if (faculty.getSelectedItem().toString().equals("Petroleum and Mining Engineering Faculty")) {
                            if (department.getSelectedItem().toString().equals("Preparatory")) {
                                if (sem == 1) {
                                    if (material.getSelectedItem().toString().equals("Math")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1j7xmwxyomcTWmAiLeOeO2rDQ1wh7e764";

                                    } else if (material.getSelectedItem().toString().equals("استاتيكا")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvdlFreXl1OFlrbnc";

                                    } else if (material.getSelectedItem().toString().equals("التاريخ الهندسي")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvRElmeWFOUUdyRzA";

                                    } else if (material.getSelectedItem().toString().equals("رسم هندسي")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvVGQ3OGc3YnhmeU0";

                                    } else if (material.getSelectedItem().toString().equals("فيزياء1")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvTkhJNDdCSkNDWDQ";

                                    } else if (material.getSelectedItem().toString().equals("كيمياء")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvSFJ1YXp6Y0t6eDQ";
                                    }
                                } else if (sem == 2) {
                                    if (material.getSelectedItem().toString().equals("تكامل")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKveXdnNGFHWVN3ajQ";

                                    } else if (material.getSelectedItem().toString().equals("لغة")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvVE1iX1NXZzZhclE";

                                    } else if (material.getSelectedItem().toString().equals("انتاج")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvelpTWVAzN0xRekk";

                                    } else if (material.getSelectedItem().toString().equals("رسم و إسقاط")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvSnlSODhhSzRneHM";

                                    } else if (material.getSelectedItem().toString().equals("سليدات الديناميكا")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvQVlHbG9tZ2twdzQ";

                                    } else if (material.getSelectedItem().toString().equals("سليدات كهربية و مغناطيسية")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvSGNSZENtSVZMeTQ";
                                    }
                                }
                            } else if (department.getSelectedItem().toString().equals("General")) {
                                if (ye == 1 & sem == 1) {
                                    if (material.getSelectedItem().toString().equals("English")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvMFR3b1NNOVNwNHM";

                                    } else if (material.getSelectedItem().toString().equals("Maths 3")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1j7xmwxyomcTWmAiLeOeO2rDQ1wh7e764";

                                    } else if (material.getSelectedItem().toString().equals("Matlab")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvbnZiRUQtYXFuSEE";

                                    } else if (material.getSelectedItem().toString().equals("Physics")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/13jbMNW2FNQ6yDv56UimEbEtTcZDGdGSV";
                                    } else if (material.getSelectedItem().toString().equals("Material")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1XGOWcCGyyxyMFSPyXc8F9LKD0TvXswVD";
                                    }
                                } else if (ye == 1 & sem == 2) {
                                    if (material.getSelectedItem().toString().equals("Mechanical Drawing")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvQjZ5Zl82UHpvbEE";

                                    } else if (material.getSelectedItem().toString().equals("Maths")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvRjZaMDNrMFlIaVU";

                                    }
                                } else if (ye == 2 & sem == 1) {
                                    if (material.getSelectedItem().toString().equals("Fluid Mechanics")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1kwAyc68isoJjnHDZAX9yWj8nfy4DfElE";

                                    } else if (material.getSelectedItem().toString().equals("Maths")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/10PhCzZN2QCLHFXacy4OH-H8Lgk_3vNwR";

                                    } else if (material.getSelectedItem().toString().equals("English2")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1Mw1bRCPhbbb5_GEMrNpkki9eWM_UEuW_";

                                    }
                                } else if (ye == 2 & sem == 2) {
                                    if (material.getSelectedItem().toString().equals("Computer Engineering")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvWUlkUGFDRzBlbFU";

                                    } else if (material.getSelectedItem().toString().equals("Electrical Engineering")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvRDFoTHBRM0pnVUk";

                                    } else if (material.getSelectedItem().toString().equals("Thermodynamics")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvZGEzYl83eG1mMkU";
                                    }
                                }
                            } else if (department.getSelectedItem().toString().equals("Petroleum Engineering Dept.")) {
                                if (ye == 1 & sem == 1) {
                                    if (material.getSelectedItem().toString().equals("Plane and Topographic Surveying")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1Ig49_DBqWXK7zWDCz6qHKgXRNYHT5OtL";
                                    }
                                } else if (ye == 1 & sem == 2) {
                                    if (material.getSelectedItem().toString().equals("Geology")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvU29WTi1jYXpPcEE";

                                    } else if (material.getSelectedItem().toString().equals("Introduction to Petroleum Engineering")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvaWdodWlnZ1pOdG8";

                                    } else if (material.getSelectedItem().toString().equals("Organic Chemstry")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvMWJsZUM2RE1Gd2s";

                                    } else if (material.getSelectedItem().toString().equals("Physical Chemstry")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvTGM3N2N3eWF5REk";

                                    } else if (material.getSelectedItem().toString().equals("Sustainability and Environmental Education")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvSndlTHJJWDFZT2c";

                                    }
                                } else if (ye == 2 & sem == 1) {
                                    if (material.getSelectedItem().toString().equals("Drilling 1")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1nafWOLBxCfmS4f0fEpw9JSFfGw8ICjwP";

                                    } else if (material.getSelectedItem().toString().equals("Material Science")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1RIqWnb-8haslCQDIbKTrjr9ueBrW2ZmQ";

                                    } else if (material.getSelectedItem().toString().equals("Structural Geology")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1iuwM2XF1x9gZLXtN2JMJ8G3pMhNlblP8";
                                    }

                                } else if (ye == 2 & sem == 2) {
                                    if (material.getSelectedItem().toString().equals("Automatic Control")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvSC16MUttMlpaZ3c";

                                    } else if (material.getSelectedItem().toString().equals("Reservoir Fluids")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvZXJCMTRVWjZRNGs";

                                    } else if (material.getSelectedItem().toString().equals("Civil Engineering")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1Gn55xqcgsFzg4PQeH4wVqUnE1utLVjOu";
                                    }
                                } else if (ye == 3 & sem == 1) {
                                    if (material.getSelectedItem().toString().equals("Computer Applications")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1ncg6J_FYX2ZLXGMY3wbRRSh1T3AqYui3";

                                    } else if (material.getSelectedItem().toString().equals("Geophisics")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1ekAPi3z1fEW7h3PyXchMoQVjn-HKPInX";

                                    } else if (material.getSelectedItem().toString().equals("Hydraulics")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1JVwXNwgiHeVvKeaEUtV5nJWpxlNAYGsK";

                                    } else if (material.getSelectedItem().toString().equals("Production Engineering 1")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1h1l0riyGDPv0t8IMgnMw4sUP0e0q-Du2";

                                    } else if (material.getSelectedItem().toString().equals("Production Equipment")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/13_GKGgJfGk1d25Oussfe0HLnNx2wCIiA";

                                    } else if (material.getSelectedItem().toString().equals("Rock Properties")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1e3uo5KZKhKvNYCHVjBNtPhjo9xkD2QTQ";
                                    } else if (material.getSelectedItem().toString().equals("Exams")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1S5mecx9wpKgBsRM1ouwVR5giH1L0KCoo";
                                    }
                                } else if (ye == 3 & sem == 2) {
                                    if (material.getSelectedItem().toString().equals("Drilling 2")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvNzdqTDlWQUthLTg";

                                    } else if (material.getSelectedItem().toString().equals("Drilling Equipment")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvU1MxVFBvaE9wNVk";

                                    } else if (material.getSelectedItem().toString().equals("Exploration Engineering")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvelZJcGUySElsajA";

                                    } else if (material.getSelectedItem().toString().equals("Language.")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvdGc3TGZtc1ZsUm8";

                                    } else if (material.getSelectedItem().toString().equals("Safety")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvdjRLa2JjbHBaOVE";

                                    } else if (material.getSelectedItem().toString().equals("Well Completion")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvVDhkdkZUWm9iUG8";

                                    } else if (material.getSelectedItem().toString().equals("Sections")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvMml1ZnVWS1VRdzQ";
                                    }
                                } else if (ye == 4 & sem == 1) {
                                    if (material.getSelectedItem().toString().equals("Petroleum Economics")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvWnV3amFmd3ZHN3M";

                                    } else if (material.getSelectedItem().toString().equals("Petroleum Geology")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvLU56aERMWnAtekU";

                                    } else if (material.getSelectedItem().toString().equals("Production Engineering 2")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvY3dkNnFMMG5KQnc";

                                    } else if (material.getSelectedItem().toString().equals("Transportation and Storage of Crude Oil")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvUWlXSzRxaEJoQWc";

                                    } else if (material.getSelectedItem().toString().equals("Well Test")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1k7hyUgcsoXUgZbH0upZsn64c7VADxrGu";
                                    }
                                } else if (ye == 4 & sem == 2) {
                                    if (material.getSelectedItem().toString().equals("Applied Reservoir Engineering")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvWWJiOUR4SlBzUXc";

                                    } else if (material.getSelectedItem().toString().equals("Enhanced Oil Recovery (EOR)")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvWjI0UWR2cmRnYjg";

                                    } else if (material.getSelectedItem().toString().equals("Environmental Control in Oil and Gas Industry")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvSTNFQlNLZ0xBY3M";

                                    } else if (material.getSelectedItem().toString().equals("Natural Gas Engineering")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvYjlYcWxYOVFNZDg";

                                    } else if (material.getSelectedItem().toString().equals("Well Logging")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvTzRqYlYzTjUwelU";
                                    }
                                }
                            } else if (department.getSelectedItem().toString().equals("Refining Engineering Dept.")) {
                                if (ye == 1 & sem == 1) {
                                    if (material.getSelectedItem().toString().equals("مدخل تكرير")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/0B_yTOPHqjRKvZEx1UmxmZVdMZms";
                                    }
                                } else if (ye == 1 & sem == 2) {
                                    if (material.getSelectedItem().toString().equals("Physical Chemsrty")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvellBUTA3ckx3bFk";
                                    }
                                } else if (ye == 2 & sem == 1) {
                                    if (material.getSelectedItem().toString().equals("Petroleum Evaluation")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvNWNZRklUVXFKSzg";

                                    } else if (material.getSelectedItem().toString().equals("Unit Operations 1")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1wHvrFmSIBMl1AI9b3vjG-C-Q_mOxP5Aa";

                                    } else if (material.getSelectedItem().toString().equals("Civil Engineering")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/10mADD1MP_Mj_1S0x4sjKQX-t2CeebDEX";
                                    }
                                } else if (ye == 2 & sem == 2) {
                                    if (material.getSelectedItem().toString().equals("Corrosion")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvYk9kQTFFblB0Rnc";

                                    } else if (material.getSelectedItem().toString().equals("تفاعلات")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvYnpCOEtrZnlYcEk";
                                    }
                                } else if (ye == 3 & sem == 1) {
                                    if (material.getSelectedItem().toString().equals("Refining Engineering")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1tDq8CKbazECZfTcCsAcgnQNvkIzyvOTJ";

                                    } else if (material.getSelectedItem().toString().equals("تفاعلات مشتركة")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1vBFHnc6gUGtIFhw2bZ-oiH3vQNBvGHvB";

                                    } else if (material.getSelectedItem().toString().equals("اختبار مواد")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1eBcWnkmhfA-QuQGWFeErHsCpaeWaThXo";

                                    } else if (material.getSelectedItem().toString().equals("Safety.")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1iN_ZTL1JKQp66delBJkeNqgiHxge9KJe";

                                    } else if (material.getSelectedItem().toString().equals("Transportation and Storage")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1sMBmHfaF_-lmtG5_Up8KYRUxhP3IlY2Z";

                                    } else if (material.getSelectedItem().toString().equals("Units Operations 2")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1oygpvZ-BhOFgv1K-d_oiiC9V3YA7ap1r";
                                    }
                                } else if (ye == 3 & sem == 2) {
                                    if (material.getSelectedItem().toString().equals("English.")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvWE5TNXpfOVE4VU0";

                                    } else if (material.getSelectedItem().toString().equals("Gas Engineering 1")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvam9nNjJXT1cxOEk";

                                    } else if (material.getSelectedItem().toString().equals("Heat Transfer")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvczBfWWgxQ2tkYm8";

                                    } else if (material.getSelectedItem().toString().equals("Petrochemical Industry 1")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKveEdlMzZPV05HMjA";

                                    } else if (material.getSelectedItem().toString().equals("Pollution Control")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvS2J0SEFndjVGbWM";
                                    }
                                } else if (ye == 4 & sem == 1) {
                                    if (material.getSelectedItem().toString().equals("Design")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvMTl0RUhNTFF3elk";

                                    } else if (material.getSelectedItem().toString().equals("Natural Gas")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvZWdNcXhPWDJUQ1U";

                                    } else if (material.getSelectedItem().toString().equals("Petrochemical Industry 2")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvb0ZIUEdaQ3VRM3c";

                                    } else if (material.getSelectedItem().toString().equals("Process Control")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvbl93VmhoeF9EaHM";

                                    } else if (material.getSelectedItem().toString().equals("معالجة المواد البترولية")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvZF9FVTc2Q0NiajA";
                                    }
                                } else if (ye == 4 & sem == 2) {
                                    if (material.getSelectedItem().toString().equals("Refining Engineering 2")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvUlNuZnEzdlhmQlk";

                                    } else if (material.getSelectedItem().toString().equals("اقتصاديات")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvMFNvX0twSFJKZ1E";

                                    } else if (material.getSelectedItem().toString().equals("تصميم أفران")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvWEpVc29BVkdJTXM";

                                    } else if (material.getSelectedItem().toString().equals("تصميم أمثل")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvOEMtTTdJZEcwZlU";

                                    } else if (material.getSelectedItem().toString().equals("تطبيقات حاسب")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/folders/0B_yTOPHqjRKvQW1SZFY0MG5JUEE";
                                    }
                                }
                            } else if (department.getSelectedItem().toString().equals("Petroleum Production and Exploration Program")) {
                                if (material.getSelectedItem().toString().equals("Crude Oil Evaluation")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/0B_yTOPHqjRKvaU1jeFVTcUJmQlU";

                                } else if (material.getSelectedItem().toString().equals("Horizontal Drilling")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/0B_yTOPHqjRKvd21qcUp0VmhSR1E";
                                } else if (material.getSelectedItem().toString().equals("Strength")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1TE6jqv3ac4IRqwPR1qaAmkhTFjrB5ht-";
                                } else if (material.getSelectedItem().toString().equals("Rock Mechanics")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1yQcUHJs0hiZoUhvlh3eRsp1zZSkl4Y51";
                                } else if (material.getSelectedItem().toString().equals("Reservoir Rock")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1qT6S5_5kRaAxLPcQ4C1ZJ9qYHf9NUE7T";
                                } else if (material.getSelectedItem().toString().equals("Production2")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1caAgFgzFCYht-lquzZllrAGBOz83aTOO";
                                } else if (material.getSelectedItem().toString().equals("Physical Chemistry")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1wiILkKNMt1agoE22ExcbYhpJKDAA6R3U";
                                } else if (material.getSelectedItem().toString().equals("Petroleum Geology")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1RADe78eVg4p4MKn3BTDU0PN8byf5qTmE";
                                } else if (material.getSelectedItem().toString().equals("Petroleum Economics")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1_LHLriwXl9ZT3ZpQ3tqHXDPLw3IiKfXv";
                                } else if (material.getSelectedItem().toString().equals("NG Processing")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1J2MGiBxM_VJbQXrZw2StMbcJE6VO-EFz";
                                } else if (material.getSelectedItem().toString().equals("Matlab")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1gflN1oTwZNspxewtfu4y0QVE2lyb3pIK";
                                } else if (material.getSelectedItem().toString().equals("Math")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/18kg56CpmiHeiitRPP8fy_sTzAk87Uu0V";
                                } else if (material.getSelectedItem().toString().equals("Jop morals")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1YAF2XeUZcuBSKyDCDO6ahyjvXpCbGidm";
                                } else if (material.getSelectedItem().toString().equals("Gas Treatment")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1aMN_oWBV62a93nrfh9-JYhdp0nG03wvL";
                                } else if (material.getSelectedItem().toString().equals("Fluid Reservoir")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1kJbbIoVOZI1P5lMHAuLqtS-nVVtIYP1n";
                                } else if (material.getSelectedItem().toString().equals("Fluid Mechanics")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1YhItF-7t1JGndU2Z2m4zyQD3y_cY_CGY";
                                } else if (material.getSelectedItem().toString().equals("EOR")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/13j1QjPznlyoR-XdO2OLRAOKT2mMVltbP";
                                } else if (material.getSelectedItem().toString().equals("English 2")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1UpXX3w-9VOseURG_ETuGQSCzO7N6ul8r";
                                } else if (material.getSelectedItem().toString().equals("English")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1EPH-Ci9Rayb1hzgAslAAaWmm-8OZI3Ns";
                                } else if (material.getSelectedItem().toString().equals("Drilling")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1HXjCFBCKKJ1ZQOitew9MNZpcB1Yv3Uh6";
                                } else if (material.getSelectedItem().toString().equals("Corrosion")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1ymENOp7Z-2KJahi6AgCRNzUphDuuzahW";
                                } else if (material.getSelectedItem().toString().equals("Computer Applications")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1wSvqORPEnRJvaMBd67PnDkJfEgsEsRvr";
                                } else if (material.getSelectedItem().toString().equals("circuits")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1KauchBdMoNiZ1wetW0U6k9xiWQ7ec6w8";
                                } else if (material.getSelectedItem().toString().equals("Automatic control")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1aIeopZHa5c_Cp1YE3GYdyJzPAVtZnt00";
                                } else if (material.getSelectedItem().toString().equals("Analytical Chemistry")) {
                                    goButton.setVisibility(View.VISIBLE);
                                    ur = "https://drive.google.com/drive/u/2/folders/1p1Pif2sWRv23RjFANrffviKaQkX2qJLv";
                                }
                            } else if (department.getSelectedItem().toString().equals("Geology Dept.")) {
                                if (ye == 1 & sem == 1) {
                                    if (material.getSelectedItem().toString().equals("General Geology")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1Z-nIPesWPAwlEOi66QddKfMHYw_aWK_m";
                                    }
                                } else if (ye == 1 & sem == 2) {
                                    if (material.getSelectedItem().toString().equals("Mineralogy Survey")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/10vI9_YKPL-rJe7__DceOqOnmjd93yr6b";
                                    }
                                } else if (ye == 2 & sem == 1) {
                                    if (material.getSelectedItem().toString().equals("Geodesy Survey")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1mVyQRBfEDNq5zVa2OVYOGUl-uQkd_l12";
                                    } else if (material.getSelectedItem().toString().equals("Sedimentology")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1YZHnBttHWGqXa6jeQHaHSc7K-rDsyqqV";
                                    } else if (material.getSelectedItem().toString().equals("Solid Mechanics")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1L3xivx7_Ech0pGeDI1BUxuOHbapgZNgh";
                                    }
                                } else if (ye == 2 & sem == 2) {
                                    if (material.getSelectedItem().toString().equals("Civil Engineering")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1c5wh3kuD2uPpOM6S5fyn6a4ORDiUwOgo";
                                    } else if (material.getSelectedItem().toString().equals("Structural Geology")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1NjLI4qa6dsp2WN1O80gyn7XUTeMaHIHC";
                                    } else if (material.getSelectedItem().toString().equals("Structural Theory")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1qQXXH8LzTf4HTi-G8hFrYzs9w0k-Fuk7";
                                    }
                                } else if (ye == 3 & sem == 1) {
                                    if (material.getSelectedItem().toString().equals("Geophysics")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1APw7Vg_z5SQoCejHRWN0GTnw-tmsRipb";

                                    } else if (material.getSelectedItem().toString().equals("Hydrology")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1jbRk1k8xEeemFYXnUsdkYkxp6utkxDGV";

                                    } else if (material.getSelectedItem().toString().equals("Petroleum Geology")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1NiVjepxFLSS7EoSi1ro3HaPoksjgH6Xl";

                                    } else if (material.getSelectedItem().toString().equals("Petrophysics")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1sooNxXda4ckLAcCEZp9SmGNWO4rsGDpB";

                                    } else if (material.getSelectedItem().toString().equals("Enviroment")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1menxqsHVcd_BDPj9zm6dlzdZQwIdBLaE";

                                    } else if (material.getSelectedItem().toString().equals("Ground Water")) {
                                        goButton.setVisibility(View.VISIBLE);
                                        ur = "https://drive.google.com/drive/u/2/folders/1CbKk6CxxJJF7hRNDQIZ18usTEHQ21_V4";

                                    }
                                }
                            }


                            /*Arts and Humanities Science Faculty*/
                        } else if (faculty.getSelectedItem().toString().equals("Arts and Humanities Science Faculty")) {
                            if (material.getSelectedItem().toString().equals("ادب انجليزى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFTDBDY1ByZU9Ndzg";

                            } else if (material.getSelectedItem().toString().equals("امتحانات")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1hn3W0fyGe9k_06jNNQ-Mm1ZIQfS293Kh&service=writely";

                            } else if (material.getSelectedItem().toString().equals("جغرافيا غرب اوربا")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFZlZSakdERS1sVXc";


                            } else if (material.getSelectedItem().toString().equals("phonotics-صوتيات1")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFdzgtQ0RIT01YUU0";


                            } else if (material.getSelectedItem().toString().equals("لغه فرنسيه")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFVk55d0hGUTJFckk";


                            } else if (material.getSelectedItem().toString().equals("تاريخ غرب اوربا")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFUkFZQktWc0lMZEE";


                            } else if (material.getSelectedItem().toString().equals("حضاره-civilization")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFVzJCbmRPUG9vLXM";


                            } else if (material.getSelectedItem().toString().equals("لغه عربيه")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFaTRlVmtkakFkRXc";


                            } else if (material.getSelectedItem().toString().equals("من الادب الانجليزى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFdURmdmpiUjlsQUk&service=writely";


                            } else if (material.getSelectedItem().toString().equals("drama(shakespearean drama)")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFOFRTVnl6TlZxUDA";


                            } else if (material.getSelectedItem().toString().equals("poetry")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFR0N6ajUzUjBSM1U?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";


                            } else if (material.getSelectedItem().toString().equals("امتحانات انجليزى ترم اول")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1nYLrDf7K6Oq0PenvY9E1HbwSa_c8wx6I";


                            } else if (material.getSelectedItem().toString().equals("phonotics-صوتيات2")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFR1JwX2pyMFM3Ykk";


                            } else if (material.getSelectedItem().toString().equals("essay writing")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFSVBlRTB0LXBKT2c";


                            } else if (material.getSelectedItem().toString().equals("novel")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFMk9GR3dEeDNNNDQ";


                            } else if (material.getSelectedItem().toString().equals("حضاره")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFbGVDQkhwbTA5M28";


                            } else if (material.getSelectedItem().toString().equals("د/شاكر رزق")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/18wcf5cwC6ZaPIQesj-7tq8gh18KbtCyi";

                            } else if (material.getSelectedItem().toString().equals("civilization - د/مازن")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1GNR4is0DEslITUVSE6mlQsodOHKrezjF";

                            } else if (material.getSelectedItem().toString().equals("Drama - د/امانى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1JJwdjDqkNzNosCszGtuoyiWXzvuWhlQ7";

                            } else if (material.getSelectedItem().toString().equals("Grammer")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1o2aUZz41yXprGU0qK7I7Kt0c7zSSLfW1";
                            } else if (material.getSelectedItem().toString().equals("Poetry - د/وفاء")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1NkMDm3mklTh4vUjRoA3N-7XRKD-2DbjZ";
                            } else if (material.getSelectedItem().toString().equals("ترجمة - د/مازن")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1ZLKLR9I2QGK1irwVs_07ENXgtiYVrZDE";
                            } else if (material.getSelectedItem().toString().equals("نقد - د/محمد عبد الوهاب")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1u9SOeC-ceMb89Ha9_b4Ih6bpzyzo1KcA";
                            } else if (material.getSelectedItem().toString().equals("لاتينى د/احمد فهمى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1RvLOWclLhnuB2Wx1QvxTPSjAdYJ-gnft";
                            } else if (material.getSelectedItem().toString().equals("poetry - د/وفاء")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1yFfmY0T79lRWfjEiiCDEjB0K8pw4Cl8O?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (material.getSelectedItem().toString().equals("Arabic د/نيازى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1Y8xSmeLWy4rHJdQzIcEerxkOJGm0Kkng?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (material.getSelectedItem().toString().equals("Novel دامانى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1Cygama4wYxmtpvwlLQ8eCE418eq_-obo?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            } else if (material.getSelectedItem().toString().equals("grammer")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFVU90V2VwWWdXemc";


                            } else if (material.getSelectedItem().toString().equals("امتحانات اولى فرنساوى ترم اول")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguSHNYNDd5YWt3a0k&service=writely";


                            } else if (material.getSelectedItem().toString().equals("تعبير كتابى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaTWZva1JTY0RuOWc";


                            } else if (material.getSelectedItem().toString().equals("صوتيات")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1HiJsGLlWEZcJdZsbTW0pIojGDn2AtLp6";


                            } else if (material.getSelectedItem().toString().equals("امتحانات اولى فرنساوى ترم تانى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguS1FnbDFRZ1REUGs&service=writely";


                            } else if (material.getSelectedItem().toString().equals("حضاره د/دعاء")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaTGdUVzFnRWFPS1U&service=writely";

                            } else if (material.getSelectedItem().toString().equals("حضاره د/منى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaT2phbUFIREZYYkU&service=writely";


                            } else if (material.getSelectedItem().toString().equals("عربى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaTXlNVVFoeVFIbUU&service=writely";


                            } else if (material.getSelectedItem().toString().equals("قراءه د/ابراهيم")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaOHJuOGxVWndTZ0k";


                            } else if (material.getSelectedItem().toString().equals("محادثه د/ عبده")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaNG1NdTNqdEdoNHc&service=writely";


                            } else if (material.getSelectedItem().toString().equals("نصوص د/ منى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaaW5scTFuT2JUUE0";

                            } else if (material.getSelectedItem().toString().equals("grammer2")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1euGclMaWbKTSzS1ABtc5jt9cjVf4A2oy?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";


                            } else if (material.getSelectedItem().toString().equals("امتحانات1")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguNE0yRl81R1dwUTQ";


                            } else if (material.getSelectedItem().toString().equals("امتحانات2")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1w3BDN29exg0v6t2ZVZ7QoRRon_nvHzT1&service=writely";


                            } else if (material.getSelectedItem().toString().equals("امتحانات3")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1-c-aKiFwclBdA2Xjoonql5Nb1zqQ2I4-?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";


                            } else if (material.getSelectedItem().toString().equals("امتحانات تانية فرنساوى ترم تانى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0ByJz1l2rodbFSmJfcTRidzdWa28";


                            } else if (material.getSelectedItem().toString().equals("قواعد3 فرنسى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1AaK_7gwtBGyz-b2LkUw_mKP-McJ9ipbQ%3Ffbclid%3DIwAR3rO_i5dDk4VZCBbxAYBJ5yRvYpzzl6cj5WB9Q60_0k5kHV-litSXMT_yY";


                            } else if (material.getSelectedItem().toString().equals("اخلاق - د/محروس")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRgudXhJTUFHbXNteUU";


                            } else if (material.getSelectedItem().toString().equals("تفكير علمى-د/منتصر")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguR3NFc20yczNRSms";

                            } else if (material.getSelectedItem().toString().equals("رياضه")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguNmcydkVqYmJ3RG8";


                            } else if (material.getSelectedItem().toString().equals("سياسه د/منتصر")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguaEpZekhHS3VXN2c";

                            } else if (material.getSelectedItem().toString().equals("علم الكلام د/منتصر")) {

                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRguOEg5cUsyYzFhaGM";
                                goButton.setVisibility(View.VISIBLE);
                            } else if (material.getSelectedItem().toString().equals("الاسس النظريه")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmadEtrenFDZkhjWjQ";


                            } else if (material.getSelectedItem().toString().equals("امتحانات علم اجتماع")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0Bx1TXZ-UjRgudS1Rb3RpQU43LVE&service=writely";

                            } else if (material.getSelectedItem().toString().equals("تاريخ الفكر الاجتماعى")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaZVQ4X18xQ1phbkU";


                            } else if (material.getSelectedItem().toString().equals("جغرافيا عامه")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaX0lYQXFUXzBQVTA&service=writely";

                            } else if (material.getSelectedItem().toString().equals("فلسفه عامه")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmabTZiSW5ZNVF3RHc";


                            } else if (material.getSelectedItem().toString().equals("لغه عربيه")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaM2ZvMno3dlZ2Vms";


                            } else if (material.getSelectedItem().toString().equals("مدخل فى علم الاجتماع")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1r7q3pqn16jwN7u8RoMxwPkAJ5WCFbhXv";


                            } else if (material.getSelectedItem().toString().equals("الاحصاء")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaZDhpTHBIcXlReU0&service=writely";

                            } else if (material.getSelectedItem().toString().equals("انثروبولوجيا")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaRk92VVBNbE1kc28&service=writely";

                            } else if (material.getSelectedItem().toString().equals("بناء المجتمع ونظمه")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaWmtaRk9naVdSWnc";


                            } else if (material.getSelectedItem().toString().equals("علم السكان")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6Vmaem9TdGYwVDBWUnc&service=writely";

                            } else if (material.getSelectedItem().toString().equals("علم النفس")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaZzlLeGhzWjNyX0k";

                            } else if (material.getSelectedItem().toString().equals("لغه انجليزيه")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/0BzYYW8dU6VmaeWNITF96VXd6b2M";

                            } else if (material.getSelectedItem().toString().equals("امتحانات ترم اول")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/1nwZxToYr7QGDcatbX0aqrKrh7P2HgWrW";
                            } else if (material.getSelectedItem().toString().equals("امتحانات فرقة اولى جغرافيا")) {
                                goButton.setVisibility(View.VISIBLE);
                                ur = "https://drive.google.com/drive/folders/14VKt2K9_b_0ZKmZaRxzi7wB3et7-Iwtj?fbclid=IwAR3px6va_7HLKy4r9X9sk-ZaQW_eUaTFqZ7jboyKUn8xc34O51hc1AdwbB4";
                            }
                        }
                    }


                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
//
//
        goButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mozakra.this, webView.class);
                intent.putExtra("url", ur);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}