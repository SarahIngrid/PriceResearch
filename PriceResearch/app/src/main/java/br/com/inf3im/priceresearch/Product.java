package br.com.inf3im.priceresearch;

public class Product {

    // representa a tabela do banco de dados

    // para encontrar erros nos testes com o app vou criar uma marcação TAG
    public static final String TAG = "Tabela Product";

    // criar as colunas da tabela
    private int mId;
    private String mName;
    private double mPrice;
    private int mStatus;
    private float mRating;
    private long mImage;
    private int mAmountConsumption;
    private int mConsumptionCycle;
    // a coluna abaixo não tem na tabela ela será na memória
    private int mUnit;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public float getRating() {
        return mRating;
    }

    public void setRating(float rating) {
        mRating = rating;
    }

    public long getImage() {
        return mImage;
    }

    public void setImage(long image) {
        mImage = image;
    }

    public int getAmountConsumption() {
        return mAmountConsumption;
    }

    public void setAmountConsumption(int amountConsumption) {
        mAmountConsumption = amountConsumption;
    }

    public int getConsumptionCycle() {
        return mConsumptionCycle;
    }

    public void setConsumptionCycle(int consumptionCycle) {
        mConsumptionCycle = consumptionCycle;
    }

    public int getUnit() {
        return mUnit;
    }

    public void setUnit(int unit) {
        mUnit = unit;
    }
// criar os metodos assessores da classe   GET  SET

    // criar dois construtores da classe
    // construtor é utilizado com o '= new'

    // criar o metodo toString para essa classe


    @Override
    public String toString() {
        return "Product{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mPrice=" + mPrice +
                ", mStatus=" + mStatus +
                ", mRating=" + mRating +
                ", mImage=" + mImage +
                ", mAmountConsumption=" + mAmountConsumption +
                ", mConsumptionCycle=" + mConsumptionCycle +
                ", mUnit=" + mUnit +
                '}';
    }

    public Product(String name, double price, int status, float rating, long image, int amountConsumption, int consumptionCycle, int unit) {
        mName = name;
        mPrice = price;
        mStatus = status;
        mRating = rating;
        mImage = image;
        mAmountConsumption = amountConsumption;
        mConsumptionCycle = consumptionCycle;
        mUnit = unit;
    }

    public Product(int id, String name, double price, int status, float rating, long image, int amountConsumption, int consumptionCycle, int unit) {
        mId = id;
        mName = name;
        mPrice = price;
        mStatus = status;
        mRating = rating;
        mImage = image;
        mAmountConsumption = amountConsumption;
        mConsumptionCycle = consumptionCycle;
        mUnit = unit;
    }
}
