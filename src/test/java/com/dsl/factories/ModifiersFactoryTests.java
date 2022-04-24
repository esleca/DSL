package com.dsl.factories;

import org.junit.jupiter.api.Test;

import com.dsl.exceptions.ModifierNotFoundException;
import com.dsl.models.entities.modifiers.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ModifiersFactoryTests {
	
	//___________________________________________
    // test_createModifier_PublicName
    //
    // GIVEN: createModifier is called
    // WHEN:  public type is passed
    // THEN:  PublicModifier is returned
    //___________________________________________
	@Test
	public void test_createModifier_PublicName() throws ModifierNotFoundException {
		//Arrange
		String type = "public";
		
		//Act
		Modifier modifier = ModifiersFactory.createModifier(type);
		
		//Assert
		assertEquals("public", modifier.getName());
	}
	
	//______________________________________________
    // test_createModifier_InstanceOfPublic
    //
    // GIVEN: createModifier is called
    // WHEN:  public type is passed
    // THEN:  Modifier is instance of PublicModifier
    //______________________________________________
	@Test
	public void test_createModifier_InstanceOfPublic() throws ModifierNotFoundException {
		//Arrange
		String type = "public";
		
		//Act
		Modifier modifier = ModifiersFactory.createModifier(type);
		
		//Assert
		assertTrue(modifier instanceof PublicModifier);
	}
	
	
	//___________________________________________
    // test_createModifier_ProtectedName
    //
    // GIVEN: createModifier is called
    // WHEN:  protected type is passed
    // THEN:  ProtectedModifier is returned
    //___________________________________________
	@Test
	public void test_createModifier_ProtectedName() throws ModifierNotFoundException {
		//Arrange
		String type = "protected";

		//Act
		Modifier modifier = ModifiersFactory.createModifier(type);
		
		//Assert
		assertEquals("protected", modifier.getName());
	}
	
	//______________________________________________
    // test_createModifier_InstanceOfProtected
    //
    // GIVEN: createModifier is called
    // WHEN:  protected type is passed
    // THEN:  Modifier is instance of ProtectedModifier
    //______________________________________________
	@Test
	public void test_createModifier_InstanceOfProtected() throws ModifierNotFoundException {
		//Arrange
		String type = "protected";
		
		//Act
		Modifier modifier = ModifiersFactory.createModifier(type);
		
		//Assert
		assertTrue(modifier instanceof ProtectedModifier);
	}
	
	
	//___________________________________________
    // test_createModifier_PrivateName
    //
    // GIVEN: createModifier is called
    // WHEN:  private type is passed
    // THEN:  PrivateModifier is returned
    //___________________________________________
	@Test
	public void test_createModifier_PrivateName() throws ModifierNotFoundException {
		//Arrange
		String type = "private";

		//Act
		Modifier modifier = ModifiersFactory.createModifier(type);
		
		//Assert
		assertEquals("private", modifier.getName());
	}
	
	//______________________________________________
    // test_createModifier_InstanceOfPrivate
    //
    // GIVEN: createModifier is called
    // WHEN:  private type is passed
    // THEN:  Modifier is instance of PrivateModifier
    //______________________________________________
	@Test
	public void test_createModifier_InstanceOfPrivate() throws ModifierNotFoundException {
		//Arrange
		String type = "private";
		
		//Act
		Modifier modifier = ModifiersFactory.createModifier(type);
		
		//Assert
		assertTrue(modifier instanceof PrivateModifier);
	}
}
