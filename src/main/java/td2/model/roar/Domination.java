package td2.model.roar;

import td2.model.lycan.Lycanthrope2;

public class Domination extends Roar{
    Lycanthrope2 submitted;
    public Domination(Lycanthrope2 submitted) {
        super("I am better ROAOR");
        this.submitted = submitted;
    }

    public Lycanthrope2 getSubmitted() {
        return submitted;
    }
}
