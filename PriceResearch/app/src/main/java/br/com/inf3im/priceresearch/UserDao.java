package br.com.inf3im.priceresearch;
//CRUD
import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public static final String TAG = "CRUD User";

    // essa classe irá representar o CRUD na tabela de produtos

    public static int insertUser(User mUser , Context mContext){
        int vResponse = 0; // 0 não deu certo     1 tudo blz ok
        String mSql;
        try{
            mSql = "INSERTO INTO users (fullName , username , password , email) VALUES ( ? , ? , ? , ?)";
            // cada ? representa o conteudo que sera definido para cada coluna da tabela
            // ? tem o nome de parametro (muitas pessoas dirao que é variavel)

            // preparar os parametros
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            // associar os ? (parametros) com o assessor get do meu objeto de produto
            mPreparedStatement.setString( 1 , mUser.getFullName());
            mPreparedStatement.setString( 2 , mUser.getUserName());
            mPreparedStatement.setString( 3 , mUser.getPassword());
            mPreparedStatement.setString( 4 , mUser.getEmail());

            vResponse = mPreparedStatement.executeUpdate(); // 0 deu erro    1 ok



        } catch (Exception e){
            Log.e( TAG , e.getMessage());

        }

        return vResponse;
    }
    public static int updateUser(User mUser , Context mContext){
        int vResponse = 0; // 0 não deu certo     1 tudo blz ok
        String mSql;
        try{
            mSql = "UPDATE Users SET fullName=? , username=? , password=?, email=? WHERE id=?";
            // cada ? representa o conteudo que sera definido para cada coluna da tabela
            // ? tem o nome de parametro (muitas pessoas dirao que é variavel)

            // preparar os parametros
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            // associar os ? (parametros) com o assessor get do meu objeto de produto
            mPreparedStatement.setString( 1 , mUser.getFullName());
            mPreparedStatement.setString( 2 , mUser.getUserName());
            mPreparedStatement.setString( 3 , mUser.getPassword());
            mPreparedStatement.setString( 4 , mUser.getEmail());
            mPreparedStatement.setInt( 5 , mUser.getId());

            vResponse = mPreparedStatement.executeUpdate(); // 0 deu erro    1 ok



        } catch (Exception e){
            Log.e( TAG , e.getMessage());

        }

        return vResponse;
    }
    public static int deleteUser(User mUser , Context mContext){
        int vResponse = 0; // 0 não deu certo     1 tudo blz ok
        String mSql;
        try{
            mSql = "DELETE FROM Users WHERE id=?";
            // cada ? representa o conteudo que sera definido para cada coluna da tabela
            // ? tem o nome de parametro (muitas pessoas dirao que é variavel)

            // preparar os parametros
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            // associar os ? (parametros) com o assessor get do meu objeto de produto

            mPreparedStatement.setInt( 1 , mUser.getId());

            vResponse = mPreparedStatement.executeUpdate(); // 0 deu erro    1 ok



        } catch (Exception e){
            Log.e( TAG , e.getMessage());

        }

        return vResponse;
    }
    public static int deleteAllUser( Context mContext ){
        int vResponse = 0; // 0 não deu certo     1 tudo blz ok
        String mSql;
        try{
            mSql = "DELETE FROM Users";
            // cada ? representa o conteudo que sera definido para cada coluna da tabela
            // ? tem o nome de parametro (muitas pessoas dirao que é variavel)

            // preparar os parametros
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            // associar os ? (parametros) com o assessor get do meu objeto de produto


            vResponse = mPreparedStatement.executeUpdate(); // 0 deu erro    1 ok



        } catch (Exception e){
            Log.e( TAG , e.getMessage());

        }

        return vResponse;
    }

    public static List<User> listAllUsers(Context mContext){
        List<User> mUserList = null;
        String mSql;
        try{
            mSql = "SELECT id, fullname. username; password, email FROM Users ORDER BY fullname ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mUserList = new ArrayList<User>();
            while (mResultSet.next()){
                mUserList.add(new User(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5)


                ));

            }

        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mUserList;
    }

    public static List<User> searchUsersByName(String vName , Context mContext){
        List<User> mUserList = null;
        String mSql;
        try{
            mSql = "SELECT id , fullname, username, email, password FROM Users WHERE fullname LIKE '%" + vName + "%' ORDER BY name ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mUserList = new ArrayList<User>();
            while (mResultSet.next()){
                mUserList.add(new User(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getString(3),
                        mResultSet.getString(4),
                        mResultSet.getString(5)
                ));

            }

        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mUserList;
    }

}
