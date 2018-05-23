package Robot;

import java.util.ArrayList;

public class TestBruteForce {

    private ArrayList<ArrayList> dozen = new ArrayList<>();
    private ArrayList<Integer> gesorteerde_producten = new ArrayList<>();
    private ArrayList<Integer> producten = new ArrayList<>();
    private int doosgrootte = 10;
    private double opvulgraad, opt_opvulgraad;

    for (int i = 1;

    i< producten.size ()
    + 1; i


        ++) {
            int r = i;
        int data[] = new int[r];

        combinationUtil(producten, data, start, paketten.size() - 1, index, r);
    }

    public TestBruteForce() {
        producten.add(2);
        producten.add(3);
        producten.add(4);
        producten.add(5);
        producten.add(6);

    }

    public ArrayList BruteForceCalc() {
        opt_opvulgraad = 0.0;

        while (!producten.isEmpty()) {

            //MAAR 1 WAARDE GEBRUIKEN OM TE TESTEN
            for (int i : producten) {
                if (producten.get(i) <= doosgrootte) {
                    opvulgraad = (double) producten.get(i) / doosgrootte;
                    opvulgraad *= 100;
                    if (opvulgraad > opt_opvulgraad) {
                        opt_opvulgraad = opvulgraad;

                    }
                }
            }
        }

        return null;
    }

    public Brute_force() {

        paketten.add(1);
        paketten.add(2);
        paketten.add(3);

        for (int x = 0; x < dozen.size(); x++) {
            System.out.println(dozen.get(x));
        }
    }

    void combinationUtil(ArrayList pakketten, int data[], int start,
            int end, int index, int r) {

        if (index == r) {
            for (int j = 0; j < r; j++) {

                doos.add(data[j]);

            }
            dozen.add(doos);
            doos = new ArrayList<>();
            opvulgraad = gevuld / ((double) DoosGrootte) * 100;

            return;
        }

        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = (Integer) pakketten.get(i);
            combinationUtil(pakketten, data, i + 1, end, index + 1, r);
        }
    }
}

public static void main(String[] args) {
        TestBruteForce tbf1 = new TestBruteForce();
        tbf1.BruteForceCalc();

    }
}
