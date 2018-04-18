package com.jbksoft.hackerrank;

public class NumberPartition {
    /**
     * Find minimum number
     *
     * @param s
     * @param d
     * @return
     */
    public static long getDigit(int s, int d){

        int[] matrix=new int[d];
        matrix[0]=1;
        int sum=1;

        for(int i=1;i<d;i++){
            matrix[i]=9;
            sum+= matrix[i];
        }


        while(sum!=s){
            boolean isMatch=false;
            if(sum-s>0){
                for(int i=1;i<d;i++){
                    if(matrix[i]>0){
                        matrix[i]=matrix[i]-1;
                        isMatch=true;
                        break;
                    }
                }
            }else if(sum-s<0){
                for(int i=d-1;i>=0;i--){
                    if(matrix[i]<9){
                        matrix[i]=matrix[i]+1;
                        isMatch=true;
                        break;
                    }
                }
            }

            if(!isMatch && sum-s<0){
                if(matrix[0]<9){
                    matrix[0]=matrix[0]+1;
                    isMatch=true;
                }
            }

            sum=0;
            for(int i=0;i<d;i++){
                sum+=matrix[i];
            }

            if(!isMatch){
                //Value won't exists
                matrix[0]=0;
                sum=s;
            }
        }

        long result=0;
        if(matrix[0]>0){
            int counter=0;
            for(int i=d-1;i>=0;i--){
                result+=matrix[i]*Math.pow(10,counter);
                counter=counter+1;
            }
        }else{
            result=-1;

        }

        return result;
    }


    public long getDigitRecursion(int s, int d){

        if(d==1 && s<10){
            return s;
        }else if(s<0 || d<0){
            return -1;
        }else if(s>9 && d==1){
            return -1;
        }

        for(int j=0;j<=9;j++){

            long result=getDigitRecursion(s-j,d-1);

            if(result>0){
                return j*(long)Math.pow(10,d-1)+ result;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        //299
        System.out.println(getDigit(20,3));
    }

}
