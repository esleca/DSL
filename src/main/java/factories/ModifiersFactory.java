package factories;

import models.entities.modifiers.Modifier;
import models.entities.modifiers.PrivateModifier;
import models.entities.modifiers.ProtectedModifier;
import models.entities.modifiers.PublicModifier;


public class ModifiersFactory {

    public Modifier createModifier(String inType){
        Modifier modifier = null;

        switch (inType){
            case "public":
                modifier = new PublicModifier(); break;
            case "private":
                modifier = new PrivateModifier(); break;
            case "protected":
                modifier = new ProtectedModifier(); break;
        }

        return modifier;
    }
}
