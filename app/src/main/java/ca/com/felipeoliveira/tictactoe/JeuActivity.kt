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


    }
    //Function pour reinitialiser la partie
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

        //On remet les imagesButtons clickables
        btnA1.setEnabled(true)
        btnA2.setEnabled(true)
        btnA3.setEnabled(true)
        btnB1.setEnabled(true)
        btnB2.setEnabled(true)
        btnB3.setEnabled(true)
        btnC1.setEnabled(true)
        btnC2.setEnabled(true)
        btnC3.setEnabled(true)

    }

    //Choisi par hazard le jouer que commence la première partie
    fun verifierJoueurCommencant():Int{
        //On choisi par hasar le joueur qui commence
        return (1..2).random()
    }

    //Verifie egalité près chaque turn
    fun verifierEgalite():Boolean{
        if(a1 != CASE_VIDE && a2 != CASE_VIDE && a3 != CASE_VIDE
            && b1 != CASE_VIDE && b2 != CASE_VIDE && b3 != CASE_VIDE
            && c1 != CASE_VIDE && c2 != CASE_VIDE && c3 != CASE_VIDE){
            return true
        }
        return false
    }

   //Verifie la victoire après chaque turn
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

    //Listener pour les 'ImageButton'. Quand l'utilisateur joue.
    fun imageButtonClick(view: View){
        //On cree une reference pour l'ImageButton selectionné
       var buttonSelectione =  findViewById<ImageButton>(view.id)



        //On change le label pour indiquer le joueur à jouer
        if(joueurTurn == 1) lblJoueurTurn.text = jouer2Nom
        else lblJoueurTurn.text = jouer1Nom

        if(joueurTurn == JOUEUR1_TURN){
            buttonSelectione.setImageResource(R.drawable.x)
            changerCaseX(buttonSelectione.id)
            buttonSelectione.setEnabled(false)
            joueurTurn = JOUEUR2_TURN
        }
        else{
            buttonSelectione.setImageResource(R.drawable.o)
            changerCaseO(buttonSelectione.id)
            buttonSelectione.setEnabled(false)
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

    //Change les variables cases pour CASE_X
    fun changerCaseX(idImageView: Int){
        when (idImageView){
            R.id.btnA1-> a1 = CASE_X
            R.id.btnA2 -> a2 = CASE_X
            R.id.btnA3 -> a3 = CASE_X
            R.id.btnB1 -> b1 = CASE_X
            R.id.btnB2 -> b2 = CASE_X
            R.id.btnB3 -> b3 = CASE_X
            R.id.btnC1 -> c1 = CASE_X
            R.id.btnC2 -> c2 = CASE_X
            R.id.btnC3 -> c3 = CASE_X
        }
    }

    //Change les variables cases pour CASE_O
    fun changerCaseO(idImageView: Int){
        when (idImageView){
            R.id.btnA1-> a1 = CASE_O
            R.id.btnA3 -> a3 = CASE_O
            R.id.btnB2 -> b2 = CASE_O
            R.id.btnB3 -> b3 = CASE_O
            R.id.btnA2 -> a2 = CASE_O
            R.id.btnC1 -> c1 = CASE_O
            R.id.btnC2 -> c2 = CASE_O
            R.id.btnC3 -> c3 = CASE_O
        }
    }

}