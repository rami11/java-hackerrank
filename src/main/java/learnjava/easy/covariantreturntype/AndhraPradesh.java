package learnjava.easy.covariantreturntype;

public class AndhraPradesh extends Region {

    @Override
    public Flower yourNationalFlower() {
        return new Lily();
    }
}
