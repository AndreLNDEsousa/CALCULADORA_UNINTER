package com.uninter.trabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener   {


    private Button numeroZero,numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,
            numeroSete,numeroOito,numeroNove,ponto,soma,subtracao,divisao,igual,multiplicacao,botao_limpar;

    private TextView txtExpressao, txtResultado;
    private ImageView backspace;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         IniciarComponentes();
      //esconder a barra de status
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this); //this é usado para visualizar a captura do onclick.
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres .setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtExpressao.setText("");//o click no botão C limpa tudo dentro do resultado e expressão.
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1; //cada click retira um numero
                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);

                }
                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado==(double)longResult){
                        txtResultado.setText((CharSequence)String.valueOf(longResult));
                    } else {
                        txtResultado.setText((CharSequence)String.valueOf(resultado));
                    }

                }catch (Exception e){

                }


            }
        });






    }

    private void IniciarComponentes() { //ligação das ID com os botões
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois= findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        botao_limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);
    }

    public void AcrescentarUmaExpressao(String string,boolean limpar_dados){ //exibição dos caracteres e limpeza de tela

        if (txtResultado.getText().equals("")){
            txtExpressao.setText(" "); //o espaço no vazio é essencial para mostrar mais de 1 numero na tela
        }

        if (limpar_dados){
            txtResultado.setText(" ");  //o espaço no vazio é essencial para mostrar mais de 1 numero na tela
            txtExpressao.append(string);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");  //o espaço no vazio é essencial para mostrar mais de 1 numero na tela
        }
    }

// as cases contem o que será exibido a cada click em botão especifico
    @Override
    public void onClick(View view) {
        switch (view.getId()){ //caixa de ações para cada botão

            case R.id.numero_zero:
                AcrescentarUmaExpressao("0",true);
                break;

            case R.id.numero_um:
                AcrescentarUmaExpressao("1",true);
                break;

            case R.id.numero_dois:
                AcrescentarUmaExpressao("2",true);
                break;

            case R.id.numero_tres:
                AcrescentarUmaExpressao("3",true);
                break;

            case R.id.numero_quatro:
                AcrescentarUmaExpressao("4",true);
                break;

            case R.id.numero_cinco:
                AcrescentarUmaExpressao("5",true);
                break;

            case R.id.numero_seis:
                AcrescentarUmaExpressao("6",true);
                break;

            case R.id.numero_sete:
                AcrescentarUmaExpressao("7",true);
                break;

            case R.id.numero_oito:
                AcrescentarUmaExpressao("8",true);
                break;

            case R.id.numero_nove:
                AcrescentarUmaExpressao("9",true);
                break;

            case R.id.ponto:
                AcrescentarUmaExpressao(".",true);
                break;

            case R.id.soma:
                AcrescentarUmaExpressao("+",false);
                break;

            case R.id.subtracao:
                AcrescentarUmaExpressao("-",false);
                break;

            case R.id.multiplicacao:
                AcrescentarUmaExpressao("*",false);
                break;

            case R.id.divisao:
                AcrescentarUmaExpressao("/",false);
                break;



        }
    }
}
