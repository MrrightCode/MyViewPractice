package com.example.yangbin.myviewpractice;

/**
 * Created by yangbin on 2018/10/10.
 */
public class SingletonTest {

    private SingletonTest(){

    }

    private static class SingleTonHolder{
        public static final SingletonTest SINGTON = new SingletonTest();
    }

    public static SingletonTest getInstance(){
        return SingleTonHolder.SINGTON;
    }

    public void quckSort(int [] s, int l , int r){
        if(l < r){
            int i = l , j = r, centerNumber = s[i];
            while(i < j){
                    //从右向左找小于center的数
                    while(i < j && s[j] >= centerNumber){
                        j--;
                    }
                    if(i < j){
                        s[i++] = s[j];
                    }
                    while(i < j && s[i] < centerNumber){
                        i++;
                    }
                    if(i < j){
                        s[j--] = s[i];
                    }
            }
            s[i] = centerNumber;
            quckSort(s,l,i-1);
            quckSort(s,i+1,r);
        }
    }

}