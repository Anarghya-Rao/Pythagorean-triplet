import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PythagoreanTriplet {
    private int a;
    private int b;
    private int c;

    PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static void main(String[] args){
        List<PythagoreanTriplet> actual
                = PythagoreanTriplet
                .makeTripletsList()
                .thatSumTo(12)
                .build();
    }

    static TripletListBuilder makeTripletsList() {
        TripletListBuilder tripletListBuilder = new TripletListBuilder();
        return tripletListBuilder;
    }

    static class TripletListBuilder {

//        List<List<Integer>> triplets = new ArrayList<>();
        List<PythagoreanTriplet> triplets = new ArrayList<>();
        int sum;
        int maxFactor;

        TripletListBuilder thatSumTo(int sum) {

        /*  int a, b, c;
            double expectedC;

            int upperLimitA = (sum / 2) - 1;
            int upperLimitB = sum - 1;

            for(a = 1; a < upperLimitA; a++){
                for(b = a+1; b < upperLimitB; b++){
                    c = sum - (a + b);
                    expectedC = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));

                    if(expectedC == c){
                        List<Integer> l = new ArrayList<>(3);
                        l.add(a);
                        l.add(b);
                        l.add(c);

                        triplets.add(l);
                    }
                }
            }

            return this;*/

            this.sum = sum;
            return this;
        }

        TripletListBuilder withFactorsLessThanOrEqualTo(int maxFactor) {
            this.maxFactor = maxFactor;
            return this;
        }

        List<PythagoreanTriplet> build() {

            /*if (maxFactor == 0)
                maxFactor = sum / 2;
            int start = (int) Math.sqrt(sum);
            for (int a = start; a <= maxFactor; a++) {
                for (int b = a; b <= maxFactor; b++) {
                    double c = Math.sqrt(a * a + b * b);
                    if (c % 1 == 0 && c <= maxFactor && a + b + c == sum) {
                        triplets.add(new PythagoreanTriplet(a, b, (int) c));
                    }
                }
            }

            return Collections.singletonList(triplets);*/


            int a, b, c, upperLimitA, upperLimitB;
            double expectedC;
            PythagoreanTriplet pythagoreanTriplet;

            if(maxFactor == 0) {
                upperLimitA = (sum / 2) - 1;
//            int upperLimitB = sum - 1;
                upperLimitB = sum / 2;
            }
            else{
                upperLimitA = maxFactor;
                upperLimitB = maxFactor;
            }

            for(a = 1; a < upperLimitA; a++){
                for(b = a+1; b < upperLimitB; b++){
                    c = sum - (a + b);
                    expectedC = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));

                    if(expectedC == c){
                        pythagoreanTriplet = new PythagoreanTriplet(a, b, c);
                        triplets.add(pythagoreanTriplet);

                        /*List<Integer> l = new ArrayList<>(3);
                        l.add(a);
                        l.add(b);
                        l.add(c);

                        triplets.add(l);*/
                    }
                }
            }

            return triplets;

            /*
            List<PythagoreanTriplet> pythagoreanTriplets = new ArrayList<>();
            PythagoreanTriplet pythagoreanTriplet;

            for (List<Integer> triplet :
                    triplets) {
                int a = triplet.get(0);
                int b = triplet.get(1);
                int c = triplet.get(2);

                pythagoreanTriplet = new PythagoreanTriplet(a, b, c);
                pythagoreanTriplets.add(pythagoreanTriplet);
            }

            return pythagoreanTriplets;*/
        }

    }

}