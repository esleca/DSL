package factories;

import exceptions.ModifierNotFoundException;
import models.entities.modifiers.Modifier;

public interface IModifiersFactory {

    Modifier createModifier(String inType) throws ModifierNotFoundException;
}
