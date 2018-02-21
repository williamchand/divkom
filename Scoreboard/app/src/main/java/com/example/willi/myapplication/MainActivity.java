package com.example.willi.myapplication;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private char inningmeet='R';
    public char getInningmeet() { return inningmeet; }
    public void setInningmeet(char inningmeet) { this.inningmeet = inningmeet; }
    private char condition_game='R';
    public char getCondition_game() {
        return condition_game;
    }
    public void setCondition_game(char condition_game) {
        if(condition_game=='H'){
            vi_home();
        }else if (condition_game=='A'){
            vi_away();
        }else if (condition_game=='R'){
            vi_both();
        }
        this.condition_game = condition_game;
    }
    private int home_score=0;
    public int getHome_score() {
        return home_score;
    }
    public void setHome_score(int home_score) {
        texthome(home_score);
        this.home_score = home_score;
    }
    private int away_score=0;
    public int getAway_score() { return away_score; }
    public void setAway_score(int away_score) {
        textaway(away_score);
        this.away_score = away_score;
    }
    private int strike=0;
    public int getStrike() { return strike; }
    public void setStrike(int strike) {
        this.strike = strike;
    }
    private int ball=0;
    public int getBall() { return ball; }
    public void setBall(int ball) {
        this.ball = ball;
    }
    private int out=0;
    public int getOut() { return out; }
    public void setOut(int out) {
        this.out = out;
    }
    private int inning=1;
    public int getInning() { return inning; }
    public void setInning(int inning) {
        textinning(inning);
        this.inning = inning;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void strikeclick(View view){
        Strike();
    }
    private void Strike(){
        if((getCondition_game()!='R')&&(getInning()!=10)) {
            int numbers;
            if (getStrike() == 2) {
                numbers = 0;
                setStrike(numbers);
                setBall(numbers);
                invi_strike();
                invi_ball();
                Out();
            } else {
                numbers = getStrike() + 1;
                vi_strike(numbers);
                setStrike(numbers);
                numbers = getBall();
                vi_ball(numbers);
            }
        }
    }
    private void Out(){
        int out;
        if(getOut()<2) {
            out=getOut()+1;
            vi_out(out);
            setOut(out);
        }else{
            invi_out();
            setOut(0);
            char gamecond = getCondition_game();
            if (gamecond=='H'){
                gamecond='A';
            }else if (gamecond=='A'){
                gamecond='H';
            }
            setCondition_game(gamecond);
            if (gamecond == getInningmeet()){
                int gameinning = getInning();
                gameinning = gameinning+1;
                setInning(gameinning);
                if(gameinning==10){
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Pemenang game");
                    if (getAway_score()>getHome_score()){
                        alertDialog.setMessage("Away");
                    }else if(getAway_score()<getHome_score()){
                        alertDialog.setMessage("Home");
                    }else{
                        alertDialog.setMessage("Draw");
                    }
                    alertDialog.show();
                }
            }
        }
    }
    public void scoreclick(View view){
        Score();
    }
    private void Score(){
        if((getCondition_game()!='R')&&(getInning()!=10)) {
            int numbers;
            if (getCondition_game() == 'H') {
                numbers = getHome_score();
                setHome_score(numbers + 1);
                invi_strike();
                invi_ball();
                setStrike(0);
                setBall(0);
            } else if (getCondition_game() == 'A') {
                numbers = getAway_score();
                setAway_score(numbers + 1);
                invi_strike();
                invi_ball();
                setStrike(0);
                setBall(0);
            }
        }
    }
    public void ballclick(View view){
        Ball();
    }
    private void Ball(){
        if((getCondition_game()!='R')&&(getInning()!=10)) {
            int numbers;
            if (getBall() != 3) {
                numbers = getBall() + 1;
                vi_ball(numbers);
                setBall(numbers);
            } else {
                numbers = 0;
                invi_ball();
                setBall(numbers);
            }
        }
    }
    public void homeclick(View view){
        Home();
    }
    private void Home(){
        if(getCondition_game()=='R') {
            setCondition_game('H');
            setInningmeet('H');
        }
    }
    public void awayclick(View view){
        Away();
    }
    private void Away(){
        if(getCondition_game()=='R') {
            setCondition_game('A');
            setInningmeet('A');
        }
    }
    public void resetclick(View view){
        Reset();
    }
    private void Reset(){
        setCondition_game('R');
        setInningmeet('R');
        setAway_score(0);
        setHome_score(0);
        setInning(1);
        setOut(0);
        setStrike(0);
        setBall(0);
        invi_out();
        invi_strike();
        invi_ball();
    }
    private void invi_strike(){
        ImageView image = (ImageView) findViewById(R.id.strikeball1);
        image.setVisibility(View.INVISIBLE);
        image = (ImageView) findViewById(R.id.strikeball2);
        image.setVisibility(View.INVISIBLE);
    }
    private void invi_ball(){
        ImageView image = (ImageView) findViewById(R.id.ball1);
        image.setVisibility(View.INVISIBLE);
        image = (ImageView) findViewById(R.id.ball2);
        image.setVisibility(View.INVISIBLE);
        image = (ImageView) findViewById(R.id.ball3);
        image.setVisibility(View.INVISIBLE);
    }
    private void invi_out(){
        ImageView image = (ImageView) findViewById(R.id.out1);
        image.setVisibility(View.INVISIBLE);
        image = (ImageView) findViewById(R.id.out2);
        image.setVisibility(View.INVISIBLE);
    }
    private void vi_strike(int n){
        int[] imageIDs = new int[] {R.id.strikeball1,R.id.strikeball2};
        for (int i = 0; i < n; i++) {
            ImageView image = (ImageView) findViewById(imageIDs[i]);
            image.setVisibility(View.VISIBLE);
        }
    }
    private void vi_ball(int n){
        int[] imageIDs = new int[] {R.id.ball1,R.id.ball2,R.id.ball3};
        for (int i = 0; i < n; i++) {
            ImageView image = (ImageView) findViewById(imageIDs[i]);
            image.setVisibility(View.VISIBLE);
        }
    }
    private void vi_out(int n){
        int[] imageIDs = new int[] {R.id.out1,R.id.out2};
        for (int i = 0; i < n; i++) {
            ImageView image = (ImageView) findViewById(imageIDs[i]);
            image.setVisibility(View.VISIBLE);
        }
    }
    private void vi_home(){
        Button buttonhome = (Button) findViewById(R.id.hometurn);
        buttonhome.setVisibility(View.VISIBLE);
        Button buttonaway = (Button) findViewById(R.id.awayturn);
        buttonaway.setVisibility(View.INVISIBLE);
    }
    private void vi_away(){
        Button buttonaway = (Button) findViewById(R.id.awayturn);
        buttonaway.setVisibility(View.VISIBLE);
        Button buttonhome = (Button) findViewById(R.id.hometurn);
        buttonhome.setVisibility(View.INVISIBLE);
    }
    private void vi_both(){
        Button buttonaway = (Button) findViewById(R.id.awayturn);
        buttonaway.setVisibility(View.VISIBLE);
        Button buttonhome = (Button) findViewById(R.id.hometurn);
        buttonhome.setVisibility(View.VISIBLE);
    }
    private void texthome(int number){
        TextView quant = (TextView) findViewById(R.id.homescore);
        quant.setText("" + number);
    }
    private void textaway(int number){
        TextView quant = (TextView) findViewById(R.id.awayscore);
        quant.setText("" + number);
    }
    private void textinning(int number){
        TextView quant = (TextView) findViewById(R.id.inning);
        quant.setText("" + number);
    }
}
