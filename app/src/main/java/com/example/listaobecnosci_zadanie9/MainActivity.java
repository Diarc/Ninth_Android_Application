package com.example.listaobecnosci_zadanie9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String [] classes = {"Matematyka", "Fizyka", "Historia"};
    Spinner ClassesSpinner;
    CheckBox FirstPerson;
    CheckBox SecondPerson;
    CheckBox ThirdPerson;
    CheckBox FourthPerson;
    CheckBox FifthPerson;
    CheckBox SixthPerson;
    Button CheckListButton;
    Button SaveButton;
    Button RefreshButton;
    Button ComeBackButton;
    TextView MathList;
    TextView FizList;
    TextView HisList;
    TextView PrzedmiotyTextView;
    TextView ListaStudentówTextView;
    DatabaseHelper myDB;
    int ListOfActiveStudentsOfMath = 0;
    int ListOfActiveStudentsOfFIZ = 0;
    int ListOfActiveStudentsOfHIS = 0;
    List <String> activeStudentsMath = new ArrayList<String>();
    List <String> activeStudentsFIZ = new ArrayList<String>();
    List <String> activeStudentsHIS = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //define UI elements
        FirstPerson= (CheckBox) findViewById(R.id.FirstPersonCheckBox);
        SecondPerson= (CheckBox) findViewById(R.id.SecondPersonCheckBox);
        ThirdPerson= (CheckBox) findViewById(R.id.ThirdPersonCheckBox);
        FourthPerson= (CheckBox) findViewById(R.id.FourthPersonCheckBox);
        FifthPerson= (CheckBox) findViewById(R.id.FifthPersonCheckBox);
        SixthPerson= (CheckBox) findViewById(R.id.SixthPersonCheckBox);
        MathList = (TextView) findViewById(R.id.MathList);
        FizList =(TextView) findViewById(R.id.FizList);
        HisList =(TextView) findViewById(R.id.HisList);
        CheckListButton = (Button) findViewById(R.id.CheckListButton);
        SaveButton = (Button) findViewById(R.id.SaveButton);
        RefreshButton = (Button) findViewById(R.id.RefreshButton);
        ComeBackButton = (Button) findViewById(R.id.ComebackButton);
        PrzedmiotyTextView = (TextView) findViewById(R.id.TextViewPrzedmiot);
        ListaStudentówTextView = (TextView) findViewById(R.id.textViewListyStudentow);

        //add users to DB

        myDB = new DatabaseHelper(this);
        myDB.clearDB();
        myDB.addMan(new Man("Kamil","Warczak","Matematyka"));
        myDB.addMan(new Man("Piotr","Kalmar","Matematyka"));
        myDB.addMan(new Man("Sebastian","Smuda","Matematyka"));
        myDB.addMan(new Man("Sylwia","Groch","Matematyka"));
        myDB.addMan(new Man("Zbyszek","Smaczek","Matematyka"));
        myDB.addMan(new Man("Gracjan","Obiad","Matematyka"));

        myDB.addMan(new Man("Władysław","Krzyż","Fizyka"));
        myDB.addMan(new Man("Jarosław","Pran","Fizyka"));
        myDB.addMan(new Man("Zuzanna","Kran","Fizyka"));
        myDB.addMan(new Man("Krystian","Koralik","Fizyka"));
        myDB.addMan(new Man("Bartosz","Krzywoń","Fizyka"));
        myDB.addMan(new Man("Szymon","Krzak","Fizyka"));

        myDB.addMan(new Man("Alicja","Melin","Historia"));
        myDB.addMan(new Man("Lidia","Monroue","Historia"));
        myDB.addMan(new Man("Bogusława","Gracham","Historia"));
        myDB.addMan(new Man("Hieronim","Krokodyl","Historia"));
        myDB.addMan(new Man("Gabriel","Pralka","Historia"));
        myDB.addMan(new Man("Franciszek","Kiks","Historia"));



        //assign subjects to spinner
        ClassesSpinner= (Spinner) findViewById(R.id.SpinnerPrzedmiotów);
        ArrayAdapter<String> subjectsAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, classes);
        ClassesSpinner.setAdapter(subjectsAdapter);
        ClassesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(ClassesSpinner.getSelectedItem().toString()=="Matematyka")
                {
                    FirstPerson.setVisibility(View.VISIBLE);
                    SecondPerson.setVisibility(View.VISIBLE);
                    ThirdPerson.setVisibility(View.VISIBLE);
                    FourthPerson.setVisibility(View.VISIBLE);
                    FifthPerson.setVisibility(view.VISIBLE);
                    SixthPerson.setVisibility(view.VISIBLE);
                    CheckListButton.setVisibility(View.VISIBLE);
                    MathList.setVisibility(View.INVISIBLE);
                    FizList.setVisibility(View.INVISIBLE);
                    HisList.setVisibility(View.INVISIBLE);
                    RefreshButton.setVisibility(View.INVISIBLE);

                    FirstPerson.setText("Kamil Warczak");
                    SecondPerson.setText("Piotr Kalmar");
                    ThirdPerson.setText("Sebastian Smuda");
                    FourthPerson.setText("Sylwia Groch");
                    FifthPerson.setText("Zbyszek Smaczek");
                    SixthPerson.setText("Gracjan Obiad");
                }
                else if(ClassesSpinner.getSelectedItem().toString()=="Fizyka")
                {
                    FirstPerson.setVisibility(View.VISIBLE);
                    SecondPerson.setVisibility(View.VISIBLE);
                    ThirdPerson.setVisibility(View.VISIBLE);
                    FourthPerson.setVisibility(View.VISIBLE);
                    FifthPerson.setVisibility(view.VISIBLE);
                    SixthPerson.setVisibility(view.VISIBLE);
                    CheckListButton.setVisibility(View.VISIBLE);
                    MathList.setVisibility(View.INVISIBLE);
                    FizList.setVisibility(View.INVISIBLE);
                    HisList.setVisibility(View.INVISIBLE);
                    RefreshButton.setVisibility(View.INVISIBLE);


                    FirstPerson.setText("Władysław Krzyż");
                    SecondPerson.setText("Jarosław Pran");
                    ThirdPerson.setText("Zuzanna Kran");
                    FourthPerson.setText("Krystian Koralik");
                    FifthPerson.setText("Bartosz Krzywoń");
                    SixthPerson.setText("Szymon Krzak");
                }
                else if (ClassesSpinner.getSelectedItem().toString()=="Historia")
                {
                    FirstPerson.setVisibility(View.VISIBLE);
                    SecondPerson.setVisibility(View.VISIBLE);
                    ThirdPerson.setVisibility(View.VISIBLE);
                    FourthPerson.setVisibility(View.VISIBLE);
                    FifthPerson.setVisibility(view.VISIBLE);
                    SixthPerson.setVisibility(view.VISIBLE);
                    CheckListButton.setVisibility(View.VISIBLE);
                    MathList.setVisibility(View.INVISIBLE);
                    FizList.setVisibility(View.INVISIBLE);
                    HisList.setVisibility(View.INVISIBLE);
                    RefreshButton.setVisibility(View.INVISIBLE);

                    FirstPerson.setText("Alicja Melin");
                    SecondPerson.setText("Lidia Monroue");
                    ThirdPerson.setText("Bogusława Gracham");
                    FourthPerson.setText("Hieronim Krokodyl");
                    FifthPerson.setText("Gabriel Pralka");
                    SixthPerson.setText("Franciszek Kiks");
                }
                else if (ClassesSpinner.getSelectedItem().toString()=="przejrzenie listy obecności")
                {
                    FirstPerson.setVisibility(View.INVISIBLE);
                    SecondPerson.setVisibility(View.INVISIBLE);
                    ThirdPerson.setVisibility(View.INVISIBLE);
                    FourthPerson.setVisibility(View.INVISIBLE);
                    FifthPerson.setVisibility(view.INVISIBLE);
                    SixthPerson.setVisibility(view.INVISIBLE);
                    CheckListButton.setVisibility(View.INVISIBLE);
                    MathList.setVisibility(View.VISIBLE);
                    FizList.setVisibility(View.VISIBLE);
                    HisList.setVisibility(View.VISIBLE);
                    RefreshButton.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        CheckListButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirstPerson.setVisibility(View.INVISIBLE);
                SecondPerson.setVisibility(View.INVISIBLE);
                ThirdPerson.setVisibility(View.INVISIBLE);
                FourthPerson.setVisibility(View.INVISIBLE);
                FifthPerson.setVisibility(view.INVISIBLE);
                SixthPerson.setVisibility(view.INVISIBLE);

                CheckListButton.setVisibility(View.INVISIBLE);
                SaveButton.setVisibility(View.INVISIBLE);
                ListaStudentówTextView.setVisibility(View.INVISIBLE);
                PrzedmiotyTextView.setVisibility(View.INVISIBLE);
                ClassesSpinner.setVisibility(View.INVISIBLE);

                MathList.setVisibility(View.VISIBLE);
                FizList.setVisibility(View.VISIBLE);
                HisList.setVisibility(View.VISIBLE);
                RefreshButton.setVisibility(View.VISIBLE);
                ComeBackButton.setVisibility(View.VISIBLE);
            }
        });

        RefreshButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                activeStudentsMath.clear();
                activeStudentsFIZ.clear();
                activeStudentsHIS.clear();
                String StudentsListMath = "Ilośc obecnych osób:0 "  + "\nObecne osoby: " + activeStudentsMath;
                String StudentsListFiz = "Ilośc obecnych osób:0 " +  "\nObecne osoby: " + activeStudentsFIZ;
                String StudentsListHis = "Ilośc obecnych osób:0 " + "\nObecne osoby: " + activeStudentsHIS;
                MathList.setText(StudentsListMath);
                FizList.setText(StudentsListFiz);
                HisList.setText(StudentsListHis);
                ListOfActiveStudentsOfMath = 0;
                ListOfActiveStudentsOfFIZ = 0;
                ListOfActiveStudentsOfHIS = 0;
            }
        });

        ComeBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirstPerson.setVisibility(View.VISIBLE);
                SecondPerson.setVisibility(View.VISIBLE);
                ThirdPerson.setVisibility(View.VISIBLE);
                FourthPerson.setVisibility(View.VISIBLE);
                FifthPerson.setVisibility(view.VISIBLE);
                SixthPerson.setVisibility(view.VISIBLE);

                SaveButton.setVisibility(View.VISIBLE);
                CheckListButton.setVisibility(View.VISIBLE);
                ListaStudentówTextView.setVisibility(View.VISIBLE);
                PrzedmiotyTextView.setVisibility(View.VISIBLE);
                ClassesSpinner.setVisibility(View.VISIBLE);

                MathList.setVisibility(View.INVISIBLE);
                FizList.setVisibility(View.INVISIBLE);
                HisList.setVisibility(View.INVISIBLE);
                RefreshButton.setVisibility(View.INVISIBLE);
                ComeBackButton.setVisibility(View.INVISIBLE);
            }
        });

        SaveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (FirstPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Matematyka" )
                {
                    if(activeStudentsMath.size()<6) {
                        ListOfActiveStudentsOfMath++;
                        activeStudentsMath.add(FirstPerson.getText().toString());
                    }
                }
                if (SecondPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Matematyka" )
                {
                    if(activeStudentsMath.size()<6) {
                        ListOfActiveStudentsOfMath++;
                        activeStudentsMath.add(SecondPerson.getText().toString());
                    }
                }
                if (ThirdPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Matematyka" )
                {
                    if(activeStudentsMath.size()<6) {
                        ListOfActiveStudentsOfMath++;
                        activeStudentsMath.add(ThirdPerson.getText().toString());
                    }
                }
                if (FourthPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Matematyka" )
                {
                    if(activeStudentsMath.size()<6) {
                        ListOfActiveStudentsOfMath++;
                        activeStudentsMath.add(FourthPerson.getText().toString());
                    }
                }
                if (FifthPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Matematyka" )
                {
                    if(activeStudentsMath.size()<6)
                    {
                        ListOfActiveStudentsOfMath++;
                        activeStudentsMath.add(FifthPerson.getText().toString());
                    }
                }
                if (SixthPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Matematyka" )
                {
                    if(activeStudentsMath.size()<6)
                    {
                        ListOfActiveStudentsOfMath++;
                        activeStudentsMath.add(SixthPerson.getText().toString());
                    }
                }

                if (FirstPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Fizyka" )
                {
                    if(activeStudentsFIZ.size()<6) {
                        ListOfActiveStudentsOfFIZ++;
                        activeStudentsFIZ.add(FirstPerson.getText().toString());
                    }
                }
                if (SecondPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Fizyka" )
                {
                    if(activeStudentsFIZ.size()<6) {
                        ListOfActiveStudentsOfFIZ++;
                        activeStudentsFIZ.add(SecondPerson.getText().toString());
                    }
                }
                if (ThirdPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Fizyka" )
                {
                    if(activeStudentsFIZ.size()<6) {
                        ListOfActiveStudentsOfFIZ++;
                        activeStudentsFIZ.add(ThirdPerson.getText().toString());
                    }
                }
                if (FourthPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Fizyka" )
                {
                    if(activeStudentsFIZ.size()<6) {
                        ListOfActiveStudentsOfFIZ++;
                        activeStudentsFIZ.add(FourthPerson.getText().toString());
                    }
                }
                if (FifthPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Fizyka" )
                {
                    if(activeStudentsFIZ.size()<6)
                    {
                        ListOfActiveStudentsOfFIZ++;
                        activeStudentsFIZ.add(FifthPerson.getText().toString());
                    }
                }
                if (SixthPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Fizyka" )
                {
                    if(activeStudentsFIZ.size()<6)
                    {
                        ListOfActiveStudentsOfFIZ++;
                        activeStudentsFIZ.add(SixthPerson.getText().toString());
                    }
                }

                if (FirstPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Historia" )
                {
                    if(activeStudentsHIS.size()<6) {
                        ListOfActiveStudentsOfHIS++;
                        activeStudentsHIS.add(FirstPerson.getText().toString());
                    }
                }
                if (SecondPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Historia" )
                {
                    if(activeStudentsHIS.size()<6) {
                        ListOfActiveStudentsOfHIS++;
                        activeStudentsHIS.add(SecondPerson.getText().toString());
                    }
                }
                if (ThirdPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Historia" )
                {
                    if(activeStudentsHIS.size()<6) {
                        ListOfActiveStudentsOfHIS++;
                        activeStudentsHIS.add(ThirdPerson.getText().toString());
                    }
                }
                if (FourthPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Historia" )
                {
                    if(activeStudentsHIS.size()<6) {
                        ListOfActiveStudentsOfHIS++;
                        activeStudentsHIS.add(FourthPerson.getText().toString());
                    }
                }
                if (FifthPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Historia" )
                {
                    if(activeStudentsHIS.size()<6)
                    {
                        ListOfActiveStudentsOfHIS++;
                        activeStudentsHIS.add(FifthPerson.getText().toString());
                    }
                }
                if (SixthPerson.isChecked() && ClassesSpinner.getSelectedItem().toString() == "Historia" )
                {
                    if(activeStudentsHIS.size()<6)
                    {
                        ListOfActiveStudentsOfHIS++;
                        activeStudentsHIS.add(SixthPerson.getText().toString());
                    }
                }

                String StudentsListMath = ListOfActiveStudentsOfMath + "/6 uczniów jest obecnych na zajęciach z matematyki." + "\nLista obecnych osób: " + activeStudentsMath;
                String StudentsListFiz = ListOfActiveStudentsOfFIZ + "/6 uczniów jest obecnych na zajęciach z fizyki." + "\nLista obecnych osób: " + activeStudentsFIZ;
                String StudentsListHis = ListOfActiveStudentsOfHIS + "/6 uczniów jest obecnych na zajęciach z historii." + "\nLista obecnych osób: " + activeStudentsHIS;

                MathList.setText(StudentsListMath);
                FizList.setText(StudentsListFiz);
                HisList.setText(StudentsListHis);
            }
        });
    }
}