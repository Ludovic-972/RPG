package objects.items;

import personnage.TypeElement;

import java.security.SecureRandom;

public class Materiaux extends Item{
    private TypeMateriaux typeMat;

    public Materiaux(TypeMateriaux typeMat){
        super();
        this.typeMat = typeMat;
    }

    public TypeMateriaux getTypeMat() {
        return typeMat;
    }

    public void setTypeMat(TypeMateriaux typeMat) {
        this.typeMat = typeMat;
    }

    @Override
    public String getItemType() {
        return this.getTypeMat().toString();
    }

    @Override
    public String toString(){
        String materiau = this.getTypeMat().toString();
        return materiau;
    }
}
