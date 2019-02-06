package com.laperrouse.theo.doubliskit;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class Jouer extends AppCompatActivity {
    public static void affichDes(int nombre,ImageView imageView, boolean noir){
        if(noir){
            switch (nombre) {
                case 1:
                    imageView.setImageResource(R.drawable.des1noir);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.des2noir);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.des3noir);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.des4noir);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.des5noir);
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.des6noir);
                    break;
            }

        }
        else {
            switch (nombre) {
                case 1:
                    imageView.setImageResource(R.drawable.des1);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.des2);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.des3);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.des4);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.des5);
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.des6);
                    break;
            }
        }
    }

    public static String affichRegle (int sommeRand, boolean regles ){
        String affRegle ="" ;
        switch(sommeRand) {
            case 2:
                if (regles) {
                    affRegle = "\net ";
                }
                affRegle = affRegle + "Le lanceur boit une gorgée";
                break;
            case 6:
                if (regles) {
                    affRegle = affRegle + "\net ";
                }
                affRegle = affRegle + "Le joueur avant le lanceur boit une gorgée";
                break;
            case 8:
                if (regles) {
                    affRegle = affRegle + "\net ";
                }
                affRegle = affRegle + "Le joueur après le lanceur boit une gorgée";
                break;
            case 12:
                if (regles) {
                    affRegle = affRegle + "\net ";
                }
                affRegle = affRegle + "Le joueur distribue 6 gorgées et invente une règle";
                break;
            default:
                break;
        }
        return affRegle;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_jouer);

        final ImageView des1 = findViewById(R.id.des1);
        final ImageView des2 = findViewById(R.id.des2);
        final ImageView des3=findViewById(R.id.des3);
        final ImageView des4 = findViewById(R.id.des4);
        final TextView regles = findViewById(R.id.regles);
        Button rejouer = findViewById(R.id.butRejouer);
        final Random randomInt1 = new Random();
        final Random randomInt2 = new Random();
        final Random randomInt3 = new Random();
        final Random randomInt4 = new Random();

        rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean regle = false;
                boolean regle1 = false;

                String affRegle1 = "";
                String affRegle2 = "";
                String affRegle = "";

                int rand1;
                int rand2;
                int rand3;
                int rand4;

                int sommeRand1;
                int sommeRand2;

                rand1 = 1 + randomInt1.nextInt(6);
                rand2 = 1 + randomInt2.nextInt(6);
                rand3 = 1 + randomInt3.nextInt(6);
                rand4 = 1 + randomInt4.nextInt(6);

                affichDes(rand1, des1, false);
                affichDes(rand2, des2, false);
                affichDes(rand3, des3,true);
                affichDes(rand4, des4,true);

                sommeRand1 = rand1+rand2;
                sommeRand2 = rand3+rand4;


                if((rand1 == rand2)&&(rand1!=1)&&(rand1!=6)){
                    affRegle1 = "Distribuez " + Integer.toString(rand1) + " gorgées";
                    regle1 = true;
                }

                affRegle1 = affRegle1 + affichRegle(sommeRand1,regle1);
                if(affRegle1 != ""){
                    regle1 = true;
                }

                if((rand3 == rand4)&&(rand3!=1)&&(rand3!=6)){
                    affRegle2 = "Distribuez " + Integer.toString(rand3) + " gorgées";
                    regle = true;
                }

                affRegle2 = affRegle2 + affichRegle(sommeRand2,regle);
                if(affRegle2 != ""){
                    regle = true;
                }

                if(regle1 && regle) {
                    affRegle = affRegle1 + "\nou " + affRegle2;
                }
                else{
                    affRegle = affRegle1 + affRegle2;
                }


                if (sommeRand1 == 3 || sommeRand2 == 3){
                    affRegle = "Le lanceur devient la PUUUUUUTE";
                }
                if (sommeRand1 == 7 || sommeRand2 == 7){
                    affRegle = "Le dernier à dire Biskit le pouce sur le front boit";
                }
                if (sommeRand1 == 7 && sommeRand2 == 7){
                    affRegle = "Doubliskit";
                }
                if (sommeRand1 == 2 || sommeRand2 == 2){
                    affRegle = "Le lanceur boit une gorgée";
                }
                regles.setText(affRegle);
            }

        });
    }
}
