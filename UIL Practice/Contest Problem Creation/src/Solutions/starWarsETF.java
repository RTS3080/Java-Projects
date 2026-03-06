package Solutions;

import java.io.*;
import java.util.*;

    public class starWarsETF {
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(new File("starWarsETF.dat"));
            int N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                int M = sc.nextInt();  
                int[] prices = new int[M];
                for (int j = 0; j < M; j++) {
                    prices[j] = sc.nextInt();
                }

                int profit = 0;
                for (int j = 0; j < M - 1; j++) {
                    if (prices[j + 1] > prices[j]) {
                        profit += prices[j + 1] - prices[j];
                    }
                }

                if (profit > 0)
                    System.out.println(profit);
                else
                    System.out.println("This is not the trade you're looking for");
            }
        }
    }

