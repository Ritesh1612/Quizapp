package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.quizapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    int totalquizquestions = QAnswers.question.length;
    int currentquestionindex = 0;
    public ConstraintLayout celeb;
    String selectedAns = "";
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvtotalquestion.setText("Total Question: " + totalquizquestions);
        Questions();
        binding.btnoption1.setOnClickListener(this);
        binding.btnoption2.setOnClickListener(this);
        binding.btnoption3.setOnClickListener(this);
        binding.btnoption4.setOnClickListener(this);
        binding.btnnextque.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        binding.btnoption1.setBackgroundDrawable(getDrawable(R.drawable.optbtnshape));
        binding.btnoption2.setBackgroundDrawable(getDrawable(R.drawable.optbtnshape));
        binding.btnoption3.setBackgroundDrawable(getDrawable(R.drawable.optbtnshape));
        binding.btnoption4.setBackgroundDrawable(getDrawable(R.drawable.optbtnshape));

        AppCompatButton clickedbtn = (AppCompatButton) view;

        if (clickedbtn.getId() == R.id.btnnextque) {
            if (selectedAns != "") {
                if (selectedAns.equals(QAnswers.correctAnswers[currentquestionindex])) {
                    points++;
                }
                currentquestionindex++;
                selectedAns = "";
                Questions();
            } else {
                binding.tvalert.setVisibility(View.VISIBLE);
            }

        } else {
            selectedAns = clickedbtn.getText().toString();
            clickedbtn.setBackgroundDrawable(getDrawable(R.drawable.selectedoptbtnshape));
            binding.tvalert.setVisibility(View.INVISIBLE);
        }
    }

    private void Questions() {
        if (currentquestionindex == totalquizquestions) {
            binding.btnnextque.setText("Submit");
            finishquiz();
            return;
        }
        binding.tvquestion.setText(QAnswers.question[currentquestionindex]);
        binding.ivimage.setImageResource(QAnswers.images[currentquestionindex]);
        binding.btnoption1.setText(QAnswers.choices[currentquestionindex][0]);
        binding.btnoption2.setText(QAnswers.choices[currentquestionindex][1]);
        binding.btnoption3.setText(QAnswers.choices[currentquestionindex][2]);
        binding.btnoption4.setText(QAnswers.choices[currentquestionindex][3]);
        YoYo.with(Techniques.SlideInRight).duration(400).repeat(0).playOn(findViewById(R.id.clmain));
    }

    private void finishquiz() {
        binding.tvtotalquestion.setVisibility(View.GONE);
        celeb = binding.incelebration.getRoot();
        celeb.setVisibility(View.VISIBLE);
        binding.clmain.setVisibility(View.GONE);
        String result = "";
        if (points > totalquizquestions * 0.60) {
            result = "Passed";
           binding.incelebration.clpass.setVisibility(View.VISIBLE);
            binding.incelebration.tvresult.setText("Congratulation you " + result + " the quiz");
        } else {
            result = "Failed";
            binding.incelebration.clfailed.setVisibility(View.VISIBLE);
            binding.incelebration.tvres.setText("Sorry you " + result + " the quiz");
            binding.incelebration.tvfailed.setText("Try Again Later");
        }
    }
}