package com.example.willi.minidivkom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int quantity=0;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    private int price=0;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int burger=0;
    public int getBurger() {
        return burger;
    }

    public void setBurger(int burger) {
        this.burger = burger;
    }
    private int spaghetti=0;

    public int getSpaghetti() {
        return spaghetti;
    }

    public void setSpaghetti(int spaghetti) {
        this.spaghetti = spaghetti;
    }
    private int milkshake=0;

    public int getMilkshake() {
        return milkshake;
    }

    public void setMilkshake(int milkshake) {
        this.milkshake = milkshake;
    }
    private int indomi=0;

    public int getIndomi() {
        return indomi;
    }

    public void setIndomi(int indomi) {
        this.indomi = indomi;
    }
    private int mieayam=0;

    public int getMieayam() {
        return mieayam;
    }

    public void setMieayam(int mieayam) {
        this.mieayam = mieayam;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Change1(View view){
        setContentView(R.layout.layout2);
    }
    public void Change2(View view){
        setContentView(R.layout.layout3);
    }
    public void Change3(View view){
        setMilkshake(0);
        setSpaghetti(0);
        setPrice(0);
        setQuantity(0);
        setBurger(0);
        setIndomi(0);
        setMieayam(0);
        setContentView(R.layout.layout2);
    }
    private void addquantity(int number){
        TextView quant = (TextView) findViewById(R.id.totalorder);
        quant.setText("" + number);
    }
    private void addprice(int number){
        TextView quant = (TextView) findViewById(R.id.total);
        quant.setText("Rp. " + number);
    }
    public void burgerplus(View view){
        int number = getBurger();
        int quantities = getQuantity();
        int prices = getPrice();
        addquantity(quantities+1);
        setQuantity(quantities+1);
        addprice(prices+10000);
        setPrice(prices+10000);
        setBurger(number+1);
        addburger(number+1);
    }

    private void addburger(int number){
        TextView quant = (TextView) findViewById(R.id.burger);
        quant.setText("" + number);
    }
    public void burgermin(View view){
        int number = getBurger();
        if(number!=0) {
            int quantities = getQuantity();
            int prices = getPrice();
            addquantity(quantities - 1);
            setQuantity(quantities - 1);
            addprice(prices - 10000);
            setPrice(prices - 10000);
            setBurger(number - 1);
            addburger(number - 1);
        }
    }
    public void spaghettiplus(View view){
        int number = getSpaghetti();
        int quantities = getQuantity();
        int prices = getPrice();
        addquantity(quantities+1);
        setQuantity(quantities+1);
        addprice(prices+25000);
        setPrice(prices+25000);
        setSpaghetti(number + 1);
        addspaghetti(number + 1);
    }
    private void addspaghetti(int number){
        TextView quant = (TextView) findViewById(R.id.spaghetti);
        quant.setText("" + number);
    }
    public void spaghettimin(View view){
        int number = getSpaghetti();
        if(number!=0) {
            int quantities = getQuantity();
            int prices = getPrice();
            addquantity(quantities - 1);
            setQuantity(quantities - 1);
            addprice(prices - 25000);
            setPrice(prices - 25000);
            setSpaghetti(number - 1);
            addspaghetti(number - 1);
        }
    }

    public void milkshakeplus(View view){
        int number = getMilkshake();
        int quantities = getQuantity();
        int prices = getPrice();
        addquantity(quantities+1);
        setQuantity(quantities+1);
        addprice(prices+7500);
        setPrice(prices+7500);
        setMilkshake(number + 1);
        addmilkshake(number + 1);
    }
    private void addmilkshake(int number){
        TextView quant = (TextView) findViewById(R.id.milkshake);
        quant.setText("" + number);
    }
    public void milkshakemin(View view){
        int number = getMilkshake();
        if(number!=0) {
            int quantities = getQuantity();
            int prices = getPrice();
            addquantity(quantities-1);
            setQuantity(quantities-1);
            addprice(prices-7500);
            setPrice(prices-7500);
            setMilkshake(number - 1);
            addmilkshake(number - 1);
        }
    }

    public void indomiplus(View view){
        int number = getIndomi();
        int quantities = getQuantity();
        int prices = getPrice();
        addquantity(quantities+1);
        setQuantity(quantities+1);
        addprice(prices+5000);
        setPrice(prices+5000);
        setIndomi(number + 1);
        addindomi(number + 1);
    }
    private void addindomi(int number){
        TextView quant = (TextView) findViewById(R.id.indomi);
        quant.setText("" + number);
    }
    public void indomimin(View view){
        int number = getIndomi();
        if(number!=0) {
            int quantities = getQuantity();
            int prices = getPrice();
            addquantity(quantities-1);
            setQuantity(quantities-1);
            addprice(prices-5000);
            setPrice(prices-5000);
            setIndomi(number - 1);
            addindomi(number - 1);
        }
    }

    public void mieayamplus(View view){
        int number = getMieayam();
        int quantities = getQuantity();
        int prices = getPrice();
        addquantity(quantities+1);
        setQuantity(quantities+1);
        addprice(prices+15000);
        setPrice(prices+15000);
        setMieayam(number + 1);
        addmieayam(number + 1);
    }
    private void addmieayam(int number){
        TextView quant = (TextView) findViewById(R.id.mieayam);
        quant.setText("" + number);
    }
    public void mieayammin(View view){
        int number = getMieayam();
        if(number!=0) {
            int quantities = getQuantity();
            int prices = getPrice();
            addquantity(quantities-1);
            setQuantity(quantities-1);
            addprice(prices-15000);
            setPrice(prices-15000);
            setMieayam(number - 1);
            addmieayam(number - 1);
        }
    }

}
