package br.com.inf3im.priceresearch;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MSSQLConnectionHelper {

    public static final String TAG = "Conexão com o Banco de Dados";

    // essa classe irá conter strings para fazer a conexao com Banco de dados:
    //  1 - SOMEE.COM
    //  2 - banco SQLSERVER LOCALHOST, no pc do laboratório/casa.
    //      nesse cenário o APP só vai funcionar no EMULADOR ou celular com cabo
    //  3 - banco MySql

    private static String mStringConnectionUrl;

    // 1 - SOMEE.COM
    private static String mStringServerIpName = "jardim.mssql.somee.com";
    private static String mStringUserName = "joao_SQLLogin_1";
    private static String mStringPassword = "12ab3irds";
    private static String mStringDatabase = "jardim";

    // 2 - LOCALHOST
    //private static String mStringServerIpName = "10.0.2.2";
   // private static String mStringUserName = "sa";
   // private static String mStringPassword = "@ITB123456";
  //  private static String mStringDatabase = "jardim";
  //  private static String mStringPort = "1433";
  //  private static String mStringInstance = "SQLEXPRESS";

    // para o MySql as strings são as mesmas do tópico 2

    public static Connection getConnection(Context mContext){
        Connection mConnection = null;
        try{
            // adicionar uma regra/politica/policy para criar uma tarefa/thread
            // vou avisar ao Sistema Operacional (OS) que ele tem permissão para tudo
            StrictMode.ThreadPolicy mPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(mPolicy);

            // testar se foi copiado/implementado o driver/biblioteca jtds
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            // montagem da string de conexao com o banco
            // concatenar as strings

            mStringConnectionUrl = "jdbc:jtds:sqlserver://" + mStringServerIpName +
                    ";databaseName=" + mStringDatabase +
                    ";user=" + mStringUserName +
                    ";password=" + mStringPassword + ";"  ;

            // para o LOCALHOST e o MySql vocë precisa de uma outra string de conexao

            // fazer com que o objeto de conexao obtenha a conexao a  partir do gerenciamento de driver
            mConnection = DriverManager.getConnection(mStringConnectionUrl);

            // registrar no Android Studio (Log) para o programador a informação que a conexao foi feita com sucesso
            Log.i (TAG , "Conexao feita com sucesso");

        } catch(ClassNotFoundException e){
            String mMessage = "Classe nao encontrada" + e.getMessage();
            Log.e(TAG , mMessage);

        }   catch(SQLException e){
            String mMessage = "Ocorreu um erro com o banco de dados" + e.getMessage();
            Log.e(TAG , mMessage);

        }  catch(Exception e){
            String mMessage = "Erro desconhecido" + e.getMessage();
            Log.e(TAG , mMessage);

        }

        return mConnection;

    }

}
