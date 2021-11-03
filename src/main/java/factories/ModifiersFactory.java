package factories;

import exceptions.ModifierNotFoundException;
import models.entities.modifiers.Modifier;
import models.entities.modifiers.PrivateModifier;
import models.entities.modifiers.ProtectedModifier;
import models.entities.modifiers.PublicModifier;
import utils.Constants;

public class ModifiersFactory {

    public static Modifier createModifier(String inType) throws ModifierNotFoundException {
        Modifier modifier;

        switch (inType){
            case Constants.MODIFIER_PUBLIC:
                modifier = new PublicModifier(); break;
            case Constants.MODIFIER_PRIVATE:
                modifier = new PrivateModifier(); break;
            case Constants.MODIFIER_PROTECTED:
                modifier = new ProtectedModifier(); break;
            default:
                throw new ModifierNotFoundException();
        }

        return modifier;
    }

}
