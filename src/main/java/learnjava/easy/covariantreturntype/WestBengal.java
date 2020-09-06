package learnjava.easy.covariantreturntype;

public class WestBengal extends Region {

    @Override
    public Flower yourNationalFlower() {
        return new Jasmine();
    }
}
