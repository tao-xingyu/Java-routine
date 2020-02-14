package Question;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card{
    public String suit;//花色
    public String rank;//点

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
       return "("+suit+" "+rank+")";
    }
}


public class CardDemo {
    public static final String[] SUITS = {"♥","♠","♣","♦"};


    public static List<Card> buyPoker(){
        List<Card> poker = new ArrayList<>();
        for(int i = 0;i < 4;i++){
            //负责构建四种花色
            for(int j = 2;j <= 10;j++){
                poker.add(new Card(SUITS[i],j+""));//数字牌
            }
            poker.add(new Card(SUITS[i],"J"));//字母牌
            poker.add(new Card(SUITS[i],"Q"));
            poker.add(new Card(SUITS[i],"K"));
            poker.add(new Card(SUITS[i],"A"));
        }
        return poker;
    }
    private static void Swap(List<Card>dack,int i,int j){
        Card t = dack.get(i);
        dack.set(i,dack.get(j));
        dack.set(j,t);
    }
    public static void main(String[] args) {
        //创建一副牌
        System.out.println("创建一副牌");
        List<Card> poker = buyPoker();
        //洗牌操作
        Collections.shuffle(poker);
        System.out.println(poker);
        //发牌,假设三人玩牌,每人五张牌
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<Card>());//三个玩家三幅手牌
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        //把牌依次发给三个玩家
        for(int cardIndex = 0;cardIndex < 5;cardIndex++){
            for(int playerIndex = 0;playerIndex < 3;playerIndex++){
                //players.get(playerIndex).add(poker.remove(0));
                List<Card> playerCards = players.get(playerIndex);
                Card curCard = poker.remove(0);
                playerCards.add(curCard);//借助get完成修改
            }
        }
        //输出玩家手牌
        System.out.println("玩家1:");
        System.out.println(players.get(0));
        System.out.println("玩家2:");
        System.out.println(players.get(1));
        System.out.println("玩家3:");
        System.out.println(players.get(2));
    }
}
