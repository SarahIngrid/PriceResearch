package br.com.inf3im.priceresearch;
//Pesquisar FILTRAR usuario,produto...

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> implements Filterable {
    public static final String TAG = "Product Adapter";

    // definir escutadores/ouvintes de clique na tela
    private  View.OnClickListener mOnClickListener;
    private  View.OnLongClickListener mOnLongClickListener; //clique longo

    private Context mContext;

    //definir objetos de lista (SELECT = list<Product> listAllProducts(Context mContext))
    private List<Product> mProductList;
    // listar reserva para dar agilidade quando aplicar filtro
    private List<Product> mProductListFull;
    // o objeto mProductListFull permite que não seja feito um acesso ao banco de dados
    // operação com banco de dados custa 'fazer acesso ao banco de dados'

    // objeto para exibir o total da compra
    private TextView mTextViewTotalPrice;

    //criar o construtor da classe ProductActAdapter


    public ProductAdapter(Context mContext, List<Product> mProductList, TextView mTextViewTotalPrice) {
        this.mContext = mContext;
        this.mProductList = mProductList;
        this.mTextViewTotalPrice = mTextViewTotalPrice;
    }

    // <funcionalidade para trocar a cor do preço> que depende de uma avaliação
    // cor=f(rating) y = f(x)
    //funcionalidade = função = metodo =ação
    //trocar a cor é uma regra de negocio - o codigo abaixo deve estar em outra classe
    // isso deve ser feito para manter o codigo limpo (tecnico CLEAN CODE)
    public String setPriceColor(double vRating){
        if (vRating < 3 ){
            return "#BF0404"; //VERMELHO

        } else {
            return "#000000"; //PRETO

        }

    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        // essa subclasse é responsavel por ativar os elementos
        // de tela com o codigo java
        //aqui teremos os elementos do CARDVIEW
        

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
