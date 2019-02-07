package com.laperrouse.theo.doubliskit;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Jouer extends AppCompatActivity {

    //Associent les lancers aléatoires à leur image
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

    public static String afficherRegle(int de1, int de2, int de3, int de4){

        //on déclare toutes nos variables qui vont nous être utiles.
        int somme1 = de1+de2;
        int somme2 = de3+de4;

        boolean egal1 = de1 == de2;
        boolean egal2 = de3 == de4;

        /* Ordre des priorité:
         * Pute
         * Biskit
         * Double 1
         * Double normal
         * suivant précédent
         * */

        //Pute
        if(somme1 == 3 || somme2 == 3){
            return "Le lanceur devient la PUUUUUUTE.";
        }

        //Biskit ou Doubliskit
        if(somme1 == 7||somme2 == 7){
            if(somme1== 7 && somme2 == 7){
                return "DOUBLISKIT !\nLe premier relance les dés";
            }else{
                return "BISKIT !\nLe premier relance les dés";
            }
        }
        //Doubles
        if(egal1 || egal2){
            if(somme1 == 2 || somme2== 2){
            return regleSiDouble(2);
            }else{
                if(egal1 && egal2){
                    int max = Math.max(somme1,somme2);
                    return regleSiDouble(max);
                }else{
                    if(egal1){
                        return regleSiDouble(somme1);
                    }else{
                        return regleSiDouble(somme2);
                    }
                }
            }
        }
        //Suivant ou Précédent
        if((somme1 == 6 && somme2==8) ||(somme1==8 && somme2==6)){
            return "Le lancer ditribue une gorgée à l'un de ces voisins.";
        }
        //Précédent
        if(somme1==6 ||somme2==6){
            return "Le joueur précédant le lanceur boit une gorgée.";
        }
        //Suivant
        if(somme1==8 ||somme2==8){
            return "Le joueur suivant le lanceur boit une gorgée.";
        }

        return "Dommage, le lanceur boit une gorgée et passe les dés à son voisin.";
    }

    public static String regleSiDouble (int somme){
        String res = "";
        switch(somme){
            case 2 :
                res = "Le lanceur boit 1 gorgée.";
                break;
            case 4 :
                res = "Le lanceur distribue 2 gorgées.";
                break;
            case 6 :
                res = "Le lanceur distribue 3 gorgées et le joueur précédent boit.";
                break;
            case 8 :
                res = "Le lanceur distribue 4 gorgées et le joueur suivant boit.";
                break;
            case 10 :
                res = "Le lanceur distribue 5 gorgées.";
                break;
            case 12 :
                res = "Le lanceur distribue 6 gorgées et invente une règle.";
                break;
            default :
                break;
        }
        return res;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_jouer);

        // Les images des dés
        final ImageView des1 = findViewById(R.id.des1);
        final ImageView des2 = findViewById(R.id.des2);
        final ImageView des3=findViewById(R.id.des3);
        final ImageView des4 = findViewById(R.id.des4);

        // Les Zones de texte où apparaissent les règles
        final TextView regles = findViewById(R.id.regles);
        final TextView regles2 = findViewById(R.id.regles2);

        //Le Bouton pour rejouer
        Button rejouer = findViewById(R.id.butRejouer);

        final Random randomInt = new Random();


        rejouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int rand1 = 1 + randomInt.nextInt(6);
                int rand2 = 1 + randomInt.nextInt(6);
                int rand3 = 1 + randomInt.nextInt(6);
                int rand4 = 1 + randomInt.nextInt(6);

                //TODO Partie là à modifier pour avoir les couleurs des dés dans un ordre aléatoire

                affichDes(rand1, des1, false);
                affichDes(rand2, des2, false);
                affichDes(rand3, des3,true);
                affichDes(rand4, des4,true);

                String affRegle = afficherRegle(rand1,rand2,rand3,rand4);
                regles.setText(affRegle);
                regles2.setText(affRegle);
            }

        });
    }
}
