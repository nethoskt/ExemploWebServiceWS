package br.senac.pi.exemplowebservice;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.senac.pi.exemplowebservice.domain.Usuario;
import br.senac.pi.exemplowebservice.domain.UsuarioWS;

public class MainActivity extends AppCompatActivity {
    private EditText edt_nome, edt_idade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        edt_nome = (EditText) findViewById(R.id.edt_Nome);
        edt_idade = (EditText) findViewById(R.id.edt_Idade);
        findViewById(R.id.btn_cadastrar).setOnClickListener(cadastrar());
            }
    private View.OnClickListener cadastrar()    {
        return new View.OnClickListener()   {
            @Override
        public void onClick(View v){
                String nome = edt_nome.getText().toString();
                //CASTING OU PARSER
                int idade = Integer.parseInt(edt_idade.getText().toString());
                UsuarioWS usuarioWS = new UsuarioWS();
                boolean resultado = usuarioWS.insertUsuario(new Usuario(0, nome, idade));
                if (resultado){
                    mensagem(getString(R.string.cadastro_sucesso));
                    edt_nome.setText("");
                    edt_idade.setText("");
                    edt_nome.requestFocus();
                }else {
                    mensagem(getString(R.string.erro_cadastro));
                }

            }
        };
    }
    private void mensagem(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}



