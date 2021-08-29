package ca.com.felipeoliveira.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //Declaration des Variables
    private var joueur1 = "jouer1"
    private var joueur2 = "jouer2"

    private lateinit var  txtJoueur1: EditText
    private lateinit var txtJoueur2: EditText
    private lateinit var btnCommencer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialiser les variables
        txtJoueur1 = findViewById(R.id.txtNomJoueur1)
        txtJoueur2 = findViewById(R.id.txtJoueur2)
        btnCommencer = findViewById(R.id.btnCommencer)

        //Listener pour le button Commencer
        btnCommencer.setOnClickListener {

        //On verifie si les EditText sont vides, si "true" on demande de saisir
            if(txtJoueur1.text.toString() == "")
                Toast.makeText(applicationContext , "Voulez saisir le nom du joueur1", Toast.LENGTH_SHORT).show()
            else if(txtJoueur2.text.toString() == "")
                Toast.makeText(applicationContext , "Voulez saisir le nom du joueur2", Toast.LENGTH_SHORT).show()
            else{
                //On recupere le nom des joueurs
                joueur1 = txtJoueur1.text.toString().take(8)
                joueur2 = txtJoueur2.text.toString().take(8)


                //On declare l'Intent pour passer les données à JeuActivity
                val intent = Intent(this, JeuActivity::class.java)
                intent.putExtra("joueur1", joueur1)
                intent.putExtra("joueur2", joueur2)

                //On start l'Acivity
                startActivity(intent)
            }

        }


    }


}