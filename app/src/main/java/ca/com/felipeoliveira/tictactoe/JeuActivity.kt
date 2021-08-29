package ca.com.felipeoliveira.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class JeuActivity : AppCompatActivity() {

    //Declaration des variables
    val JOUEUR1_TURN = 1
    val JOUEUR2_TURN = 2
    val CASE_VIDE = 0
    val CASE_X = 1
    val CASE_O = 2
    private var joueurTurn = 0
    private var turnActuel = 0
    private var verifierVictoire = 0
    private var joueur1Ponts = 0
    private var joueur2Ponts = 0
    lateinit var jouer1Nom:String
    lateinit var jouer2Nom:String
    private lateinit var btnRecommencer: Button
    //Variables des cases
    var a1 = CASE_VIDE
    var a2 = CASE_VIDE
    var a3 = CASE_VIDE
    var b1 = CASE_VIDE
    var b2 = CASE_VIDE
    var b3 = CASE_VIDE
    var c1 = CASE_VIDE
    var c2 = CASE_VIDE
    var c3 = CASE_VIDE
    private lateinit var btnA1: ImageButton
    private lateinit var btnA2: ImageButton
    private lateinit var btnA3: ImageButton
    private lateinit var btnB1: ImageButton
    private lateinit var btnB2: ImageButton
    private lateinit var btnB3: ImageButton
    private lateinit var btnC1: ImageButton
    private lateinit var btnC2: ImageButton
    private lateinit var btnC3: ImageButton
    //Variable des labels
    private lateinit var lblJoueur1Ponts: TextView
    private lateinit var lblJoueur2Ponts: TextView
    private lateinit var lblJoueurTurn: TextView
    private lateinit var lblJoueur1Nom: TextView
    private lateinit var lblJoueur2Nom: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jeu)

        //On inicialise les boutons
        btnA1 = findViewById(R.id.btnA1)
        btnA2 = findViewById(R.id.btnA2)
        btnA3 = findViewById(R.id.btnA3)
        btnB1 = findViewById(R.id.btnB1)
        btnB2 = findViewById(R.id.btnB2)
        btnB3 = findViewById(R.id.btnB3)
        btnC1 = findViewById(R.id.btnC1)
        btnC2 = findViewById(R.id.btnC2)
        btnC3 = findViewById(R.id.btnC3)

        btnRecommencer = findViewById(R.id.btnRecommencer)

        //On initialise les TextView
        lblJoueur1Ponts = findViewById(R.id.txtPontsJoueur1)
        lblJoueur2Ponts = findViewById(R.id.txtPontsJoueur2)
        lblJoueurTurn = findViewById(R.id.txtTurn)
        lblJoueur1Nom = findViewById(R.id.txtNomJoueur1)
        lblJoueur2Nom = findViewById(R.id.txtNomJoueur2)

        //On rcupere le nom des joueurs
        jouer1Nom = intent.getStringExtra("joueur1").toString()
        jouer2Nom = intent.getStringExtra("joueur2").toString()

        lblJoueur1Nom.text = jouer1Nom
        lblJoueur2Nom.text = jouer2Nom

        //On verifie le joueur qui commence
        joueurTurn = verifierJoueurCommencant();
        if(joueurTurn == 1){
            lblJoueurTurn.text = jouer1Nom
        }
        else{
            lblJoueurTurn.text = jouer2Nom
        }


        //ClickListeners pour les boutons
        btnRecommencer.setOnClickListener{
            //On reinitialise les champs
            reinitialiserTurn()
            joueur1Ponts = 0
            lblJoueur1Ponts.setText(""+joueur1Ponts)

            joueur2Ponts = 0
            lblJoueur2Ponts.setText(""+joueur2Ponts)

        }

        btnA1.setOnClickListener{
            //On change le label pour indiquer le joueur à jouer
            if(joueurTurn == 1) lblJoueurTurn.text = jouer2Nom
            else lblJoueurTurn.text = jouer1Nom

            if(joueurTurn == JOUEUR1_TURN){
                btnA1.setImageResource(R.drawable.x)
                a1 = CASE_X
                btnA1.setClickable(false)
                joueurTurn = JOUEUR2_TURN
            }
            else{
                btnA1.setImageResource(R.drawable.o)
                a1 = CASE_O
                btnA1.setClickable(false)
                joueurTurn = JOUEUR1_TURN
            }

            //On verifie la victoire
            verifierVictoire = verifierVictoire()
            if(verifierVictoire != 0){

                //si le joueur 1 a gagne
                if(verifierVictoire == 1) {
                    joueur1Ponts ++
                    lblJoueur1Ponts.setText(""+joueur1Ponts)
                }
                else{
                    joueur2Ponts ++
                    lblJoueur2Ponts.setText(""+joueur2Ponts)

                }
                reinitialiserTurn()
            }
            //Si pas de victoire, on verifie l'egalité. Si egalité on reinitialise le tableau
            if(verifierEgalite()){
                reinitialiserTurn()
            }

        }

        btnA2.setOnClickListener{
            //On change le label pour indiquer le joueur à jouer
            if(joueurTurn == 1) lblJoueurTurn.text = jouer2Nom
            else lblJoueurTurn.text = jouer1Nom

            if(joueurTurn == JOUEUR1_TURN){
                btnA2.setImageResource(R.drawable.x)
                a2 = CASE_X
                btnA2.setClickable(false)
                joueurTurn = JOUEUR2_TURN
            }
            else{
                btnA2.setImageResource(R.drawable.o)
                a2 = CASE_O
                btnA2.setClickable(false)
                joueurTurn = JOUEUR1_TURN
            }
            //On verifie la victoire
            verifierVictoire = verifierVictoire()
            if(verifierVictoire != 0){

                //si le joueur 1 a gagne
                if(verifierVictoire == 1) {
                    joueur1Ponts ++
                    lblJoueur1Ponts.setText(""+joueur1Ponts)
                }
                else{
                    joueur2Ponts ++
                    lblJoueur2Ponts.setText(""+joueur2Ponts)

                }
                reinitialiserTurn()
            }
            //Si pas de victoire, on verifie l'egalité. Si egalité on reinitialise le tableau
            if(verifierEgalite()){
                reinitialiserTurn()
            }
        }

        btnA3.setOnClickListener{
            //On change le label pour indiquer le joueur à jouer
            if(joueurTurn == 1) lblJoueurTurn.text = jouer2Nom
            else lblJoueurTurn.text = jouer1Nom

            if(joueurTurn == JOUEUR1_TURN){
                btnA3.setImageResource(R.drawable.x)
                a3 = CASE_X
                btnA3.setClickable(false)
                joueurTurn = JOUEUR2_TURN
            }
            else{
                btnA3.setImageResource(R.drawable.o)
                a3 = CASE_O
                btnA3.setClickable(false)
                joueurTurn = JOUEUR1_TURN
            }
            //On verifie la victoire
            verifierVictoire = verifierVictoire()
            if(verifierVictoire != 0){

                //si le joueur 1 a gagne
                if(verifierVictoire == 1) {
                    joueur1Ponts ++
                    lblJoueur1Ponts.setText(""+joueur1Ponts)
                }
                else{
                    joueur2Ponts ++
                    lblJoueur2Ponts.setText(""+joueur2Ponts)

                }
                reinitialiserTurn()
            }
            //Si pas de victoire, on verifie l'egalité. Si egalité on reinitialise le tableau
            if(verifierEgalite()){
                reinitialiserTurn()
            }
        }

        btnB1.setOnClickListener{
            //On change le label pour indiquer le joueur à jouer
            if(joueurTurn == 1) lblJoueurTurn.text = jouer2Nom
            else lblJoueurTurn.text = jouer1Nom

            if(joueurTurn == JOUEUR1_TURN){
                btnB1.setImageResource(R.drawable.x)
                b1 = CASE_X
                btnB1.setClickable(false)
                joueurTurn = JOUEUR2_TURN
            }
            else{
                btnB1.setImageResource(R.drawable.o)
                b1 = CASE_O
                btnB1.setClickable(false)
                joueurTurn = JOUEUR1_TURN
            }
            //On verifie la victoire
            verifierVictoire = verifierVictoire()
            if(verifierVictoire != 0){

                //si le joueur 1 a gagne
                if(verifierVictoire == 1) {
                    joueur1Ponts ++
                    lblJoueur1Ponts.setText(""+joueur1Ponts)
                }
                else{
                    joueur2Ponts ++
                    lblJoueur2Ponts.setText(""+joueur2Ponts)

                }
                reinitialiserTurn()
            }
            //Si pas de victoire, on verifie l'egalité. Si egalité on reinitialise le tableau
            if(verifierEgalite()){
                reinitialiserTurn()
            }
        }

        btnB2.setOnClickListener{
            //On change le label pour indiquer le joueur à jouer
            if(joueurTurn == 1) lblJoueurTurn.text = jouer2Nom
            else lblJoueurTurn.text = jouer1Nom

            if(joueurTurn == JOUEUR1_TURN){
                btnB2.setImageResource(R.drawable.x)
                b2 = CASE_X
                btnB2.setClickable(false)
                joueurTurn = JOUEUR2_TURN
            }
            else{
                btnB2.setImageResource(R.drawable.o)
                b2 = CASE_O
                btnB2.setClickable(false)
                joueurTurn = JOUEUR1_TURN
            }
            //On verifie la victoire
            verifierVictoire = verifierVictoire()
            if(verifierVictoire != 0){

                //si le joueur 1 a gagne
                if(verifierVictoire == 1) {
                    joueur1Ponts ++
                    lblJoueur1Ponts.setText(""+joueur1Ponts)
                }
                else{
                    joueur2Ponts ++
                    lblJoueur2Ponts.setText(""+joueur2Ponts)

                }
                reinitialiserTurn()
            }
            //Si pas de victoire, on verifie l'egalité. Si egalité on reinitialise le tableau
            if(verifierEgalite()){
                reinitialiserTurn()
            }
        }

        btnB3.setOnClickListener{
            //On change le label pour indiquer le joueur à jouer
            if(joueurTurn == 1) lblJoueurTurn.text = jouer2Nom
            else lblJoueurTurn.text = jouer1Nom

            if(joueurTurn == JOUEUR1_TURN){
                btnB3.setImageResource(R.drawable.x)
                b3 = CASE_X
                btnB3.setClickable(false)
                joueurTurn = JOUEUR2_TURN
            }
            else{
                btnB3.setImageResource(R.drawable.o)
                b3 = CASE_O
                btnB3.setClickable(false)
                joueurTurn = JOUEUR1_TURN
            }
            //On verifie la victoire
            verifierVictoire = verifierVictoire()
            if(verifierVictoire != 0){

                //si le joueur 1 a gagne
                if(verifierVictoire == 1) {
                    joueur1Ponts ++
                    lblJoueur1Ponts.setText(""+joueur1Ponts)
                }
                else{
                    joueur2Ponts ++
                    lblJoueur2Ponts.setText(""+joueur2Ponts)

                }
                reinitialiserTurn()
            }
            //Si pas de victoire, on verifie l'egalité. Si egalité on reinitialise le tableau
            if(verifierEgalite()){
                reinitialiserTurn()
            }
        }

        btnC1.setOnClickListener{
            //On change le label pour indiquer le joueur à jouer
            if(joueurTurn == 1) lblJoueurTurn.text = jouer2Nom
            else lblJoueurTurn.text = jouer1Nom

            if(joueurTurn == JOUEUR1_TURN){
                btnC1.setImageResource(R.drawable.x)
                c1 = CASE_X
                btnC1.setClickable(false)
                joueurTurn = JOUEUR2_TURN
            }
            else{
                btnC1.setImageResource(R.drawable.o)
                c1 = CASE_O
                btnC1.setClickable(false)
                joueurTurn = JOUEUR1_TURN
            }
            //On verifie la victoire
            verifierVictoire = verifierVictoire()
            if(verifierVictoire != 0){

                //si le joueur 1 a gagne
                if(verifierVictoire == 1) {
                    joueur1Ponts ++
                    lblJoueur1Ponts.setText(""+joueur1Ponts)
                }
                else{
                    joueur2Ponts ++
                    lblJoueur2Ponts.setText(""+joueur2Ponts)

                }
                reinitialiserTurn()
            }
            //Si pas de victoire, on verifie l'egalité. Si egalité on reinitialise le tableau
            if(verifierEgalite()){
                reinitialiserTurn()
            }
        }

        btnC2.setOnClickListener{
            //On change le label pour indiquer le joueur à jouer
            if(joueurTurn == 1) lblJoueurTurn.text = jouer2Nom
            else lblJoueurTurn.text = jouer1Nom

            if(joueurTurn == JOUEUR1_TURN){
                btnC2.setImageResource(R.drawable.x)
                c2 = CASE_X
                btnC2.setClickable(false)
                joueurTurn = JOUEUR2_TURN
            }
            else{
                btnC2.setImageResource(R.drawable.o)
                c2 = CASE_O
                btnC2.setClickable(false)
                joueurTurn = JOUEUR1_TURN
            }
            //On verifie la victoire
            verifierVictoire = verifierVictoire()
            if(verifierVictoire != 0){

                //si le joueur 1 a gagne
                if(verifierVictoire == 1) {
                    joueur1Ponts ++
                    lblJoueur1Ponts.setText(""+joueur1Ponts)
                }
                else{
                    joueur2Ponts ++
                    lblJoueur2Ponts.setText(""+joueur2Ponts)

                }
                reinitialiserTurn()
            }
            //Si pas de victoire, on verifie l'egalité. Si egalité on reinitialise le tableau
            if(verifierEgalite()){
                reinitialiserTurn()
            }
        }

        btnC3.setOnClickListener{
            //On change le label pour indiquer le joueur à jouer
            if(joueurTurn == 1) lblJoueurTurn.text = jouer2Nom
            else lblJoueurTurn.text = jouer1Nom

            if(joueurTurn == JOUEUR1_TURN){
                btnC3.setImageResource(R.drawable.x)
                c3 = CASE_X
                btnC3.setClickable(false)
                joueurTurn = JOUEUR2_TURN
            }
            else{
                btnC3.setImageResource(R.drawable.o)
                c3 = CASE_O
                btnC3.setClickable(false)
                joueurTurn = JOUEUR1_TURN
            }
            //On verifie la victoire
            verifierVictoire = verifierVictoire()
            if(verifierVictoire != 0){

                //si le joueur 1 a gagne
                if(verifierVictoire == 1) {
                    joueur1Ponts ++
                    lblJoueur1Ponts.setText(""+joueur1Ponts)
                }
                else{
                    joueur2Ponts ++
                    lblJoueur2Ponts.setText(""+joueur2Ponts)

                }
                reinitialiserTurn()
            }
            //Si pas de victoire, on verifie l'egalité. Si egalité on reinitialise le tableau
            if(verifierEgalite()){
                reinitialiserTurn()
            }
        }

    }

    fun reinitialiserTurn(){
        //On assigne la CASE_VIDE à chaque case
         a1 = CASE_VIDE
         a2 = CASE_VIDE
         a3 = CASE_VIDE
         b1 = CASE_VIDE
         b2 = CASE_VIDE
         b3 = CASE_VIDE
         c1 = CASE_VIDE
         c2 = CASE_VIDE
         c3 = CASE_VIDE

        //On remet l'image vide à chaque imageButton
        btnA1.setImageResource(R.drawable.vide)
        btnA2.setImageResource(R.drawable.vide)
        btnA3.setImageResource(R.drawable.vide)
        btnB1.setImageResource(R.drawable.vide)
        btnB2.setImageResource(R.drawable.vide)
        btnB3.setImageResource(R.drawable.vide)
        btnC1.setImageResource(R.drawable.vide)
        btnC2.setImageResource(R.drawable.vide)
        btnC3.setImageResource(R.drawable.vide)

        //On remet les imagesButtons cliclables
        btnA1.setClickable(true)
        btnA2.setClickable(true)
        btnA3.setClickable(true)
        btnB1.setClickable(true)
        btnB2.setClickable(true)
        btnB3.setClickable(true)
        btnC1.setClickable(true)
        btnC2.setClickable(true)
        btnC3.setClickable(true)

    }

    fun verifierJoueurCommencant():Int{
        //On choisi par hasar le joueur qui commence
        return (1..2).random()
    }

    fun verifierEgalite():Boolean{
        if(a1 != CASE_VIDE && a2 != CASE_VIDE && a3 != CASE_VIDE
            && b1 != CASE_VIDE && b2 != CASE_VIDE && b3 != CASE_VIDE
            && c1 != CASE_VIDE && c2 != CASE_VIDE && c3 != CASE_VIDE){
            return true
        }
        return false
    }


    fun verifierVictoire() : Int{
        //On verifie la victoire dans la premiere ligne
        if(a1 == b1 && b1 == c1 && c1 != CASE_VIDE){
            //On verifie le joueur gagnant
            if(c1 == CASE_X) return 1
            else return 2
        }

        //On verifie la victoire dans la deuxieme ligne
        if(a2 == b2 && b2 == c2 && c2 != CASE_VIDE){
            //On verifie le joueur gagnant
            if(c2 == CASE_X) return 1
            else return 2
        }

        //On verifie la victoire dans la troisieme ligne
        if(a3 == b3 && b3 == c3 && c3 != CASE_VIDE){
            //On verifie le joueur gagnant
            if(c3 == CASE_X) return 1
            else return 2
        }

        //On verifie la victoire dans la premiere colonne
        if(a1 == a2 && a2 == a3 && a3 != CASE_VIDE){
            //On verifie le joueur gagnant
            if(a3 == CASE_X) return 1
            else return 2
        }

        //On verifie la victoire dans la deuxieme colonne
        if(b1 == b2 && b2 == b3 && b3 != CASE_VIDE){
            //On verifie le joueur gagnant
            if(b3 == CASE_X) return 1
            else return 2
        }

        //On verifie la victoire dans la troisieme colonne
        if(c1 == c2 && c2 == c3 && c3 != CASE_VIDE){
            //On verifie le joueur gagnant
            if(c3 == CASE_X) return 1
            else return 2
        }

        //On verifie la victoire dans la premiere diagonale
        if(a1 == b2 && b2 == c3 && c3 != CASE_VIDE){
            //On verifie le joueur gagnant
            if(c3 == CASE_X) return 1
            else return 2
        }

        //On verifie la victoire dans la deuxieme diagonale
        if(a3 == b2 && b2 == c1 && c1 != CASE_VIDE){
            //On verifie le joueur gagnant
            if(c1 == CASE_X) return 1
            else return 2
        }

        //Si personne a reussi à gagnher
        return 0
    }

    fun buttonClick(view: View){
        //On cree une reference pour l'ImageButton selectionné
       val buttonSelectione =  findViewById<ImageButton>(view.id)

        //On change le label pour indiquer le joueur à jouer
        if(joueurTurn == 1) lblJoueurTurn.text = jouer2Nom
        else lblJoueurTurn.text = jouer1Nom

        if(joueurTurn == JOUEUR1_TURN){
            buttonSelectione.setImageResource(R.drawable.x)
            c3 = CASE_X
            buttonSelectione.setClickable(false)
            joueurTurn = JOUEUR2_TURN
        }
        else{
            buttonSelectione.setImageResource(R.drawable.o)
            c3 = CASE_O
            buttonSelectione.setClickable(false)
            joueurTurn = JOUEUR1_TURN
        }
        //On verifie la victoire
        verifierVictoire = verifierVictoire()
        if(verifierVictoire != 0){

            //si le joueur 1 a gagne
            if(verifierVictoire == 1) {
                joueur1Ponts ++
                lblJoueur1Ponts.setText(""+joueur1Ponts)
            }
            else{
                joueur2Ponts ++
                lblJoueur2Ponts.setText(""+joueur2Ponts)

            }
            reinitialiserTurn()
        }
        //Si pas de victoire, on verifie l'egalité. Si egalité on reinitialise le tableau
        if(verifierEgalite()){
            reinitialiserTurn()
        }
    }

    }

}