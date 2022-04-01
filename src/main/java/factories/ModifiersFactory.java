package factories;

import exceptions.ModifierNotFoundException;
import models.entities.modifiers.Modifier;
import models.entities.modifiers.PrivateModifier;
import models.entities.modifiers.ProtectedModifier;
import models.entities.modifiers.PublicModifier;
import static utils.Constants.*;

public class ModifiersFactory {

    public static Modifier createModifier(String inType) throws ModifierNotFoundException {
        Modifier modifier;

        switch (inType){
            case MODIFIER_PUBLIC:
                modifier = new PublicModifier(); break;
            case MODIFIER_PRIVATE:
                modifier = new PrivateModifier(); break;
            case MODIFIER_PROTECTED:
                modifier = new ProtectedModifier(); break;
            default:
                throw new ModifierNotFoundException();
        }

        return modifier;
    }

}
