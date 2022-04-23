package com.dsl.factories;

import com.dsl.exceptions.ModifierNotFoundException;
import com.dsl.models.entities.modifiers.Modifier;
import com.dsl.models.entities.modifiers.PrivateModifier;
import com.dsl.models.entities.modifiers.ProtectedModifier;
import com.dsl.models.entities.modifiers.PublicModifier;
import static com.dsl.utils.Constants.*;

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
