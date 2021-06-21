package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    private TextView questionTV,questionAttemptedTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    int currentScore = 0, questionAttempted = 0, currentPos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        questionTV = findViewById(R.id.question);
        questionAttemptedTV = findViewById(R.id.questions_attempted);
        option1Btn = findViewById(R.id.option1);
        option2Btn = findViewById(R.id.option2);
        option3Btn = findViewById(R.id.option3);
        option4Btn = findViewById(R.id.option4);
        quizModalArrayList = new ArrayList<>();
        getQuizQuestion(quizModalArrayList);
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())){
                  currentScore++;
                  Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
              }
              else {
                  Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
              }
              questionAttempted++;
              currentPos++;
              setDataToViews(currentPos);
            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                    Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }questionAttempted++;
                currentPos++;
                setDataToViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                    Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }
                questionAttempted++;
                currentPos++;
                setDataToViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                    Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(QuizActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }questionAttempted++;
                currentPos++;
                setDataToViews(currentPos);
            }
        });

    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(QuizActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_result,(LinearLayout)findViewById(R.id.score_dialog));
        TextView scoreTV = bottomSheetView.findViewById(R.id.result);
        Button restart = bottomSheetView.findViewById(R.id.restart);
        Button exit = bottomSheetView.findViewById(R.id.exit);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
        scoreTV.setText("Your Score Is \n"+currentScore+"/10");
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos=0;
                setDataToViews(currentPos);
                questionAttempted=0;
                currentScore=0;
                bottomSheetDialog.dismiss();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    private void setDataToViews(int currentPos){
        questionAttemptedTV.setText("Questions Attempted : "+questionAttempted+"/10");
        if(questionAttempted == 10){
            showBottomSheet();
        }
        else {
            questionTV.setText(quizModalArrayList.get(this.currentPos).getQuestion());
            option1Btn.setText(quizModalArrayList.get(this.currentPos).getOption1());
            option2Btn.setText(quizModalArrayList.get(this.currentPos).getOption2());
            option3Btn.setText(quizModalArrayList.get(this.currentPos).getOption3());
            option4Btn.setText(quizModalArrayList.get(this.currentPos).getOption4());
        }
    }

    private void getQuizQuestion(ArrayList<QuizModal> quizModalArrayList) {
        quizModalArrayList.add(new QuizModal("The trident-shaped symbol of Buddhism does not represent", "Nirvana", "Sangha", "Buddha", "Dhamma", "Nirvana" ));
        quizModalArrayList.add(new QuizModal("The treaty of Srirangapatna was signed between Tipu Sultan and", "Robert Clive", "Cornwallis", "Dalhousie", "Warren Hastings", "Cornwallis" ));
        quizModalArrayList.add(new QuizModal("The system of competitive examination for civil service was accepted in principle in the year", "1833", "1853", "1858", "1882", "1853" ));
        quizModalArrayList.add(new QuizModal("The Vijayanagara ruler, Kirshnadev Raya's work Amuktamalyada, was in", "Telugu", "Sanskrit", "Tamil", "Kannada", "Telugu" ));
        quizModalArrayList.add(new QuizModal("To which king belongs the Lion capital at Sarnath?", "Chandragupta", "Ashoka", "Kanishka", "Harsha", "Ashoka" ));
        quizModalArrayList.add(new QuizModal("Who wrote down the epic Mahabharata while Vyasa was dictating", "Narada", "Vishwakarma", "Ganesh", "Shiv", "Ganesh" ));
        quizModalArrayList.add(new QuizModal("In which of the following dance forms Birju Maharaj attained prominence?", "Sattriya", "Kathak", "Mohiniyattam", "Manipuri", "Kathak" ));
        quizModalArrayList.add(new QuizModal("Who wrote the “Panchatantra”?", "Vishnu Sharma", "Chanakya", "Kālidāsa", "None of these", "Vishnu Sharma" ));
        quizModalArrayList.add(new QuizModal("In reference to the Vedic age, the term 'Pushan' refers", "Protector of cattle", "Gods of storm", "Goddess of eternity", "Goddesses of dawn", "Protector of cattle" ));
        quizModalArrayList.add(new QuizModal("Which one is the longest epic of the world?", "Ramayana", " Ramcharitmanas", "Mahabharata", "Hanuman Chalisa", "Mahabharata" ));
    }

}
