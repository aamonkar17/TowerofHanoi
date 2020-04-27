package com.company;

import java.util.Arrays;

public class Peg {
    private int pegNum;
    private int numDiscs;
    private int[] discs;
    private int count;    //the number of discs currently on the peg.

    public Peg(int p, int num)
    {
        pegNum = p;
        numDiscs = num;
        discs = new int[num];
        count = 0;
    }

    public int getPegNum()
    {
        return pegNum;
    }
    public int getNumDiscs()
    {
        return numDiscs;
    }

    public String toString()
    {
        String s = "com.company.Peg " + pegNum;
        return s;
    }
    public boolean addDisc(int whichOne)
    {
        if (discs[0]==0) {
            discs[0] = whichOne;
            return true;
        }
        // TODO add the disc with the given number to the peg.
        // don't forget to make sure the move is value (no disc on top of a smaller one)
        for(int i=0; i < discs.length; i++) {
            if(discs[i]==0) {
                if (whichOne > discs[i - 1]) {
                    return false;
                }
                else if (whichOne < discs[i - 1]) {
                    discs[i] = whichOne;
                    count++;
                    return true;
                }
            }
        }
        return false;
    }

    public int popDisc()
    {
        // TODO remove the top disc from the peg.  Return its value.
        for(int i=0; i<discs.length; i++){
            if (i==discs.length-1 || discs[i]!=0 && discs[i+1]==0){
                int a = discs[i];
                discs[i]=0;
                count--;
                return a;
            }
        }
        return 0;
    }

    public boolean moveTopDisc(Peg newPeg)
    {
        int disc = popDisc();
        if (newPeg.addDisc(disc))
        {
            System.out.println("Moving disc " + disc + " from peg " + pegNum + " to peg " + newPeg.getPegNum());
            return true;
        }
        else{
            System.out.println("Bad Move");
            return false;
        }
    }
    public static void main(String [] arg) {
        Peg p1 = new Peg(1,5);
        p1.addDisc(3);
        System.out.println(Arrays.toString(p1.discs));
        p1.addDisc(2);
        System.out.println(Arrays.toString(p1.discs));
        p1.addDisc(4);
        System.out.println(Arrays.toString(p1.discs));
        p1.popDisc();
        System.out.println(Arrays.toString(p1.discs));
    }


}
/*
Results:
[3, 0, 0, 0, 0]
[3, 2, 0, 0, 0]
[3, 2, 0, 0, 0]
[3, 0, 0, 0, 0]
 */
