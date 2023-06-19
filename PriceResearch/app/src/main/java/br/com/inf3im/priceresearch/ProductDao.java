package br.com.inf3im.priceresearch;

import android.content.Context;
import android.util.Log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public static final String TAG = "CRUD Product";

    // essa classe irá representar o CRUD na tabela de produtos

    public static int insertProduct(Product mProduct , Context mContext){
        int vResponse = 0; // 0 não deu certo     1 tudo blz ok
        String mSql;
        try{
            mSql = "INSERT INTO products ( name , price , rating , status , image , amountConsumption , consumptionCycle ) VALUES ( ?, ?, ?, ?, ?, ?, ? )";
            // cada ? representa o conteudo que sera definido para cada coluna da tabela
            // ? tem o nome de parametro (muitas pessoas dirao que é variavel)

            // preparar os parametros
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            // associar os ? (parametros) com o assessor get do meu objeto de produto
            mPreparedStatement.setString( 1 , mProduct.getName());
            mPreparedStatement.setDouble( 2 , mProduct.getPrice());
            mPreparedStatement.setFloat( 3 , mProduct.getRating());
            mPreparedStatement.setInt( 4 , mProduct.getStatus());
            mPreparedStatement.setLong( 5 , mProduct.getImage());
            mPreparedStatement.setInt( 6 , mProduct.getAmountConsumption());
            mPreparedStatement.setInt( 7 , mProduct.getConsumptionCycle());

            vResponse = mPreparedStatement.executeUpdate(); // 0 deu erro    1 ok



        } catch (Exception e){
            Log.e( TAG , e.getMessage());

        }

        return vResponse;
    }
    public static int updateProduct(Product mProduct , Context mContext){
        int vResponse = 0; // 0 não deu certo     1 tudo blz ok
        String mSql;
        try{
            mSql = "UPDATE products SET name=? , price=? , rating=? , status=? , image=? , amountConsumption=? , consumptionCycle=? WHERE id=?";
            // cada ? representa o conteudo que sera definido para cada coluna da tabela
            // ? tem o nome de parametro (muitas pessoas dirao que é variavel)

            // preparar os parametros
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            // associar os ? (parametros) com o assessor get do meu objeto de produto
            mPreparedStatement.setString( 1 , mProduct.getName());
            mPreparedStatement.setDouble( 2 , mProduct.getPrice());
            mPreparedStatement.setFloat( 3 , mProduct.getRating());
            mPreparedStatement.setInt( 4 , mProduct.getStatus());
            mPreparedStatement.setLong( 5 , mProduct.getImage());
            mPreparedStatement.setInt( 6 , mProduct.getAmountConsumption());
            mPreparedStatement.setInt( 7 , mProduct.getConsumptionCycle());
            mPreparedStatement.setInt( 8 , mProduct.getId());

            vResponse = mPreparedStatement.executeUpdate(); // 0 deu erro    1 ok



        } catch (Exception e){
            Log.e( TAG , e.getMessage());

        }

        return vResponse;
    }
    public static int deleteProduct(Product mProduct , Context mContext){
        int vResponse = 0; // 0 não deu certo     1 tudo blz ok
        String mSql;
        try{
            mSql = "DELETE FROM products WHERE id=?";
            // cada ? representa o conteudo que sera definido para cada coluna da tabela
            // ? tem o nome de parametro (muitas pessoas dirao que é variavel)

            // preparar os parametros
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);

            // associar os ? (parametros) com o assessor get do meu objeto de produto

            mPreparedStatement.setInt( 1 , mProduct.getId());

            vResponse = mPreparedStatement.executeUpdate(); // 0 deu erro    1 ok



        } catch (Exception e){
            Log.e( TAG , e.getMessage());

        }

        return vResponse;
    }
    public static int deleteAllProduct( Context mContext ){
        int vResponse = 0; // 0 não deu certo     1 tudo blz ok
        String mSql;
        try{
            mSql = "DELETE FROM products";
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

    public static List<Product> listAllProducts(Context mContext){
        List<Product> mProductList = null;
        String mSql;
        try{
            mSql = "SELECT id , name , price , rating , status , image , amountConsumption , consumptionCycle FROM products ORDER BY name ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mProductList = new ArrayList<Product>();
            while (mResultSet.next()){
                mProductList.add(new Product(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getInt(3),
                        mResultSet.getInt(4),
                        mResultSet.getInt(5),
                        mResultSet.getInt(6),
                        mResultSet.getInt(7),
                        mResultSet.getInt(8),
                        0

                ));

            }

        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mProductList;
    }


    public static List<Product> listAllProductsByStatus(int vStatus , Context mContext){
        List<Product> mProductList = null;
        String mSql;
        try{
            mSql = "SELECT id , name , price , rating , status , image , amountConsumption , consumptionCycle FROM products WHERE status=" + vStatus + " ORDER BY name ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mProductList = new ArrayList<Product>();
            while (mResultSet.next()){
                mProductList.add(new Product(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getInt(3),
                        mResultSet.getInt(4),
                        mResultSet.getInt(5),
                        mResultSet.getInt(6),
                        mResultSet.getInt(7),
                        mResultSet.getInt(8),
                        0

                ));

            }

        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mProductList;
    }


    public static List<Product> listAllProductsByPrice(double vPrice , Context mContext){
        List<Product> mProductList = null;
        String mSql;
        try{
            mSql = "SELECT id , name , price , rating , status , image , amountConsumption , consumptionCycle FROM products WHERE price=" + vPrice + " ORDER BY name ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mProductList = new ArrayList<Product>();
            while (mResultSet.next()){
                mProductList.add(new Product(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getInt(3),
                        mResultSet.getInt(4),
                        mResultSet.getInt(5),
                        mResultSet.getInt(6),
                        mResultSet.getInt(7),
                        mResultSet.getInt(8),
                        0

                ));

            }

        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mProductList;
    }


    public static List<Product> searchProductsByName(String vName , Context mContext){
        List<Product> mProductList = null;
        String mSql;
        try{
            mSql = "SELECT id , name , price , rating , status , image , amountConsumption , consumptionCycle FROM products WHERE name LIKE '%" + vName + "%' ORDER BY name ASC";
            PreparedStatement mPreparedStatement = MSSQLConnectionHelper.getConnection(mContext).prepareStatement(mSql);
            ResultSet mResultSet = mPreparedStatement.executeQuery();
            mProductList = new ArrayList<Product>();
            while (mResultSet.next()){
                mProductList.add(new Product(
                        mResultSet.getInt(1),
                        mResultSet.getString(2),
                        mResultSet.getInt(3),
                        mResultSet.getInt(4),
                        mResultSet.getInt(5),
                        mResultSet.getInt(6),
                        mResultSet.getInt(7),
                        mResultSet.getInt(8),
                        0

                ));

            }

        } catch (Exception e){
            Log.e(TAG , e.getMessage());
        }

        return mProductList;
    }

}
