package factory;

import personnage.*;

import java.lang.reflect.Type;

public class EnnemiFactory extends EnnemiFactoryAbstract{
    private Ennemi ennemiFactory;

    private TypeElement typeElem;
        @Override
        public Ennemi creerEnnemi(String nomClasse, String nom, TypeMonstre type){
            switch (nomClasse) {
                case "Orc":
                    return ennemiFactory = new Orc(nom, type);
                case "Bat":
                    return ennemiFactory = new Bat(nom, type);
                case "Slime":
                    return ennemiFactory = new Slime(nom, type);
                case "Golem":
                    setElementType();
                    return ennemiFactory = new Golem(nom, type, typeElem);
                default:
                    return null;
                }

            }

    private void setElementType() {
        int randomElement = (int)(Math.random() * ((7 - 0) + 1)) + 0;
        switch(randomElement)
        {
            case 0:
                this.typeElem = TypeElement.EAU;
                break;
            case 1:
                this.typeElem = TypeElement.GLACE;
                break;
            case 2:
                this.typeElem = TypeElement.FEU;
                break;
            case 3:
                this.typeElem = TypeElement.TERRE;
                break;
            case 4:
                this.typeElem = TypeElement.ELECTRICITE;
                break;
            case 5:
                this.typeElem = TypeElement.LUMIERE;
                break;
            case 6:
                this.typeElem = TypeElement.TENEBRE;
                break;
            case 7:
                this.typeElem = TypeElement.VENT;
                break;
        }
    }



}

