package com.jbksoft;

/**
 * We have number 9,8,7,6
 *
 */
public class TowerOfHanoi {
    public static void main(String[] args){
        ArrayStack stack=new ArrayStack(3);
        stack.push(9,0);
        stack.push(8,0);
        stack.push(7,0);
       /* System.out.println(stack.pop(0));
        System.out.println(" "+stack.peek(0));
        System.out.println(stack.isEmpty(2));*/
        shuffle(stack);

        System.out.println(stack.isEmpty(2));
        System.out.println(stack.peek(2));
    }

    public static void shuffle(ArrayStack stacks){
        if(stacks.isEmpty(0) && stacks.isEmpty(1)) return;

        boolean moveOption1,moveOption2,moveOption3,moveOption4,moveOption5,moveOption6;

        //Find the number of possible move

       moveOption1=canMove(stacks,0,1);

        moveOption2=canMove(stacks,0,2);
        moveOption3=canMove(stacks,1,0);
        moveOption4=canMove(stacks,1,2);

        moveOption5=canMove(stacks,2,0);
        moveOption6=canMove(stacks,2,1);

        if(moveOption2){
            move(stacks,0,2);
        }else if(moveOption4){
            move(stacks,1,2);
        }else if(moveOption1){
            move(stacks,0,1);
        }else if(moveOption3){
            move(stacks,1,0);
        }else if(moveOption6){
            move(stacks,2,1);
        }else if(moveOption5){
            move(stacks,2,0);
        }

        shuffle(stacks);
    }

    public static void move(ArrayStack stacks,int stackNumSrc, int stackNumDes ){
        int data=stacks.pop(stackNumSrc);
        stacks.push(data, stackNumDes);
    }

    public static boolean canMove(ArrayStack stacks,int stackNumSrc,int stackNumDesc){
        if(stacks.isEmpty(stackNumDesc)) return true;
        if(stacks.isEmpty(stackNumSrc)) return false;

        int move1=stacks.peek(stackNumSrc);
        int move2=stacks.peek(stackNumDesc);

        if(move1<move2) return true;
        return false;
    }
}
