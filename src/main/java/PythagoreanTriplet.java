import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class PythagoreanTriplet {
    private int a;
    private int b;
    private int c;

    PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || (obj.getClass() != this.getClass())){
            return false;
        }

        PythagoreanTriplet pt = (PythagoreanTriplet) obj;

        return ((pt.a == this.a) && (pt.b == this.b) && (pt.c == this.c));
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    static TripletListBuilder makeTripletsList() {
        TripletListBuilder tripletListBuilder = new TripletListBuilder();
        return tripletListBuilder;
    }

    static class TripletListBuilder {
        private List<PythagoreanTriplet> triplets = new ArrayList<>();
        private int sum;
        private int limit;

        TripletListBuilder thatSumTo(int sum) {
            this.sum = sum;
            return this;
        }

        TripletListBuilder withFactorsLessThanOrEqualTo(int maxFactor) {
            this.limit = maxFactor;
            return this;
        }

        List<PythagoreanTriplet> build() {
            int a, b, c;
            double expectedC;
            PythagoreanTriplet pythagoreanTriplet;

            if(limit == 0) {
                limit = sum / 2;
            }

            for(a = 1; a < limit; a++){
                for(b = a+1; b < limit; b++){
                    c = sum - (a + b);

                    if(c <= limit){
                        expectedC = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));

                        if(expectedC == c) {
                            pythagoreanTriplet = new PythagoreanTriplet(a, b, c);
                            triplets.add(pythagoreanTriplet);
                        }
                    }
                }
            }

            return triplets;
        }

    }

}