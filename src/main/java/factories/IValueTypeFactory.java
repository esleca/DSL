package factories;

import exceptions.ValueTypeNotFoundException;
import models.entities.valuetypes.ValueType;

public interface IValueTypeFactory {

    ValueType createValueType(String inType, Object value) throws ValueTypeNotFoundException;
}
