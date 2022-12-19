package com.example.quizapp;

public class QAnswers {
    public static String question[] ={
            "1. What will be the output of following Java code?",
            "2.  What will be the output of the following C code?",
            "3. What will be the output of following Java code?",
            "4. What will be the output of following Java code?",
            "5. What will be the output of the following C code?"

    };

    public static Integer images[] ={
            R.drawable.quizpic1,
            R.drawable.quizpic2,
            R.drawable.quizpic3,
            R.drawable.quizpic4,
            R.drawable.quizpic5
    };

    public static String choices[][] = {
            {"5","9","8","4"},
            {"20","24","Garbage","Error"},
            {"{10 =Java, 3 =C, 4 =C++, 6 =null, 5 =Ruby}",
                    "{10 =Java, 6 =null, 5 =Ruby, 4 =C++, 3 =C}"
                    ,"{3 =C, 4 =C++, 5 =Ruby, 6 =null, 10 =Java}",
                    "None of these"},
            {"1","No output","8","1357911"},
            {"Grade : A","Grade : B","Grade : C","Grade : D"}

    };

    public static String correctAnswers[] = {
            "8",
            "24",
            "{10 =Java, 6 =null, 5 =Ruby, 4 =C++, 3 =C}",
            "No output",
            "Grade : D"
    };
}
